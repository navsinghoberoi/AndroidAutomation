package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PayPerRideCompletePaymentPage extends BasePage {

    By payPerRide = By.id("item_booking_option.title");
    By payNowButton = By.id("abp.make_payment");
    By shuttlCredit = By.id("ppr_wallet.radio_button");
    By finalRidePriceText = By.id("abp.final_price_text");
    By paymentPage = By.xpath("//android.widget.TextView[@text='Complete Payment']");
    By shuttlCreditTitle = By.id("ppr_wallet.icon");

    public PayPerRideCompletePaymentPage(WebDriver driver) {
        super(driver);
    }

    public boolean getPayPerRide() {
        try {
            boolean result = false;
            waitForClickabilityOf(payPerRide);
            List<WebElement> payPerRideOption = driver.findElements(payPerRide);
            int payPRSize = payPerRideOption.size();
            for (int i = 0; i < payPRSize; i++) {
                String pPR = payPerRideOption.get(i).getAttribute("text");
                System.out.println("Text Of payPer Ride" + pPR);
                if (pPR.equalsIgnoreCase("Pay Per Ride")) {
                    result = true;
                    break;
                }
            }
            return result;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean payNowButtonVisible() {

        boolean getPNButtonVisible = driver.findElement(payNowButton).isDisplayed();
        return getPNButtonVisible;
    }
    public boolean noPayNowButtonDisplayed() {
        boolean result;
        if (checkIfElementPresent(payNowButton, 10) == true) {
            System.out.println("Pass Button is Enabled");
            result = driver.findElement(payNowButton).isEnabled();
        } else {
            result = false;
        }
        return result;
    }
    public void clickPayNowButton(){
        waitForVisibilityOf(payNowButton);
        driver.findElement(payNowButton).click();
    }
    public String shuttlCredits(){
        waitForVisibilityOf(shuttlCreditTitle);
        List<WebElement> getShuttlCreditText = driver.findElements(shuttlCreditTitle);
        return getShuttlCreditText.get(0).getText();
    }
    public void clickShuttlCreditRButton(){
        waitForClickabilityOf(shuttlCredit);
        driver.findElement(shuttlCredit).click();

    }
    public String getFinalRidePrice(){
        waitForVisibilityOf(finalRidePriceText);
        String finalPrice = driver.findElement(finalRidePriceText).getText();
        return finalPrice;
    }
    public String paymentTitleText(){
        waitForVisibilityOf(paymentPage);
        String pprPaymentTitleText = driver.findElement(paymentPage).getText();
        return pprPaymentTitleText;
    }


}



