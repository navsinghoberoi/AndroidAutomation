package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SlotsPage extends BasePage {

    public SlotsPage(WebDriver driver) {
        super(driver);
    }

    By selectSlot = By.id("parent_view");
    By selectSlotsBoardingTime = By.id(app_package_name + "time_tv");
    By selectRoute_button = By.id(app_package_name + "next_shuttl_container");
    //By clickBook_button = By.id(app_package_name + "booking_btn_book");
    By clickCTA_button = By.id("booking_book_button");
    By confirm_popup = By.id(app_package_name + "popup_notify_wa.title");
    //By slotTime = By.id(app_package_name + "ts_item_time");
    By slotTime = By.id("time_tv");
    By selectOptionText = By.id("booking_option.title");
    By buyPassOption = By.id("item_booking_option.title");
    By secondOption = By.id("item_booking_option.title");      // second option could be PPR or POSTPAY
    By buyPassOptionSubtext = By.id("item_booking_option.text");
    By takePPROptionSubtext = By.id("item_booking_option.text");
    By backButton = By.className("android.widget.ImageButton");

    public void clickSlot(int index) throws InterruptedException {
        waitForClickabilityOf(selectSlot);
        Thread.sleep(2000);
        driver.findElements(selectSlot).get(index).click();
        Thread.sleep(2000);
    }

    public void clickRoute() throws InterruptedException {
        waitForClickabilityOf(selectRoute_button);
        driver.findElement(selectRoute_button).click();
        Thread.sleep(2000);
    }

    public void clickSlot1(int index) throws InterruptedException {
        waitForClickabilityOf(selectSlotsBoardingTime);
        Thread.sleep(2000);
        driver.findElements(selectSlotsBoardingTime).get(index).click();
        Thread.sleep(2000);
    }

    public String clickCtaOnSlotsPage() throws InterruptedException {
        waitForVisibilityOf(clickCTA_button);
        String ctaName = driver.findElement(clickCTA_button).getText();
        System.out.println("Name of the CTA on slots page = " + ctaName);
        driver.findElement(clickCTA_button).click();
        Thread.sleep(3000);
        return ctaName;
    }

    public String confirmBookingPopup() {
        waitForVisibilityOf(confirm_popup);
        String text = driver.findElement(confirm_popup).getText();
        return text;

    }

    int selectedSlot() {
        List<WebElement> availableSlots = driver.findElements(slotTime);
        int a = availableSlots.size();
        int i = 0;
        //int selected = 0;
        System.out.println(a);
        for (i = 0; i < a; i++) {
            String slot = availableSlots.get(i).getAttribute("text");
            int selected = Integer.parseInt(slot);
            System.out.println("Slot time is" + selected);

            if (selected > 8) {
                System.out.println("Slot time is" + selected);
                break;
                //return i;
            }
        }
        return i;

    }


    public String getSelectOptionText() {
        waitForVisibilityOf(selectOptionText);
        String text = driver.findElement(selectOptionText).getText();
        System.out.println("Heading on the select options page = " + text);
        return text;
    }


    public String clickBuyPassOption(int index) throws Exception {
        waitForVisibilityOf(buyPassOption);
        Thread.sleep(2000);
        String text = driver.findElements(buyPassOptionSubtext).get(index).getText();
        driver.findElements(buyPassOption).get(index).click();
        Thread.sleep(2000);
        return text;
    }


    public String clickPPROption(int index) throws Exception {
        waitForVisibilityOf(secondOption);
        Thread.sleep(2000);
        String text = driver.findElements(takePPROptionSubtext).get(index).getText();
        driver.findElements(secondOption).get(index).click();
        Thread.sleep(2000);
        return text;
    }

    public void clickBackButton() {
        waitForVisibilityOf(backButton);
        driver.findElement(backButton).click();

    }


    public void selectOptionFromContinueCTA(int slotIndex, int optionIndex) throws Exception {
        clickSlot(slotIndex);
        clickCtaOnSlotsPage();
        getSelectOptionText();
        String selectedOption = clickBuyPassOption(optionIndex);
        System.out.println("Subtext of the selected option = " + selectedOption);

    }


}