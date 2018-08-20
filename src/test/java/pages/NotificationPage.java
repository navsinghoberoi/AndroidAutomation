package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class NotificationPage extends BasePage{

    public NotificationPage(WebDriver driver) {
        super(driver);
    }

    By notificationDisplayText = By.xpath("//android.widget.CheckedTextView[@text='Notifications']");
    By getNotificationLandingText = By.xpath("//android.widget.TextView[@text='Notifications']");
    By bookingNotificationTitle = By.id("list_item_title");
    By bookingCreationNotificationSubText = By.id("list_item_detail");
    By viewTextOnNotification = By.id("notification_btn");
    By bookingIdInHistoryTab = By.id("booking_details.id_tv");
    By bookingCancellationNotificationSubText = By.id("list_item_detail");

    public String getNotificationText(){

        waitForVisibilityOf(notificationDisplayText);
        String notification = driver.findElement(notificationDisplayText).getText();
        return notification;
    }


    public boolean clickNotificationText(){

        waitForClickabilityOf(notificationDisplayText);
        driver.findElement(notificationDisplayText).click();
        return true;
    }


    public String getNotificationTitleText(){

        waitForVisibilityOf(getNotificationLandingText);
        String landing_NPage = driver.findElement(getNotificationLandingText).getText();
        return landing_NPage;
    }


    public String getBookingNotification(){
        waitForVisibilityOf(bookingNotificationTitle);
        String bookingDetailsTitle = driver.findElement(bookingNotificationTitle).getText();
        return bookingDetailsTitle;
    }

//    public String getBookingCancelledNotification(){
//        waitForVisibilityOf(bookingNotification);
//
//
//    }

    public String getViewButtonOnBooking(){
        waitForVisibilityOf(viewTextOnNotification);
        String viewButton = driver.findElement(viewTextOnNotification).getText();
        return viewButton;
    }

    public Boolean clickViewButtonOnBooking(){
        try {
            waitForClickabilityOf(viewTextOnNotification);
            driver.findElement(viewTextOnNotification).click();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public String getBookingCreationNotificationSubText(){
        waitForVisibilityOf(bookingCreationNotificationSubText);
        List<WebElement> bookingDetailsOnCreation = driver.findElements(bookingCreationNotificationSubText);
        String booking_Index_Detail_Creation= bookingDetailsOnCreation.get(0).getText();
        System.out.println(booking_Index_Detail_Creation);
        booking_Index_Detail_Creation = booking_Index_Detail_Creation.substring(booking_Index_Detail_Creation.indexOf("is ")+ 3,booking_Index_Detail_Creation.indexOf("."));
        System.out.println(booking_Index_Detail_Creation);
        return booking_Index_Detail_Creation;

    }



    public String getBookingCancellationNotificationSubText(){
        waitForVisibilityOf(bookingCancellationNotificationSubText);
        List<WebElement> bookingDetailsOnCancellation = driver.findElements(bookingCancellationNotificationSubText);
        String booking_Index_Detail_Cancellation= bookingDetailsOnCancellation.get(0).getText();
        System.out.println(booking_Index_Detail_Cancellation);
        booking_Index_Detail_Cancellation = booking_Index_Detail_Cancellation.substring(booking_Index_Detail_Cancellation.indexOf("ID ")+3,booking_Index_Detail_Cancellation.lastIndexOf(" has"));
        System.out.println(booking_Index_Detail_Cancellation);
        return booking_Index_Detail_Cancellation;

    }


    public String getBookingId(){
        waitForVisibilityOf(bookingIdInHistoryTab);
        String bookingId = driver.findElement(bookingIdInHistoryTab).getText();
        return bookingId;

    }




}

