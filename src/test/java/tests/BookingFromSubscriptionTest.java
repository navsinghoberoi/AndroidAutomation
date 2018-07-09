package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;


public class BookingFromSubscriptionTest extends Setup {

// NOTE -- Need to book ride on morning/evening route as per current time

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
    private String ridesLeftCountBeforeBooking;
    private String ridesLeftCountAfterBooking;
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
        commons.goToHomepage("oldUserPhoneNumber", "oldUserOTP");
        className = getClass().getSimpleName() + commons.getCurrentTime();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if (ITestResult.FAILURE == iTestResult.getStatus()){
            commons.captureScreenshot(driver,className);
            System.out.println("Screenshot taken for failed testcase");
        }
        driver.quit();
    }


    @AfterClass
    public void quit() {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }
    @Test(priority = 1)
    public void verifyIsSubscriptionDisplayed() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        boolean result = passDetailsPage.isNoPassCTADisplayed();
        Assert.assertEquals(result, false, "test case failed");

    }


    @Test(priority = 2)
    public void verifyRidesCountBeforeBooking() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        String ridesCountBeforeBooking = passDetailsPage.getRidesRemaining(0);
       /*String rides[] = ridesCountBeforeBooking.split("/");
       ridesLeftCountBeforeBooking = rides[0].trim();*/
        ridesLeftCountBeforeBooking = commons.splitAndTrimString(ridesCountBeforeBooking,0,"/");
        System.out.println(ridesLeftCountBeforeBooking);
    }


    @Test(priority = 3)
    public void verifySlotsPage() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        boolean isDisplayed = slotsPage.isLocatePickupStopDisplayed();
        Assert.assertEquals(isDisplayed, true, "test case failed");
    }


    @Test(priority = 4)
    public void verifySlotsPageBackClick() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        homepage.clickBackButton();
        boolean isDisplayed = homepage.isFindRouteButtonDisplayed();
        System.out.println("Is search card displayed ? " + isDisplayed);
        Assert.assertEquals(isDisplayed, true, "test case failed");

    }


    @Test(priority = 5)
    public void verifyIsRidesRemainingDisplayedOnSlotsPage() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        boolean result = slotsPage.isRidesRemainingDisplayedOnSlotsPage();
        Assert.assertEquals(result, true, "test case failed");
    }



    @Test(priority = 6)
    public void verifyRidesRemainingCountOnSlotsPage() throws Exception {
        boolean result;
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        String count = slotsPage.getRidesRemainingCountOnSlotsPage();
      /* String rides[] = count.split(" ");
       String countOnSlotsPage = rides[0];*/
        String countOnSlotsPage = commons.splitAndTrimString(count,0," ");
        System.out.println(countOnSlotsPage);
        System.out.println(ridesLeftCountBeforeBooking);   // remove this line

        if(countOnSlotsPage.equalsIgnoreCase(ridesLeftCountBeforeBooking)){
            result = true;
        }else
        {
            result = false;
        }

        Assert.assertEquals(result,true,"test case failed");
    }

    @Test(priority = 7)
    public void verifyReserveSeatDisplayed() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        boolean result = slotsPage.isReserveSeatButtonEnabled();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 8)
    public void verifyCreateBooking() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickCtaOnSlotsPage();
        String actualText = bookingCompletePage.getBookingConfirmPopupTitle();
        System.out.println("Text after creating a booking = " + actualText);
        bookingCompletePage.clickBookingConfirmPopupCTA();
        Assert.assertEquals(actualText, "Ride Confirmed");
    }


    @Test(priority = 9)
    public void verifyActiveRideHomecardDisplayed() {
        boolean result = homepage.isTrackShuttlDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }

    @Test(priority = 10)
    public void verifyCreateBookingOnSameSlot() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickCtaOnSlotsPage();
        boolean result = slotsPage.isAlertDisplayedForBookingSameRoute();
        Assert.assertEquals(result, true, "test case failed");
    }

    @Test(priority = 11)
    public void verifyRidesCountAfterBookingRide() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        String ridesCountAfterBooking = passDetailsPage.getRidesRemaining(0);
       /*String rides[] = ridesCountAfterBooking.split("/");
       ridesLeftCountAfterBooking = rides[0].trim();*/
        ridesLeftCountAfterBooking = commons.splitAndTrimString(ridesCountAfterBooking,0,"/");
        System.out.println(ridesLeftCountAfterBooking);
    }


    @Test(priority = 12)
    public void verifyRideCountDecreaseAfterCreatingBooking() {
        boolean result;
        if ((Integer.parseInt(ridesLeftCountBeforeBooking) - Integer.parseInt(ridesLeftCountAfterBooking)) == 1) {
            System.out.println("Rides count before booking > Rides count after booking ");
            result = true;
        } else {
            result = false;
        }

        Assert.assertEquals(result, true, "test case failed");

    }

}
