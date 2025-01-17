package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;


// Precondition -- Active booking and multiple slots should be present

public class BookingRescheduleTest extends Setup {
    private HomePage homepage;
    private Commons commons;
    private BookingCompletePage bookingCompletePage;
    private TrackShuttlPage trackShuttlPage;
    private CancelOrRescheduleRidePage cancelOrRescheduleRidePage;
    private String className;

    @BeforeMethod
    public void setUp() throws Exception {
        createAndroidSession(true);
        homepage = new HomePage(driver);
        commons = new Commons(driver);
        bookingCompletePage = new BookingCompletePage(driver);
        trackShuttlPage = new TrackShuttlPage(driver);
        cancelOrRescheduleRidePage = new CancelOrRescheduleRidePage(driver);
        commons.goToHomepage("userWithoutSubsPhoneNumber", "userWithoutSubsOTP");
        className = getClass().getSimpleName() + commons.getCurrentTime();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if (ITestResult.FAILURE == iTestResult.getStatus()){
            commons.captureScreenshot(driver, className + " " + iTestResult.getMethod().getMethodName());
            System.out.println("Screenshot taken for failed testcase");
        }
        driver.quit();
    }


    @AfterClass
    public void quit() {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }


    @Test
    public void passPurchaseAndCreateBookingViaApi() throws Exception
    {
        commons.subscriptionBuyViaApiEngine(getValueFromPPFile("BuyPassUserID")); // buy pass via api
        commons.createBookingViaApiEngine(getValueFromPPFile("CreateBookingUserId")); // createBooking via api
    }

    @Test(enabled = false)
    public void verifyActiveRideHomecardDisplayed() throws Exception {
        //adding this temporarily to login if user gets logged out due to bug in getSession api
        commons.goToHomepage("userWithoutSubsPhoneNumber", "userWithoutSubsOTP");
        boolean result = homepage.isTrackShuttlDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }

    @Test(priority = 1,enabled = false)
    public void verifyPPNameOnActiveRide() {
        String ppName = homepage.getBookingHomecardData();
        boolean isPickupPointSame = ppName.contains("Rithala");     // Because booking will be made from this point in createBooking scenario
        Assert.assertEquals(isPickupPointSame, true, "Pickup point on the booking homecard does not matches");
    }


    @Test(priority = 2,enabled = false)
    public void verifyTrackShuttlClick() {
        homepage.clickBookingHomeCard();
        trackShuttlPage.dismissProtip();
        boolean result = trackShuttlPage.isTrackShuttlPageOpened();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 3,enabled = false)
    public void verifyBackButtonClickOnTrackShuttlPage() {
        homepage.clickBookingHomeCard();
        trackShuttlPage.clickBackIcon();
        boolean isActiveBooking = homepage.isTrackShuttlDisplayed();
        Assert.assertEquals(isActiveBooking, true, "test case failed");
    }


    @Test(priority = 4,enabled = false)
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


    @Test(priority = 5,enabled = false)
    public void verifyShowTrafficOptionDisplayed() {
        commons.openRideOptionsFromBookingHomecards();
        boolean result = commons.verifyIsLocatorPresent("Show Traffic", trackShuttlPage.getOptionsNameLocator());
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 6,enabled = false)
    public void verifyProtipTextOnTrackShuttl() {
        homepage.clickBookingHomeCard();
        String result = trackShuttlPage.getProtipText();
        Assert.assertEquals(result, "You can always reschedule to get an early Shuttl or postpone to a later time.", "test case failed");
    }


    @Test(priority = 7,enabled = false)
    public void verifyRideReschedulePageTitle() {
        commons.openRideOptionsFromBookingHomecards();
        trackShuttlPage.selectRideOption(0);
        String title = cancelOrRescheduleRidePage.getCancelReschedulePageTitle();
        Assert.assertEquals(title, "Cancel or Reschedule Ride?", "test case failed");

    }


    @Test(priority = 8)
    public void verifyCrossIconClickOnRideReschedulePage() {
        commons.openRideOptionsFromBookingHomecards();
        trackShuttlPage.selectRideOption(0);
        cancelOrRescheduleRidePage.crossIconClick();
        boolean result = commons.verifyIsLocatorPresent("Show Traffic", trackShuttlPage.getOptionsNameLocator());
        Assert.assertEquals(result, true, "test case failed");

    }


