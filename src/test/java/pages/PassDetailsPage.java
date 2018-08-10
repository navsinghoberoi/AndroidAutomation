package pages;

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
    By noPassCTA = By.id("empty_feed_retry");
    By passPrice = By.id("cpt.price");
    By activeBenefits = By.id("acb.container");

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

    public boolean isNoPassCTADisplayed() {
        boolean result;
        if (checkIfElementPresent(noPassCTA, 5) == true) {
            System.out.println("User does not has pass");
            result = driver.findElement(noPassCTA).isEnabled();
        } else {
            result = false;
        }
        return result;
    }

    public boolean isDeletePassIconEnabled() {
        boolean result = false;
        if (checkIfElementPresent(deleteIcon, 5) == true) {
            System.out.println("Delete pass icon is enabled");
            result = driver.findElement(deleteIcon).isEnabled();
        } else {
            System.out.println("Delete pass icon is not enabled");
        }
        return result;
    }

    public boolean isDeletePassIconDisplayed() {
        boolean result = false;
        if (checkIfElementPresent(deleteIcon, 5) == true) {
            System.out.println("Delete pass icon is displayed");
            result = driver.findElement(deleteIcon).isDisplayed();
        } else {
            System.out.println("Delete pass icon is not displayed");
        }
        return result;
    }


    public void clickDeleteIcon() {
        waitForClickabilityOf(deleteIcon);
        driver.findElement(deleteIcon).click();
    }


    public int getDeletePassReasonsCount() {
        waitForClickabilityOf(selectDeleteReason);
        int size = driver.findElements(selectDeleteReason).size();

        for (int i = 0; i < size; i++) {

            String reason = driver.findElements(selectDeleteReason).get(i).getText();
            System.out.println("Reason for Discontinuing Pass = " + reason);
        }
        return size;
    }


    public void selectDeletePassReason(int reasonForPassDelete) {
        waitForClickabilityOf(selectDeleteReason);
        driver.findElements(selectDeleteReason).get(reasonForPassDelete).click();

    }

    public String getCancelSubscriptionPopupHeading() {
        waitForVisibilityOf(cancelPopupTitle);
        String titleCancelPopup = driver.findElement(cancelPopupTitle).getText();
        return titleCancelPopup;
    }


    public String getCancelSubscriptionPopupContent() {
        waitForVisibilityOf(cancelPopupText);
        String textCancelPopup = driver.findElement(cancelPopupText).getText();
        return textCancelPopup;
    }

    public void clickConfirmButtonOnCancelSubsPopup() {
        waitForVisibilityOf(cancelPopupConfirm);
        driver.findElement(cancelPopupConfirm).click();
    }


    public String getPassPrice(){
        waitForVisibilityOf(passPrice);
        return driver.findElement(passPrice).getText();
    }

    public boolean isActiveBenefitsDisplayed() {
        try {
            scrollToText("Active Benefits");
        } catch (Exception e) {
            System.out.println("Scroll is not done as the element is not visible");
            e.printStackTrace();
        }
        if (checkIfElementPresent(activeBenefits, 5) == true) {
            System.out.println("Active Benefits is displayed on pass details page");
            return true;
        } else {
            System.out.println("Active Benefits is not displayed on pass details page");
            return false;
        }
    }

}
