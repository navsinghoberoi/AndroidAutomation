package pages.android;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReferNEarnPage extends BasePage {

    public ReferNEarnPage(WebDriver driver) {
        super(driver);
    }

    By hamburger_icon = By.className("android.widget.ImageButton");
    By referNEarnDsiplayText = By.xpath(("//android.widget.CheckedTextView[@text='Refer & Earn']"));
    By action_Info = By.id("action_info");
    By headerTNCText = By.xpath(("//android.widget.TextView[@text='Terms and Conditions']"));
    By BackButton = By.xpath("//android.widget.ImageButton[@index=0]");
    By referal_earning = By.xpath("//android.widget.TextView[@text='Your total referral earnings']");
    By yourEarningTitle = By.xpath("//android.widget.TextView[@text='Your Earnings']");
    By referal_code = By.id("refer.refer_id_value");
    By referNEarnTitle = By.xpath("//android.widget.TextView[@text='Refer & Earn']");
    By whatsappIcon = By.xpath("//android.widget.ImageView[@index=0]");
    By whatsappTitleText = By.xpath("//android.widget.TextView[@text='Send to…']");
    By whatappScreen = By.xpath("//android.widget.TextView[@text='Munish']");
    By WhatsappSend = By.xpath("//android.widget.ImageButton[@index=1]");
    By WhatsappSendButton = By.xpath("//android.widget.ImageButton[@index=3]");
    By facebookIcon = By.xpath("//android.widget.LinearLayout[@index=1]");
    By facebookTitleText = By.xpath("//android.view.View[@content-desc='Send Separately']");
    By facebookSendButton = By.xpath("//android.widget.Button[@text=SEND]");
    By messageIcon = By.xpath("//android.widget.ImageView[@index=2]");
    By threeDotMenuIcon = By.xpath("//android.widget.ImageView[@index=3]");
    By startReferingButton = By.xpath("//android.widget.TextView[@text='START REFERRING']");


    //    public void gethamburger_iconClick()
//    {
//
//        //    System.out.println("I am here");
//
//        if(checkIfElementPresent(hamburger_icon,10) == true)
//        {
//            System.out.println("I am here_1");
//            waitForClickabilityOf(hamburger_icon);
//            driver.findElement(hamburger_icon).click();
//            System.out.println("I am here_2");
//        }
//        else
//        {
//            System.out.println("Script failed");
//        }
//    }

            public String getreferNEarnDsiplayText() {
            waitForVisibilityOf(referNEarnDsiplayText);
            String FindMyReferNEarnText= driver.findElement(referNEarnDsiplayText).getText();
            return FindMyReferNEarnText;
//        List<WebElement> FindMyReferNEarnText = driver.findElements(referNEarnDsiplayText);
//        String[] ReferText = new String[FindMyReferNEarnText.size()];
//        int i = 0;
//        for (WebElement element : FindMyReferNEarnText) {
//            ReferText[i] = element.getText();
//            i++;
//            for (String t : ReferText)
//                if (driver.getTitle().equals("Refer & Earn")) {
//                    System.out.println("passed");
//                } else {
//                    System.out.println("failed");
//                }
//        }

    }
    public void getreferNEarnDsiplayTextClick()
    {
        waitForClickabilityOf(referNEarnDsiplayText);
        driver.findElement(referNEarnDsiplayText).click();
    }
    public String getRNETitleText(){
        waitForVisibilityOf(referNEarnTitle);
        String FindreferNEarnTitleText= driver.findElement(referNEarnTitle).getText();
        return FindreferNEarnTitleText;
    }
    public void getaction_InfoClick()
    {
        waitForClickabilityOf(action_Info);
        driver.findElement(action_Info).click();
    }
    public String getTNCHeaderText() {
        waitForVisibilityOf(headerTNCText);
        String FindHeaderTNCTextValue =  driver.findElement(headerTNCText).getText();
        return FindHeaderTNCTextValue;
    }
    public void backButtonClick(){
        waitForClickabilityOf(BackButton);
        driver.findElement(BackButton).click();
    }
    public void getreferal_earningClick()
    {
        waitForClickabilityOf(referal_earning);
        driver.findElement(referal_earning).click();
    }
    public String getYourEarningTitle(){
        waitForVisibilityOf(yourEarningTitle);
        String FindYourEarningText = driver.findElement(yourEarningTitle).getText();
        return FindYourEarningText;
    }
    public void getStartReferingClick(){
        waitForClickabilityOf(startReferingButton);
        driver.findElement(startReferingButton).click();
    }
    public String getStartReferingText(){
        waitForClickabilityOf(startReferingButton);
        String FindReferingText = driver.findElement(startReferingButton).getText();
        return FindReferingText;
    }

//    public String gettermsAndCondition()
//    {
//        waitForVisibilityOf(termsAndCondition);
//        String FindtermsAndConditionText =  driver.findElement(termsAndCondition).getText();
//        return FindtermsAndConditionText;
//    }

    public String getreferal_code()
    {
        waitForVisibilityOf(referal_code);
        String FindMyReferal_Code= driver.findElement(referal_code).getText();
        return FindMyReferal_Code;
    }
    public void getWhatsappIconClick(){
        waitForClickabilityOf(whatsappIcon);
        driver.findElement(whatsappIcon).click();
    }
    public String getWhatsappTitle(){
        String FindMyWhatsappTitleText = driver.findElement(whatsappTitleText).getText();
        return FindMyWhatsappTitleText;
    }
    public void getWhatsAppScreen(){
        waitForClickabilityOf(whatappScreen);
        driver.findElement(whatappScreen).click();
    }
    public String getWhatsappScreenText(){
        String FindMyWhatsAppContactTitle = driver.findElement(whatappScreen).getText();
        return FindMyWhatsAppContactTitle;
    }
    public void whatsAppButtonClick(){
        waitForVisibilityOf(WhatsappSendButton);
        driver.findElement(WhatsappSendButton).click();
    }
    public void getWhatappSendButton(){
        waitForClickabilityOf(WhatsappSend);
        driver.findElement(WhatsappSend).click();
    }
    public void getFBIconClick(){
        waitForClickabilityOf(facebookIcon);
        driver.findElement(facebookIcon).click();
    }
    public String getFBTitleText(){
        String FindFBTitleText = driver.findElement(facebookTitleText).getText();
        return FindFBTitleText;
    }
    public void fbSendbuttonClick(){
        waitForClickabilityOf(facebookSendButton);
        driver.findElement(facebookSendButton).click();
    }
    public void getMessageIconClick(){
        waitForClickabilityOf(messageIcon);
        driver.findElement(messageIcon).click();
    }
    public void getThreeDotMenuIconClick(){
        waitForClickabilityOf(threeDotMenuIcon);
        driver.findElement(threeDotMenuIcon).click();
    }

}
