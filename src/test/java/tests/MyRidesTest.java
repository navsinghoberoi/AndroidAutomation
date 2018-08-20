package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BookingCompletePage;
import pages.HomePage;
import pages.MenuPage;
import pages.MyRidesPage;

import java.security.PublicKey;

public class MyRidesTest extends Setup {

    private HomePage homePage;
    private Commons commons;
    private MenuPage menuPage;
    private MyRidesPage myRidesPage;
    private String className;
    private BookingCompletePage bookingCompletePage;
//    private String newUser;
//    private String bookingForUser;

    @BeforeClass
    public void setUp() throws Exception {
        createAndroidSession(true);
        commons = new Commons(driver);
        menuPage = new MenuPage(driver);
        //commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        //Thread.sleep(10000L);
        homePage = new HomePage(driver);
        homePage.clickMenu();
        myRidesPage = new MyRidesPage(driver);
        className = getClass().getSimpleName() + commons.getCurrentTime();
        bookingCompletePage = new BookingCompletePage(driver);
//        newUser = commons.connectSQLDbAndFetchValue(getValueFromPPFile("umsQaDbIP"), getValueFromPPFile("umsQaDbUserName"), getValueFromPPFile("umsQaDbPassword"), getValueFromPPFile("umsQaDbName"), getValueFromPPFile("umsQaDbSqlQueryFetchUserThroughPHNumber"), getValueFromPPFile("umsQaDbFetchUserId"));
//        bookingForUser = commons.connectSQLDbAndFetchValue(getValueFromPPFile("umsQaDbIP"), getValueFromPPFile("umsQaDbUserName"), getValueFromPPFile("umsQaDbPassword"), getValueFromPPFile("umsQaDbName"), getValueFromPPFile("umsQaDbSqlQueryFetchUserThroughPHNumber"), getValueFromPPFile("umsQaDbFetchUserBooking"));

    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            commons.captureScreenshot(driver, className);
            System.out.println("Screenshot taken for failed testcase");
        }
        //  driver.quit();
    }

    @AfterClass
    public void quit() {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyMyRidesDisplayText() throws Exception {
        String ridesDisplayText = myRidesPage.getMyRidesDisplayText();
        Assert.assertEquals(ridesDisplayText, "My Rides");
        myRidesPage.clickMyRidesDisplayText();
    }

    @Test(priority = 2)
    public void verifyMyRidesTitleText() throws Exception {
        String myRidesTitleText = myRidesPage.getMyRidesTitleText();
        Assert.assertEquals(myRidesTitleText, "My Rides");
    }

    @Test(priority = 3)
    public void verifyActiveRidesWindowTabWhenNoBooking() throws Exception {
        String activeRidesWindow = myRidesPage.getActiveRidesWindows();
        Assert.assertEquals(activeRidesWindow, "You don't have any active rides");
    }

//    @Test(priority = 4,enabled = false)
//    public void verifyHistoryTabWhenNoBooking() throws Exception {
//        myRidesPage.clickHistoryRidesTab();
//        String historyTabWithNoRidesText = myRidesPage.getHistoryTabWithNoRides();
//        Assert.assertEquals(historyTabWithNoRidesText, "You haven't taken any rides yet");
//    }

    @Test(priority = 4)
    public void verifyCurrentRideTabOnBooking() throws Exception {
        driver.navigate().back();
        //Buy a subscription through API
        commons.subscriptionBuyViaApiEngine(getValueFromPPFile("BuyPassUserIDNewuser"));
        //Booked a ride first through API
        commons.createBookingViaApiEngine(getValueFromPPFile("CreateBookingNewUserId"));
        driver.navigate().back();
        commons.enterUserPhoneNumberOTP("old1UserPhoneNumber", "OTP");
        homePage.clickSearchBar();
        driver.navigate().back();
        homePage.clickMenu();
        myRidesPage.clickMyRidesDisplayText();
        boolean currentRideDisplay = myRidesPage.getCurrentRide();
        Assert.assertEquals(currentRideDisplay, true, "Current Ride is displayed");
    }

    @Test(priority = 5)
    public void verifyHistoryRidesTab() throws Exception {
        myRidesPage.clickHistoryRidesTab();
        String activeTab = myRidesPage.getHistoryRidesTab();
        Assert.assertEquals(activeTab, "HISTORY");

    }

    @Test(priority = 6)
    public void verifyRideSelectionFromHistory() throws Exception {
        myRidesPage.clickRidesSelection();
        String rideNowButton = myRidesPage.getRideNowButtonText();
        Assert.assertEquals(rideNowButton, "RIDE NOW");
    }

    @Test(priority = 7)
    public void verifyGetRideNowTitleText() {
        myRidesPage.clickRideNowButton();
        String rideNowTitleText = myRidesPage.getRideNowTitleText();
        Assert.assertEquals(rideNowTitleText, "Select a Timeslot");
        myRidesPage.clickBackButton();
    }

    @Test(priority = 8)
    public void verifySelectedHistoryRideTitleText() throws Exception {
        String historyRideTitleText = myRidesPage.getHistoryTitleText();
        Assert.assertEquals(historyRideTitleText, myRidesPage.getRideSelectionDate());
    }

    @Test(priority = 9)
    public void verifyPickAndDropLocationText() {
        String pickupPoint = myRidesPage.getPickupPointText();
        String getPickupPointInMyRidesText = myRidesPage.getPickupPointInMyRidesText();
        if (pickupPoint.equals(getPickupPointInMyRidesText)) {
            String pickupPointInMyRides = myRidesPage.getPickupPointInMyRidesText();
            Assert.assertEquals(pickupPointInMyRides, myRidesPage.getPickupPointText());
        }
    }

    @Test(priority = 10)
    public void verifyNeedHelpWithTheRide() {
        String needHelpText = myRidesPage.getNeedHelpWithThisRideText();
        Assert.assertEquals(needHelpText, "NEED HELP WITH THIS RIDE?");
    }

    @Test(priority = 11)
    public void verifyCurrentTabAfterCancelBooking() throws Exception {
        //ApiHelper.cancelBooking(userId);
        commons.cancelBookingViaApiEngine(getValueFromPPFile("CancelBookingNewUserId"));
        commons.refundSubscriptionViaApiEngine(getValueFromPPFile("RefundPassUserIdNewUser"));
        driver.navigate().back();
        homePage.clickMenu();
        myRidesPage.clickMyRidesDisplayText();
        myRidesPage.clickSessionExpired();
        commons.enterUserPhoneNumberOTP("old1UserPhoneNumber", "OTP");
        homePage.clickMenu();
        myRidesPage.clickMyRidesDisplayText();
        String activeRidesWindow = myRidesPage.getActiveRidesWindows();
        Assert.assertEquals(activeRidesWindow, "You don't have any active rides");
}

    @Test(priority = 12)
    public void verifyCancelRideStatusAtHistoryTab() {
        myRidesPage.clickHistoryRidesTab();
        String getRideDStatus = myRidesPage.getStatusOfRide(1);
        Assert.assertEquals(getRideDStatus, "Cancelled");
    }

//    @Test(priority = 13)
//    public void verifyGetLostAnItemText() {
//
//        myRidesPage.getLostItemText(0);
//        String getLostItemButtonText = myRidesPage.getLostItemTitleText();
//        Assert.assertEquals(getLostItemButtonText, "I lost an item");
//        myRidesPage.getDescriptionText();
//        myRidesPage.clickSubmitButton();
//        String getHelpTitleText = myRidesPage.getNeedHelpTitleText();
//        Assert.assertEquals(getHelpTitleText, "Select An Issue");
//    }

//    @Test(priority = 14,enabled = false)
//    public void verifyGetPickUpIssue() {
//        myRidesPage.clickGetPickUpItem();
//        String getPickButtonText = myRidesPage.getPickupPointText();
//        Assert.assertEquals(getPickButtonText, "I have an issue with my pickup");
//        myRidesPage.getDescriptionText();
//        myRidesPage.clickSubmitButton();
//        String getHelpTitleText = myRidesPage.getNeedHelpTitleText();
//        Assert.assertEquals(getHelpTitleText, "Select An Issue");
//
//    }
//    @Test(priority = 15,enabled = false)
//    public void verifyGetDriverIssue() {
//        myRidesPage.clickGetIssueWithDriver();
//        String getDriverButtonText = myRidesPage.getIssueWithDriver();
//        Assert.assertEquals(getDriverButtonText, "I have an issue with my driver");
//        myRidesPage.getDescriptionText();
//        myRidesPage.clickSubmitButton();
//        String getHelpTitleText = myRidesPage.getNeedHelpTitleText();
//        Assert.assertEquals(getHelpTitleText, "Select An Issue");
//    }
//    @Test(priority = 16, enabled = false)
//    public void verifyGetOtherIssue() {
//        myRidesPage.clickGetOtherIssue();
//        String getOtherIssueText = myRidesPage.getOtherIssue();
//        Assert.assertEquals(getOtherIssueText, "I have some other issue with my trip");
//        myRidesPage.getDescriptionText();
//        myRidesPage.clickSubmitButton();
//        String getHelpTitleText = myRidesPage.getNeedHelpTitleText();
//        Assert.assertEquals(getHelpTitleText, "Select An Issue");
//    }
}
