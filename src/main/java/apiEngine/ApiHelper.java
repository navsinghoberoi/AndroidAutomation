package apiEngine;


import com.google.gson.Gson;
import com.shuttl.automation.core.Request;
import com.shuttl.automation.core.RequestConfig;
import com.shuttl.automation.core.RequestMethod;
import com.shuttl.automation.core.exception.NotFoundException;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

/**
 * created by naveenkumar on Jul, 2018
 */
public class ApiHelper {
    private static String REQUEST_ID;
    private static String SESSION_ID;

    private static String getEncryptedUserId(String userId) {
        String url = "http://qa.goplus.in/restricted/getEncryptedUserIds";
        RequestConfig.Builder builder = new RequestConfig.Builder();
        builder.setUrl(url);
        builder.setRequestMethod(RequestMethod.POST);
        builder.setContentType(ContentType.URLENC);
        HashMap<String, Object> formParams = new HashMap<String, Object>();
        formParams.put("userId", userId);
//      DataLoader.getFormParams("ENCRYPTED_USER_ID");
        builder.setFormParams(formParams);
        Request request = new Request(builder.build());
        Response response = request.getResponse();
        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getString("data");
    }

    public static Response explorePasses(String userId) {
        String host = "http://qa.goplus.in";
        String path = "/v2/subPlan/explorePasses";
        RequestConfig.Builder builder = new RequestConfig.Builder();
        builder.setUrl(host + path);
        builder.setRequestMethod(RequestMethod.POST);
        HashMap<String, String> headers = DataLoader.getHeaders("SUB_PLAN_EXPLORE_PASSES");
        headers.put("userId", getEncryptedUserId(userId));
        builder.setHeaders(headers);
        builder.setContentType(ContentType.JSON);
        String body = DataLoader.getRequestBody("SUB_PLAN_EXPLORE_PASSES");
        builder.setRequestBody(body);
        RequestConfig requestConfig = builder.build();
        Request request = new Request(requestConfig);
        return request.getResponse();
    }

    public static Long getSubscriptionId(String userId) {
        Response response = explorePasses(userId);
        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getLong("data.passes.plans.getAt(0).subscriptionId");   // To pick 1st pass from list
    }

    public static Response buySub(String userId) {
        String host = "http://qa.goplus.in";
        String path = "/v2/sub/buy";
        RequestConfig.Builder builder = new RequestConfig.Builder();
        builder.setUrl(host + path);
        builder.setRequestMethod(RequestMethod.POST);
        HashMap<String, String> headers = DataLoader.getHeaders("BUY_SUB");
        headers.put("userId", getEncryptedUserId(userId));
        builder.setHeaders(headers);
        builder.setContentType(ContentType.JSON);
        String body = DataLoader.getRequestBody("BUY_SUB");
        BuySubRbDTO buySubRbDTO = new Gson().fromJson(body, BuySubRbDTO.class);
        buySubRbDTO.setSubscriptionId(getSubscriptionId(userId));
        builder.setRequestBody(new Gson().toJson(buySubRbDTO));
        RequestConfig requestConfig = builder.build();
        Request request = new Request(requestConfig);
        Response response = request.getResponse();
        return response;
    }

    @SuppressWarnings("unchecked")
    public static Response combinedSlots(String userId) {
        //   buySub(userId);
        String host = "http://172.31.18.109:18080";
        String path = "/v3/routes/combinedSlots";
        RequestConfig.Builder builder = new RequestConfig.Builder();
        builder.setUrl(host + path);
        builder.setRequestMethod(RequestMethod.GET);
        HashMap<String, String> headers = DataLoader.getHeaders("COMBINED_SLOTS");
        headers.put("userId", getEncryptedUserId(userId));
        builder.setHeaders(headers);
        HashMap<String, Object> queryParams = DataLoader.getQueryParams("COMBINED_SLOTS");
        builder.setQueryParams(queryParams);
        RequestConfig requestConfig = builder.build();
        Request request = new Request(requestConfig);
        return request.getResponse();
    }

