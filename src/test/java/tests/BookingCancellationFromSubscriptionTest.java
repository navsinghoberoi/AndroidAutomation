package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;


// Precondition -- Active booking should be present

public class BookingCancellationFromSubscriptionTest extends Setup {
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
        trackShuttlPage = new TrackShuttlPage(driver);
        cancelOrRescheduleRidePage = new CancelOrRescheduleRidePage(driver);
        //   commons.goToHomepage("oldUserPhoneNumber","oldUserOTP");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }


    @Test
    public void verifyActiveRideHomecardDisplayed() {
        boolean result = homepage.isTrackShuttlDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }

    @Test(priority = 1)
    public void verifyPPNameOnActiveRide() {
        String ppName = homepage.getBookingHomecardData();
        boolean isPickupPointSame = ppName.contains("Rithala");     // Because booking will be made from this point in createBooking scenario
        Assert.assertEquals(isPickupPointSame, true, "Pickup point on the booking homecard does not matches");
    }


    @Test(priority = 2)
    public void verifyTrackShuttlClick() {
        homepage.clickBookingHomeCard();
        trackShuttlPage.dismissProtip();
        boolean result = trackShuttlPage.isTrackShuttlPageOpened();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 3)
    public void verifyBackButtonClickOnTrackShuttlPage() {
        homepage.clickBookingHomeCard();
        trackShuttlPage.clickBackIcon();
        boolean isActiveBooking = homepage.isTrackShuttlDisplayed();
        Assert.assertEquals(isActiveBooking, true, "test case failed");
    }


    @Test(priority = 4)
    public void verifyOptionsCountOnTrackShuttlPage() {
        boolean result;
        homepage.clickBookingHomeCard();
        trackShuttlPage.dismissProtip();
        int optionsCount = trackShuttlPage.printOptionValues();
        if (optionsCount == 5) {
            result = true;
        } else {
            result = false;
        }

        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 5)
    public void verifyShowTrafficOptionDisplayed() {
        homepage.clickBookingHomeCard();
        trackShuttlPage.dismissProtip();
        trackShuttlPage.clickOptionsIcon();
        boolean result = commons.verifyIsStringPresent("Show Traffic", trackShuttlPage.optionsName);
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 6)
    public void verifyProtipTextOnTrackShuttl() {
        homepage.clickBookingHomeCard();
        String result = trackShuttlPage.getProtipText();
        Assert.assertEquals(result, "You can always reschedule to get an early Shuttl or postpone to a later time.", "test case failed");
    }


    @Test(priority = 7)
    public void verifyRideCancelPageTitle() {
        homepage.clickBookingHomeCard();
        trackShuttlPage.dismissProtip();
        trackShuttlPage.clickOptionsIcon();
        trackShuttlPage.selectRideOption(0);
        String title = cancelOrRescheduleRidePage.getCancelReschedulePageTitle();
        Assert.assertEquals(title, "Cancel or Reschedule Ride?", "test case failed");

    }


    @Test(priority = 8)
    public void verifyCrossIconClickOnRideCancelPage() {
        homepage.clickBookingHomeCard();
        trackShuttlPage.dismissProtip();
        trackShuttlPage.clickOptionsIcon();
        trackShuttlPage.selectRideOption(0);
        cancelOrRescheduleRidePage.crossIconClick();
        boolean result = commons.verifyIsStringPresent("Show Traffic", trackShuttlPage.optionsName);
        Assert.assertEquals(result, true, "test case failed");

    }


    @Test(priority = 9)
    public void verifyCancelRideCategoriesCount() {
        boolean result;
        homepage.clickBookingHomeCard();
        trackShuttlPage.dismissProtip();
        trackShuttlPage.clickOptionsIcon();
        trackShuttlPage.selectRideOption(0);
        int size = cancelOrRescheduleRidePage.getCancelRescheduleCategories();
        if (size == 3) {
            result = true;
        } else {
            result = false;
        }
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 10)
    public void verifySelectedRideCancelCategoryText() {
        homepage.clickBookingHomeCard();
        trackShuttlPage.dismissProtip();
        trackShuttlPage.clickOptionsIcon();
        trackShuttlPage.selectRideOption(0);
        String cancelCategoryText = cancelOrRescheduleRidePage.selectCancelRescheduleCategory(1);
        String cancelSelectedCategory = cancelOrRescheduleRidePage.getCancelRescheduleSelectedCategoryText();
        Assert.assertEquals(cancelCategoryText, cancelSelectedCategory, "test case failed");
    }


