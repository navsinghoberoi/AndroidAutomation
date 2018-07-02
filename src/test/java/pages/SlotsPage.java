package pages;

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
    By locatePickupStop = By.id("locate_pickup_button");
    By ppName = By.id("from_tv");
    By dpName = By.id("drop_tv");
    By selectTimeSlotText = By.xpath("//android.widget.TextView[@text='Select a Timeslot']");
    By ridesRemainingOnSlotsPage = By.id("slots.info_text");
    By alertTitle = By.id("alertTitle");
    By couponText = By.id("booking_coupon_text");
    By bannerImage = By.id("banner_shutl_more_image");


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

    public String getCtaOnSlotsPage() throws InterruptedException {
        try {
            waitForVisibilityOf(clickCTA_button);
            String ctaName = driver.findElement(clickCTA_button).getText();
            System.out.println("Name of the CTA on slots page = " + ctaName);
            Thread.sleep(3000);
            return ctaName;
        }
        catch (Exception e){
            return "CTA Button Not Found";
        }
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
    public String getPPRSubText() {
        waitForClickabilityOf(takePPROptionSubtext);
        // extract fair from "Proceed to pay ₹100.0 for this ride"
        List<WebElement> payPerRideOption = driver.findElements(takePPROptionSubtext);
        String pprTextOption = payPerRideOption.get(1).getText();
        System.out.println(pprTextOption);
        pprTextOption = pprTextOption.substring(pprTextOption.indexOf("pay") + 4, pprTextOption.lastIndexOf("for") - 3);
        // Convert String fair into Int fair
        return pprTextOption;
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
    public void selctOptionFromContinuePPRO(int slotIndex, int optionIndex) throws Exception{
        getSelectOptionText();
        String pPROption = clickBuyPassOption(optionIndex);
        System.out.println(pPROption);
        System.out.printf("Subtext of the selected option = " + pPROption);
    }

    public boolean isLocatePickupStopDisplayed()
    {
        waitForClickabilityOf(locatePickupStop);
        boolean result =  driver.findElement(locatePickupStop).isDisplayed();
        return result;
    }


    public String getPPNameOnSlotsPage(){
        waitForVisibilityOf(ppName);
        String data = driver.findElement(ppName).getText();
        return data;
    }


    public String getDPNameOnSlotsPage(){
        waitForVisibilityOf(dpName);
        String data = driver.findElement(dpName).getText();
        return data;
    }



    public boolean isSelectTimeslotDisplayed(){

        if (checkIfElementPresent(selectTimeSlotText, 10) == true) {
            System.out.println("Select timeslot is displayed, i.e. user is on slots page");
            return true;
        } else {
            System.out.println("Select timeslot is not displayed, i.e. user is not on slots page");
            return false;
        }

    }

    public boolean isRidesRemainingDisplayedOnSlotsPage(){

        if (checkIfElementPresent(ridesRemainingOnSlotsPage, 10) == true) {
            System.out.println("Rides remaining count is displayed on slots page");
            return true;
        } else {
            System.out.println("Rides remaining count is displayed on slots page");
            return false;
        }

    }

    public String getRidesRemainingCountOnSlotsPage(){

        waitForVisibilityOf(ridesRemainingOnSlotsPage);
        String ridesCount = driver.findElement(ridesRemainingOnSlotsPage).getText();
        System.out.println("Rides remaining count on slots page = "+ridesCount);
        return ridesCount;
    }


    public boolean isReserveSeatButtonEnabled(){
        boolean result;
        if (checkIfElementPresent(clickCTA_button, 10) == true) {
            result = driver.findElement(clickCTA_button).isEnabled();
            System.out.println("Reserve seat button is enabled");
            return result;
        } else {
            System.out.println("Rides remaining count is displayed on slots page");
            return false;
        }

    }


    public boolean isAlertDisplayedForBookingSameRoute(){
        boolean result;
        if (checkIfElementPresent(alertTitle, 10) == true) {
            result = driver.findElement(alertTitle).isEnabled();
            System.out.println("Alert is displayed for trying to book on same route when already one booking is created");
            String alertText = driver.findElement(alertTitle).getText();
            System.out.println("Heading of the alert = " +alertText);
            return result;
        } else {
            System.out.println("Alert for booking on same route is not displayed");
            return false;
        }

    }
    public String getCouponCodeTextOnSlotScreen() {
        waitForVisibilityOf(couponText);
        String getCouponText = driver.findElement(couponText).getText();
        return getCouponText;
    }


    public String getCTAOnSlotsPage() {
        waitForVisibilityOf(clickCTA_button);
        String ctaName = driver.findElement(clickCTA_button).getText();
        System.out.println("Name of the CTA on slots page = " + ctaName);
        return ctaName;
    }


    public boolean isBannerImageDisplayed() {
        boolean result;
        if (checkIfElementPresent(bannerImage, 10) == true) {
            result = driver.findElement(bannerImage).isEnabled();
            System.out.println("Banner image is displayed on slots page");
            return result;
        } else {
            System.out.println("Banner image is not displayed on slots page");
            return false;
        }

    }


    public boolean isPostpayOptionDisplayed() {
        boolean result = false;
        if (checkIfElementPresent(secondOption, 10) == true) {
            result = driver.findElements(secondOption).get(1).isDisplayed();
            System.out.println("Postpay option is displayed");
        } else {
            System.out.println("Postpay option is not displayed");
        }

        return result;

    }


    public String checkPostpayOptionText() {
        String optionName = "";
        if (checkIfElementPresent(secondOption, 10) == true) {
            optionName = driver.findElements(secondOption).get(1).getText();
            System.out.println("Postpay option is displayed");
        } else {
            System.out.println("Postpay option is not displayed");
        }

        return optionName;

    }


    public String checkPostpaySubtext() {
        waitForVisibilityOf(takePPROptionSubtext);
        String text = driver.findElements(takePPROptionSubtext).get(1).getText();
        System.out.println("Subtext of the selected option page = " + text);
        return text;
    }


    public void clickPostPayOption() throws Exception {
        waitForVisibilityOf(secondOption);
        driver.findElements(secondOption).get(1).click();

    }


    public boolean isBuyPassOptionDisplayed() {
        boolean result = false;
        if (checkIfElementPresent(buyPassOption, 10) == true) {
            result = driver.findElements(buyPassOption).get(0).isDisplayed();
            String optionName =  driver.findElements(buyPassOption).get(0).getText();
            System.out.println("Buy Pass option is displayed = " +optionName);
        } else {
            System.out.println("Postpay option is not displayed");
        }

        return result;

    }


    // This methods checks Buy pass CTA OR Buy pass option from Continue
    public boolean checkBuyPassDisplayed() throws Exception{
        boolean result =false;
        String cta = getCTAOnSlotsPage();
        if(cta.equalsIgnoreCase("BUY PASS"))
        {
            System.out.println("Only Buy Pass option displayed on slots page, i.e. Non PPR route");
            result = true;
        }else if(cta.equalsIgnoreCase("CONTINUE")){
            clickCtaOnSlotsPage();
            System.out.println("Multiple options are displayed on slots page, i.e.PPR route");
            result = isBuyPassOptionDisplayed();
        }

        return result;
    }

// This methods clicks on Buy pass CTA OR Buy pass option from Continue
    public void clickBuyPass() throws Exception{
        String cta = getCTAOnSlotsPage();
        if(cta.equalsIgnoreCase("BUY PASS"))
        {
            System.out.println("Only Buy Pass option displayed on slots page, i.e. Non PPR route");
            clickCtaOnSlotsPage();
        }else if(cta.equalsIgnoreCase("CONTINUE")){
            clickCtaOnSlotsPage();
            System.out.println("Multiple options are displayed on slots page, i.e.PPR route");
            clickBuyPassOption(0);
        }

    }




}