    @Test(priority = 9)
    public void verifyRescheduleRideCategoriesCount() {
        boolean result;
        commons.openRideOptionsFromBookingHomecards();
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
    public void verifySelectedRideRescheduleCategoryText() {
        commons.openRideOptionsFromBookingHomecards();
        trackShuttlPage.selectRideOption(0);
        String cancelCategoryText = cancelOrRescheduleRidePage.selectCancelRescheduleCategory(1);
        String cancelSelectedCategory = cancelOrRescheduleRidePage.getCancelRescheduleSelectedCategoryText();
        Assert.assertEquals(cancelCategoryText, cancelSelectedCategory, "test case failed");
    }


    @Test(priority = 11)
    public void verifyRideSelectedCategoryBackIconClick() {
        commons.openRideOptionsFromBookingHomecards();
        trackShuttlPage.selectRideOption(0);
        cancelOrRescheduleRidePage.selectCancelRescheduleCategory(1);
        cancelOrRescheduleRidePage.backIconClick();
        String title = cancelOrRescheduleRidePage.getCancelReschedulePageTitle();
        Assert.assertEquals(title, "Cancel or Reschedule Ride?", "test case failed");
    }


    @Test(priority = 12)
    public void verifyCancelAndRescheduleButtonsDisplayedFirstCategory() {
        boolean result;
        commons.openRideOptionsFromBookingHomecards();
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
        commons.openRideOptionsFromBookingHomecards();
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
        commons.openRideOptionsFromBookingHomecards();
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
    public void verifyTimeslotsPageOnClickOfRescheduleRide() {
        commons.openRideOptionsFromBookingHomecards();
        trackShuttlPage.selectRideOption(0);
        cancelOrRescheduleRidePage.selectCancelRescheduleCategory(1);
        cancelOrRescheduleRidePage.clickResheduleRide();
        String result = cancelOrRescheduleRidePage.rescheduleSlotsPageSubtext();
        Assert.assertEquals(result, "Please select a suitable timeslot to book a new ride", "test case failed");
    }


    @Test(priority = 16)
    public void verifySubtextAfterSelectingRideForRescheduling() throws Exception {
        commons.openRideOptionsFromBookingHomecards();
        trackShuttlPage.selectRideOption(0);
        cancelOrRescheduleRidePage.selectCancelRescheduleCategory(1);
        cancelOrRescheduleRidePage.clickResheduleRide();
        cancelOrRescheduleRidePage.clickRescheduleSlot(1);
        String result = cancelOrRescheduleRidePage.rescheduleSlotsPageReserveSeatSubtext();
        Assert.assertEquals(result, "Your current ride will be cancelled automatically", "test case failed");

    }


    @Test(priority = 17)
    public void verifyRescheduleRideConfirmationPopup() throws Exception {
        commons.openRideOptionsFromBookingHomecards();
        trackShuttlPage.selectRideOption(0);
        cancelOrRescheduleRidePage.selectCancelRescheduleCategory(1);
        cancelOrRescheduleRidePage.clickResheduleRide();
        cancelOrRescheduleRidePage.clickRescheduleSlot(1);
        cancelOrRescheduleRidePage.reserveSeatForRescheduleRide();
        String actualText = bookingCompletePage.getBookingConfirmPopupTitle();
        System.out.println("Text after rescheduling a booking = " + actualText);
        bookingCompletePage.clickBookingConfirmPopupCTA();
        Assert.assertEquals(actualText, "Ride Confirmed", "Booking is not rescheduled");
    }


    @Test(priority = 18)
    public void verifyRescheduledRideAppearingOnHomepage() {
        boolean result = homepage.isTrackShuttlDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }

    @Test(priority = 19)
    public void refundPassAndCancelBookingViaApi() throws Exception {
        commons.refundSubscriptionViaApiEngine(getValueFromPPFile("RefundPassUserID")); // refund sub via api
        commons.cancelBookingViaApiEngine(getValueFromPPFile("CancelBookingUserId")); // cancel booking via api
    }

}