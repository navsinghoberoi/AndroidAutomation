package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

/*Before running testcase -- Need to add Shuttl credits before running this test
After running testcase -- Run testcase for refund Pass*/

public class SubscriptionBuyViaCreditsTest extends Setup {
    private HomePage homepage;
    private Commons commons;
    private SlotsPage slotsPage;
    private ExplorePassesPage explorePassesPage;
    private ChooseBenefitsPage chooseBenefitsPage;
    private ReviewRoutePage reviewRoutePage;
    private PassCompletePaymentPage passCompletePaymentPage;
    private PassDetailsPage passDetailsPage;
    private String className;

    @BeforeMethod
    public void setUp() throws Exception {
        createAndroidSession(true);
        homepage = new HomePage(driver);
        commons = new Commons(driver);
        slotsPage = new SlotsPage(driver);
        explorePassesPage = new ExplorePassesPage(driver);
        chooseBenefitsPage = new ChooseBenefitsPage(driver);
        reviewRoutePage = new ReviewRoutePage(driver);
        passCompletePaymentPage = new PassCompletePaymentPage(driver);
        passDetailsPage = new PassDetailsPage(driver);
        commons.goToHomepage("userWithoutSubsPhoneNumber", "userWithoutSubsOTP");
        className = getClass().getSimpleName() + commons.getCurrentTime();
    }


    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            commons.captureScreenshot(driver, className + " " + iTestResult.getMethod().getMethodName());
            System.out.println("Screenshot taken for failed testcase");
        }
        driver.quit();
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
        boolean noPassCtaDisplayed = passDetailsPage.isNoPassCTADisplayed();
        Assert.assertEquals(noPassCtaDisplayed, true);
    }


    @Test(priority = 2)
    public void verifyBuyPassOptionAppearing() throws Exception {
        boolean buyPassOptionDisplayed;
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        buyPassOptionDisplayed = slotsPage.checkBuyPassDisplayed();
        Assert.assertEquals(buyPassOptionDisplayed, true);
    }


    @Test(priority = 3)
    public void verifyExplorePassesPageHeading() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        String pageHeading = explorePassesPage.getPageTitle();
        Assert.assertEquals(pageHeading, "Shuttl Pass");
    }


    @Test(priority = 4)
    public void verifyPassesCountOnExplorePassPage() throws Exception {
        boolean passesCount;
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        int count = explorePassesPage.passesCount();
        if (count == 0) {
            passesCount = false;
        } else {
            passesCount = true;
        }
        Assert.assertEquals(passesCount, true);
    }


    @Test(priority = 5)
    public void verifyChooseBenefitsPageHeading() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        String pageHeading = chooseBenefitsPage.getPageTitle();
        Assert.assertEquals(pageHeading, "Choose Benefits With");
    }


    @Test(priority = 6)
    public void verifyChooseBenefitsPageCTA() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        String pageCTAName = chooseBenefitsPage.getCTAName();
        Assert.assertEquals(pageCTAName, "Proceed without benefits");
    }


    @Test(priority = 7)
    public void verifyReviewRoutePageHeading() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.submitPassBenefitsDetails();
        String pageHeading = reviewRoutePage.getPageTitle();
        Assert.assertEquals(pageHeading, "Review Route For");
    }


    @Test(priority = 8)
    public void verifyReviewRoutePageCTA() throws Exception {
        boolean pageCTAName;
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.submitPassBenefitsDetails();
        String ctaName = reviewRoutePage.getCTAName();
        if (ctaName.contains("Continue To Pay ₹")) {
            pageCTAName = true;
        } else {
            pageCTAName = false;
        }
        Assert.assertEquals(pageCTAName, true);
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
        String pageHeading = passCompletePaymentPage.getPageTitle();
        Assert.assertEquals(pageHeading, "Complete Payment");
    }


    @Test(priority = 10)
    public void verifyTotalPriceAmountOnCompletePaymentPage() throws Exception {
        boolean isTotalPassPriceCalculatedCorrectly;
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.submitPassBenefitsDetails();
        String ctaNameOnReviewRoute = reviewRoutePage.getCTAName();
        String array[] = ctaNameOnReviewRoute.split(" ");
        String expectedTotalPrice = array[3];
        reviewRoutePage.submitReviewRouteDetails();
        String totalPriceOnCompletePaymentPage = passCompletePaymentPage.getTotalPrice();
        if (totalPriceOnCompletePaymentPage.equals(expectedTotalPrice)) {
            isTotalPassPriceCalculatedCorrectly = true;
        } else {
            isTotalPassPriceCalculatedCorrectly = false;
        }
        Assert.assertEquals(isTotalPassPriceCalculatedCorrectly, true);
    }


    @Test(priority = 11)
    public void verifyPayButtonIsEnabledOnCompletePaymentPage() throws Exception {
        boolean isPayButtonEnabled;
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.submitPassBenefitsDetails();
        reviewRoutePage.submitReviewRouteDetails();
        isPayButtonEnabled = passCompletePaymentPage.isPayButtonEnabled();
        Assert.assertEquals(isPayButtonEnabled, true);
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
        String payButtonText = passCompletePaymentPage.getPayButtonText();
        Assert.assertEquals(payButtonText, "Pay Now");
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
        boolean noPassCtaDisplayed = passDetailsPage.isNoPassCTADisplayed();
        Assert.assertEquals(noPassCtaDisplayed, false);
    }

    // This method is added to refund the subscription bought in above methods
    @Test(priority = 15)
    public void refundPassViaApi() throws Exception {
        commons.refundSubscriptionViaApiEngine(getValueFromPPFile("RefundPassUserID"));
    }
}

