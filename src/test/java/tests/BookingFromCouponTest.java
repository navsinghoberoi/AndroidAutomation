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
    private MyRidesPage myRidesPage;

    @BeforeClass
    public void Setup() throws Exception {
        createAndroidSession(true);
        commons = new Commons(driver);
        //commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        Thread.sleep(10000L);
        homePage = new HomePage(driver);
        homePage.clickMenu();
        couponsPage = new CouponsPage(driver);
        bookingFromCouponPage = new BookingFromCouponPage(driver);
        homeAddressPage = new HomeAddressPage(driver);
        slotsPage = new SlotsPage(driver);
        myRidesPage = new MyRidesPage(driver);

    }

    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }

    @Test()
    public void verifyCouponsDisplayText() {

        String couponDisplayText = bookingFromCouponPage.getCouponsDisplayText();
        Assert.assertEquals(couponDisplayText, "Coupons");
        bookingFromCouponPage.clickCouponsDisplayText();

    }

    @Test(priority = 1)
    public void verifyCouponsTitleText() {
        String couponTitleText = bookingFromCouponPage.getCouponTitleText();
        Assert.assertEquals(couponTitleText, "Coupons");

    }

    @Test(priority = 2)
    public void verifyEnterCouponCode() throws Exception {
        couponsPage.addCouponIntegrated();
        bookingFromCouponPage.clickPopUp();
        bookingFromCouponPage.clickSavedCouponTab();
        bookingFromCouponPage.clickSavedCoupon();
        String couponCode = bookingFromCouponPage.getSavedCouponCodeText();
        Assert.assertEquals(couponCode, getValueFromPPFile("couponcode"));
        couponsPage.clickDismissButton();
        bookingFromCouponPage.clickBackButton();

    }

    @Test(priority = 3)
    public void verifyCreateBookingViaCoupon() throws Exception {
        homePage.checkSearchBar();
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        String couponDetails = bookingFromCouponPage.getCouponCodeText();
        Assert.assertEquals(couponDetails, getValueFromPPFile("couponcode"));
        slotsPage.clickCtaOnSlotsPage();

    }

    @Test(priority = 4)
    public void verifyRideConfirmed() {
        String getRideConfirmationText = bookingFromCouponPage.getRideConfirmedTest();
        Assert.assertEquals(getRideConfirmationText, "Ride Confirmed");
        bookingFromCouponPage.clickRideConfirmedGotItButton();

    }

    @Test(priority = 5)
    public void verifyCurrentRideVisibility() {
        boolean homepageCurrenrRideCard = bookingFromCouponPage.bookingCardVisibility();
        Assert.assertEquals(homepageCurrenrRideCard, true);

    }

    @Test(priority = 6)
    public void verifyCurrentRide() throws Exception {
        String pickupStopText = bookingFromCouponPage.pickUpStopCard();
        homePage.clickMenu();
        myRidesPage.clickMyRidesDisplayText();
        String currentRideText = bookingFromCouponPage.currentRideText();
        Assert.assertEquals(currentRideText, pickupStopText);
        driver.navigate().back();
    }

    @Test(priority = 7)
    public void verifyCouponRedeemAfterBooking() {
        homePage.clickMenu();
        bookingFromCouponPage.clickCouponsDisplayText();
        bookingFromCouponPage.clickSavedCouponTab();
        String savedCouponScreenAfterCR = bookingFromCouponPage.getSavedCouponScreenAfterCouponRedemption();
        Assert.assertEquals(savedCouponScreenAfterCR,"You do not have any saved coupons.");

    }
}
