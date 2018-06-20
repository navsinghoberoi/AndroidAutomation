package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

/*Before running testcase -- Need to add Shuttl credits before running this test
After running testcase -- Run testcase for refund Pass*/

public class SubscriptionBuyViaCreditsTest extends Setup {
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
    private String className;

    @BeforeMethod
    public void setUp() throws Exception {
        createAndroidSession(true);
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
        commons.goToHomepage("userWithoutSubsPhoneNumber", "userWithoutSubsOTP");
        className = getClass().getSimpleName() + commons.getCurrentTime();
    }


    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            commons.captureScreenshot(driver, className + " " + iTestResult.getMethod().getMethodName());
            System.out.println("Screenshot taken for failed testcase");
        }
    }


    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }


    @Test(priority = 1)
    public void verifyIsSubscriptionDisplayed() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        boolean result = passDetailsPage.isNoPassCTADisplayed();
        Assert.assertEquals(result, true);
    }


    @Test(priority = 2)
    public void verifyBuyPassOptionAppearing() throws Exception {
        boolean result;
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        result = slotsPage.checkBuyPassDisplayed();
        Assert.assertEquals(result, true);
    }


    @Test(priority = 3)
    public void verifyExplorePassesPageHeading() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        String result = explorePassesPage.getPageHeading();
        Assert.assertEquals(result, "Shuttl Pass");
    }


    @Test(priority = 4)
    public void verifyPassesCountOnExplorePassPage() throws Exception {
        boolean result;
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        int count = explorePassesPage.passesCount();
        if (count == 0) {
            result = false;
        } else {
            result = true;
        }
        Assert.assertEquals(result, true);
    }


    @Test(priority = 5)
    public void verifyChooseBenefitsPageHeading() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        String result = chooseBenefitsPage.getPageHeading();
        Assert.assertEquals(result, "Choose Benefits With");
    }


    @Test(priority = 6)
    public void verifyChooseBenefitsPageCTA() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        String result = chooseBenefitsPage.getCTAName();
        Assert.assertEquals(result, "Proceed without benefits");
    }


    @Test(priority = 7)
    public void verifyReviewRoutePageHeading() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.submitPassBenefitsDetails();
        String result = reviewRoutePage.getPageHeading();
        Assert.assertEquals(result, "Review Route For");
    }


    @Test(priority = 8)
    public void verifyReviewRoutePageCTA() throws Exception {
        boolean result;
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.submitPassBenefitsDetails();
        String ctaName = reviewRoutePage.getCTAName();
        if (ctaName.contains("Continue To Pay ₹")) {
            result = true;
        } else {
            result = false;
        }
        Assert.assertEquals(result, true);
    }


    @Test(priority = 9)
    public void verifyCompletePaymentPageHeading() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.submitPassBenefitsDetails();
        reviewRoutePage.submitReviewRouteDetails();
        String result = passCompletePaymentPage.getPageHeading();
        Assert.assertEquals(result, "Complete Payment");
    }


    @Test(priority = 10)
    public void verifyTotalPriceAmountOnCompletePaymentPage() throws Exception {
        boolean result;
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.submitPassBenefitsDetails();
        String data = reviewRoutePage.getRidesDaysData();
        String array[] = data.split(" ");
        int rides = Integer.parseInt(array[0]);
        int days = Integer.parseInt(array[3]);
        int price = rides * days;
        String expectedTotalPrice = "₹" + String.valueOf(price);
        reviewRoutePage.submitReviewRouteDetails();
        String totalPriceOnCompletePaymentPage = passCompletePaymentPage.getTotalPrice();
        if (totalPriceOnCompletePaymentPage.equals(expectedTotalPrice)) {
            result = true;
        } else {
            result = false;
        }
        Assert.assertEquals(result, true);
    }


    @Test(priority = 11)
    public void verifyPayButtonIsEnabledOnCompletePaymentPage() throws Exception {
        boolean result;
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.submitPassBenefitsDetails();
        reviewRoutePage.submitReviewRouteDetails();
        result = passCompletePaymentPage.isPayButtonEnabled();
        Assert.assertEquals(result, true);
    }


    @Test(priority = 12)
    public void verifyPayButtonTextOnCompletePaymentPage() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.submitPassBenefitsDetails();
        reviewRoutePage.submitReviewRouteDetails();
        String result = passCompletePaymentPage.getPayButtonText();
        Assert.assertEquals(result, "Pay Now");
    }


    @Test(priority = 13)
    public void verifyPassPurchasePrompt() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.submitPassBenefitsDetails();
        reviewRoutePage.submitReviewRouteDetails();
        passCompletePaymentPage.clickPayNowButton();
        String passPurchasedtext = passCompletePaymentPage.clickPassPurchaseSuccessfulCTA();
        Assert.assertEquals(passPurchasedtext, "Pass Purchased");
    }

    @Test(priority = 14)
    public void verifyIsSubscriptionDisplayedAfterPassPurchase() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        boolean result = passDetailsPage.isNoPassCTADisplayed();
        Assert.assertEquals(result, false);
    }


}

