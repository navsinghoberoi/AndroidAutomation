package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;


public class BookingFromCouponTest extends Setup {

    private LandingPage landingPage;
    private LoginPage loginPage;
    private PersonalDetailsPage personalDetails;
    private HomeAddressPage homeAddressPage;
    private OfficeAddressPage officeAddressPage;
    private OtpPage otpPage;
    private HomePage homePage;
    private MenuPage menuPage;
    private Commons commons;
    private CouponsPage couponsPage;
    private BookingFromCouponPage bookingFromCouponPage;
    private SelectLocationPage selectLocationPage;
    private SlotsPage slotsPage;
    private ExplorePassesPage explorePassesPage;
    private ChooseBenefitsPage chooseBenefitsPage;
    private ReviewRoutePage reviewRoutePage;
    private PassCompletePaymentPage passCompletePaymentPage;
    private PassDetailsPage passDetailsPage;
    private RefundPassPage refundPassPage;
    private BookingCompletePage bookingCompletePage;


    @BeforeClass
    public void Setup() throws Exception {
        createAndroidSession(true);

//        landingPage = new LandingPage(driver);
//        loginPage = new LoginPage(driver);
//        personalDetails = new PersonalDetailsPage(driver);

//        officeAddressPage = new OfficeAddressPage(driver);
//        otpPage = new OtpPage(driver);
//        homepage = new HomePage(driver);

//        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
         Thread.sleep(10000L);
         homePage = new HomePage(driver);
         //homePage.clickMenu();
         commons = new Commons(driver);
         couponsPage = new CouponsPage(driver);
         bookingFromCouponPage = new BookingFromCouponPage(driver);
         homeAddressPage = new HomeAddressPage(driver);
         slotsPage = new SlotsPage(driver);
//        selectLocationPage = new SelectLocationPage(driver);

//        explorePassesPage = new ExplorePassesPage(driver);
//        chooseBenefitsPage = new ChooseBenefitsPage(driver);
//        reviewRoutePage = new ReviewRoutePage(driver);
//        passCompletePaymentPage = new PassCompletePaymentPage(driver);
//        passDetailsPage = new PassDetailsPage(driver);
//        refundPassPage = new RefundPassPage(driver);
//        bookingCompletePage = new BookingCompletePage(driver);

    }
    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }
    @Test(enabled = false)
    public void verifyCouponsDisplayText(){

        String couponDisplayText = bookingFromCouponPage.getCouponsDisplayText();
        System.out.println("I am checking assert");
        Assert.assertEquals(couponDisplayText,"Coupons");
        bookingFromCouponPage.clickCouponsDisplayText();

    }
    @Test(priority = 0,enabled = false)
    public void verifyCouponsTitleText(){
        String couponTitleText = bookingFromCouponPage.getCouponTitleText();
        Assert.assertEquals(couponTitleText,"Coupons");

    }
    @Test(priority = 1,enabled = false)
    public void verifyEnterCouponCode()throws Exception{
        couponsPage.addCouponIntegrated();
        bookingFromCouponPage.clickPopUp();
        bookingFromCouponPage.clickSavedCouponTab();
        bookingFromCouponPage.clickSavedCoupon();
        String couponCode = bookingFromCouponPage.getSavedCouponCodeText();
        Assert.assertEquals(couponCode,getValueFromPPFile("couponcode"));
        couponsPage.clickDismissButton();
        bookingFromCouponPage.clickBackButton();

    }

    @Test(priority = 2)
    public void verifyCreateBookingViaCoupon() throws Exception{
        homePage.checkSearchBar();
        commons.buySubscriptionViaShuttlCredits("homeAddress", "officeAddress", 0, 0, 0);
        slotsPage.clickSlot(0);
        slotsPage.clickCtaOnSlotsPage();
        String actualText = bookingCompletePage.getBookingConfirmPopupTitle();
        System.out.println("Text after creating a booking = " + actualText);
        bookingCompletePage.clickBookingConfirmPopupCTA();
        Assert.assertEquals(actualText, "Ride Confirmed");
    }
    @Test(priority = 3)
    public void a(){

    }
}