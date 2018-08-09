package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pages.*;


public class HomepageTest extends Setup {

    private HomePage homePage;
    private SelectLocationPage selectLocationPage;
    private SlotsPage slotsPage;
    private Commons commons;
    private String className;

    @BeforeMethod
    public void setUp() throws Exception {

        createAndroidSession(true);
        homePage = new HomePage(driver);
        selectLocationPage = new SelectLocationPage(driver);
        slotsPage = new SlotsPage(driver);
        commons = new Commons(driver);
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


    @Test(priority = 1)
    public void testHomeCards() throws Exception {
        commons.goToHomepage("userWithoutSubsPhoneNumber","userWithoutSubsOTP");
    }

    @Test(priority = 2)
    public void testHomePageOldUser() throws Exception {
        boolean result = homePage.checkSearchBar();
        Assert.assertEquals(result, true, "test case failed");
        driver.quit();
    }

    @Test(priority = 3, enabled = false)
    public void testHomePageNewUserWithoutBooking() throws Exception {
        createAndroidSession(false);
        commons.enterUserPhoneNumberOTP("userWithoutBookingPhoneNumber", "userWithoutBookingOTP");
        boolean result = homePage.checkSearchBar();
        Assert.assertEquals(result, false, "test case failed");
    }

    @Test(priority = 4)
    public void verifySearchBarIsClickable() throws Exception {
        boolean result = homePage.checkSearchBar();
        if (result == true) {
            commons.clickSearchBar();
        } else {
            System.out.println("Search bar is not clicked");
        }
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 5)
    public void verifySearchBarContent() throws Exception {
        String actualText = homePage.getHeaderText();
        System.out.println("Heading of the searchbar = " + actualText);
        Assert.assertEquals(actualText, "Search for a route", "test case failed");
    }


    @Test(priority = 6)
    public void verifySearchCardDisplayed() throws Exception {
        commons.clickSearchBar();
        boolean isDisplayed = homePage.isFindRouteButtonDisplayed();
        System.out.println("Is search card displayed ? " + isDisplayed);
        Assert.assertEquals(isDisplayed, true, "test case failed");
    }


    @Test(priority = 7)
    public void verifyFindRouteButtonWithoutAddresses() throws Exception {
        commons.clickSearchBar();
        boolean isFindRouteButtonEnabled = homePage.isFindRouteButtonEnabled();
        System.out.println("Is search card enabled before entering home and office address ? " + isFindRouteButtonEnabled);
        Assert.assertEquals(isFindRouteButtonEnabled, false, "test case failed");

    }


    @Test(priority = 8)
    public void verifyFindRouteButtonWithoutToLocationAddresses() throws Exception {
        commons.clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("homeAddress"), 0);
        boolean isEnabled = homePage.isFindRouteButtonEnabled();
        System.out.println("Is search card enabled before entering office address ? " + isEnabled);
        Assert.assertEquals(isEnabled, false, "test case failed");

    }

