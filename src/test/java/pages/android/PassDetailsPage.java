package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PassDetailsPage extends BasePage {

    By rideRemaining = By.id("value");   // this variable is used for rides and validity data
    By renewPassButton = By.id("pd.renew_layout");
    By renewPassSubtext = By.id("pd.renew_details");
    By deleteIcon = By.id("action_unsubscribe");
    By deleteTitle = By.id("cancel.title");
    By selectDeleteReason = By.id("reason_text"); //index
    By cancelPopupTitle = By.id("alertTitle");
    By cancelPopupText = By.id("message");
    By cancelPopupDismiss = By.id("button2");
    By cancelPopupConfirm = By.id("button1");

    public PassDetailsPage(WebDriver driver) {
        super(driver);
    }


    public String getRidesRemaining(int index) {
        waitForClickabilityOf(rideRemaining);
        String text = driver.findElements(rideRemaining).get(index).getText();
        return text;
    }

    public String getpassValidity(int index) {
        waitForClickabilityOf(rideRemaining);
        String text = driver.findElements(rideRemaining).get(index).getText();
        return text;
    }


    public void clickRenewPassButton() {
        waitForClickabilityOf(renewPassButton);
        driver.findElement(renewPassButton).click();

    }

    public String geRenewPassSubtext() {
        waitForClickabilityOf(renewPassSubtext);
        String text = driver.findElement(renewPassSubtext).getText();
        return text;
    }


    public void deletePass(int reasonForPassDelete) {
        waitForClickabilityOf(deleteIcon);
        driver.findElement(deleteIcon).click();
        waitForVisibilityOf(deleteTitle);
        String title = driver.findElement(deleteTitle).getText();
        System.out.println("Text of the popup displayed on click of delete icon = " + title);
        waitForClickabilityOf(selectDeleteReason);
        driver.findElements(selectDeleteReason).get(reasonForPassDelete).click();
        waitForVisibilityOf(cancelPopupTitle);
        String titleCancelPopup = driver.findElement(cancelPopupTitle).getText();
        System.out.println("Title of the popup displayed after selecting delete reason = " + titleCancelPopup);
        waitForVisibilityOf(cancelPopupText);
        String textCancelPopup = driver.findElement(cancelPopupText).getText();
        System.out.println("Text of the popup displayed after selecting delete reason = " + textCancelPopup);
        waitForVisibilityOf(cancelPopupConfirm);
        driver.findElement(cancelPopupConfirm).click();
    }


    public void cancelPopupDismiss() {
        waitForVisibilityOf(cancelPopupDismiss);
        driver.findElement(cancelPopupDismiss).click();
    }


    public void getRidesValidityData(int ridesIndex, int validityIndex) {
        getRidesRemaining(ridesIndex);
        getpassValidity(validityIndex);
    }


}
