package tests.android;

import common.android.Commons;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.android.*;

public class BookingFromSubscriptionTest extends Setup {

// NOTE -- Need to book ride on morning/evening route as per current time


    private LandingPage landingPage;
    private LoginPage loginPage;
    private PersonalDetailsPage personalDetails;
    private HomeAddressPage homeAddressPage;
    private OfficeAddressPage officeAddressPage;
    private OtpPage otpPage;
    private HomePage homepage;
    private Commons commons;
    private SelectLocationPage selectLocationPage;
    private SlotsPage slotsPage;
    private ExplorePassesPage explorePassesPage;
    private ChooseBenefitsPage chooseBenefitsPage;
    private ReviewRoutePage reviewRoutePage;
    private PassCompletePaymentPage passCompletePaymentPage;
    private PassDetailsPage passDetailsPage;
    private RefundPassPage refundPassPage;
    private BookingCompletePage bookingCompletePage;
    private SubscriptionBuyAndRefundTest subscriptionBuyAndRefundTest;

    @BeforeMethod
    public void setUp() throws Exception {
        createAndroidSession(false);
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        personalDetails = new PersonalDetailsPage(driver);
        homeAddressPage = new HomeAddressPage(driver);
        officeAddressPage = new OfficeAddressPage(driver);
        otpPage = new OtpPage(driver);
        homepage = new HomePage(driver);
        commons = new Commons(driver);
        selectLocationPage = new SelectLocationPage(driver);
        slotsPage = new SlotsPage(driver);
        explorePassesPage = new ExplorePassesPage(driver);
        chooseBenefitsPage = new ChooseBenefitsPage(driver);
        reviewRoutePage = new ReviewRoutePage(driver);
        passCompletePaymentPage = new PassCompletePaymentPage(driver);
        passDetailsPage = new PassDetailsPage(driver);
        refundPassPage = new RefundPassPage(driver);
        bookingCompletePage = new BookingCompletePage(driver);
        subscriptionBuyAndRefundTest = new SubscriptionBuyAndRefundTest();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }


    @Test
    public void verifyCreateBookingFromSubscription() throws Exception {
        commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
        commons.buySubscriptionViaShuttlCredits("homeAddress","officeAddress",0,0,0);
        slotsPage.clickSlot(0);
        slotsPage.clickCtaOnSlotsPage();
        String actualText =   bookingCompletePage.getBookingConfirmPopupTitle();
        System.out.println("Text after creating a booking = "+actualText);
        bookingCompletePage.clickBookingConfirmPopupCTA();
        Assert.assertEquals(actualText,"Ride Confirmed");
        homepage.clickMenu();

        commons.refundSubscription(0,0,1,1,0);

        /*homepage.openMyPass(0); // User will be redirected to Pass details page directly (from version 36000+)
        passDetailsPage.getRidesValidityData(0, 1);
        passDetailsPage.deletePass(1);
        refundPassPage.clickDiscontinuePassButton(0);
        String refundPassText = refundPassPage.clickPassRefundSuccessfulCTA();
        System.out.println(refundPassText);*/

    }




}
