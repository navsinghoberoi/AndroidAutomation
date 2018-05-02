package tests.android;

import common.android.Commons;
import io.appium.java_client.android.AndroidKeyCode;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.*;

import java.util.List;

public class ReferNEarnTest extends Setup {

    private HomePage homePage;
    //private LandingPage landingPage;
    private LoginPage loginPage;
    private OtpPage otpPage;
    private Commons commons;
    private MenuPage menuPage;
    private ReferNEarnPage referNEarnPage;

    @BeforeClass
    public void setUp() throws Exception {
        createAndroidSession(false);
        commons = new Commons(driver);
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        Thread.sleep(10000L);
        homePage = new HomePage(driver);
        homePage.clickMenu();
        referNEarnPage = new ReferNEarnPage(driver);
    }

    @Test(priority = 1)
    public void verifyReferNEarnDsiplayText() throws Exception {
        String rnfDisplayText1 = referNEarnPage.getreferNEarnDsiplayText();
        Assert.assertEquals(rnfDisplayText1, "Refer & Earn");
        referNEarnPage.getreferNEarnDsiplayTextClick();

    }

    @Test(priority = 2)
    public void verifyReferAndEarnTitleText() throws Exception {
        String HeaderText = referNEarnPage.getRNETitleText();
        Assert.assertEquals(HeaderText, "Refer & Earn", "The header text din't match");
    }

    @Test(priority = 3)
    public void verifytermsAndCondText() throws Exception {
        referNEarnPage.getaction_InfoClick();
        String TncHeaderText = referNEarnPage.getTNCHeaderText();
        Assert.assertEquals(TncHeaderText, "Terms and Conditions", "Terms and Condition text din't match = Terms and Condition");
        referNEarnPage.clickBackButton();
        String ReferAndEarnHeaderText = referNEarnPage.getRNETitleText();
        Assert.assertEquals(ReferAndEarnHeaderText, "Refer & Earn", "The header text din't match = Refer and Earn");
    }

    @Test(priority = 4)
    public void verifyReferalCodeNumber() throws Exception {
        String referralCode = referNEarnPage.getreferal_code();
        Assert.assertEquals(referralCode, "9999999999");
    }

    @Test(priority = 5)
    public void verifyYourEarning() throws Exception {
        referNEarnPage.getreferal_earningClick();
        String YourEarning = referNEarnPage.getYourEarningTitle();
        Assert.assertEquals(YourEarning, "Your Earnings", "The header text din't match = Your Earning");
        referNEarnPage.clickBackButton();
        String ReferAndEarnHeaderText = referNEarnPage.getRNETitleText();
        Assert.assertEquals(ReferAndEarnHeaderText, "Refer & Earn", "The header text din't match = Refer and Earn");
    }

    @Test(priority = 6)
    public void verifyStartRefering() throws Exception {
        referNEarnPage.getreferal_earningClick();
        String StartReferingText = referNEarnPage.getStartReferingText();
        Assert.assertEquals(StartReferingText, "START REFERRING", "The header text din't match = Your Earning");
        referNEarnPage.getStartReferingClick();
        String ReferAndEarnHeaderText = referNEarnPage.getRNETitleText();
        Assert.assertEquals(ReferAndEarnHeaderText, "Refer & Earn", "The header text din't match = Refer and Earn");
    }

    @Test(priority = 7)
    public void verifyShareThroughWhatsappButton() {
        referNEarnPage.getWhatsappIconClick();
        String WhatsappShare = referNEarnPage.getWhatsappTitle();
        Assert.assertEquals(WhatsappShare, "Send to…");
        referNEarnPage.clickBackButton();
    }

    @Test(priority = 8)
    public void verifyWhatsappSendButton() {
        referNEarnPage.getWhatsappIconClick();
        referNEarnPage.getWhatsAppScreen();
        String WhatsAppContactTextDetail = referNEarnPage.getWhatsappScreenText();
        Assert.assertEquals(WhatsAppContactTextDetail, "Munish");
        referNEarnPage.getWhatappSendButton();
        referNEarnPage.whatsAppButtonClick();
       //driver.pressKeyCode(AndroidKeyCode.BACK);

    }
//    @Test(priority = 9)
//    public void verifyFBShareFeature(){
//        referNEarnPage.getFBIconClick();
//        String FbTitleTextVerify = referNEarnPage.getFBTitleText();
//        Assert.assertEquals(FbTitleTextVerify,"Send Separately");
//        referNEarnPage.fbSendbuttonClick();
//        referNEarnPage.clickBackButton();
  //      }
    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        System.out.println("Test cases completed");
        driver.quit();
    }

}




