package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import sun.font.TrueTypeFont;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By searchBar = By.id("booking.search_bar");
    By buddyButton = By.className("android.widget.ImageView");
    By buddyButtonClickable = By.id("buddy");
    By buddyOptions = By.className("android.widget.TextView");
    By findRoutebutton = By.id("cfts.button");
    By fromLocationButton = By.id("cfts.from");
    By toLocationButton = By.id("cfts.to");
    By locationSwapButton = By.id("cfts.swap");
    By menuButton = By.xpath("//android.widget.ImageButton[@content-desc='open']");
    By wallet_button = By.id(app_package_name + "design_menu_item_text");
    By clickGetFreeRide = By.xpath("//android.widget.CheckedTextView[@text='Get Free Rides']");
    By closeSearchPopup = By.id("hso.close_icon");
    By myPass = By.id("design_menu_item_text");
    By cachedLocation = By.id("sr_li_name");
    By reportIssueOption = By.xpath("//android.widget.TextView[@text='Report An Issue']");
    By reportIssueSubmitButton = By.xpath("//android.widget.Button[@text='Submit']");
    By reserveSeat = By.id("hr.action_button");
 //   By rebookCardTitle = By.id("hr.ride_session");
    By rebookCardTitleMorning = By.xpath("//android.widget.TextView[@text='Morning Ride']");
    By rebookCardTitleEvening = By.xpath("//android.widget.TextView[@text='Evening Ride']");
    By rebookCardPickupPoint = By.id("hr.pick_up_location");
    By rebookCardDropPoint = By.id("hr.drop_location");
    By homecardTrackShuttl = By.id("hab.action_container");
    By homecardPickupPoint = By.id("hab.pick_up_location");
    By subscriptionPasses = By.id("cpt.rides");
    By rideStatus = By.id("hab.ride_day");
    By currentRideStatus = By.id("list_item_title");
    By rideInfo = By.id("hab.vehicle_text");
    By currentLocationButton = By.id("pb_refocus_map_btn");
    By ongoingHomecard = By.id("hbpb.ride_day");
    By userProfileName = By.id("drawer.user_name");
    By backButton = By.className("android.widget.ImageButton");


    public String getHeaderText() {
        waitForVisibilityOf(searchBar);
        String HeaderText = driver.findElement(searchBar).getText();
        return HeaderText;
    }

    public void clickFromLocation() {
        waitForClickabilityOf(fromLocationButton);
        driver.findElement(fromLocationButton).click();
    }

    public String getFromLocationText() {
        waitForClickabilityOf(fromLocationButton);
        return driver.findElement(fromLocationButton).getText();
    }

    public String getToLocationText() {
        waitForClickabilityOf(toLocationButton);
        return driver.findElement(toLocationButton).getText();
    }

    public void clickToLocation() {
        waitForClickabilityOf(toLocationButton);
        driver.findElement(toLocationButton).click();
    }

    public void clickFindMyShuttl() {
        waitForClickabilityOf(findRoutebutton);
        driver.findElement(findRoutebutton).click();
    }

    public void clickMenu() {
        if (checkIfElementClickable(menuButton, 15) == true) {
            System.out.println("Menu button is displayed, need to open menu");
            driver.findElement(menuButton).click();
            System.out.println("Menu button has been clicked");
            if (checkUserProfileName() == true){
                System.out.println("User profile name is displayed i.e Menu is opened");
            } else {
                System.out.println("In retry method of clicking menu");
                driver.findElement(menuButton).click();
                if (checkUserProfileName() == true) {
                    System.out.println("User profile name is displayed via Retry, i.e Menu is opened");
                }
            }
        } else {
            System.out.println("Menu button is not displayed");
        }
    }


    public void clickWallet() {
        waitForClickabilityOf(wallet_button);
        driver.findElements(wallet_button).get(4).click();
    }

    public void clickLocationSwap() {
        waitForClickabilityOf(locationSwapButton);
        driver.findElement(locationSwapButton).click();
    }

    public void clickGetFreeRide() {
        waitForClickabilityOf(clickGetFreeRide);
        driver.findElement(clickGetFreeRide).click();

    }

    public void clickCoupon() {
        waitForClickabilityOf(wallet_button);
        driver.findElements(wallet_button).get(3).click();
    }


    public boolean checkBuddyButton() {
        if (checkIfElementPresent(buddyButton))
            return true;
        else
            return false;

    }


    public boolean isBuddyButtonEnabled() {
        waitForVisibilityOf(buddyButtonClickable);
        boolean result = driver.findElement(buddyButtonClickable).isEnabled();
        return result;
    }

    public void clickBuddy() {
        waitForVisibilityOf(buddyButtonClickable);
        driver.findElement(buddyButtonClickable).click();
    }


    public boolean checkSearchBar() {
        if (checkIfElementPresent(searchBar, 10) == true) {
            System.out.println("Search bar is displayed");
            return true;
        } else {
            System.out.println("Search bar is not displayed");
            return false;
        }
    }

    public void clickSearchBar() {
        if (checkIfElementClickable(searchBar, 15) == true) {
            System.out.println("Search bar is displayed, need to open search bar");
            driver.findElement(searchBar).click();
            if (isFindRouteButtonDisplayed() == true){
                System.out.println("FIND A ROUTE button is displayed i.e Search bar is opened");
            } else {
                System.out.println("In retry method of clicking search");
                driver.findElement(searchBar).click();
                if (isFindRouteButtonDisplayed() == true) {
                    System.out.println("FIND A ROUTE button is displayed via Retry i.e Search bar is opened");
                }
            }

        } else {
            System.out.println("Search bar is not displayed");
        }
    }

    public void closeSearchPopup() {
        waitForClickabilityOf(closeSearchPopup);
        driver.findElement(closeSearchPopup).click();
    }

    public void openMyPass(int index)     // index will be the menuitem number to be opened
    {
        waitForClickabilityOf(myPass);
        driver.findElements(myPass).get(index).click();
        openSubscriptionPass();
    }

    public boolean isFindRouteButtonDisplayed() {
        boolean result;
        if(checkIfElementPresent(findRoutebutton,10)){
        result = driver.findElement(findRoutebutton).isDisplayed();
        }else {
        result = false;
        }
        return result;
    }


    public boolean isFindRouteButtonEnabled() {
        waitForVisibilityOf(findRoutebutton);
        boolean displayed = driver.findElement(findRoutebutton).isEnabled();
        return displayed;
    }


    public boolean checkCachedLocations(String location) {
        boolean result = false;
        waitForClickabilityOf(cachedLocation);
        int size = driver.findElements(cachedLocation).size();

        for (int i = 0; i < size; i++) {

            String text = driver.findElements(cachedLocation).get(i).getText();
            if (text.equalsIgnoreCase(location)) {
                System.out.println("Match has been found");
                result = true;
                break;
            } else {
                result = false;
            }

        }

        return result;
    }


    public int getBuddyOptionsSize() {

        waitForClickabilityOf(buddyOptions);
        int size = driver.findElements(buddyOptions).size();
        return size;
    }

    public boolean reportIssueOptionClick() {

        if (checkIfElementPresent(reportIssueOption, 5) == true) {
            System.out.println("Report issue option is displayed");
            driver.findElement(reportIssueOption).click();
            System.out.println("Report issue page is opened");
            return true;
        } else {
            System.out.println("Report issue option is not displayed");
            return false;
        }

    }

    public boolean checkReportIssuePage() {
        if (checkIfElementPresent(reportIssueSubmitButton, 5) == true) {
            System.out.println("User is on report issue page , SUBMIT button is displayed");
            return true;
        } else {
            System.out.println("User is NOT on report issue page");
            return false;
        }
    }


    public void clickBackButton() {
        waitForVisibilityOf(backButton);
        driver.findElement(backButton).click();
    }

    public boolean isReserveSeatButtonDisplayed() {
        if (checkIfElementPresent(reserveSeat, 5) == true) {
            System.out.println("RESERVE A SEAT button is displayed");
            return true;
        } else {
            System.out.println("RESERVE A SEAT button is not displayed");
            return false;
        }
    }


    public boolean isReserveSeatEnabled() {
        boolean result = false;
        if (checkIfElementPresent(reserveSeat, 5) == true) {
            System.out.println("RESERVE A SEAT button is displayed");
            result = driver.findElement(reserveSeat).isEnabled();
            System.out.println("RESERVE A SEAT button is enabled");
        } else {
            System.out.println("RESERVE A SEAT button is not enabled");
        }
        return result;
    }


    public String getMorningRebookCardTitle() {
            String text = "";
        if (checkIfElementPresent(rebookCardTitleMorning, 10) == true) {
            System.out.println("Morning Ride Rebook Card is displayed");
            text = driver.findElement(rebookCardTitleMorning).getText();
            } else {
            System.out.println("Morning Ride Rebook Card is not displayed");
            text = "no morning ride rebook card available";
        }
        return text;
    }

    public String getEveningRebookCardTitle() {
        String text = "";
        if (checkIfElementPresent(rebookCardTitleEvening, 10) == true) {
            System.out.println("Evening Ride Rebook Card is displayed");
            text = driver.findElement(rebookCardTitleEvening).getText();
        } else {
            System.out.println("Evening Ride Rebook Card is not displayed");
            text = "no evening ride rebook card available";
        }
        return text;
    }


    public void getRebookCardContents() {
        waitForVisibilityOf(rebookCardPickupPoint);
        String morningPP = driver.findElements(rebookCardPickupPoint).get(0).getText();
        String eveningPP = driver.findElements(rebookCardPickupPoint).get(1).getText();
        String morningDP = driver.findElements(rebookCardDropPoint).get(0).getText();
        String eveningDP = driver.findElements(rebookCardDropPoint).get(1).getText();

        System.out.println("Data mentioned over the rebook cards = " + morningPP + " ; " + eveningPP + " ; " + morningDP + " ; " + eveningDP);
    }


    public boolean reserveSeatClick() {
        boolean result;
        waitForVisibilityOf(reserveSeat);
        driver.findElement(reserveSeat).click();
        result = true;
        System.out.println("User has clicked on reserve a seat button");
        return result;
    }


    public String getBookingHomecardData() {
        String pickupPointName = null;
        waitForClickabilityOf(homecardTrackShuttl);
        boolean isTrackShuttlVisible = driver.findElement(homecardTrackShuttl).isDisplayed();
        System.out.println("Track shuttl visibility on homecard is = " + isTrackShuttlVisible);

        if (isTrackShuttlVisible) {
            waitForClickabilityOf(homecardPickupPoint);
            pickupPointName = driver.findElement(homecardPickupPoint).getText();
            System.out.println(pickupPointName);

        } else {
            System.out.println("Track Shuttl is not displayed on the booking homecard");
        }
        System.out.println("Value of pickupoint name = " + pickupPointName);
        return pickupPointName;
    }


    public void clickBookingHomeCard() {
        waitForClickabilityOf(homecardTrackShuttl);
        driver.findElement(homecardTrackShuttl).click();
    }

    public boolean isTrackShuttlDisplayed() {
            boolean isTrackShuttlVisible;
        if (checkIfElementPresent(homecardTrackShuttl, 10) == true) {
            System.out.println("TRACK SHUTTL is appearing on active ride");
            isTrackShuttlVisible = driver.findElement(homecardTrackShuttl).isDisplayed();
        } else {
            System.out.println("TRACK SHUTTL is not appearing, so no active ride on homepage");
            isTrackShuttlVisible = false;
        }

        return isTrackShuttlVisible;
    }

    public void openSubscriptionPass() {
        if (checkIfElementPresent(subscriptionPasses, 10) == true) {
            int size = driver.findElements(subscriptionPasses).size();
            if (size > 1) {
                System.out.println("Multiple passes are available on My Pass page, opening first pass");
                driver.findElements(subscriptionPasses).get(0).click();
            } else if(size == 1){
                System.out.println("Only one pass is available, pass details page are opened automatically");
            }
        } else {
            System.out.println("No passes available on My Pass page");
        }

    }

    public String getRideStatus(){
        waitForVisibilityOf(rideStatus);
        String RideST = driver.findElement(rideStatus).getText();
        return RideST;
    }
    public String getCurrentRideTitle() {
        waitForVisibilityOf(currentRideStatus);
        String currentRideTitleSt = driver.findElement(currentRideStatus).getText();
        return currentRideTitleSt;
    }
    public boolean getCurrentLocationIcon(){
        waitForVisibilityOf(currentLocationButton);
        return driver.findElement(currentLocationButton).isDisplayed();
    }

    public void clickCurrentLocationButton(){
        waitForVisibilityOf(currentLocationButton);
        driver.findElement(currentLocationButton).click();
    }

    public void shuttlVehicleDetail(){
        waitForVisibilityOf(rideInfo);
        driver.findElement(rideInfo).getText();
    }

    public String getOngoingBookingHomecardText() {
        waitForVisibilityOf(ongoingHomecard);
        return driver.findElement(ongoingHomecard).getText();
    }

    public void openBoardedRideHomecard() {
        if (checkIfElementPresent(ongoingHomecard, 10) == true) {
            System.out.println("Ongoing Ride Homecard is displayed");
            driver.findElement(ongoingHomecard).click();
        } else {
            System.out.println("Ongoing Ride Homecard is not displayed");
        }
    }


    public boolean checkUserProfileName() {
        if (checkIfElementPresent(userProfileName, 10) == true) {
            System.out.println("Menu page is opened");
            return true;
        } else {
            System.out.println("Menu page is not opened");
            return false;
        }
    }

}