    @Test(priority = 11)
    public void verifyRideSelectedCategoryBackIconClick() {
        homepage.clickBookingHomeCard();
        trackShuttlPage.dismissProtip();
        trackShuttlPage.clickOptionsIcon();
        trackShuttlPage.selectRideOption(0);
        cancelOrRescheduleRidePage.selectCancelRescheduleCategory(1);
        cancelOrRescheduleRidePage.backIconClick();
        String title = cancelOrRescheduleRidePage.getCancelReschedulePageTitle();
        Assert.assertEquals(title, "Cancel or Reschedule Ride?", "test case failed");
    }


    @Test(priority = 12)
    public void verifyCancelAndRescheduleButtonsDisplayedFirstCategory() {
        boolean result;
        homepage.clickBookingHomeCard();
        trackShuttlPage.dismissProtip();
        trackShuttlPage.clickOptionsIcon();
        trackShuttlPage.selectRideOption(0);
        cancelOrRescheduleRidePage.selectCancelRescheduleCategory(0);
        boolean isCancelRideButtonDisplayed = cancelOrRescheduleRidePage.isCancelRideButtonDisplayed();
        boolean isRescheduleRideButtonDisplayed = cancelOrRescheduleRidePage.isRescheduleRideButtonDisplayed();
        if (isCancelRideButtonDisplayed == true && isRescheduleRideButtonDisplayed == true) {
            result = true;
        } else {
            result = false;
        }

        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 13)
    public void verifyCancelAndRescheduleButtonsDisplayedSecondCategory() {
        boolean result;
        homepage.clickBookingHomeCard();
        trackShuttlPage.dismissProtip();
        trackShuttlPage.clickOptionsIcon();
        trackShuttlPage.selectRideOption(0);
        cancelOrRescheduleRidePage.selectCancelRescheduleCategory(1);
        boolean isCancelRideButtonDisplayed = cancelOrRescheduleRidePage.isCancelRideButtonDisplayed();
        boolean isRescheduleRideButtonDisplayed = cancelOrRescheduleRidePage.isRescheduleRideButtonDisplayed();
        if (isCancelRideButtonDisplayed == true && isRescheduleRideButtonDisplayed == true) {
            result = true;
        } else {
            result = false;
        }

        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 14)
    public void verifyCancelAndRescheduleButtonsDisplayedThirdCategory() {
        boolean result;
        homepage.clickBookingHomeCard();
        trackShuttlPage.dismissProtip();
        trackShuttlPage.clickOptionsIcon();
        trackShuttlPage.selectRideOption(0);
        cancelOrRescheduleRidePage.selectCancelRescheduleCategory(2);
        boolean isCancelRideButtonDisplayed = cancelOrRescheduleRidePage.isCancelRideButtonDisplayed();
        boolean isRescheduleRideButtonDisplayed = cancelOrRescheduleRidePage.isRescheduleRideButtonDisplayed();
        if (isCancelRideButtonDisplayed == true && isRescheduleRideButtonDisplayed == false) {
            result = true;
        } else {
            result = false;
        }

        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 15)
    public void verifyCancelRidePopupText() {
        homepage.clickBookingHomeCard();
        trackShuttlPage.dismissProtip();
        trackShuttlPage.clickOptionsIcon();
        trackShuttlPage.selectRideOption(0);
        cancelOrRescheduleRidePage.selectCancelRescheduleCategory(1);
        cancelOrRescheduleRidePage.clickCancelRide();
        String result = cancelOrRescheduleRidePage.getRideCancelledPopupTitle();
        Assert.assertEquals(result, "Ride Cancelled", "test case failed");
    }

    @Test(priority = 16)
    public void verifyRideCancelledNotAppearingOnHomepage() {
        boolean result = homepage.isTrackShuttlDisplayed();
        Assert.assertEquals(result, false, "test case failed");

    }


}
