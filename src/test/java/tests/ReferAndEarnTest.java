package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.OtpPage;
import pages.ReferAndEarnPage;


public class ReferAndEarnTest extends Setup {
    private HomePage homePage;
    private LoginPage loginPage;
    private OtpPage otpPage;
    private Commons commons;
    private ReferAndEarnPage referAndEarnPage;

    @BeforeMethod
    public void setUp() throws Exception {
        createAndroidSession(false);
//      commons = new Commons(driver);
//      commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        Thread.sleep(10000L);
        homePage = new HomePage(driver);
        homePage.clickMenu();
        referAndEarnPage = new ReferAndEarnPage(driver);
    }

    @Test(priority = 1)
    public void testHomeCards() throws Exception {
        commons.goToHomepage("newUserPhoneNumber" , "OTP");
    }

    @Test(priority = 1)
    public void verifyReferNEarnDsiplayText() throws Exception {
        String rnfDisplayText1 = referAndEarnPage.getReferAndEarnDsiplayText();
        Assert.assertEquals(rnfDisplayText1, "Refer & Earn");
        referAndEarnPage.getReferAndEarnDsiplayTextClick();

    }

    @Test(priority = 2)
    public void verifyReferAndEarnTitleText() throws Exception {
        String HeaderText = referAndEarnPage.getRNETitleText();
        Assert.assertEquals(HeaderText, "Refer & Earn", "The header text din't match");
    }

    @Test(priority = 3)
    public void verifytermsAndCondText() throws Exception {
        referAndEarnPage.getActionInfoClick();
        String TncHeaderText = referAndEarnPage.getTNCHeaderText();
        Assert.assertEquals(TncHeaderText, "Terms and Conditions", "Terms and Condition text din't match = Terms and Condition");
        referAndEarnPage.clickBackButton();
        String ReferAndEarnHeaderText = referAndEarnPage.getRNETitleText();
        Assert.assertEquals(ReferAndEarnHeaderText, "Refer & Earn", "The header text din't match = Refer and Earn");
    }

    @Test(priority = 4)
    public void verifyReferalCodeNumber() throws Exception {
        String referralCode = referAndEarnPage.getReferalCode();
        Assert.assertEquals(referralCode, getValueFromPPFile("newUserPhoneNumber"));
    }

    @Test(priority = 5)
    public void verifyYourEarning() throws Exception {
        referAndEarnPage.getReferalEarningClick();
        String YourEarning = referAndEarnPage.getYourEarningTitle();
        Assert.assertEquals(YourEarning, "Your Earnings", "The header text din't match = Your Earning");
        referAndEarnPage.clickBackButton();
        String ReferAndEarnHeaderText = referAndEarnPage.getRNETitleText();
        Assert.assertEquals(ReferAndEarnHeaderText, "Refer & Earn", "The header text din't match = Refer and Earn");
    }

    @Test(priority = 6)
    public void verifyStartRefering() throws Exception {
        referAndEarnPage.getReferalEarningClick();
        String StartReferingText = referAndEarnPage.getStartReferingText();
        Assert.assertEquals(StartReferingText, "START REFERRING", "The header text din't match = Your Earning");
        referAndEarnPage.getStartReferingClick();
        String ReferAndEarnHeaderText = referAndEarnPage.getRNETitleText();
        Assert.assertEquals(ReferAndEarnHeaderText, "Refer & Earn", "The header text din't match = Refer and Earn");
    }

    @Test(priority = 7)
    public void verifyShareThroughWhatsappButton() {
        referAndEarnPage.getWhatsappIconClick();
        String WhatsappShare = referAndEarnPage.getWhatsappTitle();
        Assert.assertEquals(WhatsappShare, "Send to…");
        referAndEarnPage.clickBackButton();
    }

    @Test(priority = 8)
    public void verifyWhatsappSendButton() {
        referAndEarnPage.getWhatsappIconClick();
        String WhatsAppContactTextDetail = referAndEarnPage.getWhatsappScreenText();
        Assert.assertEquals(WhatsAppContactTextDetail, "Frequently contacted");
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




