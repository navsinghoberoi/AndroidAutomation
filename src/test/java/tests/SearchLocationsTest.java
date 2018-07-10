package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class SearchLocationsTest extends Setup {

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
    private BasePage basePage;
    private String className;

    @BeforeMethod
    public void setUp() throws Exception {

        createAndroidSession(true);
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
        basePage = new BasePage(driver);
        //   commons.goToHomepage("userWithoutSubsPhoneNumber", "userWithoutSubsOTP");
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
    public void quit() {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }


    @Test(priority = 1)
    public void verifySearchBarIsClickable() throws Exception {
        boolean searchBarClickable = homePage.checkSearchBar();
        if (searchBarClickable == true) {
            commons.clickSearchBar();
        } else {
            System.out.println("Search bar is not clicked");
        }
        Assert.assertEquals(searchBarClickable, true);
    }

    @Test(priority = 2)
    public void verifySearchBarContent() {
        String searchBarContent = homePage.getHeaderText();
        System.out.println("Heading of the search bar = " + searchBarContent);
        Assert.assertEquals(searchBarContent, "Search for a route");
    }

    @Test(priority = 3)
    public void verifySearchCardDisplayed() {
        commons.clickSearchBar();
        boolean isSearchCardDisplayed = homePage.isFindRouteButtonDisplayed();
        System.out.println("Is search card displayed ? " + isSearchCardDisplayed);
        Assert.assertEquals(isSearchCardDisplayed, true);
    }

    @Test(priority = 4)
    public void verifyNoSearchResultsWith1Char() throws Exception {
        commons.clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.enterSearchLocation("R");
        boolean locationResultsAppearing = selectLocationPage.isSearchLocationResultsAppearing();
        Assert.assertEquals(locationResultsAppearing, false);
    }

    @Test(priority = 5)
    public void verifyNoSearchResultsWith2Char() throws Exception {
        commons.clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.enterSearchLocation("RI");
        boolean locationResultsAppearing = selectLocationPage.isSearchLocationResultsAppearing();
        Assert.assertEquals(locationResultsAppearing, false);
    }

    @Test(priority = 6)
    public void verifyNoSearchResultsWith2CharAndSpace() throws Exception {
        commons.clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.enterSearchLocation("RI ");
        boolean locationResultsAppearing = selectLocationPage.isSearchLocationResultsAppearing();
        System.out.println("Result = " + locationResultsAppearing);
        Assert.assertEquals(locationResultsAppearing, false);
    }

    @Test(priority = 7)
    public void verifyShuttlAndGoogleResultsAppearing() throws Exception {
        boolean shuttlAndGoogleResultsAppearing;
        commons.clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.enterSearchLocation("Rithala sector");
        basePage.hideKeyboard();
        int allSearchResultsCount = selectLocationPage.getCountOfAllSearchLocations();
        int shuttlSearchResultsCount = selectLocationPage.getCountOfShuttlSearchLocations();
        int googleSearchResultsCount = allSearchResultsCount - shuttlSearchResultsCount;
        System.out.println("Google search results = " + googleSearchResultsCount);
        if (googleSearchResultsCount > 0 && shuttlSearchResultsCount > 0) {
            shuttlAndGoogleResultsAppearing = true;
        } else {
            shuttlAndGoogleResultsAppearing = false;
        }
        Assert.assertEquals(shuttlAndGoogleResultsAppearing, true);
    }

    @Test(priority = 8)
    public void verifySearchResultsAppearingWith3Char() throws Exception {
        commons.clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.enterSearchLocation("RIT");
        basePage.hideKeyboard();
        boolean locationResultsAppearing = selectLocationPage.isSearchLocationResultsAppearing();
        Assert.assertEquals(locationResultsAppearing, true);
    }

}
