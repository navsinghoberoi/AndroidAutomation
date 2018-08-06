package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CancelOrRescheduleRidePage extends BasePage {


    By cancelReschedulePageTitle = By.id("title");
    By cancelRescheduleCategory = By.id("reason_text");
    By cancelButton = By.xpath("//android.widget.TextView[@text='Cancel Ride']");
    By rescheduleButton = By.xpath("//android.widget.TextView[@text='Reschedule Ride']");
    By rideCancelledPopup = By.id("popup_notify_wa.title");
    By crossIcon = By.id("close_button");
    By cancelRescheduleSelectedCategory = By.id("action_reason_text");
    By backIcon = By.id("action_left");
    By rescheduleSlotsPageSubtext = By.id("reschedule.sub_title");
    By rescheduleSlotsPageReserveSeatSubtext = By.id("book_sub_cta");
    By selectRescheduleSlot = By.id("parent_view");
    By reserveSeat = By.id("reschedule_active_container");


    public CancelOrRescheduleRidePage(WebDriver driver) {
        super(driver);
    }


    public String getCancelReschedulePageTitle() {
        waitForVisibilityOf(cancelReschedulePageTitle);
        String title = driver.findElement(cancelReschedulePageTitle).getText();
        System.out.println("Title of the page = " + title);
        return title;
    }

    public String selectCancelRescheduleCategory(int index) {
        waitForVisibilityOf(cancelRescheduleCategory);
        String categoryName = driver.findElements(cancelRescheduleCategory).get(index).getText();
        System.out.println("Name of category selected for cancelling/rescheduling ride = " + categoryName);
        driver.findElements(cancelRescheduleCategory).get(index).click();
        return categoryName;
    }


    public int getCancelRescheduleCategories() {
        waitForVisibilityOf(cancelRescheduleCategory);
        int size = driver.findElements(cancelRescheduleCategory).size();

        for (int i = 0; i < size; i++) {
            String text = driver.findElements(cancelRescheduleCategory).get(i).getText();
        }
        return size;
    }


    public boolean isCancelRideButtonDisplayed() {
        if (checkIfElementPresent(cancelButton, 5) == true) {
            System.out.println("Cancel Ride button is displayed");
            return true;
        } else {
            System.out.println("Cancel Ride button is not displayed");
            return false;
        }
    }


    public boolean isRescheduleRideButtonDisplayed() {
        if (checkIfElementPresent(rescheduleButton, 5) == true) {
            System.out.println("Reschedule Ride button is displayed");
            return true;
        } else {
            System.out.println("Reschedule Ride button is not displayed");
            return false;
        }
    }


    public void clickCancelRide() {

        waitForClickabilityOf(cancelButton);
        driver.findElement(cancelButton).click();
    }

    public void clickResheduleRide() {

        waitForClickabilityOf(rescheduleButton);
        driver.findElement(rescheduleButton).click();
    }


    public String getRideCancelledPopupTitle() {
        waitForVisibilityOf(rideCancelledPopup);
        String title = driver.findElement(rideCancelledPopup).getText();
        System.out.println("Ride cancelled popup's title = " + title);
        return title;
    }


    public void crossIconClick() {
        waitForClickabilityOf(crossIcon);
        driver.findElement(crossIcon).click();
    }


    public String getCancelRescheduleSelectedCategoryText() {
        waitForClickabilityOf(cancelRescheduleSelectedCategory);
        return driver.findElement(cancelRescheduleSelectedCategory).getText();
    }

    public void backIconClick() {
        waitForClickabilityOf(backIcon);
        driver.findElement(backIcon).click();
    }

    public String rescheduleSlotsPageSubtext(){

        waitForVisibilityOf(rescheduleSlotsPageSubtext);
        return driver.findElement(rescheduleSlotsPageSubtext).getText();
    }

    public String rescheduleSlotsPageReserveSeatSubtext(){
        waitForVisibilityOf(rescheduleSlotsPageReserveSeatSubtext);
        return driver.findElement(rescheduleSlotsPageReserveSeatSubtext).getText();

    }


    public void clickRescheduleSlot(int index) throws InterruptedException {
        if (checkIfElementPresent(selectRescheduleSlot, 5) == true) {
            System.out.println("Slot for rescheduling ride is displayed");
            driver.findElements(selectRescheduleSlot).get(index).click();
        } else {
            System.out.println("Slot for rescheduling ride is not displayed");
        }

    }

    public void reserveSeatForRescheduleRide(){
        waitForClickabilityOf(reserveSeat);
        driver.findElement(reserveSeat).click();
    }



}
