package pages;


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
    By referEarningValue = By.id("refer.earnings_card_value");
    private MenuPage menuPage;
    private HomePage homePage;

    public String getReferAndEarnDsiplayText() {
        String FindMyReferAndEarnText = null;
        if(checkIfElementPresent(referAndEarnDsiplayText,10)){
             FindMyReferAndEarnText= driver.findElement(referAndEarnDsiplayText).getText();
        }
        else{
            FindMyReferAndEarnText =  menuPage.referText();
        }
        return FindMyReferAndEarnText;
    }
    public boolean getReferAndEarnDisplayTextClick()
    {
        try{
            System.out.println("need to click on R&F title");
            waitForClickabilityOf(referAndEarnDsiplayText);
            System.out.println("wait for clickability");
            driver.findElement(referAndEarnDsiplayText).click();
            System.out.println("clicked");
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }

    public String getRNETitleText(){
        String FindReferAndEarnTitleText = null;
        try{
           waitForVisibilityOf(referAndEarnTitle);
           FindReferAndEarnTitleText= driver.findElement(referAndEarnTitle).getText();
       }catch (Exception e)
       {
           return FindReferAndEarnTitleText;
       }
        return FindReferAndEarnTitleText ;
    }
    public boolean getActionInfoClick()
    {
        try{
            waitForClickabilityOf(actionInfo);
            driver.findElement(actionInfo).click();
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }
    public String getTNCHeaderText() {
        waitForVisibilityOf(headerTNCText);
        String FindHeaderTNCTextValue =  driver.findElement(headerTNCText).getText();
        return FindHeaderTNCTextValue;
    }
    public boolean clickBackButton(){
        try {
            waitForClickabilityOf(backButton);
            driver.findElement(backButton).click();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public boolean getReferalEarningClick()
    {
        try{
            waitForClickabilityOf(referalEarning);
            driver.findElement(referalEarning).click();
            return true;
        }
        catch(Exception e){
            return false;
        }

    }
    public String getReferalEarning(){
        try {
            waitForVisibilityOf(referEarningValue);
            String getREValue = driver.findElement(referEarningValue).getText();
            getREValue = getREValue.substring(1);
            System.out.println(getREValue);
            return getREValue;
        }
        catch(Exception e){
            return null;
        }
    }
    public String getYourEarningTitle(){
        waitForVisibilityOf(yourEarningTitle);
        String FindYourEarningText = driver.findElement(yourEarningTitle).getText();
        return FindYourEarningText;
    }
    public boolean getStartReferingClick(){
        try {
            waitForClickabilityOf(startReferingButton);
            driver.findElement(startReferingButton).click();
            return true;
        }
        catch(Exception e){
            return false;
        }

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
    public boolean getWhatsappIconClick(){
        try {
            waitForClickabilityOf(whatsappIcon);
            driver.findElement(whatsappIcon).click();
            return true;
        }
        catch(Exception e){
            return false;

        }
    }
    public String getWhatsappTitle(){
        String FindMyWhatsappTitleText = driver.findElement(whatsappTitleText).getText();
        return FindMyWhatsappTitleText;
    }
    public boolean getWhatsAppScreen(){
        try {
            waitForClickabilityOf(whatappScreen);
            driver.findElement(whatappScreen).click();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public boolean getWhatsappFirstContactClick(){
        try {
            waitForClickabilityOf(WhatsappFirstElementClick);
            driver.findElement(WhatsappFirstElementClick).click();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public String getWhatsappScreenText(){
        String FindMyWhatsappContactTitle = driver.findElement(whatappScreen).getText();
        return FindMyWhatsappContactTitle;
    }
    public boolean whatsAppButtonClick(){
        try {
            waitForVisibilityOf(WhatsappSendButton);
            driver.findElement(WhatsappSendButton).click();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean getWhatappSendButton(){
        try {
            waitForClickabilityOf(WhatsappSend);
            driver.findElement(WhatsappSend).click();
            return true;
        }
        catch (Exception e){
            return false;
        }
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
