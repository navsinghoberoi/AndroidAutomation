package common;


import apiEngine.ApiHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Commons extends BasePage {

    public Commons(WebDriver driver) throws MalformedURLException {
        super(driver);
    }

    private LandingPage landingPage = new LandingPage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private HomePage homePage = new HomePage(driver);
    private OtpPage otpPage = new OtpPage(driver);
    private HomeAddressPage homeAddressPage = new HomeAddressPage(driver);
    private OfficeAddressPage officeAddressPage = new OfficeAddressPage(driver);
    private PersonalDetailsPage personalDetails = new PersonalDetailsPage(driver);
    private SelectLocationPage selectLocationPage = new SelectLocationPage(driver);
    private SlotsPage slotsPage = new SlotsPage(driver);
    private ExplorePassesPage explorePassesPage = new ExplorePassesPage(driver);
    private ChooseBenefitsPage chooseBenefitsPage = new ChooseBenefitsPage(driver);
    private ReviewRoutePage reviewRoutePage = new ReviewRoutePage(driver);
    private PassCompletePaymentPage passCompletePaymentPage = new PassCompletePaymentPage(driver);
    private PassDetailsPage passDetailsPage = new PassDetailsPage(driver);
    private RefundPassPage refundPassPage = new RefundPassPage(driver);
    private TrackShuttlPage trackShuttlPage = new TrackShuttlPage(driver);
    private CouponsPage couponsPage = new CouponsPage(driver);

    public void login(String phoneNumber, String OTP) throws Exception {
        enterUserPhoneNumberOTP(phoneNumber, OTP);
    }

    public void goToHomepage(String phoneNumber, String OTP) throws Exception {
        if (!homePage.checkSearchBar()) {
            enterUserPhoneNumberOTP(phoneNumber, OTP);
        } else {
            System.out.println("User is already on the homepage");
        }
    }
    /* This method lets user login by specifying phonenumber and OTP*/
    public void enterUserPhoneNumberOTP(String phoneNumberKey, String otpKey) throws Exception {
        String userPhoneNumber = getValueFromPPFile(phoneNumberKey);
        String userOTP = getValueFromPPFile(otpKey);
        landingPage.clickSkipToLogin();
        loginPage.enterMobileNumber(userPhoneNumber);
        loginPage.clickVerifyCheckBox();
        loginPage.clickVerify();

        /*
        If device is already registered then alert comes during signup with below text .
        "Our welcome offer is not valid on this device as it has already been registered from a different number."
        If Device is new then no alert will come . Therefore no need to throw an exception .
         */

        try {
            landingPage.registeredDeviceAlertAcceptAtSignup();
        } catch (Exception e) {
        }

        otpPage.enterOtp(userOTP);


    }


    public void enterUserDetails(String userNameKey, String genderKey) throws Exception {
        personalDetails.enterUserNameAtSignUp(getValueFromPPFile(userNameKey));
        personalDetails.selectGender(getValueFromPPFile(genderKey));
        personalDetails.personalDetailSubmitAtSignup();

    }

    public void enterHomeAddressDetailsNewUser(String homeAddressKey) throws Exception {
        //    String homeText = homeAddressPage.whereDoYouLiveText();
        homeAddressPage.selectHomeLocationClick();
        homeAddressPage.searchBarClick();
        homeAddressPage.enterHomeAddress(getValueFromPPFile(homeAddressKey));
        homeAddressPage.selectHomeAddress();   // Adding homeAddressPage by searching address
        homeAddressPage.useThisPlaceAddressText();
        homeAddressPage.selectLocationClick();
        /*homeAddressPage.flatNumSet(getValueFromPPFile("flatNum")); // Commenting for avoiding NPE on hidekeyboard
        androidDriver.hideKeyboard();*/
        homeAddressPage.homeAddressSubmit();
    }

    public void enterOfficeAddressDetailsNewUser() {
        officeAddressPage.whereDoYouWorkText();
        officeAddressPage.selectOfficeLocationClick();
        officeAddressPage.selectThisLocationClick();  // Adding officeAddressPage by using Select this location feature
        officeAddressPage.useThisPlaceAddressText();
        officeAddressPage.selectLocationClick();
        officeAddressPage.officeAddressSubmit();
    }


    public void signUp(String userPhoneNumberKey, String otpKey,
                       String genderKey, String userNameKey, String homeAddressKey) throws Exception {

        enterUserPhoneNumberOTP(userPhoneNumberKey, otpKey);
        enterUserDetails(userNameKey, genderKey);
        enterHomeAddressDetailsNewUser(homeAddressKey);
        enterOfficeAddressDetailsNewUser();
        System.out.println("User has signed up successfully");

    }


    public void clickSearchBar() {
        homePage.clickSearchBar();
    }

    public void closeSearchPopup() {
        homePage.closeSearchPopup();
    }


    public void buySubscriptionViaShuttlCredits(String homeAddress, String officeAddress, int slotIndex, int optionIndex, int menuItemIndex) throws Exception {
        clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile(homeAddress), 0);
        homePage.clickToLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile(officeAddress), 0);
        homePage.clickFindMyShuttl();
        slotsPage.selectOptionFromContinueCTA(slotIndex, optionIndex);
        explorePassesPage.openPass(menuItemIndex);
        chooseBenefitsPage.submitPassBenefitsDetails();
        reviewRoutePage.submitReviewRouteDetails();
        passCompletePaymentPage.getPassCompletepageInfo();
        passCompletePaymentPage.clickPayNowButton();
        passCompletePaymentPage.clickPassPurchaseSuccessfulCTA();
    }

    public void refundSubscription(int menuItemIndex, int ridesIndex, int validityIndex, int reasonForPassDelete, int refundPassValueIndex) {
        homePage.openMyPass(menuItemIndex); // User will be redirected to Pass details page directly (from version 36000+)
        passDetailsPage.getRidesValidityData(ridesIndex, validityIndex);
        passDetailsPage.deletePass(reasonForPassDelete);
        refundPassPage.clickDiscontinuePassButton(refundPassValueIndex);
        String refundPassText = refundPassPage.clickPassRefundSuccessfulCTA();
        System.out.println(refundPassText);
    }


    public void clearTextField(By fieldLocator) {
        driver.findElement(fieldLocator).clear();
    }


    // ------------------------     CREATE TEXT FILE      -------------------------


    public void writeTextFile(String filePath, String lineText) throws IOException {
        File f = new File(filePath);
        FileUtils.write(f, lineText, true);
    }


    public List<String> readTextFileFromEnd(String filePath, int startLine, int endLine) {

        List<String> lines = null;
        try {

            LineIterator it = IOUtils.lineIterator(
                    new BufferedReader(new FileReader(filePath)));

            for (int i = startLine; i < endLine; i++)
                lines.add(it.next());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }


    public boolean verifyIsLocatorPresent(String text, By locator) {
        boolean result = false;
        waitForClickabilityOf(locator);
        int size = driver.findElements(locator).size();

        for (int i = 0; i < size; i++) {

            String content = driver.findElements(locator).get(i).getText();
            if (content.equalsIgnoreCase(text)) {
                result = true;
                break;
            } else {
                result = false;
            }

        }

        return result;
    }


    public void openRideOptionsFromBookingHomecards() {
        homePage.clickBookingHomeCard();
        trackShuttlPage.dismissProtip();
        trackShuttlPage.clickOptionsIcon();

    }

    public void openSearchBarAndFindRoute(String address1, String address2) throws Exception {
        clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile(address1), 0);
        homePage.clickToLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile(address2), 0);
        homePage.clickFindMyShuttl();
    }

    public void bookingViaCoupon(String homeAddress, String OfficeAddress) throws Exception {
        couponsPage.clickCouponsDisplayText();
        couponsPage.addCouponIntegrated();
        couponsPage.clickPopUp();
        driver.navigate().back();
        openSearchBarAndFindRoute(homeAddress,OfficeAddress);
        slotsPage.clickSlot(0);
        slotsPage.clickCtaOnSlotsPage();
    }


    public String splitAndTrimString(String toBeSplit, int index, String pattern) {

        String array[] = toBeSplit.split(pattern);
        String finalString = array[index].trim();
        return finalString;
    }


    public void captureScreenshot(WebDriver driver, String screenshotName) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));
        } catch (IOException e) {
            System.out.println("Exception occured while taking screenshot : " + e.getMessage());
            e.printStackTrace();
        }

    }

    public String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


    // Method to connect with SQL and get String value from db
    public String connectSQLDbAndFetchValue(String ip, String username, String password, String dbName, String query, String columnName) throws Exception {
                String value = "";
        try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver is loaded");
                System.out.println("jdbc:mysql://" + ip + "/" + dbName + "");
                Connection con = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + dbName + "", username, password);
                System.out.println("Connected to mysql database");
                Statement smt = con.createStatement();
                ResultSet res = smt.executeQuery(query);
                while (res.next()) {

                    value = res.getString(columnName); // specify column name
                    System.out.println("Value : " + value);
                }
                closeSQLDBConnection(con);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        return value;
        }
    public void closeSQLDBConnection(Connection con) {
        try {
            con.close();
            System.out.println("SQL Database connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception appeared while closing connection");
        }

    }

    public void openRideOptionsFromBookingHomecardsForBoardedRide() {
        homePage.openBoardedRideHomecard();
        trackShuttlPage.dismissProtip();
        trackShuttlPage.clickOptionsIcon();

    }


    // Method to fetch boolean values corresponding to a key from api response
    public boolean getBooleanValueFromApiResponse(Response response, String key) {
        JsonPath jsonPath = response.jsonPath();
        boolean keyValue = jsonPath.getBoolean(key);
        System.out.println("Value fetched of " + key + " key from response is = " + keyValue);
        return keyValue;
    }

    // Method to fetch integer values corresponding to a key from api response
    public int getIntegerValueFromApiResponse(Response response, String key) {
        JsonPath jsonPath = response.jsonPath();
        int keyValue = jsonPath.getInt(key);
        System.out.println("Value fetched of " + key + " key from response is = " + keyValue);
        return keyValue;
    }

    // Method to fetch double values corresponding to a key from api response
    public double getDoubleValueFromApiResponse(Response response, String key) {
        JsonPath jsonPath = response.jsonPath();
        double keyValue = jsonPath.getDouble(key);
        System.out.println("Value fetched of " + key + " key from response is = " + keyValue);
        return keyValue;
    }

    // Method to fetch String values corresponding to a key from api response
    public String getStringValueFromApiResponse(Response response, String key) {
        JsonPath jsonPath = response.jsonPath();
        String keyValue = jsonPath.getString(key);
        System.out.println("Value fetched of " + key + " key from response is = " + keyValue);
        return keyValue;
    }


    public void subscriptionBuyViaApiEngine(String UserID) {
        Response response = ApiHelper.buySub(UserID);
        boolean value1 = getBooleanValueFromApiResponse(response, "success");
        int value2 = getIntegerValueFromApiResponse(response, "data.userSubscriptionId");
        Assert.assertEquals(value1, true);
    }


    public void getActiveUserSubscriptionViaApiEngine(String UserID) {
        ApiHelper.getUserActiveSubs(UserID);
    }

    public int createBookingViaApiEngine(String UserID) {
        Response response = ApiHelper.createBooking(UserID);
        boolean value1 = getBooleanValueFromApiResponse(response, "success");
        int value2 = getIntegerValueFromApiResponse(response, "data.bookingId");
        Assert.assertEquals(value1, true);
        return value2;
    }

    public void cancelBookingViaApiEngine(String UserID) {
        Response response = ApiHelper.cancelBooking(UserID);
        boolean value1 = getBooleanValueFromApiResponse(response, "success");
        String value2 = getStringValueFromApiResponse(response, "data.bookingStatus");
        Assert.assertEquals(value1, true);
        Assert.assertEquals(value2, "CANCELLED");
    }

    public void refundSubscriptionViaApiEngine(String UserID) {
        Response response = ApiHelper.refundSubscription(UserID);
        boolean value1 = getBooleanValueFromApiResponse(response, "success");
        String value2 = getStringValueFromApiResponse(response, "data.title");
        Assert.assertEquals(value1, true);
        Assert.assertEquals(value2, "Refund Successful");
    }

    public boolean boardRideViaApiEngine(String hostname,int bookingId) throws Exception {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "[{\n  \"bookingId\": "+bookingId+",\n  \"timestamp\": 1532602200000,\n  \"boardingType\": \"CHIRP\"\n}]");
        Request request = new Request.Builder()
                .url(hostname + "/restricted/booking/board")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "781d03c8-db21-c06f-2f42-b486a354b920")
                .build();
        okhttp3.Response response = client.newCall(request).execute();
        boolean isApiSuccessful = response.isSuccessful();
        System.out.println("Is api working fine ? = " +isApiSuccessful);
    /*    String jsonData = response.body().string();
        System.out.println("Response of board api = "+jsonData);*/
        return isApiSuccessful;
    }

    public int getHourOfDay(){
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        System.out.println("Value of hour = "+hour);
        return hour;
    }

    public String getFromLocationPlaceholder() {
        int hour = getHourOfDay();
        String pickupPoint = "";
        if (hour >= 10 && hour <= 18) {
            pickupPoint = "Enter office location";
        } else {
            pickupPoint = "Enter home location";
        }
        return pickupPoint;
    }

    public String getToLocationPlaceholder() {
        int hour = getHourOfDay();
        String dropPoint = "";
        if (hour >= 10 && hour <= 18) {
            dropPoint = "Enter home location";
        } else {
            dropPoint = "Enter office location";
        }
        return dropPoint;
    }





}




