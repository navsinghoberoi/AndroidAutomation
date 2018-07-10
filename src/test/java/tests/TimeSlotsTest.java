package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.SlotsPage;

public class TimeSlotsTest extends Setup {

    private HomePage homePage;
    private SlotsPage slotsPage;
    private Commons commons;
    private String className;
    private BasePage basePage;

    @BeforeClass
    public void Setup() throws Exception {
        createAndroidSession(true);
        commons = new Commons(driver);
        // commons.goToHomepage("newUserPhoneNumber","OTP");
        homePage = new HomePage(driver);
        //homePage.clickMenu();
        slotsPage = new SlotsPage(driver);
        className = getClass().getSimpleName() + commons.getCurrentTime();
        basePage = new BasePage(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            commons.captureScreenshot(driver, className);
            System.out.println("Screenshot taken for failed testcase");
        }
    }

    @Test(priority = 1)
    public void verifyPickupLocation() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        String getPickUpLocation = slotsPage.getPPNameOnSlotsPage();
        boolean result = getValueFromPPFile("homeAddress").contains(getPickUpLocation);
        Assert.assertEquals(result, true);
    }

    @Test(priority = 2)
    public void verifySingleRoute() {
        boolean getSingleRouteInfo = slotsPage.getRouteOption();
        Assert.assertEquals(getSingleRouteInfo, false);
    }

    @Test(priority = 3)
    public void verifyMultipleRoute() throws Exception {
        driver.navigate().back();
        driver.navigate().back();
        commons.openSearchBarAndFindRoute("multipleRoute", "officeAddress");
        boolean getmultipleRoute = slotsPage.getRouteOption();
        Assert.assertEquals(getmultipleRoute, true);
        slotsPage.clickRoute(0);
    }

    @Test(priority = 4)
    public void verifySlotsVisible() {
        boolean slots_Visibility = slotsPage.getSlotsVisibility(0);
        Assert.assertTrue(slots_Visibility);
    }

    @Test(priority = 5)
    public void verifyViewOnMapButtonVisible() throws Exception {
        boolean viewOnMapButtonVisible = slotsPage.viewOnMap();
        Assert.assertEquals(viewOnMapButtonVisible, true);
    }

    @Test(priority = 6)
    public void verifyViewOnMapCrossIconVisible() {
        slotsPage.clickViewOnMap();
        boolean crossButtonVisible = slotsPage.viewCrossButton();
        Assert.assertEquals(crossButtonVisible, true);
        slotsPage.clickCrossButton();
        driver.navigate().back();
    }

    @Test(priority = 7)
    public void verifyViewPickupStopButtonVisible() throws Exception {
        driver.navigate().back();
        driver.navigate().back();
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        boolean viewPKButtonVisible = slotsPage.viewPickupStop();
        Assert.assertEquals(viewPKButtonVisible, true);
        slotsPage.clickPickupStop();
    }

    @Test(priority = 8)
    public void verifyViewPickupStopTitle() {
        String getPickup_Stop = slotsPage.pickupTitle();
        Assert.assertEquals(getPickup_Stop, "View Pickup Stop");
    }

    @Test(priority = 9)
    public void verifyViewRouteMapButtonVisible() {
        boolean view_Route_Map = slotsPage.viewRouteMapVisible();
        Assert.assertEquals(view_Route_Map, true);

    }

    @Test(priority = 10)
    public void verifySuggestDifferentTimeButtonVisible() {
        driver.navigate().back();
        boolean getSDT = slotsPage.suggestDifferentTimeButtonVisible();
        Assert.assertEquals(getSDT, true);
        slotsPage.clickDifferentTimeButton();
    }

    @Test(priority = 11)
    public void verifyTimeScreenVisible() {
        boolean timeScreenPopupVisible = slotsPage.timePopupVisible();
        Assert.assertEquals(timeScreenPopupVisible, true);
    }

    @Test(priority = 12)
    public void verifyAddingATimeSuggestion() {
        slotsPage.getHourSelection();
        slotsPage.getMinuteSelection();
        slotsPage.clickOkButtonOnPopup();
        boolean getThankyouPopup = slotsPage.getThankyouPageVisible();
        Assert.assertEquals(getThankyouPopup, true);
    }

    @Test(priority = 13)
    public void verifyThankYouPopup() {
        boolean getOkButton = slotsPage.getThankyouPageOkButton();
        Assert.assertEquals(getOkButton, true);
        slotsPage.clickThankYouPageOkButton();
    }

}