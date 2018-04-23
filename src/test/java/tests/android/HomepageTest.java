package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
    private PostBooking postBooking;
    private SmsPage smsPage;
    private GetFreeRide getFreeRide;
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
        postBooking = new PostBooking(driver);
        smsPage = new SmsPage(driver);
        getFreeRide = new GetFreeRide(driver);
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


}