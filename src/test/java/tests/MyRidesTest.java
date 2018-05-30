package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyRidesPage;

public class MyRidesTest extends Setup {

    private HomePage homePage;
    private Commons commons;
    private MyRidesPage myRidesPage;

    @BeforeClass
    public void setUp() throws Exception {
        createAndroidSession(false);
        commons = new Commons(driver);
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        Thread.sleep(10000L);
        homePage = new HomePage(driver);
        homePage.clickMenu();
        myRidesPage = new MyRidesPage(driver);
    }

    @Test(priority = 1)
    public void verifyMyRidesDisplayText() throws Exception {
        String ridesDisplayText = myRidesPage.getMyRidesDisplayText();
        Assert.assertEquals(ridesDisplayText, "My Rides");
        myRidesPage.getMyRidesDisplayTextClick();
    }

    @Test(priority = 2, dependsOnMethods = "verifyMyRidesDisplayText")
    public void verifyMyRidesTitleText() throws Exception {

        String myRidesTitleText = myRidesPage.getMyRidesTitleText();
        Assert.assertEquals(myRidesTitleText, "My Rides");

    }

    @Test(priority = 3, dependsOnMethods = "verifyMyRidesDisplayText")
    public void verifyActiveRidesWindowsScreen() throws Exception {
        String activeRidesWindow = myRidesPage.getActiveRidesWindows();
        Assert.assertEquals(activeRidesWindow, "You don't have any active rides");

    }

    @Test(priority = 4, dependsOnMethods = "verifyMyRidesDisplayText")
    public void verifyHistoryRidesTab() throws Exception {
        myRidesPage.getHistoryRidesTabClick();
        String activeTab = myRidesPage.getHistoryRidesTab();
        Assert.assertEquals(activeTab, "HISTORY");

    }

    @Test(priority = 5, dependsOnMethods = "verifyHistoryRidesTab")
    public void verifyRideSelectionFromHistory() throws Exception {
        myRidesPage.ridesSelectionClick();
        String rideNowButton = myRidesPage.getRideNowButtonText();
        Assert.assertEquals(rideNowButton, "RIDE NOW");
    }

    @Test(priority = 6, dependsOnMethods = "verifyRideSelectionFromHistory")
    public void verifyGetRideNowTitleText() {
        myRidesPage.getRideNowButtonClick();
        String rideNowTitleText = myRidesPage.getRideNowTitleText();
        Assert.assertEquals(rideNowTitleText, "Select a Timeslot");
        myRidesPage.clickBackButton();
    }

    @Test(priority = 7, dependsOnMethods = "verifyRideSelectionFromHistory")
    public void verifySelectedHistoryRideTitleText() throws Exception {
        String historyRideTitleText = myRidesPage.getHistoryTitleText();
        Assert.assertEquals(historyRideTitleText, myRidesPage.getRideSelectionDate());
    }

    @Test(priority = 8, dependsOnMethods = "verifyRideSelectionFromHistory")
    public void verifyPickAndDropLocationText() {
        String pickupPoint = myRidesPage.getPickupPointText();
        String getPickupPointInMyRidesText = myRidesPage.getPickupPointInMyRidesText();
        if (pickupPoint.equals(getPickupPointInMyRidesText)) {
            String pickupPointInMyRides = myRidesPage.getPickupPointInMyRidesText();
            Assert.assertEquals(pickupPointInMyRides, myRidesPage.getPickupPointText());
        }
    }

    @Test(priority = 9)
    public void verifyNeedHelpWithTheRide() {
        String needHelpText = myRidesPage.getNeedHelpWithThisRideText();
        Assert.assertEquals(needHelpText, "NEED HELP WITH THIS RIDE?");
        myRidesPage.getNeedHelpWithThisRideButtonClick();
    }

    @Test(priority = 10, dependsOnMethods = "verifyNeedHelpWithTheRide", enabled = false)
    public void verifyGetLostAnItemText() {

        myRidesPage.getLostItemClick();
        String getLostItemButtonText = myRidesPage.getLostItemTitleText();
        Assert.assertEquals(getLostItemButtonText, "I lost an item");
        myRidesPage.getDescriptionText();
        myRidesPage.SubmitButtonClick();
        String getHelpTitleText = myRidesPage.getNeedHelpTitleText();
        Assert.assertEquals(getHelpTitleText, "Select An Issue");
    }

    @Test(priority = 11, dependsOnMethods = "verifyNeedHelpWithTheRide", enabled = false)
    public void verifyGetPickUpIssue() {
        myRidesPage.getPickUpItemClick();
        String getPickButtonText = myRidesPage.getPickupPointText();
        Assert.assertEquals(getPickButtonText, "I have an issue with my pickup");
        myRidesPage.getDescriptionText();
        myRidesPage.SubmitButtonClick();
        String getHelpTitleText = myRidesPage.getNeedHelpTitleText();
        Assert.assertEquals(getHelpTitleText, "Select An Issue");

    }

    @Test(priority = 12, dependsOnMethods = "verifyNeedHelpWithTheRide", enabled = false)
    public void verifyGetDriverIssue() {
        myRidesPage.getIssueWithDriverClick();
        String getDriverButtonText = myRidesPage.getIssueWithDriver();
        Assert.assertEquals(getDriverButtonText, "I have an issue with my driver");
        myRidesPage.getDescriptionText();
        myRidesPage.SubmitButtonClick();
        String getHelpTitleText = myRidesPage.getNeedHelpTitleText();
        Assert.assertEquals(getHelpTitleText, "Select An Issue");
    }

    @Test(priority = 13, dependsOnMethods = "verifyNeedHelpWithTheRide", enabled = false)
    public void verifyGetOtherIssue() {
        myRidesPage.getOtherIssueClick();
        String getOtherIssueText = myRidesPage.getOtherIssue();
        Assert.assertEquals(getOtherIssueText, "I have some other issue with my trip");
        myRidesPage.getDescriptionText();
        myRidesPage.SubmitButtonClick();
        String getHelpTitleText = myRidesPage.getNeedHelpTitleText();
        Assert.assertEquals(getHelpTitleText, "Select An Issue");
    }


}
