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
    By locate_pickup = By.xpath("//android.widget.TextView[@text='Locate pickup']");
    By locate_pickup_title_text = By.xpath("//android.widget.TextView[@text='View Pickup Stop']");
    By call_Customer_Care = By.xpath("//android.widget.TextView[@text='Call Customer Care']");
    By call_Customer_Care_Slide_Text = By.xpath("//android.widget.TextView[@text='Complete action using']");
    By menuUpIcon = By.id("pb.options_chevron");
    By toggleButton = By.id("itso.switch");
    By refreshIcon = By.id("pb_refresh_btn");
    By boardBookingID = By.xpath("//android.widget.TextView[@text='BOOKING ID']");
    By navigateButton = By.id("navigate_button");
    By toggleIcon = By.id("action_toggle");
    By helpText = By.xpath("//android.widget.TextView[@text='Help']");
    By faqLink = By.xpath("//android.widget.TextView[@text='FAQs']");
    By registrationNumber = By.id("hab.vehicle_text");
    By homecardTrackShuttl =By.id("hab.action_container");
    By currentLocation = By.id("bc_refocus_map_btn");
    By boardingSuccessfulPopupText = By.id("dsf.title");
    By sosButton = By.id("pb_sos_btn");
    By dropPointETA = By.id("pb.drop_time_info");
    By dropPointName = By.id("pb.drop_location");

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
    public void clickLocatePickup(){
        waitForClickabilityOf(locate_pickup);
        driver.findElement(locate_pickup).click();
    }
    public String locatePickupText(){
        waitForClickabilityOf(locate_pickup);
        String getLocatePickupText = driver.findElement(locate_pickup).getText();
        return getLocatePickupText;
    }
    public String locatePickupTitleText(){
        waitForClickabilityOf(locate_pickup_title_text);
        String getLocatePickupTitleText = driver.findElement(locate_pickup_title_text).getText();
        return getLocatePickupTitleText;
    }
    public void clickMapsToggleIcon(){
        waitForClickabilityOf(toggleButton);
        driver.findElement(toggleButton).click();
    }
    public void clickCallCustomerCare(){
        waitForClickabilityOf(call_Customer_Care);
        driver.findElement(call_Customer_Care).click();
    }
    public String getCallCustomerCareSlideText(){
        waitForClickabilityOf(call_Customer_Care_Slide_Text);
        String callCC = driver.findElement(call_Customer_Care_Slide_Text).getText();
        return callCC;
    }
    public void clickMenuUpIcon(){
        waitForClickabilityOf(menuUpIcon);
        driver.findElement(menuUpIcon).click();
    }
    public void clickShowTraffic(){
        waitForClickabilityOf(toggleButton);
        List<WebElement> showTrafficToggle = driver.findElements(toggleButton);
        showTrafficToggle.get(1).click();
    }
    public void getShowTrafficStatus(){
        waitForClickabilityOf(toggleButton);
        List<WebElement> show_Traffic_Toggle = driver.findElements(toggleButton);

        if(show_Traffic_Toggle.get(1).getText()=="ON"){
            System.out.println("Traffic Toggle Is Enabled");
        }
        else {
            show_Traffic_Toggle.get(1).click();
            System.out.println("Clicked on Traffic Toggle");
        }

    }
    public boolean trafficToggle(){
        waitForClickabilityOf(toggleButton);
        List<WebElement> shuttle_Arrival_Bubble = driver.findElements(toggleButton);
        return shuttle_Arrival_Bubble.get(1).isDisplayed();
    }
    public void clickShuttlArrivalToggle(){
        waitForClickabilityOf(toggleButton);
        List<WebElement> shuttle_Arrival_Bubble = driver.findElements(toggleButton);
        shuttle_Arrival_Bubble.get(0).click();
    }
    public void getShuttlArrivalToggle(){
        waitForClickabilityOf(toggleButton);
        List<WebElement> shuttleArrivalBubble = driver.findElements(toggleButton);
        System.out.println(shuttleArrivalBubble);

        if (shuttleArrivalBubble.get(0).getText()=="ON"){
            System.out.println("Toggle Is Enabled");
        }
        else{
            shuttleArrivalBubble.get(0).click();
            System.out.println("Clicked on Toggle");
        }
    }
    public boolean arrivalBubble(){
        waitForClickabilityOf(toggleButton);
        List<WebElement> shuttle_Arrival_Bubble = driver.findElements(toggleButton);
        return shuttle_Arrival_Bubble.get(0).isDisplayed();
    }
    public void clickRefreshIcon(){
        waitForClickabilityOf(refreshIcon);
        driver.findElement(refreshIcon).click();

    }
    public boolean refreshIcon(){
        waitForClickabilityOf(refreshIcon);
        return driver.findElement(refreshIcon).isDisplayed();
    }
    public void getPressToBoardButton(){
        waitForClickabilityOf(boardBookingID);
        driver.findElement(boardBookingID).getText();
    }
    public String getNavigateButton(){
        waitForVisibilityOf(navigateButton);
        String getNavigateButton = driver.findElement(navigateButton).getText();
        return getNavigateButton;
    }
    public void clickNavigateButton(){
        waitForClickabilityOf(navigateButton);
        driver.findElement(navigateButton).click();
    }
    public void clickToggleIcon(){
        waitForClickabilityOf(toggleIcon);
        driver.findElement(toggleIcon).click();
    }
    public String helpText(){
        waitForVisibilityOf(helpText);
        String getHelpText = driver.findElement(helpText).getText();
        return getHelpText;
    }
    public void clickHelpText(){
        waitForClickabilityOf(helpText);
        driver.findElement(helpText).click();
    }
    public String getFaqLink(){
        waitForVisibilityOf(faqLink);
        String faqLinkText = driver.findElement(faqLink).getText();
        return faqLinkText;
    }
    public String getRegistrationNumber() {
        String rNText = null;
        waitForVisibilityOf(registrationNumber);
        boolean registrationNumberText = driver.findElement(registrationNumber).isDisplayed();
        System.out.println("Registration Number visibility on homecard is = " + registrationNumberText);

        if (registrationNumberText) {
            waitForClickabilityOf(registrationNumber);
            rNText = driver.findElement(registrationNumber).getText();
            System.out.println(registrationNumber);
        } else {
            System.out.println("Registration Number is not displayed on the booking homecard");

        }
        return rNText;
    }
    public boolean isRegistrationNumberVisible() {
        boolean registrationNumberText;
        if (checkIfElementPresent(homecardTrackShuttl, 10) == true) {
            System.out.println("TRACK SHUTTL is appearing on active ride");
            registrationNumberText = driver.findElement(homecardTrackShuttl).isDisplayed();
        } else {
            System.out.println("TRACK SHUTTL is not appearing, so no active ride on homepage");
            registrationNumberText = false;
        }

        return registrationNumberText;
    }
    public void clickCurrentLocationButton(){
        waitForClickabilityOf(currentLocation);
        driver.findElement(currentLocation).click();
    }
    public boolean currentLocationButton(){
        waitForClickabilityOf(currentLocation);
        return driver.findElement(currentLocation).isDisplayed();
    }

    public String getBoardingSuccessfulPopupTitle() {
        waitForVisibilityOf(boardingSuccessfulPopupText);
        return driver.findElement(boardingSuccessfulPopupText).getText();
    }

    public boolean checkPressToBoardCTADisplayed() {
        if (checkIfElementPresent(pressToBoard, 5) == true) {
            System.out.println("PRESS TO BOARD button is displayed");
            return true;
        } else {
            System.out.println("PRESS TO BOARD button is not displayed");
            return false;
        }
    }

    public boolean isSOSbuttonDisplayed() {
        if (checkIfElementPresent(sosButton, 5) == true) {
            System.out.println("SOS button is displayed");
            return true;
        } else {
            System.out.println("SOS button is not displayed");
            return false;
        }
    }

    public boolean isSOSButtonClickable() {
        waitForVisibilityOf(sosButton);
        return driver.findElement(sosButton).isEnabled();
    }

    public String getDropStopReachTimeText() {
        waitForVisibilityOf(dropPointETA);
        String etaText = driver.findElement(dropPointETA).getText();
        System.out.println(etaText);
        return etaText;
    }

    public String getDropPointName() {
        waitForVisibilityOf(dropPointName);
        return driver.findElement(dropPointName).getText();
    }

}
