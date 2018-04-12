package tests;

import common.Commons;
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

    @BeforeClass
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
        postBooking = new PostBooking(driver);
        smsPage = new SmsPage(driver);
        getFreeRide = new GetFreeRide(driver);
        otpPage = new OtpPage(driver);
        commons = new Commons(driver);

    }


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        System.out.println("Test cases completed");
        driver.quit();
    }

    @Test(priority = 1)
    public void testHomeCards() throws Exception {
        commons.goToHomepage();

    }


}