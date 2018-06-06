package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingFromCouponPage extends BasePage {

    public BookingFromCouponPage(WebDriver driver) {
        super(driver);
    }

    By couponsDisplayText = By.xpath("//android.widget.CheckedTextView[@text='Coupons']");
    By couponsTitleText = By.xpath("//android.widget.TextView[@index=1]");
    By savedCouponTab = By.xpath("//android.widget.TextView[@text='SAVED COUPONS']");
    By offer_details = By.xpath("//android.widget.TextView[@text='Offer Details']");
    By savedCoupon = By.id("layout_container");
    By savedCouponCode = By.id("code_tv");
    By popUp = By.id("popup_notify_wa.icon");
    By couponText = By.id("booking_coupon_text");
    By backButton = By.xpath("//android.widget.ImageButton[@index=0]");
    By slotTime = By.id("parent_view");
    By rideConfirmed = By.id("dsf.title");
    By gotItButton = By.id("dsf.button");
    By bookingCurrentRideCard = By.id("hab.action_container");
    By pickuHomepageCard = By.id("hab.pick_up_location");
    By currentRideInMyRIde = By.id("pdwl.pick_up_name");
    By getSavedCouponTabAfterBooking = By.xpath("//android.widget.TextView[@text='You do not have any saved coupons.']");


    public String getCouponsDisplayText() {
        waitForVisibilityOf(couponsDisplayText);
        String findCouponDisplayText = driver.findElement(couponsDisplayText).getText();
        return findCouponDisplayText;
    }

    public void clickCouponsDisplayText() {
        waitForClickabilityOf(couponsDisplayText);
        driver.findElement(couponsDisplayText).click();
    }

    public String getCouponTitleText() {

        waitForClickabilityOf(couponsTitleText);
        String getCouponTitleText = driver.findElement(couponsTitleText).getText();
        return getCouponTitleText;
    }

    public void clickSavedCouponTab() {
        waitForVisibilityOf(savedCouponTab);
        driver.findElement(savedCouponTab).click();
    }

    public void clickSavedCoupon() {
        waitForVisibilityOf(savedCoupon);
        List<WebElement> savedCouponsList = driver.findElements(savedCoupon);
        savedCouponsList.get(0).click();
    }

    public String getSavedCouponCodeText() {
        waitForVisibilityOf(savedCouponCode);
        String getCouponCode = driver.findElement(savedCouponCode).getText();
        return getCouponCode;

    }

    public void clickPopUp() {

        if (checkIfElementPresent(popUp, 20) == true) {
            System.out.println("Coupon Added PopUp is displayed, need to click on screen");
            waitForClickabilityOf(popUp);
            driver.navigate().back();
        } else {
            waitForVisibilityOf(savedCouponTab);
            driver.findElement(savedCouponTab).click();
        }
    }

    public boolean getOfferDetailVisibility() {
        waitForVisibilityOf(offer_details);
        return driver.findElement(offer_details).isDisplayed();
    }

    public void clickBackButton() {

        waitForClickabilityOf(backButton);
        driver.findElement(backButton).click();

    }

    public String getCouponCodeText() {
        waitForVisibilityOf(couponText);
        String getCouponText = driver.findElement(couponText).getText();
        return getCouponText;
    }

    public String getSavedCouponScreenAfterCouponRedemption() {
        waitForVisibilityOf(getSavedCouponTabAfterBooking);
        String CouponTabAfterRedeem = driver.findElement(getSavedCouponTabAfterBooking).getText();
        return CouponTabAfterRedeem;
    }
    public String  getRideConfirmedTest(){
        waitForVisibilityOf(rideConfirmed);
        String getRideConfirmedText = driver.findElement(rideConfirmed).getText();
        return getRideConfirmedText;
    }
    public void clickRideConfirmedGotItButton(){
        waitForClickabilityOf(gotItButton);
        driver.findElement(gotItButton).click();
    }
    public boolean bookingCardVisibility() {
        if (checkIfElementPresent(bookingCurrentRideCard)){

            return true;
        } else {

            return false;
        }
    }

    public String pickUpStopCard(){

        waitForVisibilityOf(pickuHomepageCard);
        String pickupHomePageCardTest = driver.findElement(pickuHomepageCard).getText();
        return pickupHomePageCardTest;
    }
    public String  currentRideText (){
        waitForVisibilityOf(currentRideInMyRIde);
        String currentRidePicupText = driver.findElement(currentRideInMyRIde);
        return currentRidePicupText;

    }
}