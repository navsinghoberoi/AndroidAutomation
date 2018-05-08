package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingCompletePage extends BasePage{

    By bookingConfirmPopupTitle = By.id("dsf.title");
    By bookingConfirmPopupSubtext = By.id("dsf.message");
    By bookingConfirmPopupCTA = By.id("dsf.button");

    public BookingCompletePage(WebDriver driver) {
        super(driver);
    }


    public String clickBookingConfirmPopupCTA()
    {
        waitForVisibilityOf(bookingConfirmPopupCTA);
        String text = driver.findElement(bookingConfirmPopupCTA).getText();
        driver.findElement(bookingConfirmPopupCTA).click();
        return text;
    }

    public String getBookingConfirmPopupTitle()
    {
        waitForVisibilityOf(bookingConfirmPopupTitle);
        String text = driver.findElement(bookingConfirmPopupTitle).getText();
        return text;
    }


    public String getBookingConfirmPopupSubtext()
    {
        waitForVisibilityOf(bookingConfirmPopupSubtext);
        String text = driver.findElement(bookingConfirmPopupSubtext).getText();
        return text;
    }

}
