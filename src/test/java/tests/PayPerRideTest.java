package tests;


import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class PayPerRideTest extends Setup {
    private HomePage homePage;
    private SlotsPage slotsPage;
    private Commons commons;
    private PayPerRideCompletePaymentPage payPerRideCompletePaymentPage;
    private BookingCompletePage bookingCompletePage;
    private String className;
    private String creditsBeforeBooking;
    private String pprSubText;


    @BeforeClass
    public void Setup() throws Exception {
        createAndroidSession(true);
        // commons.goToHomepage("newUserPhoneNumber","OTP");
        commons = new Commons(driver);
        homePage = new HomePage(driver);
        //homePage.clickMenu();
        slotsPage = new SlotsPage(driver);
        payPerRideCompletePaymentPage = new PayPerRideCompletePaymentPage(driver);
        bookingCompletePage = new BookingCompletePage(driver);
        className = getClass().getSimpleName() + commons.getCurrentTime();
        //Credits saved in a variable before booking
        creditsBeforeBooking = commons.connectSQLDbAndFetchValue(getValueFromPPFile("umsQaDbIP"), getValueFromPPFile("umsQaDbUserName"), getValueFromPPFile("umsQaDbPassword"), getValueFromPPFile("umsQaDbName"), getValueFromPPFile("umsQaDbSqlQueryFetchUSerWalletDetails"), getValueFromPPFile("umsQaDbFetchBalanceColumnName"));
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
     //   driver.quit();
    }

    @Test(priority = 1)
    public void verifyNonPayPerRideRoute() throws Exception {
        commons.openSearchBarAndFindRoute("officeAddress", "homeAddress");
        slotsPage.clickSlot(0);
        String continueButtonText = slotsPage.getCtaOnSlotsPage();
        Assert.assertEquals(continueButtonText, "BUY PASS", "CTA Button Not Found");
        driver.navigate().back();
        homePage.closeSearchPopup();

    }

    @Test(priority = 2)
    public void verifyPayPerRideRoute() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickCtaOnSlotsPage();
        boolean payPerRideText = payPerRideCompletePaymentPage.getPayPerRide();
        Assert.assertEquals(payPerRideText, true, "Pay Per Ride Text Visible");

    }

    @Test(priority = 3)
    public void verifyRidePrice() throws Exception {

        pprSubText = slotsPage.getPPRSubText();
        System.out.println(pprSubText);
        slotsPage.selectOptionFromContinuePPRO(1);
        payPerRideCompletePaymentPage.clickShuttlCreditRButton();
        String finalRidePrice = payPerRideCompletePaymentPage.getFinalRidePrice();
        Assert.assertEquals(finalRidePrice, pprSubText);

    }

    @Test(priority = 4)
    public void verifyPaymentTitleText() {

        String pprTitleText = payPerRideCompletePaymentPage.paymentTitleText();
        Assert.assertEquals(pprTitleText, "Complete Payment");
    }

    @Test(priority = 5)
    public void verifyPayNowButtonVisibiltyBeforePaymentModeSelection() throws Exception {
        driver.navigate().back();
        slotsPage.clickCtaOnSlotsPage();
        slotsPage.selectOptionFromContinuePPRO( 1);
        boolean getPNBButtonVisibiltyBeforeModeSelection = payPerRideCompletePaymentPage.noPayNowButtonDisplayed();
        Assert.assertEquals(getPNBButtonVisibiltyBeforeModeSelection, false);

    }

    @Test(priority = 6)
    public void verifyPayNowButtonVisibilty() {
        payPerRideCompletePaymentPage.clickShuttlCreditRButton();
        boolean getPNButtonVisibilty = payPerRideCompletePaymentPage.payNowButtonVisible();
        Assert.assertEquals(getPNButtonVisibilty, true);
        payPerRideCompletePaymentPage.clickPayNowButton();
    }

    @Test(priority = 7)
    public void verifyRideConfirmed() {
        String rideConfirmed = bookingCompletePage.clickBookingConfirmPopupCTA();
        Assert.assertEquals(rideConfirmed, "GOT IT!");
    }

    @Test(priority = 8)
    public void verifyHomepageCard() {
        homePage.clickMenu();
        driver.navigate().back();
        boolean homeCardDisplay = homePage.isTrackShuttlDisplayed();
        Assert.assertEquals(homeCardDisplay, true);
    }

    @Test(priority = 9)
    public void verifyShuttlCreditBalanceAfterBooking() throws Exception {
        String creditsAfterBooking = commons.connectSQLDbAndFetchValue(getValueFromPPFile("umsQaDbIP"), getValueFromPPFile("umsQaDbUserName"), getValueFromPPFile("umsQaDbPassword"), getValueFromPPFile("umsQaDbName"), getValueFromPPFile("umsQaDbSqlQueryFetchUSerWalletDetails"), getValueFromPPFile("umsQaDbFetchBalanceColumnName"));
        Assert.assertEquals((Double.parseDouble(creditsBeforeBooking) - Double.parseDouble(pprSubText.substring(1, pprSubText.length()))), Double.parseDouble(creditsAfterBooking));
    }
}
