package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PassCompletePaymentPage extends BasePage {

    By passPrice = By.id("rpd.base_price_value");
    By totalPrice = By.id("rpd.total_price_value");
    By payNowButton = By.id("booking_payment_ppr.make_payment");
    By emailIdData = By.id("booking_payment_ppr.email_id");
    By changeEmailId = By.id("booking_payment_ppr.email_change");
    By enterEmailId = By.id("booking_payment_ppr.email_input_text");
    By passPurchasedText = By.id("dsf.title");
    By successfullyPurchasePassText = By.id("dsf.message");
    By cta = By.id("dsf.button");
    By pageHeading = By.className("android.widget.TextView");
    By addonName = By.id("itd.tax_label");

    public PassCompletePaymentPage(WebDriver driver) {
        super(driver);
    }


    public String getPassPrice() {
        waitForVisibilityOf(passPrice);
        String text = driver.findElement(passPrice).getText();
        System.out.println("Pass price = " + text);
        return text;
    }

    public String getTotalPrice() {
        waitForVisibilityOf(totalPrice);
        String text = driver.findElement(totalPrice).getText();
        System.out.println("Total pass price = " + text);
        return text;
    }


    public String getEmailIdData() {
        waitForVisibilityOf(emailIdData);
        String text = driver.findElement(emailIdData).getText();
        System.out.println("Email id of the user = " + text);
        return text;
    }


    public void changeEmailId() {
        waitForVisibilityOf(changeEmailId);
        driver.findElement(changeEmailId).click();
    }

    public void enterEmailId(String email) {
        waitForVisibilityOf(enterEmailId);
        driver.findElement(enterEmailId).sendKeys(email);
    }


    public void clickPayNowButton() {
        waitForVisibilityOf(payNowButton);
        driver.findElement(payNowButton).click();
    }


    public String clickPassPurchaseSuccessfulCTA() {
        waitForVisibilityOf(passPurchasedText);
        String text1 = driver.findElement(passPurchasedText).getText();
        waitForVisibilityOf(successfullyPurchasePassText);
        String text2 = driver.findElement(successfullyPurchasePassText).getText();
        waitForVisibilityOf(cta);
        String text3 = driver.findElement(cta).getText();
        System.out.println("Pass purchased text = " + text1 + " ; " + text2 + " ; " + text3);
        driver.findElement(cta).click();
        return text1;
    }

    public void getPassCompletepageInfo()
    {
        getPassPrice();
        getTotalPrice();
    }

    public String getPageTitle() {
        waitForVisibilityOf(pageHeading);
        return driver.findElement(pageHeading).getText();
    }


    public boolean isPayButtonEnabled(){
        boolean result;
        waitForVisibilityOf(payNowButton);
        result = driver.findElement(payNowButton).isEnabled();
        return result;
    }


    public String getPayButtonText(){

        waitForVisibilityOf(payNowButton);
        return driver.findElement(payNowButton).getText();
    }


    public String getAddonNameUnderPriceSummary() {
        waitForVisibilityOf(addonName);
        return driver.findElement(addonName).getText();
    }
}
