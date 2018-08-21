package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

public class PostBookingTest extends Setup {
    private HomePage homePage;
    private MyRidesPage myRidesPage;
    private Commons commons;
    private BookingCompletePage bookingCompletePage;
    private TrackShuttlPage trackShuttlPage;
    private String className;


    @BeforeClass
    public void Setup() throws Exception {
        createAndroidSession(true);
        commons = new Commons(driver);
        //commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        //Thread.sleep(10000L);
        homePage = new HomePage(driver);
        homePage.clickMenu();
        myRidesPage = new MyRidesPage(driver);
        bookingCompletePage = new BookingCompletePage(driver);
        trackShuttlPage = new TrackShuttlPage(driver);
        className = getClass().getSimpleName() + commons.getCurrentTime();    }

    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if (ITestResult.FAILURE == iTestResult.getStatus()){
            commons.captureScreenshot(driver,className);
            System.out.println("Screenshot taken for failed testcase");
        }
       // driver.quit();
    }

    @Test()
    public void verifyPickUpStop() throws Exception {
        commons.bookingViaCoupon();
        bookingCompletePage.clickBookingConfirmPopupCTA();
        boolean cardVisible = homePage.isTrackShuttlDisplayed();
        Assert.assertEquals(cardVisible,true,"Booking Card is Visible");
    }

    @Test(priority = 1)
    public void verifyRideStatus() {
        String dayRideST = homePage.getRideStatus();
        homePage.clickMenu();
        myRidesPage.clickMyRidesDisplayText();
        String currentRidePickupText = homePage.getCurrentRideTitle();
        Assert.assertEquals(currentRidePickupText, dayRideST);
        driver.navigate().back();
    }

    @Test(priority = 2)
    public void verifyPickUpPoint() throws Exception{
        String pickupStopText = homePage.getBookingHomecardData();
        homePage.clickMenu();
        myRidesPage.clickMyRidesDisplayText();
        String currentRidePickupText = myRidesPage.currentRideText();
        boolean isCurrentRidePickupText = currentRidePickupText.contains(getValueFromPPFile("homeAddress"));
        Assert.assertEquals(currentRidePickupText, true);
        driver.navigate().back();
    }

    @Test(priority = 3)
    public void verifyTrackShuttlButton() {
        boolean trackShuttlText = homePage.isTrackShuttlDisplayed();
        Assert.assertEquals(trackShuttlText, true);
    }

    @Test(priority = 4)
    public void verifyRegistrationNumber() {
        boolean regNumber = trackShuttlPage.isRegistrationNumberVisible();
        Assert.assertEquals(regNumber, true, "Reg No. Visible");
        homePage.clickBookingHomeCard();
    }

    @Test(priority = 5)
    public void verifyRefreshIcon() {
        boolean refreshIconButton = trackShuttlPage.refreshIcon();
        Assert.assertEquals(refreshIconButton,true);
        trackShuttlPage.clickRefreshIcon();
    }

    @Test(priority = 6)
    public void verifyCurrentLocationIconVisible() {
        boolean currentLocationButton = homePage.getCurrentLocationIcon();
        Assert.assertEquals(currentLocationButton, true);
        homePage.clickCurrentLocationButton();
    }

    @Test(priority = 7)
    public void verifyShuttlArrivalBubbleStatus() {
        trackShuttlPage.clickMenuUpIcon();
        trackShuttlPage.clickShuttlArrivalToggle();
        boolean shuttleBubbleStatus = trackShuttlPage.arrivalBubble();
        Assert.assertEquals(shuttleBubbleStatus,true, "Toggle is Displayed");
    }

    @Test(priority = 8)
    public void verifyTrafficToggleStatus(){
        trackShuttlPage.getShowTrafficStatus();
    boolean trafficToggleStatus = trackShuttlPage.trafficToggle();
    Assert.assertEquals(trafficToggleStatus,true,"Traffic toggle is Displayed");
    }
    @Test(priority = 9)
    public void verifyLocatePickup() {
        String locatePickupText = trackShuttlPage.locatePickupText();
        Assert.assertEquals(locatePickupText,"Locate pickup");
        trackShuttlPage.clickLocatePickup();
    }

    @Test(priority = 10)
    public void verifyLocatePickupTitle() {
        String locatePickupTitle = trackShuttlPage.locatePickupTitleText();
        Assert.assertEquals(locatePickupTitle,"View Pickup Stop");
    }

    @Test(priority = 11)
    public void verifyNavigateButton() {
        String locateNavigateButton = trackShuttlPage.getNavigateButton();
        Assert.assertEquals(locateNavigateButton,"NAVIGATE");
        trackShuttlPage.clickNavigateButton();
        driver.navigate().back();
    }

    @Test(priority = 12)
    public void verifyTogglePickupButton() {
        trackShuttlPage.clickToggleIcon();
        boolean currentLocationButton = trackShuttlPage.currentLocationButton();
        Assert.assertEquals(currentLocationButton, true);
        trackShuttlPage.clickCurrentLocationButton();
        driver.navigate().back();
    }

    @Test(priority = 13)
    public void verifyHelpText(){
        String getHelptext = trackShuttlPage.helpText();
        Assert.assertEquals(getHelptext,"Help");
        trackShuttlPage.clickHelpText();
    }

    @Test(priority = 14)
    public void verifyHelpScreen(){
        String getFaq = trackShuttlPage.getFaqLink();
        Assert.assertEquals(getFaq,"FAQs");
        driver.navigate().back();
    }
}
