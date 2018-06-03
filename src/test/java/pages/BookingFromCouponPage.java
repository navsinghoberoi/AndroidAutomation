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
    By offer_details=By.xpath("//android.widget.TextView[@text='Offer Details']");
    By savedCoupon = By.id("layout_container");
    By savedCouponCode = By.id("code_tv");
    By popUp = By.id("popup_notify_wa.icon");
    By couponText = By.id("booking_coupon_text");
    By backButton = By.xpath("//android.widget.ImageButton[@index=0]");



    public String getCouponsDisplayText() {
        System.out.println("I am inside inside fucntion");
        waitForVisibilityOf(couponsDisplayText);
        System.out.println("I am testing visibility");
        String findCouponDisplayText = driver.findElement(couponsDisplayText).getText();
        System.out.println("Tested Visibility");
        return findCouponDisplayText;
    }

    public void clickCouponsDisplayText() {
        System.out.println("Testing click");
        waitForClickabilityOf(couponsDisplayText);
        System.out.println("Clicked");
        driver.findElement(couponsDisplayText).click();
    }
    public String getCouponTitleText() {

        waitForClickabilityOf(couponsTitleText);
        String getCouponTitleText = driver.findElement(couponsTitleText).getText();
        return getCouponTitleText;
    }
    public void clickSavedCouponTab(){
        waitForVisibilityOf(savedCouponTab);
        driver.findElement(savedCouponTab).click();
    }
    public void clickSavedCoupon(){
        waitForVisibilityOf(savedCoupon);
        List<WebElement> savedCouponsList = driver.findElements(savedCoupon);
        savedCouponsList.get(0).click();
    }
    public String getSavedCouponCodeText(){
        waitForVisibilityOf(savedCouponCode);
        String getCouponCode = driver.findElement(savedCouponCode).getText();
        return getCouponCode;

    }
    public void clickPopUp(){

        if (checkIfElementPresent(popUp, 20) == true) {
            System.out.println("Coupon Added PopUp is displayed, need to click on screen");
            waitForClickabilityOf(popUp);
            driver.navigate().back();
        } else {
            waitForVisibilityOf(savedCouponTab);
            driver.findElement(savedCouponTab).click();
        }
    }
    public boolean getOfferDetailVisibility()
    {
        waitForVisibilityOf(offer_details);
        return driver.findElement(offer_details).isDisplayed();
    }
    public void clickBackButton() {

        waitForClickabilityOf(backButton);
        driver.findElement(backButton).click();

    }
    public String getCouponCodeText(){
        waitForVisibilityOf(couponText);
        String getCouponText = driver.findElement(couponText).getText();
        return getCouponText;
    }

}