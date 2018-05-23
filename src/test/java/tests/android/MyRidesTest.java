package tests.android;

import common.android.Commons;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import oracle.jrockit.jfr.ActiveSettingEvent;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.HomePage;
import pages.android.MyRidesPage;

public class MyRidesTest extends Setup {

    private HomePage homePage;
    private Commons  commons;
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
    public void myRidesDisplayText() throws Exception{
        String ridesDisplayText = myRidesPage.getMyRidesDisplayText();
        Assert.assertEquals(ridesDisplayText, "My Rides");
        myRidesPage.getMyRidesDisplayTextClick();
    }

    @Test(priority = 2)
    public void myRidesTitleText() throws Exception{

        String nyRidesTitleText = myRidesPage.getMYRidesTitleText();
        Assert.assertEquals(nyRidesTitleText,"My Rides");

        }
    @Test(priority = 3)
    public void activeRidesWindowsScreen()throws Exception{
        String activeRidesWindow = myRidesPage.getActiveRidesWindows();
        Assert.assertEquals(activeRidesWindow, "You don't have any active rides");

    }

    @Test(priority = 4)
    public void historyRidesTab()throws Exception{
        myRidesPage.getHistoryRidesTabClick();
        String activeTab = myRidesPage.getHistoryRidesTab();
        Assert.assertEquals(activeTab, "HISTORY");

    }
    @Test(priority = 5)
    public void rideSelectionFromHistory()throws Exception{
        String rideSelection = myRidesPage.getHistoryRideSelectionText();
        Assert.assertEquals(rideSelection, gethistoryRide("historyRide") );
        myRidesPage.getHistoryRideSelectionClick();

    }
    @Test(priority = 6)
    public void verifyRideNowTitletext(){
        myRidesPage.getRideNowButtonClick();
        String rideNowTitleText = myRidesPage.getRideNowTitleText();
        Assert.assertEquals(rideNowTitleText,"Select a Timeslot");
        myRidesPage.clickBackButton();
    }

    @Test(priority = 7)
    public void selctedHistoryRideTitleText()throws Exception{
        String historyRideTitleText = myRidesPage.getHistoryTitleText();
        Assert.assertEquals(historyRideTitleText, gethistoryRideTitleText("historyRideTitle"));
    }

    @Test(priority = 8)
    public void pickAndDropLocationText(){
        String pickupPoint = myRidesPage.getPickupPointText();
        String getPickupPointInMyRidesText = myRidesPage.getPickupPointInMyRidesText();
        if(pickupPoint.equals(getPickupPointInMyRidesText)){
            String pickupPointInMyRides = myRidesPage.getPickupPointInMyRidesText();
            Assert.assertEquals(pickupPointInMyRides,"Dwarka Mor 1");
        }
    }
    @Test(priority = 9)
    public void needHelpWithTheRide()
    {
        String needHelpText = myRidesPage.getNeedHelpWithThisRideText();
        Assert.assertEquals(needHelpText, "NEED HELP WITH THIS RIDE?");
        myRidesPage.getNeedHelpWithThisRideButtonClick();
    }

}
