package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyRidesPage;

public class MyRidesTest extends Setup {

    private HomePage homePage;
    private Commons  commons;
    private MyRidesPage myRidesPage;

    @BeforeClass
    public void setUp() throws Exception {
        createAndroidSession(true);
//        commons = new Commons(driver);
//        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        Thread.sleep(10000L);
        homePage = new HomePage(driver);
        homePage.clickMenu();
        myRidesPage = new MyRidesPage(driver);
    }

    @Test(priority = 1)
    public void myRidesDisplayText() throws Exception{
        String ridesDisplayText = myRidesPage.getMyRidesDisplayText();
        Assert.assertEquals(ridesDisplayText, "My Rides");
        myRidesPage.getMyRidesDisplayTextClick();
    }

    @Test(priority = 2 , dependsOnMethods = "myRidesDisplayText")
    public void myRidesTitleText() throws Exception{

        String myRidesTitleText = myRidesPage.getMyRidesTitleText();
        Assert.assertEquals(myRidesTitleText,"My Rides");

        }
    @Test(priority = 3, dependsOnMethods = "myRidesDisplayText")
    public void activeRidesWindowsScreen()throws Exception{
        String activeRidesWindow = myRidesPage.getActiveRidesWindows();
        Assert.assertEquals(activeRidesWindow, "You don't have any active rides");

    }

    @Test(priority = 4, dependsOnMethods = "myRidesDisplayText")
    public void historyRidesTab()throws Exception{
        myRidesPage.getHistoryRidesTabClick();
        String activeTab = myRidesPage.getHistoryRidesTab();
        Assert.assertEquals(activeTab, "HISTORY");

    }
    @Test(priority = 5, dependsOnMethods = "historyRidesTab")
    public void rideSelectionFromHistory()throws Exception{
        myRidesPage.ridesSelectionClick();
        String rideNowButton = myRidesPage.getRideNowButtonText();
        Assert.assertEquals(rideNowButton, "RIDE NOW");
    }

    @Test(priority = 6, dependsOnMethods = "rideSelectionFromHistory")
    public void getRideNowTitleText(){
        myRidesPage.getRideNowButtonClick();
        String rideNowTitleText = myRidesPage.getRideNowTitleText();
        Assert.assertEquals(rideNowTitleText,"Select a Timeslot");
        myRidesPage.clickBackButton();
    }

    @Test(priority = 7,dependsOnMethods = "rideSelectionFromHistory")
    public void selctedHistoryRideTitleText()throws Exception{
        String historyRideTitleText = myRidesPage.getHistoryTitleText();
        Assert.assertEquals(historyRideTitleText, myRidesPage.getRideSelectionDate());
    }

    @Test(priority = 8, dependsOnMethods = "rideSelectionFromHistory")
    public void pickAndDropLocationText(){
        String pickupPoint = myRidesPage.getPickupPointText();
        String getPickupPointInMyRidesText = myRidesPage.getPickupPointInMyRidesText();
        if(pickupPoint.equals(getPickupPointInMyRidesText)){
            String pickupPointInMyRides = myRidesPage.getPickupPointInMyRidesText();
            Assert.assertEquals(pickupPointInMyRides,myRidesPage.getPickupPointText());
        }
    }
    @Test(priority = 9)
    public void verifyNeedHelpWithTheRide()
    {
        String needHelpText = myRidesPage.getNeedHelpWithThisRideText();
        Assert.assertEquals(needHelpText, "NEED HELP WITH THIS RIDE?");
        myRidesPage.getNeedHelpWithThisRideButtonClick();
    }
//    @Test(priority = 10 , dependsOnMethods = "verifyNeedHelpWithTheRide")
//    public void getLostAnItemText(){
//
//        myRidesPage.getLostItemClick();
//        String getLostItemButtonText = myRidesPage.getLostItemTitleText();
//        Assert.assertEquals(getLostItemButtonText, "I lost an item");
//        myRidesPage.getDescriptionText();
//        myRidesPage.SubmitButtonClick();
//        String getHelpTitleText = myRidesPage.getNeedHelpTitleText();
//        Assert.assertEquals(getHelpTitleText,"Select An Issue");
//    }

    @Test(priority = 11)
    public void getPickUpIssue(){
        myRidesPage.getPickUpItemClick();
        String getPickButtonText = myRidesPage.getPickupPointText();
        Assert.assertEquals(getPickButtonText,"I have an issue with my pickup");
        myRidesPage.getDescriptionText();
        myRidesPage.SubmitButtonClick();
        String getHelpTitleText = myRidesPage.getNeedHelpTitleText();
        Assert.assertEquals(getHelpTitleText,"Select An Issue");

    }

    @Test(priority = 12)
    public void getDriverIssue(){
        myRidesPage.getIssueWithDriverClick();
        String getDriverButtonText = myRidesPage.getIssueWithDriver();
        Assert.assertEquals(getDriverButtonText,"I have an issue with my driver");
        myRidesPage.getDescriptionText();
        myRidesPage.SubmitButtonClick();
        String getHelpTitleText = myRidesPage.getNeedHelpTitleText();
        Assert.assertEquals(getHelpTitleText,"Select An Issue");
    }

    @Test(priority = 13)
    public void getOtherIssue(){
        myRidesPage.getOtherIssueClick();
        String getOtherIssueText = myRidesPage.getOtherIssue();
        Assert.assertEquals(getOtherIssueText,"I have some other issue with my trip");
        myRidesPage.getDescriptionText();
        myRidesPage.SubmitButtonClick();
        String getHelpTitleText = myRidesPage.getNeedHelpTitleText();
        Assert.assertEquals(getHelpTitleText,"Select An Issue");
    }


}