    public static CreateBookingRbDTO getCreateBookingRbDTO(String userID) {
        Response response = combinedSlots(userID);
        JsonPath jsonPath = response.jsonPath();
        CombinedSlotTripInfoDTO combinedSlotTripInfoDTO = jsonPath.getObject("data.routes.getAt(0).slots.getAt(0).trip", CombinedSlotTripInfoDTO.class);
        CombinedSlotLocDTO combinedSlotFromLocDTO = jsonPath.getObject("data.routes.getAt(0).fromLoc", CombinedSlotLocDTO.class);
        if (combinedSlotFromLocDTO == null) {
            throw new NotFoundException("fromLoc object not in CombinedSlots call");
        }
        CombinedSlotLocDTO combinedSlotToLocDTO = jsonPath.getObject("data.routes.getAt(0).toLoc", CombinedSlotLocDTO.class);
        if (combinedSlotToLocDTO == null) {
            throw new NotFoundException("toLoc object not in CombinedSlots call");
        }
        CombinedSlotCouponDTO combinedSlotCouponDTO = jsonPath.getObject("data.routes.getAt(0).slots.getAt(0).coupon", CombinedSlotCouponDTO.class);
        if (combinedSlotCouponDTO == null) {
            throw new NotFoundException("coupon object not in CombinedSlots call");
        }
        CreateBookingRbDTO createBookingRbDTO = new CreateBookingRbDTO();
        createBookingRbDTO.setTripId(combinedSlotTripInfoDTO.getId());
        createBookingRbDTO.setFromId(combinedSlotFromLocDTO.getId());
        createBookingRbDTO.setToId(combinedSlotToLocDTO.getId());
        createBookingRbDTO.setUserFromLat(combinedSlotFromLocDTO.getLat());
        createBookingRbDTO.setUserFromLng(combinedSlotFromLocDTO.getLng());
        createBookingRbDTO.setUserToLat(combinedSlotToLocDTO.getLat());
        createBookingRbDTO.setUserToLng(combinedSlotToLocDTO.getLng());
        createBookingRbDTO.setUserFromName(combinedSlotFromLocDTO.getName());
        createBookingRbDTO.setUserToName(combinedSlotToLocDTO.getName());
        createBookingRbDTO.setBoardingTime(combinedSlotTripInfoDTO.getStaticTime());
        createBookingRbDTO.setCouponId(combinedSlotCouponDTO.getActiveCouponId());
        return createBookingRbDTO;
    }

    @SuppressWarnings("unchecked")
    private static void getRequestIdSessionId(String userId) {
        String host = "http://172.31.18.109:18080";
        String path = "/agg/internal/getRequestIdAndSessionId";
        RequestConfig.Builder builder = new RequestConfig.Builder();
        builder.setUrl(host + path);
        builder.setRequestMethod(RequestMethod.GET);
        HashMap<String, Object> queryParams = DataLoader.getQueryParams("REQUEST_ID_SESSION_ID");
        queryParams.put("userId", getEncryptedUserId(userId));
        builder.setQueryParams(queryParams);
        RequestConfig requestConfig = builder.build();
        Request request = new Request(requestConfig);
        Response response = request.getResponse();
        REQUEST_ID = response.jsonPath().getString("data.requestId");
        SESSION_ID = response.jsonPath().getString("data.sessionId");
    }

    //    private static String getRequestId() {
//        Response response = getRequestIdSessionId();
//        return response.jsonPath().getString("data.requestId");
//    }
//
//    private static String getSessionId() {
//        Response response = getRequestIdSessionId();
//        return response.jsonPath().getString("data.sessionId");
//    }
    public static Response createBooking(String userId) {
        String host = "http://qa.goplus.in";
        String path = "/v3/booking/create";
        RequestConfig.Builder builder = new RequestConfig.Builder();
        builder.setUrl(host + path);
        builder.setRequestMethod(RequestMethod.POST);
        builder.setRequestBody(new Gson().toJson(getCreateBookingRbDTO(userId)));
        HashMap<String, String> headers = DataLoader.getHeaders("CREATE_BOOKING");
        headers.put("userId", getEncryptedUserId(userId));
        getRequestIdSessionId(userId);
        headers.put("sessionId", SESSION_ID);
        headers.put("requestId", REQUEST_ID);
        builder.setHeaders(headers);
        builder.setContentType(ContentType.JSON);
        RequestConfig requestConfig = builder.build();
        Request request = new Request(requestConfig);
        Response response = request.getResponse();
        return response;
    }

    public static Response cancelBooking(String userId) {
        String host = "http://172.31.18.109:18080";
        ;
        String path = "/v3/booking/cancel";
        RequestConfig.Builder builder = new RequestConfig.Builder();
        builder.setUrl(host + path);
        builder.setRequestMethod(RequestMethod.POST);
        String body = "{\n" +
                "        \"bookingId\": " + getUserActiveBooking(userId) + ",\n" +
                "        \"reasonId\": 12\n" +
                "    }";
        builder.setRequestBody(body);
        HashMap<String, String> headers = DataLoader.getHeaders("CANCEL_BOOKING");
        headers.put("userId", getEncryptedUserId(userId));
        getRequestIdSessionId(userId);
        headers.put("sessionId", SESSION_ID);
        headers.put("requestId", REQUEST_ID);
        builder.setHeaders(headers);
        builder.setContentType(ContentType.JSON);
        RequestConfig requestConfig = builder.build();
        Request request = new Request(requestConfig);
        Response response = request.getResponse();
        return response;
    }

