package tests;

import common.Commons;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

/*
Before running testcase -- User should have an active pass
*/

public class SubscriptionRefundTest extends Setup {
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
        boolean noPassCtaDisplayed = passDetailsPage.isNoPassCTADisplayed();
        Assert.assertEquals(noPassCtaDisplayed, false);
    }

    @Test(priority = 2)
    public void verifyDeletePassIconDisplayed() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        boolean deletePassIconDisplayed = passDetailsPage.isDeletePassIconDisplayed();
        Assert.assertEquals(deletePassIconDisplayed, true);
    }

    @Test(priority = 3)
    public void verifyDeletePassIconClickable() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        boolean deletePassIconEnabled = passDetailsPage.isDeletePassIconEnabled();
        Assert.assertEquals(deletePassIconEnabled, true);
    }

    @Test(priority = 4)
    public void verifyDiscontinuePassOptionsAreDisplayed() {
        boolean isDiscontinuePassOptionAppearing;
        homepage.clickMenu();
        homepage.openMyPass(0);
        passDetailsPage.clickDeleteIcon();
        int discontinueReasonsCount = passDetailsPage.getDeletePassReasonsCount();
        if (discontinueReasonsCount > 0) {
            isDiscontinuePassOptionAppearing = true;
        } else {
            isDiscontinuePassOptionAppearing = false;
        }
        Assert.assertEquals(isDiscontinuePassOptionAppearing, true);
    }

    @Test(priority = 5)
    public void verifyCancelSubscriptionPopupHeading() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        passDetailsPage.clickDeleteIcon();
        passDetailsPage.selectDeletePassReason(1);
        String cancelSubscriptionPopupHeading = passDetailsPage.getCancelSubscriptionPopupHeading();
        Assert.assertEquals(cancelSubscriptionPopupHeading, "Cancel Subscription");
    }

    @Test(priority = 6)
    public void verifyCancelSubscriptionPopupContent() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        passDetailsPage.clickDeleteIcon();
        passDetailsPage.selectDeletePassReason(1);
        String cancelSubscriptionPopupContent = passDetailsPage.getCancelSubscriptionPopupContent();
        Assert.assertEquals(cancelSubscriptionPopupContent, "Are you sure you want to discontinue your pass? You will lose all your current rides.");
    }

    @Test(priority = 7)
    public void verifyDismissButtonClickOnCancelSubscriptionPopup() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        passDetailsPage.clickDeleteIcon();
        passDetailsPage.selectDeletePassReason(1);
        passDetailsPage.cancelPopupDismiss();
        // Verify user remains on Pass Details page after clicking Dismiss button
        boolean deletePassIconDisplayed = passDetailsPage.isDeletePassIconDisplayed();
        Assert.assertEquals(deletePassIconDisplayed, true);
    }

    @Test(priority = 8)
    public void verifyConfirmButtonClickOnCancelSubscriptionPopup() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        passDetailsPage.clickDeleteIcon();
        passDetailsPage.selectDeletePassReason(1);
        passDetailsPage.clickConfirmButtonOnCancelSubsPopup();
        //Verify user directed to Discontinue Pass page on click of Confirm button
        boolean discontinuePassButtonDisplayed = refundPassPage.isDiscontinuePassButtonEnabled();
        Assert.assertEquals(discontinuePassButtonDisplayed, true);
    }

    @Test(priority = 9)
    public void verifyRefundPassPriceOnRefundPage() {
        boolean isRefundPassPriceCorrect;
        homepage.clickMenu();
        homepage.openMyPass(0);
        // Fetch pass price on Pass Details page
        String passPriceOnPassDetailsPage = passDetailsPage.getPassPrice().trim();
        System.out.println("Pass price on Pass Details page = " + passPriceOnPassDetailsPage);
        passDetailsPage.clickDeleteIcon();
        passDetailsPage.selectDeletePassReason(1);
        passDetailsPage.clickConfirmButtonOnCancelSubsPopup();
        refundPassPage.clickRefundDetailsInfo();
        // Fetch refund pass price from refund pass info popup
        String passPriceOnRefundPassPage = refundPassPage.getPassPriceFromRefundDetailsInfoPopup(0).trim();
        if (passPriceOnPassDetailsPage.equals(passPriceOnRefundPassPage)) {
            isRefundPassPriceCorrect = true;
        } else {
            isRefundPassPriceCorrect = false;
        }
        Assert.assertEquals(isRefundPassPriceCorrect, true);
    }


    @Test(priority = 10)
    public void verifyDiscontinuePassButtonEnabled() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        passDetailsPage.clickDeleteIcon();
        passDetailsPage.selectDeletePassReason(1);
        passDetailsPage.clickConfirmButtonOnCancelSubsPopup();
        boolean discontinuePassButtonDisplayed = refundPassPage.isDiscontinuePassButtonEnabled();
        Assert.assertEquals(discontinuePassButtonDisplayed, true);
    }

    @Test(priority = 11)
    public void verifyDiscontinuePassButtonText() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        passDetailsPage.clickDeleteIcon();
        passDetailsPage.selectDeletePassReason(1);
        passDetailsPage.clickConfirmButtonOnCancelSubsPopup();
        String discontinuePassButtonText = refundPassPage.getDiscontinuePassButtonText();
        Assert.assertEquals(discontinuePassButtonText, "DISCONTINUE PASS");
    }

    @Test(priority = 12)
    public void verifyRefundSubscription() throws Exception {
        homepage.clickMenu();
        homepage.openMyPass(0);
        passDetailsPage.clickDeleteIcon();
        passDetailsPage.selectDeletePassReason(1);
        passDetailsPage.clickConfirmButtonOnCancelSubsPopup();
        refundPassPage.clickDiscontinuePassButton();
        String refundPassText = refundPassPage.clickPassRefundSuccessfulCTA();
        Thread.sleep(5000);
        Assert.assertEquals(refundPassText, "Refund Successful");
    }

    @Test(priority = 13)
    public void verifyIsSubscriptionDisplayedAfterPassRefund() {
        homepage.clickMenu();
        homepage.openMyPass(0);
        boolean noPassCtaDisplayed = passDetailsPage.isNoPassCTADisplayed();
        Assert.assertEquals(noPassCtaDisplayed, true);
    }


}
