package pages.android;

import com.sun.xml.internal.rngom.parse.host.Base;
import common.android.Commons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import tests.android.Setup;

import java.net.MalformedURLException;
import java.util.List;

public class MyRidesPage extends BasePage {
    By myRidesDisplayText = By.xpath(("//android.widget.CheckedTextView[@text='My Rides']"));
    By myRidesTitleText = By.xpath("//android.widget.TextView[@index=1]");
    By currentRidesCheckText = By.id("mb_current_no_data");
    By CurrentActiveRideCheckScreen = By.xpath("//android.widget.TextView[@text='Today']");
    By currentRideBoardLocation = By.xpath("//android.widget.TextView[@index='CD Chowk ']");
    By historyRidesTab = By.xpath("//android.widget.TextView[@text='HISTORY']");
    By tripSelectionByDate = By.xpath("//android.widget.TextView[@index=1]");
    //By selectionOfTrip = By.id("mb_item_time");
    By ridesList = By.id("mb_past_list");
    By historyRideTitleText = By.xpath("//android.widget.TextView[@index=1]");
    By pickupPointText = By.xpath("//android.widget.TextView[@text='Dwarka Mor 1']");
    By dropPointText = By.xpath("//android.widget.TextView[@text='CD Chowk (Spaze IT park) ']");
    By pickupPointInMyRides = By.xpath("//android.widget.TextView[@text='Dwarka Mor 1']");
    By dropPointInMyRidesText = By.xpath("//android.widget.TextView[@text='CD Chowk (Spaze IT park) ']");
    By historyRideNowButton = By.xpath("//android.widget.TextView[@text='RIDE NOW']");
    By rideNowTitleText = By.xpath("//android.widget.TextView[@text='Select a Timeslot']");
    By needHelpWithThisRide = By.xpath("//android.widget.TextView[@text='NEED HELP WITH THIS RIDE?']");
    By needHelpTitleText = By.xpath("//android.widget.TextView[@index=1]");
    By lostAnItem = By.xpath("/android.widget.TextView[@text='I lost an item']");
    By descriptionTextField = By.xpath("//android.widget.EditText[@index=2]");
    By submitButton = By.xpath("//android.widget.Button[@text='SUBMIT']");
    By pickUpIssue = By.xpath("//android.widget.TextView[@text='I have an issue with my pickup']");
    By driverIssue = By.xpath("//android.widget.TextView[@text='I have an issue with my driver']");
    By otherIssue = By.xpath("//android.widget.TextView[@text='I have some other issue with my trip']");
    By backButton = By.xpath("//android.widget.ImageButton[@index=0]");


    private AndroidDriver androidDriver;
    public MyRidesPage(WebDriver driver) {
        super(driver);
        androidDriver = (AndroidDriver)driver;

            }

    public String getMyRidesDisplayText() {

        waitForVisibilityOf(myRidesDisplayText);
        String findMyRidesDisplayText = driver.findElement(myRidesDisplayText).getText();
        return findMyRidesDisplayText;
    }

    public void getMyRidesDisplayTextClick() {

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

    public void getHistoryRidesTabClick() {
        waitForClickabilityOf(historyRidesTab);
        driver.findElement(historyRidesTab).click();

    }
    public void ridesSelectionClick(){

        scrollDown();
        waitForVisibilityOf(ridesList);
        List<WebElement> RidesList = driver.findElements(ridesList);
        RidesList.get(4).click();
    }

    public String getHistoryRideSelectionText()throws Exception {

        waitForVisibilityOf(tripSelectionByDate);
        String getSelectionOfTrip = driver.findElement(tripSelectionByDate).getText();
        return getSelectionOfTrip;
        }

//    public void getHistoryRideSelectionClick() {
//        waitForClickabilityOf(selectionOfTrip);
//        driver.findElement(selectionOfTrip).click();
//    }

    public String getHistoryTitleText() {
        waitForVisibilityOf(historyRideTitleText);
        String findHistoryTitleText = driver.findElement(historyRideTitleText).getText();
        return findHistoryTitleText;
    }

    public void getRideNowButtonClick() {

        waitForClickabilityOf(historyRideNowButton);
        driver.findElement(historyRideNowButton).click();

    }

    public String getRideNowTitleText() {
        String getRideNowTitleText = driver.findElement(rideNowTitleText).getText();
        return getRideNowTitleText;
    }

    public void getPickupPointClick() {
        List<WebElement> findPickupPoint = driver.findElements(pickupPointText);
        findPickupPoint.get(5).click();

    }
    public String getPickupPointText() {
        String findPickupPoint = driver.findElement(pickupPointText).getText();
        return findPickupPoint;

    }

    public String getDropPointText() {
        String findDropPoint = driver.findElement(dropPointText).getText();
        return findDropPoint;
    }

    public String getPickupPointInMyRidesText() {
        String findPickupPointInMyRides = driver.findElement(pickupPointInMyRides).getText();
        return findPickupPointInMyRides;
    }

    public String getDropPointInMyRidesText() {
        String findDropPointInMyRides = driver.findElement(dropPointInMyRidesText).getText();
        return findDropPointInMyRides;
    }

    public void getNeedHelpWithThisRideButtonClick() {

        waitForVisibilityOf(needHelpWithThisRide);
        driver.findElement(needHelpWithThisRide).click();

    }
    public String getNeedHelpWithThisRideText(){
        waitForVisibilityOf(needHelpWithThisRide);
        String findNeedHelpWithText = driver.findElement(needHelpWithThisRide).getText();
        return findNeedHelpWithText;
    }

    public String getNeedHelpWithRideButtonText() {
        String findHelpIssue = driver.findElement(needHelpTitleText).getText();
        return findHelpIssue;
    }
    public String getNeedHelpTitleText(){
        waitForVisibilityOf(needHelpTitleText);
        String findHelpTitleText= driver.findElement(needHelpTitleText).getText();
        return findHelpTitleText;
    }
    public void getLostItemClick(){
        waitForClickabilityOf(lostAnItem);
        driver.findElement(lostAnItem).click();
    }
    public String getLostItemTitleText() {
        String findLostItemTitlleText = driver.findElement(lostAnItem).getText();
        return findLostItemTitlleText;
    }
    public void getDescriptionText(){
        waitForVisibilityOf(descriptionTextField);
        driver.findElement(descriptionTextField).sendKeys("This Is Test Description");
    }
    public void SubmitButtonClick(){
        waitForVisibilityOf(submitButton);
        driver.findElement(submitButton).click();
    }
    public void getPickUpItemClick(){
        waitForClickabilityOf(pickUpIssue);
        driver.findElement(pickUpIssue).click();
    }
    public String getPickUpIssueText(){
        String findPickupIssue = driver.findElement(pickUpIssue).getText();
        return findPickupIssue;
    }
    public void getIssueWithDriverClick(){
        waitForVisibilityOf(driverIssue);
        driver.findElement(driverIssue).click();
    }
    public String getIssueWithDriver(){
        String findDriverIssue = driver.findElement(driverIssue).getText();
        return findDriverIssue;
    }
    public void getOtherIssueClick(){
        waitForVisibilityOf(otherIssue);
        driver.findElement(otherIssue).click();
    }
    public String getOtherIssue(){
        String findTripIssue = driver.findElement(otherIssue).getText();
        return findTripIssue;
    }

    public void clickBackButton() {

        waitForClickabilityOf(backButton);
        driver.findElement(backButton).click();

    }


}
