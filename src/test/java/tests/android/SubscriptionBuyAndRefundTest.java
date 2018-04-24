package tests.android;

import common.android.Commons;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.*;

// Need to add Shuttl credits before running this test

public class SubscriptionBuyAndRefundTest extends Setup {
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

    @BeforeClass
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
    }

    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }


    @Test(priority = 1)
    public void verifySubscriptionBuy() throws Exception {
        commons.enterUserPhoneNumberOTP("oldUserPhoneNumber", "oldUserOTP");
        commons.clickSearchBar();
        homepage.clickFromLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("homeAddress"), 0);
        homepage.clickToLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile("officeAddress"), 0);
        homepage.clickFindMyShuttl();
        slotsPage.selectOptionFromContinueCTA(0, 0);
        explorePassesPage.openPass(0);
        chooseBenefitsPage.submitPassBenefitsDetails();
        reviewRoutePage.submitReviewRouteDetails();
        passCompletePaymentPage.getPassCompletepageInfo();
        passCompletePaymentPage.clickPayNowButton();
        String passPurchasedtext = passCompletePaymentPage.clickPassPurchaseSuccessfulCTA();
        Assert.assertEquals(passPurchasedtext, "Pass Purchased", "Pass is not purchased successfully");
        System.out.println("Pass is purchased successfully");
    }

    @Test(priority = 2)
    public void verifySubscriptionRefund() {

        slotsPage.clickBackButton();
        commons.closeSearchPopup();
        homepage.clickMenu();
        homepage.openMyPass(0); // User will be redirected to Pass details page directly (from version 36000+)
        passDetailsPage.getRidesValidityData(0, 1);
        passDetailsPage.deletePass(1);
        refundPassPage.clickDiscontinuePassButton(0);
        String refundPassText = refundPassPage.clickPassRefundSuccessfulCTA();
        Assert.assertEquals(refundPassText, "Refund Successful", "Pass is not refunded successfully");
        System.out.println("Pass is refunded successfully");
    }


}

