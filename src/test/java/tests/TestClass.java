package tests;

import common.Commons;
import io.restassured.response.Response;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import apiEngine.ApiHelper;

import java.io.IOException;
/*
Intent of this class is to check new implementations or amend existing implementation
*/

public class TestClass extends BasePage {
    public static WebDriver driver;
    private LandingPage landingPage;
    private LoginPage loginPage;
    private PersonalDetailsPage personalDetails;
    private HomeAddressPage homeAddressPage;
    private OfficeAddressPage officeAddressPage;
    private OtpPage otpPage;
    private HomePage homepage;
    private Commons commons;
    private SelectLocationPage selectLocationPage;
    private SlotsPage slotsPage;
    private ExplorePassesPage explorePassesPage;
    private ChooseBenefitsPage chooseBenefitsPage;
    private ReviewRoutePage reviewRoutePage;
    private PassCompletePaymentPage passCompletePaymentPage;
    private PassDetailsPage passDetailsPage;
    private RefundPassPage refundPassPage;
    private String className;
    private static String api = "https://dkr-serviceadmin.goplus.in/addTrip?tripId=0&slot=17:47:00&type=Extra%20Trip&vehicleId=3&routeId=241";
    private static MyRidesPage myRidesPage;

    @BeforeClass
    public void setUp() throws Exception {
        createAndroidSession(true);
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        personalDetails = new PersonalDetailsPage(driver);
        homeAddressPage = new HomeAddressPage(driver);
        officeAddressPage = new OfficeAddressPage(driver);
        otpPage = new OtpPage(driver);
        homepage = new HomePage(driver);
        commons = new Commons(driver);
        selectLocationPage = new SelectLocationPage(driver);
        slotsPage = new SlotsPage(driver);
        explorePassesPage = new ExplorePassesPage(driver);
        chooseBenefitsPage = new ChooseBenefitsPage(driver);
        reviewRoutePage = new ReviewRoutePage(driver);
        passCompletePaymentPage = new PassCompletePaymentPage(driver);
        passDetailsPage = new PassDetailsPage(driver);
        refundPassPage = new RefundPassPage(driver);
        className = getClass().getSimpleName() + commons.getCurrentTime();
        myRidesPage = new MyRidesPage(driver);
    }

    public TestClass(WebDriver driver) {
        super(driver);
    }

    @Test(priority = 1, enabled = true)
    public void testQAUMSDBConnection() throws Exception {
        String dbValue = commons.connectSQLDbAndFetchValue(getValueFromPPFile("umsQaDbIP"), getValueFromPPFile("umsQaDbUserName"), getValueFromPPFile("umsQaDbPassword"), getValueFromPPFile("umsQaDbName"), getValueFromPPFile("umsQaDbSqlQuery"), getValueFromPPFile("umsQaDbColumnName"));
        System.out.println("Value fetched from qa database = " + dbValue);
        System.out.println("------------ End of test 1 ----------------");
    }


    @Test(priority = 2, enabled = true)
    public void testProdUMSDBConnection() throws Exception {
        String dbValue = commons.connectSQLDbAndFetchValue(getValueFromPPFile("umsProdDbIP"), getValueFromPPFile("umsProdDbUserName"), getValueFromPPFile("umsProdDbPassword"), getValueFromPPFile("umsProdDbName"), getValueFromPPFile("umsProdDbSqlQuery"), getValueFromPPFile("umsProdDbColumnName"));
        System.out.println("Value fetched from prod database = " + dbValue);
        System.out.println("------------ End of test 2 ----------------");
    }


    @Test(priority = 3)
    public void subscriptionBuyViaApiEngine(String UserID) {
        System.out.println("----------------Buy user subscription --------------");

        Response response = ApiHelper.buySub(UserID);
        boolean value1 = commons.getBooleanValueFromApiResponse(response, "success");
        int value2 = commons.getIntegerValueFromApiResponse(response, "data.userSubscriptionId");
        Assert.assertEquals(value1, true);
    }

    @Test(priority = 4)
    public void getActiveUserSubscriptionViaApiEngine() {
        System.out.println("----------------Get active user subscription --------------");
        ApiHelper.getUserActiveSubs("652245");
    }

    @Test(priority = 5)
    public void createBookingViaApiEngine() {
        System.out.println("-------------- Create booking --------------");
        Response response = ApiHelper.createBooking("652245");
        boolean value1 = commons.getBooleanValueFromApiResponse(response, "success");
        int value2 = commons.getIntegerValueFromApiResponse(response, "data.bookingId");
        Assert.assertEquals(value1, true);

    }

    @Test(priority = 6)
    public void cancelBookingViaApiEngine() {
        System.out.println("-------------- Cancel booking --------------");
        Response response = ApiHelper.cancelBooking("652245");
        boolean value1 = commons.getBooleanValueFromApiResponse(response, "success");
        String value2 = commons.getStringValueFromApiResponse(response, "data.bookingStatus");
        Assert.assertEquals(value1, true);
        Assert.assertEquals(value2, "CANCELLED");

    }

    @Test(priority = 7)
    public void refundSubscriptionViaApiEngine(String UserID) {
        System.out.println("-------------- Refund Subscription --------------");
        Response response = ApiHelper.refundSubscription(UserID);
        boolean value1 = commons.getBooleanValueFromApiResponse(response, "success");
        String value2 = commons.getStringValueFromApiResponse(response, "data.title");
        Assert.assertEquals(value1, true);
        Assert.assertEquals(value2, "Refund Successful");

    }

    public static void createTrip() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(api)
                .get()
                .addHeader("Cookie", "authToken=f6ce750a-4048-4a17-b243-cac7358fd307")
                .addHeader("Cache-Control", "no-cache")
                .build();

        okhttp3.Response response = client.newCall(request).execute();
        System.out.println("Is api response successful = " + response.isSuccessful());
    }

    public static void main(String args[]) throws Exception {
        /*Commons commons = new Commons(driver);
        commons.subscriptionBuyViaApiEngine("652245");
        commons.getActiveUserSubscriptionViaApiEngine("652245");
        commons.createBookingViaApiEngine("652245");
        commons.cancelBookingViaApiEngine("652245");
        commons.refundSubscriptionViaApiEngine("652245");*/

        //       createTrip();


    }
}