    @Test(priority = 9)
    public void verifyFindRouteButtonWithoutFromLocationAddresses() throws Exception {
        commons.clickSearchBar();
        homePage.clickToLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("officeAddress"), 0);
        boolean isEnabled = homePage.isFindRouteButtonEnabled();
        System.out.println("Is search card enabled before entering home address ? " + isEnabled);
        Assert.assertEquals(isEnabled, false, "test case failed");

    }

    @Test(priority = 10)
    public void verifyFindRouteButtonWithAddresses() throws Exception {
        commons.clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("homeAddress"), 0);
        homePage.clickToLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("officeAddress"), 0);
        boolean isEnabled = homePage.isFindRouteButtonEnabled();
        System.out.println("Is search card enabled after entering home and office address ? " + isEnabled);
        Assert.assertEquals(isEnabled, true, "test case failed");

    }


    @Test(priority = 11)
    public void verifyCloseSearchBarPopup() throws Exception {
        commons.clickSearchBar();
        homePage.closeSearchPopup();
        //Check if searchbar is displayed after closing popup
        boolean actualResult = homePage.checkSearchBar();
        Assert.assertEquals(actualResult, true, "test case failed");
    }

    @Test(priority = 12,enabled = false)
    public void verifyFromLocationHeading() throws Exception {
        commons.clickSearchBar();
        String text = homePage.getFromLocationText();
        System.out.println("Heading of from location field = " + text);
        Assert.assertEquals(text, "Enter home location", "test case failed"); // Might fail coz of app config, need to handle via time
    }


    @Test(priority = 13,enabled = false)
    public void verifyToLocationHeading() throws Exception {
        commons.clickSearchBar();
        String text = homePage.getToLocationText();
        System.out.println("Heading of to location field = " + text);
        Assert.assertEquals(text, "Enter office location", "test case failed"); // Might fail coz of app config, need to handle via time
    }


    @Test(priority = 14)
    public void verifyFromLocationData() throws Exception {
        commons.clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("homeAddress"), 0);
        String text = homePage.getFromLocationText();
        boolean result = text.contains(getValueFromPPFile("homeAddress"));
        Assert.assertEquals(result, true, "test case has failed");
    }


    @Test(priority = 15)
    public void verifyToLocationData() throws Exception {
        commons.clickSearchBar();
        homePage.clickToLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("officeAddress"), 0);
        String text = homePage.getToLocationText();
        boolean result = text.contains(getValueFromPPFile("officeAddress"));
        Assert.assertEquals(result, true, "test case has failed");
    }


    @Test(priority = 16)
    public void verifySwapFromToLocations() throws Exception {
        commons.clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("homeAddress"), 0);
        homePage.clickToLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("officeAddress"), 0);
        homePage.clickLocationSwap();
        String text = homePage.getToLocationText();
        boolean result = text.contains(getValueFromPPFile("homeAddress"));
        Assert.assertEquals(result, true, "test case has failed");
    }


    @Test(priority = 17)
    public void verifySlotsPage() throws Exception {
        commons.clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("homeAddress"), 0);
        homePage.clickToLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("officeAddress"), 0);
        homePage.clickFindMyShuttl();
        boolean isDisplayed = slotsPage.isLocatePickupStopDisplayed();
        Assert.assertEquals(isDisplayed, true, "test case failed");
    }


    @Test(priority = 18)
    public void verifyLocationsCaching() throws Exception {
        commons.clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("homeAddress"), 0);
        homePage.clickFromLocation();
        boolean result = homePage.checkCachedLocations(getValueFromPPFile("homeAddress"));
        System.out.println(result);
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 19)
    public void verifyBuddyIconIsDisplayed() {
        boolean result = homePage.checkBuddyButton();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 20)
    public void verifyBuddyIconIsEnabled() {
        boolean result = homePage.isBuddyButtonEnabled();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 21)
    public void verifyBuddyIconOptions() {
        boolean result = false;
        homePage.clickBuddy();
        int size = homePage.getBuddyOptionsSize();
        if (size > 0) {
            result = true;
        } else {
            result = false;
        }
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 22,enabled = false)  // Option not appears always
    public void verifyReportIssueOptionClick() {
        homePage.clickBuddy();
        boolean result = homePage.reportIssueOptionClick();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 23,enabled = false)   // Option not appears always
    public void verifyReportIssueLandingPage() {
        homePage.clickBuddy();
        homePage.reportIssueOptionClick();
        boolean result = homePage.checkReportIssuePage();
        Assert.assertEquals(result, true, "test case failed");

    }


    @Test(priority = 24,enabled = false)   // Option not appears always
    public void verifyBackButtonOnReportIssuePage() {
        homePage.clickBuddy();
        homePage.reportIssueOptionClick();
        homePage.clickBackButton();
        boolean result = homePage.checkBuddyButton();
        Assert.assertEquals(result, true, "test case failed");

    }


    @Test(priority = 25)
    public void verifyReserveSeatButtonIsDisplayed() {
        boolean result = homePage.isReserveSeatButtonDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 26)
    public void verifyReserveSeatButtonIsEnabled() {
        boolean result = homePage.isReserveSeatEnabled();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 27)
    public void verifyRebookCardMorningTitle() {
        String result = homePage.getMorningRebookCardTitle();
        Assert.assertEquals(result, "Morning Ride", "test case failed");
    }

    @Test(priority = 28,enabled = false)   // Fails when 1 rebook card is displayed
    public void verifyRebookCardEveningTitle() {
        String result = homePage.getEveningRebookCardTitle();
        Assert.assertEquals(result, "Evening Ride", "test case failed");
    }


    @Test(priority = 29,enabled = false) // Multiple rebook cards not appears always
    public void printRebookCardContent() {
        homePage.getRebookCardContents();
    }


    @Test(priority = 30)
    public void verifyReserveSeatClick() {
        boolean result = homePage.reserveSeatClick();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 31)
    public void verifySlotsPageOnClickOfReserveSeat() {
        homePage.reserveSeatClick();
        boolean result = slotsPage.isSelectTimeslotDisplayed();
        System.out.println(result);
        Assert.assertEquals(result, true, "test case failed");

    }


    @Test(priority = 32)
    public void verifyBackButtonFromSlotsPage() {
        homePage.reserveSeatClick();
        homePage.clickBackButton();
        boolean result = homePage.checkBuddyButton();
        Assert.assertEquals(result, true, "test case failed");
    }


}