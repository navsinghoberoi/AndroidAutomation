package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

/*
Before running testcase -- Need to clear device details and booking metadata (from sql and mongoDB).
*/

public class BookingPostpayRide extends Setup {

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
    private BookingCompletePage bookingCompletePage;
    private SubscriptionBuyAndRefundTest subscriptionBuyAndRefundTest;
    private TrackShuttlPage trackShuttlPage;
    private CancelOrRescheduleRidePage cancelOrRescheduleRidePage;
    private String className;


    @BeforeMethod
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
        bookingCompletePage = new BookingCompletePage(driver);
        subscriptionBuyAndRefundTest = new SubscriptionBuyAndRefundTest();
        //  commons.goToHomepage("postpayUserPhoneNumer", "postpayUserOTP");
        trackShuttlPage = new TrackShuttlPage(driver);
        cancelOrRescheduleRidePage = new CancelOrRescheduleRidePage(driver);
        className = getClass().getSimpleName() + commons.getCurrentTime();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            commons.captureScreenshot(driver, className);
            System.out.println("Screenshot taken for failed testcase");
        }
    }

    @AfterClass
    public void quit() {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyUserNotHaveSubscription() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        boolean result = passDetailsPage.isNoPassCTADisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 2)
    public void verifySlotsPage() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        boolean isDisplayed = slotsPage.isLocatePickupStopDisplayed();
        Assert.assertEquals(isDisplayed, true, "test case failed");
    }


    @Test(priority = 3)
    public void verifySlotsPageBackClick() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        homepage.clickBackButton();
        boolean isDisplayed = homepage.isFindRouteButtonDisplayed();
        System.out.println("Is search card displayed ? " + isDisplayed);
        Assert.assertEquals(isDisplayed, true, "test case failed");

    }


    @Test(priority = 4)
    public void verifyIsBannerDisplayedOnSlotsPage() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        boolean result = slotsPage.isBannerImageDisplayed();
        Assert.assertEquals(result, true);

    }

    @Test(priority = 5)
    public void verifyContinueCTADisplayedOnSlotsPage() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        String CTAtext = slotsPage.getCTAOnSlotsPage();
        Assert.assertEquals(CTAtext, "CONTINUE");
    }

    @Test(priority = 6)
    public void checkPostPayOptionDisplayed() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickCtaOnSlotsPage();    //Click Continue button
        boolean result = slotsPage.isPostpayOptionDisplayed();
        Assert.assertEquals(result, true);
    }


    @Test(priority = 7)
    public void checkPostPayOptionText() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickCtaOnSlotsPage();    //Click Continue button
        String result = slotsPage.checkPostpayOptionText();
        Assert.assertEquals(result, "Ride Now, Pay Later");
    }


    @Test(priority = 8)
    public void checkPostPayOptionSubtext() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickCtaOnSlotsPage();    //Click Continue button
        String result = slotsPage.checkPostpaySubtext();
        Assert.assertEquals(result, "Take a trial ride, and pay if you like your ride experience.");
    }


    @Test(priority = 9)
    public void verifyPostpayBookingCreate() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickCtaOnSlotsPage();    //Click Continue button
        slotsPage.clickPostPayOption();
        String actualText = bookingCompletePage.getBookingConfirmPopupTitle();
        System.out.println("Text after creating a booking = " + actualText);
        bookingCompletePage.clickBookingConfirmPopupCTA();
        Assert.assertEquals(actualText, "Ride Confirmed");

    }

    @Test(priority = 10)
    public void verifyActiveRideHomecardDisplayed() {
        boolean result = homepage.isTrackShuttlDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 11)
    public void cancelPostPayRide() {
        commons.openRideOptionsFromBookingHomecards();
        trackShuttlPage.selectRideOption(0);
        cancelOrRescheduleRidePage.selectCancelRescheduleCategory(1);
        cancelOrRescheduleRidePage.clickCancelRide();
        String result = cancelOrRescheduleRidePage.getRideCancelledPopupTitle();
        Assert.assertEquals(result, "Ride Cancelled", "test case failed");
    }


    @Test(priority = 12)
    public void verifyPostPayRideOptionAppearingAfterCancellingRide() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickCtaOnSlotsPage();    //Click Continue button
        String result = slotsPage.checkPostpayOptionText();
        Assert.assertEquals(result, "Ride Now, Pay Later");
    }


}
