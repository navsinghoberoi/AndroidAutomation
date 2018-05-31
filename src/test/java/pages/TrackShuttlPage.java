package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TrackShuttlPage extends BasePage {

    By locationPermissionPopup = By.id("permission_message");
    By locationPermissionAllowButton = By.id("permission_allow_button");
    By locationPermissionDenyButton = By.id("permission_deny_button");
    By ppNameOnMap = By.id("mtspd.location_name");        // Click this to remove blue bubble from trackShuttl screen
    By pressToBoard = By.id("pb.chirp_container");
    By optionsIcon = By.id("pb.options_chevron");
    By optionsName = By.id("itso.text");     // Options include cancel/reschedule trip , locate pickup etc
    By backIcon = By.id("pb.custom_back");
    By cancelProTip = By.id("pb_cancel_pro_tip");
    By protipText = By.id("pb_pro_tip");

    public TrackShuttlPage(WebDriver driver) {
        super(driver);
    }


    public void checkLocationPermissionPopup() {

        boolean isLocationPopupVisible = driver.findElement(locationPermissionPopup).isDisplayed();
        System.out.println("Visibility of location popup = " + isLocationPopupVisible);
        if (isLocationPopupVisible) {
            String message = driver.findElement(locationPermissionPopup).getText();
            System.out.println("Message content of location permission popup = " + message);

        }
    }

    public void acceptLocationPermission() {
        boolean isLocationPopupVisible = driver.findElement(locationPermissionPopup).isDisplayed();
        System.out.println("Visibility of location popup = " + isLocationPopupVisible);
        if (isLocationPopupVisible) {
            driver.findElement(locationPermissionAllowButton).click();
        }

    }


    public void denyLocationPermission() {
        boolean isLocationPopupVisible = driver.findElement(locationPermissionPopup).isDisplayed();
        System.out.println("Visibility of location popup = " + isLocationPopupVisible);
        if (isLocationPopupVisible) {
            driver.findElement(locationPermissionDenyButton).click();
        }

    }


    public void clickPPPointOnTrackShuttl() {
        waitForClickabilityOf(ppNameOnMap);
        driver.findElement(ppNameOnMap).click();
    }

    public void clickBoardButton() {
        waitForClickabilityOf(pressToBoard);
        driver.findElement(pressToBoard).click();
    }


    public int printOptionValues() {
        clickOptionsIcon();
        waitForClickabilityOf(optionsName);
        List<WebElement> options = driver.findElements(optionsName);
        int size = driver.findElements(optionsName).size();
        for (WebElement i : options) {
            System.out.println("Name of the option = " + i.getText());
        }
        return size;
    }


    public void clickOptionsIcon() {
        waitForClickabilityOf(optionsIcon);
        driver.findElement(optionsIcon).click();
    }

    public boolean isTrackShuttlPageOpened() {
        boolean result = false;
        if (checkIfElementPresent(optionsIcon, 10) == true) {
            System.out.println("User is on track shuttl page");
            result = driver.findElement(optionsIcon).isEnabled();
        } else {
            System.out.println("User is not on track shuttl page");
        }
        return result;
    }


    public void selectRideOption(int index) {
        waitForVisibilityOf(optionsName);
        driver.findElements(optionsName).get(index).click();
    }


    public void clickBackIcon() {
        waitForClickabilityOf(backIcon);
        driver.findElement(backIcon).click();
    }


    public void dismissProtip() {
        waitForClickabilityOf(cancelProTip);
        driver.findElement(cancelProTip).click();
    }

    public String getProtipText() {

        waitForVisibilityOf(protipText);
        return driver.findElement(protipText).getText();
    }


 public By getOptionsNameLocator(){

        return optionsName;
 }

}
