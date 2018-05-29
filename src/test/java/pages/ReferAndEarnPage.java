package pages.android;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReferAndEarnPage extends BasePage {

    public ReferAndEarnPage(WebDriver driver) {
        super(driver);
    }

    By hamburger_icon = By.className("android.widget.ImageButton");
    By referAndEarnDsiplayText = By.xpath(("//android.widget.CheckedTextView[@text='Refer & Earn']"));
    By actionInfo = By.id("action_info");
    By headerTNCText = By.xpath(("//android.widget.TextView[@text='Terms and Conditions']"));
    By backButton = By.xpath("//android.widget.ImageButton[@index=0]");
    By referalEarning = By.xpath("//android.widget.TextView[@text='Your total referral earnings']");
    By yourEarningTitle = By.xpath("//android.widget.TextView[@text='Your Earnings']");
    By referalCode = By.id("refer.refer_id_value");
    By referAndEarnTitle = By.xpath("//android.widget.TextView[@text='Refer & Earn']");
    By whatsappIcon = By.xpath("//android.widget.ImageView[@index=0]");
    By whatsappTitleText = By.xpath("//android.widget.TextView[@text='Send to…']");
    By WhatsappFirstElementClick = By.xpath("//android.widget.RelativeLayout[@index=2]");
    By whatappScreen = By.xpath("//android.widget.TextView[@text='Frequently contacted']");
    By WhatsappSend = By.xpath("//android.widget.ImageButton[@index=1]");
    By WhatsappSendButton = By.xpath("//android.widget.ImageButton[@index=3]");
    By facebookIcon = By.xpath("//android.widget.LinearLayout[@index=1]");
    By facebookTitleText = By.xpath("//android.view.View[@content-desc='Send Separately']");
    By facebookSendButton = By.xpath("//android.widget.Button[@text=SEND]");
    By messageIcon = By.xpath("//android.widget.ImageView[@index=2]");
    By threeDotMenuIcon = By.xpath("//android.widget.ImageView[@index=3]");
    By startReferingButton = By.xpath("//android.widget.TextView[@text='START REFERRING']");


    public String getReferAndEarnDsiplayText() {
        waitForVisibilityOf(referAndEarnDsiplayText);
        String FindMyReferAndEarnText= driver.findElement(referAndEarnDsiplayText).getText();
        return FindMyReferAndEarnText;

    }
    public void getReferAndEarnDsiplayTextClick()
    {
        waitForClickabilityOf(referAndEarnDsiplayText);
        driver.findElement(referAndEarnDsiplayText).click();
    }
    public String getRNETitleText(){
        waitForVisibilityOf(referAndEarnTitle);
        String FindReferAndEarnTitleText= driver.findElement(referAndEarnTitle).getText();
        return FindReferAndEarnTitleText;
    }
    public void getActionInfoClick()
    {
        waitForClickabilityOf(actionInfo);
        driver.findElement(actionInfo).click();
    }
    public String getTNCHeaderText() {
        waitForVisibilityOf(headerTNCText);
        String FindHeaderTNCTextValue =  driver.findElement(headerTNCText).getText();
        return FindHeaderTNCTextValue;
    }
    public void clickBackButton(){
        waitForClickabilityOf(backButton);
        driver.findElement(backButton).click();
    }
    public void getReferalEarningClick()
    {
        waitForClickabilityOf(referalEarning);
        driver.findElement(referalEarning).click();
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
    public String getReferalCode()
    {
        waitForVisibilityOf(referalCode);
        String FindMyReferal_Code= driver.findElement(referalCode).getText();
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
    public void getWhatsappFirstContactClick(){
        waitForClickabilityOf(WhatsappFirstElementClick);
        driver.findElement(WhatsappFirstElementClick).click();
    }
    public String getWhatsappScreenText(){
        String FindMyWhatsappContactTitle = driver.findElement(whatappScreen).getText();
        return FindMyWhatsappContactTitle;
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
    public void fbSendButtonClick(){
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