    private static Long getUserActiveBooking(String userId) {
        Long bookingId = null;
        String host = "http://qa.goplus.in";
        String path = "/v2/booking/active";
        RequestConfig.Builder builder = new RequestConfig.Builder();
        builder.setUrl(host + path);
        builder.setRequestMethod(RequestMethod.GET);
        HashMap<String, String> headers = DataLoader.getHeaders("ACTIVE_BOOKING");
        headers.put("userId", getEncryptedUserId(userId));
        builder.setHeaders(headers);
        builder.setContentType(ContentType.JSON);
        RequestConfig requestConfig = builder.build();
        Request request = new Request(requestConfig);
        Response response = request.getResponse();
        JsonPath jsonPath = response.jsonPath();
        List<Object> activeBookings = jsonPath.getList("data");
        if (activeBookings.size() != 0) {
            bookingId = jsonPath.getLong("data.getAt(0).bookingId");
        } else {
            System.out.println("No active booking");
        }
        return bookingId;
    }

    public static Response getSurvey() {
        String url = "http://qa.goplus.in/v2/survey/getSurvey";
        RequestConfig.Builder builder = new RequestConfig.Builder();
        builder.setUrl(url);
        builder.setRequestMethod(RequestMethod.GET);
        HashMap<String, Object> queryParams = DataLoader.getQueryParams("GET_SURVEY");
        builder.setQueryParams(queryParams);
        RequestConfig requestConfig = builder.build();
        Request request = new Request(requestConfig);
        Response response = request.getResponse();
        int statusCode = response.getStatusCode();
        System.out.println("Status code of this api = " + statusCode);
        return response;
    }

    public static Response refundSubscription(String userId) {
        String host = "http://qa.goplus.in";
        String path = "/v2/sub/refundSubscription";
        RequestConfig.Builder builder = new RequestConfig.Builder();
        builder.setUrl(host + path);
        builder.setRequestMethod(RequestMethod.POST);
        String json = "{\n" +
                "\t\"reasonId\": 10,\n" +
                "\t\"userSubscriptionId\": " + getUserSubscriptionId(userId) + "\n" +
                "}";
        builder.setRequestBody(json);
        HashMap<String, String> headers = DataLoader.getHeaders("REFUND_SUBSCRIPTION");
        headers.put("userId", getEncryptedUserId(userId));
        builder.setHeaders(headers);
        builder.setContentType(ContentType.JSON);
        RequestConfig requestConfig = builder.build();
        Request request = new Request(requestConfig);
        Response response = request.getResponse();
        return response;
    }

    public static void updateShuttlWalletBalance(String userId) {
        String sql = "update USER_WALLET set BALANCE=10000, CASHBACK_BALANCE = 10000, REFUNDABLE_BALANCE=0 where USER_ID = " + userId + "and USER_WALLET_TYPE=\"SHUTTL_WALLET\"";
        // do by yourself
//        MySQLConnector mySQLConnector = CommonUtils.connectUMS();
//        mySQLConnector.executeUpdate(sql);
//        mySQLConnector.close();


    }

    public static ExploredPlansDTO getUserActiveSubs(String userId) {
        ExploredPlansDTO exploredPlansDTO = null;
        String host = "http://qa.goplus.in";
        String path = "/v2/subPlan/userSubs";
        RequestConfig.Builder builder = new RequestConfig.Builder();
        builder.setUrl(host + path);
        builder.setRequestMethod(RequestMethod.GET);
        HashMap<String, String> headers = DataLoader.getHeaders("USER_SUB_PLANS");
        headers.put("userId", getEncryptedUserId(userId));
        builder.setHeaders(headers);
        RequestConfig requestConfig = builder.build();
        Request request = new Request(requestConfig);
        Response response = request.getResponse();
        JsonPath jsonPath = response.jsonPath();
        List<ExploredPlansDTO> exploredPlansDTOList = jsonPath.getList("data", ExploredPlansDTO.class);
        if (exploredPlansDTOList.size() != 0) {
            exploredPlansDTO = exploredPlansDTOList.get(0);
        }
        return exploredPlansDTO;
    }

    public static Long getUserSubscriptionId(String userId) {
        ExploredPlansDTO exploredPlansDTO = getUserActiveSubs(userId);
        if (exploredPlansDTO != null) {
            return exploredPlansDTO.getUserSubscriptionId();
        } else {
           /* updateShuttlWalletBalance(userId);
            Response response = buySub(userId);
            JsonPath jsonPath = response.jsonPath();
            return jsonPath.getLong("data.userSubscriptionId");*/
           System.out.println("User does not have an active subscription");
           return null;
        }
    }

    public static void main(String[] args) {
        buySub("652245");
        createBooking("652245");
        getUserActiveSubs("652245");
        refundSubscription("652245");
        cancelBooking("652245");
    }
}