package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;


public class BookingFromCouponTest extends Setup {


    private HomePage homePage;
    private MenuPage menuPage;
    private Commons commons;
    private CouponsPage couponsPage;
    private SlotsPage slotsPage;
    private MyRidesPage myRidesPage;
    private BookingCompletePage bookingCompletePage;
    private String className;


    @BeforeClass
    public void Setup() throws Exception {
        createAndroidSession(true);
        commons = new Commons(driver);
        //commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        //Thread.sleep(10000L);
        homePage = new HomePage(driver);
        homePage.clickMenu();
        couponsPage = new CouponsPage(driver);
        slotsPage = new SlotsPage(driver);
        myRidesPage = new MyRidesPage(driver);
        bookingCompletePage = new BookingCompletePage(driver);
        className = getClass().getSimpleName() + commons.getCurrentTime();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if (ITestResult.FAILURE == iTestResult.getStatus()){
            commons.captureScreenshot(driver,className);
            System.out.println("Screenshot taken for failed testcase");
        }
      //  driver.quit();
    }

    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }

    @Test()
    public void verifyCouponsDisplayText() {

        String couponDisplayText = couponsPage.getCouponsDisplayText();
        Assert.assertEquals(couponDisplayText, "Coupons");
        couponsPage.clickCouponsDisplayText();
    }

    @Test(priority = 1)
    public void verifyCouponsTitleText() {
        String couponTitleText = couponsPage.getCouponTitleText();
        Assert.assertEquals(couponTitleText, "Coupons");

    }

    @Test(priority = 2)
    public void verifyEnterCouponCode() throws Exception {
        couponsPage.addCouponIntegrated();
        couponsPage.clickPopUp();
        couponsPage.clickSavedCouponsArea();
        couponsPage.clickOnSavedCoupon();
        String couponCode = couponsPage.getSavedCouponCodeText();
        couponsPage.clickDismissButton();
        Assert.assertEquals(couponCode, getValueFromPPFile("couponcode"));
    }

    @Test(priority = 3)
    public void verifyCreateBookingViaCoupon() throws Exception {
        driver.navigate().back();
        boolean result = false;
        homePage.checkSearchBar();
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        String couponDetails = slotsPage.getCouponCodeTextOnSlotScreen();
        if (couponDetails.contains(getValueFromPPFile("couponcode")))
        {
            result = true;
        }
        else
        {
        result = slotsPage.getCouponTextOnSLot();
        }
        slotsPage.clickCtaOnSlotsPage();
        Assert.assertTrue(result,"Test Case failed");
    }

    @Test(priority = 4)
    public void verifyRideConfirmed() {

        String getRideConfirmationText = bookingCompletePage.getBookingConfirmPopupTitle();
        bookingCompletePage.clickBookingConfirmPopupCTA();
        Assert.assertEquals(getRideConfirmationText, "Ride Confirmed");
    }
    @Test(priority = 5)
    public void verifyCurrentRideVisibility() {
        System.out.println("I am inside test");
        boolean homepageCurrentRideCard = homePage.isTrackShuttlDisplayed();
        Assert.assertTrue(homepageCurrentRideCard);
    }

    @Test(priority = 6)
    public void verifyCurrentRideInMyRides() throws Exception {
        homePage.clickMenu();
        myRidesPage.clickMyRidesDisplayText();
        String currentRidePickupText = myRidesPage.currentRideText();
        driver.navigate().back();
        Assert.assertTrue(getValueFromPPFile("homeAddress").contains(currentRidePickupText));
    }

    @Test(priority = 7)
    public void verifyCouponRedeemAfterBooking() {
        homePage.clickMenu();
        couponsPage.clickCouponsDisplayText();
        couponsPage.clickSavedCouponsArea();
        String savedCouponScreenAfterCR = couponsPage.getSavedCouponScreenAfterCouponRedemption();
        Assert.assertEquals(savedCouponScreenAfterCR,"You do not have any saved coupons.");

    }
}
