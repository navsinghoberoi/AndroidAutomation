package pages;

import com.sun.xml.internal.rngom.parse.host.Base;
import common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import tests.Setup;

import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyRidesPage extends BasePage {
    By myRidesDisplayText = By.xpath(("//android.widget.CheckedTextView[@text='My Rides']"));
    By myRidesTitleText = By.xpath("//android.widget.TextView[@index=1]");
    By currentRidesCheckText = By.id("mb_current_no_data");
    By CurrentActiveRideCheckScreen = By.xpath("//android.widget.TextView[@text='Today']");
    By currentRideBoardLocation = By.xpath("//android.widget.TextView[@index='CD Chowk ']");
    By historyRidesTab = By.xpath("//android.widget.TextView[@text='HISTORY']");
    By tripSelectionByDate = By.xpath("//android.widget.TextView[@index=1]");
    By selectionOfTripDate = By.id("list_item_title");
    By selectionOfTripTime = By.id("mb_item_time");
    By ridesList = By.id("mb_item_parent");
    By historyRideTitleText = By.xpath("//android.widget.TextView[@index=1]");
    By pickupPointText = By.id("pdwl.pick_up_name");
    // By dropPointText = By.id("pdwl.drop_name");
    By pickupPointInMyRides = By.id("pdwl.pick_up_name");
    // By dropPointInMyRidesText = By.xpath("//android.widget.TextView[@text='CD Chowk (Spaze IT park) ']");
    By historyRideNowButton = By.xpath("//android.widget.TextView[@text='RIDE NOW']");
    By rideNowTitleText = By.xpath("//android.widget.TextView[@text='Select a Timeslot']");
    By needHelpWithThisRide = By.xpath("//android.widget.TextView[@text='NEED HELP WITH THIS RIDE?']");
    By needHelpTitleText = By.xpath("//android.widget.TextView[@index=1]");
    //By lostAnItem = By.id("th_item_name");
    By lostAnItem = By.xpath("//*[@text='I lost an item']");
    // By lostAnItem = By.xpath("//android.widget.TextView[@text='I lost an item']");
    By descriptionTextField = By.xpath("//android.widget.EditText[@index=2]");
    By submitButton = By.xpath("//android.widget.Button[@text='SUBMIT']");
    By pickUpIssue = By.id("th_item_name");
    By driverIssue = By.id("th_item_name");
    By otherIssue = By.id("th_item_name");
    By backButton = By.xpath("//android.widget.ImageButton[@index=0]");


    private AndroidDriver androidDriver;

    public MyRidesPage(WebDriver driver) {
        super(driver);
        androidDriver = (AndroidDriver) driver;

    }

    public String getMyRidesDisplayText() {

        waitForVisibilityOf(myRidesDisplayText);
        String findMyRidesDisplayText = driver.findElement(myRidesDisplayText).getText();
        return findMyRidesDisplayText;
    }

    public void clickMyRidesDisplayText() {

        waitForClickabilityOf(myRidesDisplayText);
        driver.findElement(myRidesDisplayText).click();
    }

    public String getMyRidesTitleText() {
        waitForVisibilityOf(myRidesTitleText);
        String getMyRidesTitleText = driver.findElement(myRidesTitleText).getText();
        return getMyRidesTitleText;
    }

    public String getActiveRidesWindows() {

        waitForVisibilityOf(currentRidesCheckText);
        String findMyActiveRidesWindows = driver.findElement(currentRidesCheckText).getText();
        return findMyActiveRidesWindows;
    }

    public String getCurrentRideHomePageText() {

        waitForVisibilityOf(currentRideBoardLocation);
        String findMycurrentRideHomePageText = driver.findElement(currentRideBoardLocation).getText();
        return findMycurrentRideHomePageText;

    }

    public String getHistoryRidesTab() {
        waitForVisibilityOf(historyRidesTab);
        String getHistoryRideTabText = driver.findElement(historyRidesTab).getText();
        return getHistoryRideTabText;

    }

    public void clickHistoryRidesTab() {
        waitForClickabilityOf(historyRidesTab);
        driver.findElement(historyRidesTab).click();

    }

    public String getRideSelectionDate() {

        waitForVisibilityOf(tripSelectionByDate);
        String dateText = driver.findElement(tripSelectionByDate).getText();

        if (dateText.equalsIgnoreCase("Today")) {
            String dateFormat = new SimpleDateFormat("MMMM dd, yyyy").format(new Date());
            return dateFormat + "RideTime";

        } else {

            return dateText;
        }
    }

    public void ignoreTitleTexr() {

        waitForVisibilityOf(selectionOfTripTime);
        List<WebElement> RideTime = driver.findElement(selectionOfTripTime);
        RideTime.get(0).getText();

    }

    public void clickRidesSelection() {

//      scrollDown();
        waitForVisibilityOf(ridesList);
        List<WebElement> RidesList = driver.findElements(ridesList);
        RidesList.get(0).click();
    }

    public String getHistoryRideSelectionText() throws Exception {

        waitForVisibilityOf(tripSelectionByDate);
        String getSelectionOfTrip = driver.findElement(tripSelectionByDate).getText();
        return getSelectionOfTrip;
    }

//    public void clickHistoryRideSelection() {
//        waitForClickabilityOf(selectionOfTrip);
//        driver.findElement(selectionOfTrip).click();
//    }

    public String getHistoryTitleText() {
        waitForVisibilityOf(historyRideTitleText);
        String findHistoryTitleText = driver.findElement(historyRideTitleText).getText();
        return findHistoryTitleText;
    }

    public void clickRideNowButton() {

        waitForClickabilityOf(historyRideNowButton);
        driver.findElement(historyRideNowButton).click();

    }

    public String getRideNowButtonText() {
        waitForClickabilityOf(historyRideNowButton);
        String findRideNowButtonText = driver.findElement(historyRideNowButton).getText();
        return findRideNowButtonText;

    }


    public String getRideNowTitleText() {
        String getRideNowTitleText = driver.findElement(rideNowTitleText).getText();
        return getRideNowTitleText;
    }

    public void clickGetPickupPoint() {
        List<WebElement> findPickupPoint = driver.findElements(pickupPointText);
        findPickupPoint.get(5).click();

    }

    public String getPickupPointText() {

        List<WebElement> findPickupPointText = driver.findElements(pickupPointText);
        return findPickupPointText.get(0).getText();

    }

    public void getDropPointText() {

        List<WebElement> findDropPointText = driver.findElements(pickupPointText);
        findDropPointText.get(0).getText();
//        String findDropPointText = driver.findElement(dropPointText).getText();
//        return findDropPointText;
    }

    public String getPickupPointInMyRidesText() {
        String findPickupPointInMyRides = driver.findElement(pickupPointInMyRides).getText();
        return findPickupPointInMyRides;
    }

    public String getDropPointInMyRidesText() {
        String findDropPointInMyRides = driver.findElement(pickupPointText).getText();
        return findDropPointInMyRides;
    }

    public void clickGetNeedHelpWithThisRideButton() {

        waitForVisibilityOf(needHelpWithThisRide);
        driver.findElement(needHelpWithThisRide).click();

    }

    public String getNeedHelpWithThisRideText() {
        waitForVisibilityOf(needHelpWithThisRide);
        String findNeedHelpWithText = driver.findElement(needHelpWithThisRide).getText();
        return findNeedHelpWithText;
    }

    public String getNeedHelpWithRideButtonText() {
        String findHelpIssue = driver.findElement(needHelpTitleText).getText();
        return findHelpIssue;
    }

    public String getNeedHelpTitleText() {
        waitForVisibilityOf(needHelpTitleText);
        String findHelpTitleText = driver.findElement(needHelpTitleText).getText();
        return findHelpTitleText;
    }

    public void clickGetLostItem() {

//      waitForVisibilityOf(lostAnItem);
//      driver.findElement(lostAnItem).click();
        waitForClickabilityOf(lostAnItem);
        List<WebElement> helpList = driver.findElements(lostAnItem);
        helpList.get(0).click();
        driver.findElement(lostAnItem).click();

//        List<WebElement> list  = driver.findElement(lostAnItem);
//        for (int i=0;i<list.size();i++){
//        System.out.println("clicked on "+list.get(i).getAttribute("xpath"));
    }

    public String getLostItemTitleText() {
        String findLostItemTitlleText = driver.findElement(lostAnItem).getText();
        return findLostItemTitlleText;
    }

    public void getDescriptionText() {
        waitForVisibilityOf(descriptionTextField);
        driver.findElement(descriptionTextField).sendKeys("This Is Test Description");
    }

    public void clickSubmitButton() {
        waitForVisibilityOf(submitButton);
        driver.findElement(submitButton).click();
    }

    public void clickGetPickUpItem() {
        waitForClickabilityOf(pickUpIssue);
        List<WebElement> helpList = driver.findElement(pickUpIssue);
        helpList.get(1).click();
        //driver.findElement(pickUpIssue).click();
    }

    public String getPickUpIssueText() {
        String findPickupIssue = driver.findElement(pickUpIssue).getText();
        return findPickupIssue;
    }

    public void clickGetIssueWithDriver() {
        waitForVisibilityOf(driverIssue);
        driver.findElement(driverIssue).click();
    }

    public String getIssueWithDriver() {
        String findDriverIssue = driver.findElement(driverIssue).getText();
        return findDriverIssue;
    }

    public void clickGetOtherIssue() {
        waitForVisibilityOf(otherIssue);
        driver.findElement(otherIssue).click();
    }

    public String getOtherIssue() {
        String findTripIssue = driver.findElement(otherIssue).getText();
        return findTripIssue;
    }

    public void clickBackButton() {

        waitForClickabilityOf(backButton);
        driver.findElement(backButton).click();

    }

}