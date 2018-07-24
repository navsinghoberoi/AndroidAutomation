package tests;

import common.Commons;
import org.glassfish.grizzly.compression.lzma.impl.Base;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;


public class ReferAndEarnTest extends Setup {
    private HomePage homePage;
    private LoginPage loginPage;
    private OtpPage otpPage;
    private Commons commons;
    private ReferAndEarnPage referAndEarnPage;
    private String className;
    private String referalEarning;

    @BeforeClass
    public void setUp() throws Exception {
        createAndroidSession(true);
        commons = new Commons(driver);
        //commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        Thread.sleep(5000L);
        homePage = new HomePage(driver);
        homePage.clickMenu();
        referAndEarnPage = new ReferAndEarnPage(driver);
        className = getClass().getSimpleName() + commons.getCurrentTime();
        referalEarning = commons.connectSQLDbAndFetchValue(getValueFromPPFile("umsQaDbIP"), getValueFromPPFile("umsQaDbUserName"), getValueFromPPFile("umsQaDbPassword"), getValueFromPPFile("umsQaDbName"), getValueFromPPFile("umsQaDbSqlQueryFetchUserReferalEarning"), getValueFromPPFile("umsQaDbFetchEarningColumnName"));
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if (ITestResult.FAILURE == iTestResult.getStatus()){
            commons.captureScreenshot(driver,className);
            System.out.println("Screenshot taken for failed testcase");
        }
     //   driver.quit();
    }

    @Test(priority = 1)
    public void verifyReferNEarnDsiplayText() throws Exception {
        String rnfDisplayText1 = referAndEarnPage.getReferAndEarnDsiplayText();
        Assert.assertEquals(rnfDisplayText1, "Refer & Earn");
    }

    @Test(priority = 2)
    public void verifyReferAndEarnTitleText() throws Exception {
        System.out.println("clicked hamburger");
        referAndEarnPage.getReferAndEarnDsiplayTextClick();
        String headerText = referAndEarnPage.getRNETitleText();
        Assert.assertEquals(headerText, "Refer & Earn", "The header text din't match");
    }

    @Test(priority = 3)
    public void verifytermsAndCondText() throws Exception {
        referAndEarnPage.getActionInfoClick();
        String tncHeaderText = referAndEarnPage.getTNCHeaderText();
        Assert.assertEquals(tncHeaderText, "Terms and Conditions", "Terms and Condition text din't match = Terms and Condition");
        referAndEarnPage.clickBackButton();
        String referAndEarnHeaderText = referAndEarnPage.getRNETitleText();
        Assert.assertEquals(referAndEarnHeaderText, "Refer & Earn", "The header text din't match = Refer and Earn");
    }

    @Test(priority = 4)
    public void verifyReferalCodeNumber() throws Exception {
        String referralCode = referAndEarnPage.getReferalCode();
        Assert.assertEquals(referralCode, getValueFromPPFile("newUserPhoneNumber"));
    }

    @Test(priority = 5)
    public void verifyYourEarning() throws Exception {
        referAndEarnPage.getReferalEarningClick();
        String yourEarning = referAndEarnPage.getYourEarningTitle();
        Assert.assertEquals(yourEarning, "Your Earnings", "The header text din't match = Your Earning");
        referAndEarnPage.clickBackButton();
        String referAndEarnHeaderText = referAndEarnPage.getRNETitleText();
        Assert.assertEquals(referAndEarnHeaderText, "Refer & Earn", "The header text din't match = Refer and Earn");
    }
    @Test(priority = 6)
    public void verifyReferalEarning(){
        String referal_Earning = referAndEarnPage.getReferalEarning();
        Assert.assertEquals(referal_Earning,referalEarning);
    }

    @Test(priority = 7)
    public void verifyStartRefering() throws Exception {
        referAndEarnPage.getReferalEarningClick();
        String startReferingText = referAndEarnPage.getStartReferingText();
        Assert.assertEquals(startReferingText, "START REFERRING", "The header text din't match = Your Earning");
        referAndEarnPage.getStartReferingClick();
        String referAndEarnHeaderText = referAndEarnPage.getRNETitleText();
        Assert.assertEquals(referAndEarnHeaderText, "Refer & Earn", "The header text din't match = Refer and Earn");
    }

    @Test(priority = 8)
    public void verifyShareThroughWhatsappButton() {
        referAndEarnPage.getWhatsappIconClick();
        String whatsappShare = referAndEarnPage.getWhatsappTitle();
        Assert.assertEquals(whatsappShare, "Send to…");
        referAndEarnPage.clickBackButton();
    }

    @Test(priority = 9)
    public void verifyWhatsappSendButton() {
        referAndEarnPage.getWhatsappIconClick();
        String whatsAppContactTextDetail = referAndEarnPage.getWhatsappScreenText();
        Assert.assertEquals(whatsAppContactTextDetail, "Frequently contacted");
        referAndEarnPage.getWhatsappFirstContactClick();
        referAndEarnPage.getWhatappSendButton();
        referAndEarnPage.whatsAppButtonClick();

    }

    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Test cases completed");
        driver.quit();
    }

}




