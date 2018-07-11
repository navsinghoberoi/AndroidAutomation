package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class SubscriptionBuyWithPBAddon extends Setup {
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
        //  commons.goToHomepage("userWithoutSubsPhoneNumber", "userWithoutSubsOTP");
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
    public void verifyAddonsPassOfferLabelOnExplorePassesPage() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        String addonsOfferLabel = explorePassesPage.getOfferLabelText(0);
        boolean isOfferLabelContentCorrect = addonsOfferLabel.contains(getValueFromPPFile("addonsOfferLabelText"));
        Assert.assertEquals(isOfferLabelContentCorrect, true);
    }

    @Test(priority = 4)
    public void verifyChooseBenefitsPageHeading() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        String pageHeading = chooseBenefitsPage.getPageTitle();
        Assert.assertEquals(pageHeading, "Choose Benefits With");
    }

    @Test(priority = 5)
    public void verifyPBAddonDisplayedOnChooseBenefitsPage() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        String addonName = chooseBenefitsPage.getAddonName();
        Assert.assertEquals(addonName, "Priority Booking");
    }

    @Test(priority = 6)
    public void verifyChooseBenefitsPageCTA() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        String addonPrice = chooseBenefitsPage.selectAddonForAdditionalBenefits();
        String pageCTAName = chooseBenefitsPage.getCTAName();
        Assert.assertEquals(pageCTAName, "Add benefit worth " + addonPrice);
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
    public void verifyCTADisabledBeforeSelectingTimeRangeAddons() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.selectAddonForAdditionalBenefits();
        chooseBenefitsPage.submitPassBenefitsDetails();
        boolean CTAEnabled = reviewRoutePage.isCTAEnabled();
        Assert.assertEquals(CTAEnabled, false);
    }

    @Test(priority = 9)
    public void verifyCTAEnabledAfterSelectingTimeRangeAddons() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.selectAddonForAdditionalBenefits();
        chooseBenefitsPage.submitPassBenefitsDetails();
        reviewRoutePage.selectTimeRangeMorningSession(0);
        reviewRoutePage.selectTimeRangeEveningSession(0);
        boolean CTAEnabled = reviewRoutePage.isCTAEnabled();
        Assert.assertEquals(CTAEnabled, true);
    }

    @Test(priority = 10)
    public void verifyReviewRoutePageCTA() throws Exception {
        boolean pageCTAName;
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.selectAddonForAdditionalBenefits();
        chooseBenefitsPage.submitPassBenefitsDetails();
        String ctaName = reviewRoutePage.getCTAName();
        if (ctaName.contains("Continue To Pay ₹")) {
            pageCTAName = true;
        } else {
            pageCTAName = false;
        }
        Assert.assertEquals(pageCTAName, true);
    }

    @Test(priority = 11)
    public void verifyCompletePaymentPageHeading() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.selectAddonForAdditionalBenefits();
        chooseBenefitsPage.submitPassBenefitsDetails();
        reviewRoutePage.selectTimeRangeMorningSession(0);
        reviewRoutePage.selectTimeRangeEveningSession(0);
        reviewRoutePage.submitReviewRouteDetails();
        String pageHeading = passCompletePaymentPage.getPageTitle();
        Assert.assertEquals(pageHeading, "Complete Payment");
    }

    @Test(priority = 12)
    public void verifyPBAddonNameOnCompletePaymentPage() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.selectAddonForAdditionalBenefits();
        chooseBenefitsPage.submitPassBenefitsDetails();
        reviewRoutePage.selectTimeRangeMorningSession(0);
        reviewRoutePage.selectTimeRangeEveningSession(0);
        reviewRoutePage.submitReviewRouteDetails();
        String addonNameOnCompletePaymentPage = passCompletePaymentPage.getAddonNameUnderPriceSummary();
        Assert.assertEquals(addonNameOnCompletePaymentPage, "Add-on: Priority Booking");
    }

    @Test(priority = 13)
    public void verifyTotalPriceAmountOnCompletePaymentPage() throws Exception {
        boolean isTotalPassPriceCalculatedCorrectly;
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.selectAddonForAdditionalBenefits();
        chooseBenefitsPage.submitPassBenefitsDetails();
        reviewRoutePage.selectTimeRangeMorningSession(0);
        reviewRoutePage.selectTimeRangeEveningSession(0);
        String fullCTAName = reviewRoutePage.getCTAName();
        reviewRoutePage.submitReviewRouteDetails();
        String expectedTotalPrice = fullCTAName.substring(16, 22);     // fetching total (pass + addons) price
        String totalPriceOnCompletePaymentPage = passCompletePaymentPage.getTotalPrice();
        if (totalPriceOnCompletePaymentPage.equals(expectedTotalPrice)) {
            isTotalPassPriceCalculatedCorrectly = true;
        } else {
            isTotalPassPriceCalculatedCorrectly = false;
        }
        Assert.assertEquals(isTotalPassPriceCalculatedCorrectly, true);
    }

    @Test(priority = 14)
    public void verifyPayButtonIsEnabledOnCompletePaymentPage() throws Exception {
        boolean isPayButtonEnabled;
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.selectAddonForAdditionalBenefits();
        chooseBenefitsPage.submitPassBenefitsDetails();
        reviewRoutePage.selectTimeRangeMorningSession(0);
        reviewRoutePage.selectTimeRangeEveningSession(0);
        reviewRoutePage.submitReviewRouteDetails();
        isPayButtonEnabled = passCompletePaymentPage.isPayButtonEnabled();
        Assert.assertEquals(isPayButtonEnabled, true);
    }

    @Test(priority = 15)
    public void verifyPassPurchaseWithAddonPrompt() throws Exception {
        commons.openSearchBarAndFindRoute("homeAddress", "officeAddress");
        slotsPage.clickSlot(0);
        slotsPage.clickBuyPass();
        explorePassesPage.dismissPassRulesPopup();
        explorePassesPage.openPass(0);
        chooseBenefitsPage.selectAddonForAdditionalBenefits();
        chooseBenefitsPage.submitPassBenefitsDetails();
        reviewRoutePage.selectTimeRangeMorningSession(0);
        reviewRoutePage.selectTimeRangeEveningSession(0);
        reviewRoutePage.submitReviewRouteDetails();
        passCompletePaymentPage.clickPayNowButton();
        String passPurchasedtext = passCompletePaymentPage.clickPassPurchaseSuccessfulCTA();
        Assert.assertEquals(passPurchasedtext, "Pass Purchased");
    }

    @Test(priority = 16)
    public void verifyIsSubscriptionDisplayedAfterPassPurchase() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        boolean noPassCtaDisplayed = passDetailsPage.isNoPassCTADisplayed();
        Assert.assertEquals(noPassCtaDisplayed, false);
    }

    @Test(priority = 17)
    public void verifyActiveBenefitsAppearingOnPassDetailsPage() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        boolean activeBenefitsDisplayed = passDetailsPage.isActiveBenefitsDisplayed();
        Assert.assertEquals(activeBenefitsDisplayed, true);
    }

}
