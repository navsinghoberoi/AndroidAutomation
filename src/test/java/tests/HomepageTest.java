package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pages.*;


public class HomepageTest extends Setup {

    private LandingPage landingPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private SelectLocationPage selectLocationPage;
    private SlotsPage slotsPage;
    private SlotsSelectedPage slotsSelectedPage;
    private ShuttlEnRoutePage shuttlEnRoutePage;
    private WalletPage walletPage;
    private ShuttlWalletDetailsPage shuttlWalletDetailsPage;
    private ShuttlWalletCheckoutPage shuttlWalletCheckoutPage;
    private PaytmPage paytmPage;
    private CouponsPage couponsPage;
    private PostBookingPage postBookingPage;
    private SmsPage smsPage;
    private GetFreeRidePage getFreeRidePage;
    private OtpPage otpPage;
    private Commons commons;

    @BeforeMethod
    public void setUp() throws Exception {

        createAndroidSession(false);
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        selectLocationPage = new SelectLocationPage(driver);
        slotsPage = new SlotsPage(driver);
        slotsSelectedPage = new SlotsSelectedPage(driver);
        shuttlEnRoutePage = new ShuttlEnRoutePage(driver);
        walletPage = new WalletPage(driver);
        shuttlWalletDetailsPage = new ShuttlWalletDetailsPage(driver);
        shuttlWalletCheckoutPage = new ShuttlWalletCheckoutPage(driver);
        paytmPage = new PaytmPage(driver);
        couponsPage = new CouponsPage(driver);
        postBookingPage = new PostBookingPage(driver);
        smsPage = new SmsPage(driver);
        getFreeRidePage = new GetFreeRidePage(driver);
        otpPage = new OtpPage(driver);
        commons = new Commons(driver);

    }


    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        System.out.println("Test case completed");
        driver.quit();
    }

    @Test(priority = 1, enabled = false)
    public void testHomeCards() throws Exception {
        createAndroidSession(true);
        commons.goToHomepage();
    }

    @Test(priority = 3, enabled = true)
    public void testHomePageOldUser() throws Exception {
        commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
        boolean result = homePage.checkSearchBar();
        Assert.assertEquals(result, true, "test case failed");
        driver.quit();
    }

    @Test(priority = 2, enabled = true)
    public void testHomePageNewUserWithoutBooking() throws Exception {
        commons.enterUserPhoneNumberOTP("userWithoutBookingPhoneNumber", "userWithoutBookingOTP");
        boolean result = homePage.checkSearchBar();
        Assert.assertEquals(result, false, "test case failed");

    }

    @Test(priority = 4)
    public void verifySearchBarIsClickable() throws Exception {
        //   commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
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
        //    commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
        String actualText = homePage.getHeaderText();
        System.out.println("Heading of the searchbar = " + actualText);
        Assert.assertEquals(actualText, "Search for a route", "test case failed");
    }


    @Test(priority = 6)
    public void verifySearchCardDisplayed() throws Exception {
        //     commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
        commons.clickSearchBar();
        boolean isDisplayed = homePage.isFindRouteButtonDisplayed();
        System.out.println("Is search card displayed ? " + isDisplayed);
        Assert.assertEquals(isDisplayed, true, "test case failed");
    }


    @Test(priority = 7)
    public void verifyFindRouteButtonWithoutAddresses() throws Exception {
        //      commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
        commons.clickSearchBar();
        boolean isEnabled = homePage.isFindRouteButtonEnabled();
        System.out.println("Is search card enabled before entering home and office address ? " + isEnabled);
        Assert.assertEquals(isEnabled, false, "test case failed");

    }


    @Test(priority = 8)
    public void verifyFindRouteButtonWithoutToLocationAddresses() throws Exception {
        //      commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
        commons.clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("homeAddress"), 0);
        boolean isEnabled = homePage.isFindRouteButtonEnabled();
        System.out.println("Is search card enabled before entering office address ? " + isEnabled);
        Assert.assertEquals(isEnabled, false, "test case failed");

    }

    @Test(priority = 9)
    public void verifyFindRouteButtonWithoutFromLocationAddresses() throws Exception {
        //      commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
        commons.clickSearchBar();
        homePage.clickToLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("officeAddress"), 0);
        boolean isEnabled = homePage.isFindRouteButtonEnabled();
        System.out.println("Is search card enabled before entering home address ? " + isEnabled);
        Assert.assertEquals(isEnabled, false, "test case failed");

    }

    @Test(priority = 10)
    public void verifyFindRouteButtonWithAddresses() throws Exception {
        // commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
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
        //   commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
        commons.clickSearchBar();
        homePage.closeSearchPopup();
        //Check if searchbar is displayed after closing popup
        boolean actualResult = homePage.checkSearchBar();
        Assert.assertEquals(actualResult, true, "test case failed");
    }

    @Test(priority = 12)
    public void verifyFromLocationHeading() throws Exception {
        //   commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
        commons.clickSearchBar();
        String text = homePage.getFromLocationText();
        System.out.println("Heading of from location field = " + text);
    }


    @Test(priority = 13)
    public void verifyToLocationHeading() throws Exception {
        //   commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
        commons.clickSearchBar();
        String text = homePage.getToLocationText();
        System.out.println("Heading of to location field = " + text);
    }


    @Test(priority = 14)
    public void verifyFromLocationData() throws Exception {
        //   commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
        commons.clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("homeAddress"), 0);
        String text = homePage.getFromLocationText();
        boolean result = text.contains(getValueFromPPFile("homeAddress"));
        Assert.assertEquals(result, true, "test case has failed");
    }


    @Test(priority = 15)
    public void verifyToLocationData() throws Exception {
        //   commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
        commons.clickSearchBar();
        homePage.clickToLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("officeAddress"), 0);
        String text = homePage.getToLocationText();
        boolean result = text.contains(getValueFromPPFile("officeAddress"));
        Assert.assertEquals(result, true, "test case has failed");
    }


    @Test(priority = 16)
    public void verifySwapFromToLocations() throws Exception {
        //   commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
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
        // commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
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

        // commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
        commons.clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("homeAddress"), 0);
        homePage.clickFromLocation();
        boolean result = homePage.checkCachedLocations(getValueFromPPFile("homeAddress"));
        System.out.println(result);
        Assert.assertEquals(result, true, "test case failed");
    }


}