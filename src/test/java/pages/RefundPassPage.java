package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RefundPassPage extends BasePage {

    By refundPassValue = By.id("rms.value");      // index for this and Amount refund to credits
    By totalRefundPassValue = By.id("sd.refund_amount");
    By discontinuePassButton = By.id("sd.discontinue");
    By refundSuccessfulTitle = By.id("dsf.title");
    By refundSuccessfulMessage = By.id("dsf.message");
    By refundSuccessfulCTA = By.id("dsf.button");

    public RefundPassPage(WebDriver driver) {
        super(driver);
    }

    public String refundPassValue(int index) {
        waitForClickabilityOf(refundPassValue);
        String text = driver.findElements(refundPassValue).get(index).getText();
        return text;
    }

    public String totalRefundPassValue() {
        waitForClickabilityOf(totalRefundPassValue);
        String text = driver.findElement(totalRefundPassValue).getText();
        return text;
    }

    public String clickPassRefundSuccessfulCTA() {
        waitForVisibilityOf(refundSuccessfulTitle);
        String text1 = driver.findElement(refundSuccessfulTitle).getText();
        waitForVisibilityOf(refundSuccessfulMessage);
        String text2 = driver.findElement(refundSuccessfulMessage).getText();
        waitForVisibilityOf(refundSuccessfulCTA);
        String text3 = driver.findElement(refundSuccessfulCTA).getText();
        System.out.println("Pass refunded text = " + text1 + " ; " + text2 + " ; " + text3);
        return text1;

    }

    public void clickDiscontinuePassButton(int refundPassValueIndex) {
        refundPassValue(refundPassValueIndex);
        totalRefundPassValue();
        waitForClickabilityOf(discontinuePassButton);
        driver.findElement(discontinuePassButton).click();
    }


}
