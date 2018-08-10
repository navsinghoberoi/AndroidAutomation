package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class PostBoardingTest extends Setup {

    private HomePage homepage;
    private Commons commons;
    private TrackShuttlPage trackShuttlPage;
    private MyRidesPage myRidesPage;
    private MenuPage menuPage;
    private String className;
    private int bookingIdFromAPI;

    @BeforeMethod
    public void setUp() throws Exception {
        createAndroidSession(true);
        homepage = new HomePage(driver);
        commons = new Commons(driver);
        trackShuttlPage = new TrackShuttlPage(driver);
        myRidesPage = new MyRidesPage(driver);
        menuPage = new MenuPage(driver);
        commons.goToHomepage("userWithoutSubsPhoneNumber", "userWithoutSubsOTP");
        className = getClass().getSimpleName() + commons.getCurrentTime();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            commons.captureScreenshot(driver, className + " " + iTestResult.getMethod().getMethodName());
            System.out.println("Screenshot taken for failed testcase");
        }
        driver.quit();
    }

    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }

    @Test(priority=0)
    public void buyPassAndCreateBookingViaApi() throws Exception
    {
        commons.subscriptionBuyViaApiEngine(getValueFromPPFile("BuyPassUserID")); // buy pass via api
        bookingIdFromAPI =  commons.createBookingViaApiEngine(getValueFromPPFile("CreateBookingUserId")); // createBooking via api
    }

    @Test(priority = 1)
    public void verifyActiveRideHomecardDisplayed() throws Exception {
        //adding this temporarily to login if user gets logged out due to bug in getSession api
        commons.goToHomepage("userWithoutSubsPhoneNumber", "userWithoutSubsOTP");
        boolean result = homepage.isTrackShuttlDisplayed();
        Assert.assertEquals(result, true);
    }

    @Test(priority = 2)
    public void boardActiveRideViaApi() throws Exception {
        boolean isRideBoarded =    commons.boardRideViaApiEngine(getValueFromPPFile("QA_UMS_URL"), +bookingIdFromAPI);
        System.out.println("Is ride boarded using the /board api ? = "+isRideBoarded);
        Assert.assertEquals(isRideBoarded,true);
    }

    @Test(priority = 2)
    public void verifyOngoingAppearingOnBookingHomecard() throws Exception {
        //adding this temporarily to login if user gets logged out due to bug in getSession api
        commons.goToHomepage("userWithoutSubsPhoneNumber", "userWithoutSubsOTP");
        String boardedHomecardText = homepage.getOngoingBookingHomecardText();
        Assert.assertEquals(boardedHomecardText, "Ongoing");
    }

    @Test(priority = 3)
    public void verifyBoardingSuccessfulPopup() {
        homepage.openBoardedRideHomecard();
        String boardingSuccessfulPopupTitle = trackShuttlPage.getBoardingSuccessfulPopupTitle();
        System.out.println(boardingSuccessfulPopupTitle);
        Assert.assertEquals(boardingSuccessfulPopupTitle, "Boarding Successful");
    }


    @Test(priority = 4)
    public void verifyChirpButtonNotDisplayedPostBoarding() {
        homepage.openBoardedRideHomecard();
        boolean pressToBoardCTADisplayed = trackShuttlPage.checkPressToBoardCTADisplayed();
        Assert.assertEquals(pressToBoardCTADisplayed, false);
    }


    @Test(priority = 5)
    public void verifyDropPointNameOnTrackShuttl() {
        homepage.openBoardedRideHomecard();
        String dropPointNameOnTrackShuttl = trackShuttlPage.getDropPointName();
        System.out.println("Name of drop point on track shuttl = " + dropPointNameOnTrackShuttl);
        trackShuttlPage.clickBackIcon();
        homepage.clickMenu();
        menuPage.clickMyRides();
        String dropPointNameOnMyRides = myRidesPage.getDropPointInMyRidesText();
        System.out.println("Drop point name on my rides page = " + dropPointNameOnMyRides);
        Assert.assertEquals(dropPointNameOnTrackShuttl, dropPointNameOnMyRides);
    }


    @Test(priority = 6)
    public void verifyETAToReachDropPointDisplayed() throws Exception {
        boolean isDropPointETAAppearing;
        homepage.openBoardedRideHomecard();
        String dropStopReachTimeText = trackShuttlPage.getDropStopReachTimeText();
        if (dropStopReachTimeText.contains(getValueFromPPFile("dropPointETAText"))) {
            isDropPointETAAppearing = true;
        } else {
            isDropPointETAAppearing = false;
        }
        Assert.assertEquals(isDropPointETAAppearing, true);
    }

    @Test(priority = 7)
    public void verifySOSButtonDisplayed() {
        homepage.openBoardedRideHomecard();
        boolean SOSbuttonDisplayed = trackShuttlPage.isSOSbuttonDisplayed();
        Assert.assertEquals(SOSbuttonDisplayed, true);
    }

    @Test(priority = 8)
    public void verifySOSButtonClickable() {
        homepage.openBoardedRideHomecard();
        boolean SOSbuttonClickable = trackShuttlPage.isSOSButtonClickable();
        Assert.assertEquals(SOSbuttonClickable, true);
    }


    @Test(priority = 9)
    public void verifyShareRideStatusOptionAppearing() {
        commons.openRideOptionsFromBookingHomecardsForBoardedRide();
        boolean shareRideStatusOptionAppearing = commons.verifyIsLocatorPresent("Share Ride Status", trackShuttlPage.getOptionsNameLocator());
        Assert.assertEquals(shareRideStatusOptionAppearing, true);
    }


    @Test(priority = 10)
    public void verifyShowTrafficOptionAppearing() {
        commons.openRideOptionsFromBookingHomecardsForBoardedRide();
        boolean showTrafficOptionAppearing = commons.verifyIsLocatorPresent("Show Traffic", trackShuttlPage.getOptionsNameLocator());
        Assert.assertEquals(showTrafficOptionAppearing, true);
    }


    @Test(priority = 11)
    public void verifyCancelOrRescheduleRideOptionNotAppearing() {
        commons.openRideOptionsFromBookingHomecardsForBoardedRide();
        boolean cancelRideOptionAppearing = commons.verifyIsLocatorPresent("Cancel/Reschedule this trip", trackShuttlPage.getOptionsNameLocator());
        Assert.assertEquals(cancelRideOptionAppearing, false);
    }

    @Test(priority = 12)
    public void refundPassViaApi() throws Exception {
        commons.refundSubscriptionViaApiEngine(getValueFromPPFile("RefundPassUserID")); // refund sub via api
    }

}
