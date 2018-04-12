package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.*;
import common.*;

public class BookingTest extends Setup {

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
        System.out.println("Test cases  completed");
        driver.quit();
    }
/*
    @Test (priority=9)
    public void registrationGplus() throws InterruptedException
    {
        Thread.sleep(8000);
        landingPage.clickGplus();
        Thread.sleep(5000);
        landingPage.clickGplusAccount();
        loginPage.enterMobileNumber("8882455443");
        loginPage.clickGetOtp();
        loginPage.enterOtp("1111");
        loginPage.clickVerify();
        String Text = new HomePage(driver).getFindMyShuttlText();
        Assert.assertEquals(Text, "Find My Shuttl");

    }

    @Test (priority=10)
    public void registrationFacebook() throws InterruptedException {
        Thread.sleep(5000);
        landingPage.clickFacebook();
        Thread.sleep(2000);
        loginPage.enterMobileNumber("8882455443");
        loginPage.clickGetOtp();
        loginPage.enterOtp("1111");
        loginPage.clickVerify();
        String Text = new HomePage(driver).getFindMyShuttlText();
        Assert.assertEquals(Text, "Find My Shuttl");
    }

*/


    @Test(priority = 1)
    public void signIn() throws InterruptedException {
        commons.goToHomepage();
        homePage.clickBuddy();
        Thread.sleep(10000);
    }


/*

    @Test (priority=2)//, dependsOnMethods={"registrationGplus"})
    public void booking() throws InterruptedException
    {

        Thread.sleep(8000);
        homePage.clickFromLocation();
        selectLocationPage.selectSearchLocation("opp cro",0);
        homePage.clickToLocation();
        selectLocationPage.selectSearchLocation("mg roa",0);
        homePage.clickFindMyShuttl();
        Thread.sleep(10000);
        slotsPage.clickSlot();
        slotsSelectedPage.clickBook();
        Thread.sleep(10000);
        String Success = shuttlEnRoutePage.getBookingConfirmationPopupText();
        Assert.assertEquals(Success, "Booking Confirmed");
    }

    @Test (priority=8)
    public void booking1() throws InterruptedException
    {
        if(couponsPage.isVisible()){
            couponsPage.isRebook();
        }
        Thread.sleep(5000);
        homePage.clickFromLocation();
        selectLocationPage.selectSearchLocation("opp cr",0);
        homePage.clickToLocation();
        selectLocationPage.selectSearchLocation("mg roa",0);
        homePage.clickFindMyShuttl();
        Thread.sleep(5000);
        slotsPage.clickRoute();
        slotsPage.clickSlot1(1);
        slotsPage.clickBook();
        slotsPage.confirmBookingPopup();
        Thread.sleep(3000);
        driver.navigate().back();
    }

    @Test (priority=3)
    public void bookingReschedule() throws InterruptedException {
        postBooking.clickArrow();
        postBooking.clickReschedule();
        slotsPage.clickSlot1(2);
        slotsPage.clickBook();
        slotsPage.confirmBookingPopup();
        Thread.sleep(3000);
        driver.navigate().back();
    }

    @Test (priority=4)
    public void bookingCancel() throws InterruptedException {
        postBooking.clickArrow();
        postBooking.en_clickCancel();
        postBooking.cancleReason();
        postBooking.clickCancel();
        postBooking.cancelBookingPopup();
    }


    @Test (priority=7) // Not completed yet!!!
    public void rechargeShuttlWallet() throws InterruptedException
    {

        Thread.sleep(5000);
        if(couponsPage.isVisible()){
            couponsPage.isRebook();
        }
        homePage.clickMenu();
        homePage.clickWallet();
        walletPage.clickShuttlWallet();
        Thread.sleep(10000);
        shuttlWalletDetailsPage.enterAmount("1");
        Thread.sleep(2000);
        driver.hideKeyboard();
        Thread.sleep(10000);
        shuttlWalletDetailsPage.clickaddMoney();
        shuttlWalletCheckoutPage.selectPaytmWallet();
        Thread.sleep(10000);
        paytmPage.clickPaytmLogin();
        paytmPage.enterPaytmCredientials();
        paytmPage.clickPaytmSignin();
        smsPage.readOtp();

    }

    @Test (priority=5)
    public void addCoupon() throws InterruptedException
    {
        //Thread.sleep(10000);
        //couponsPage.isRebook();
        //Thread.sleep(10000);
        if(couponsPage.isVisible()){
            couponsPage.isRebook();
        }
        homePage.clickMenu();
        homePage.clickCoupon();
        couponsPage.getFindMyEnterCouponText();
        couponsPage.clickCouponCodeArea();
        couponsPage.enterCouponCode();
        //Thread.sleep(10000);
        driver.hideKeyboard();
        couponsPage.clickSaveButton();
        Thread.sleep(5000);
        couponsPage.getAddCouponConfirmationPopupText();
        System.out.println("coupon added successfully");
    }

    @Test(priority=6)
    public void get_free_ride() {
        if(couponsPage.isVisible()){
            couponsPage.isRebook();
        }
        homePage.clickMenu();
        homePage.clickGetFreeRide();
        getFreeRide.VerifyGetFreePage();
        driver.navigate().back();
    }
    */
}