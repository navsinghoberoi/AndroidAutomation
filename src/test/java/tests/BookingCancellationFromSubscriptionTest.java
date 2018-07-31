package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;


// Precondition -- Active booking should be present

public class BookingCancellationFromSubscriptionTest extends Setup {
    private HomePage homepage;
    private Commons commons;
    private TrackShuttlPage trackShuttlPage;
    private CancelOrRescheduleRidePage cancelOrRescheduleRidePage;
    private String className;

    @BeforeMethod
    public void setUp() throws Exception {
        createAndroidSession(true);
        homepage = new HomePage(driver);
        commons = new Commons(driver);
        trackShuttlPage = new TrackShuttlPage(driver);
        cancelOrRescheduleRidePage = new CancelOrRescheduleRidePage(driver);
        commons.goToHomepage("oldUserPhoneNumber","oldUserOTP");
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
        commons.openRideOptionsFromBookingHomecards();
        boolean result = commons.verifyIsLocatorPresent("Show Traffic", trackShuttlPage.getOptionsNameLocator());
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
        commons.openRideOptionsFromBookingHomecards();
        trackShuttlPage.selectRideOption(0);
        String title = cancelOrRescheduleRidePage.getCancelReschedulePageTitle();
        Assert.assertEquals(title, "Cancel or Reschedule Ride?", "test case failed");

    }


    @Test(priority = 8)
    public void verifyCrossIconClickOnRideCancelPage() {
        commons.openRideOptionsFromBookingHomecards();
        trackShuttlPage.selectRideOption(0);
        cancelOrRescheduleRidePage.crossIconClick();
        boolean result = commons.verifyIsLocatorPresent("Show Traffic", trackShuttlPage.getOptionsNameLocator());
        Assert.assertEquals(result, true, "test case failed");

    }


    @Test(priority = 9)
    public void verifyCancelRideCategoriesCount() {
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
    public void verifySelectedRideCancelCategoryText() {
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
    public void verifyCancelRidePopupText() {
        commons.openRideOptionsFromBookingHomecards();
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

