package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CouponsPage extends BasePage {
    public CouponsPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    By couponsDisplayText = By.xpath("//android.widget.CheckedTextView[@text='Coupons']");
    By couponsTitleText = By.xpath("//android.widget.TextView[@index=1]");
    By backButton = By.xpath("//android.widget.ImageButton[@index=0]");
    By popUp = By.id("popup_notify_wa.icon");
    By savedCouponCode = By.id("code_tv");
    By getSavedCouponTabAfterBooking = By.xpath("//android.widget.TextView[@text='You do not have any saved coupons.']");
    By enter_coupon_area = By.xpath("//android.widget.TextView[@text='ENTER COUPON']");
    By saved_coupon_area = By.xpath("//android.widget.TextView[@text='SAVED COUPONS']");
    By saved_coupons_name = By.id(app_package_name+"layout_container");
    By terms_of_service = By.id(app_package_name+"enter_promo.tnc");
   // By enter_coupon_text = By.id(app_package_name + "enter_promo.text");
    By save_coupon_button = By.id(app_package_name + "enter_promo.apply_layout");
    By enable_coupon_code_area = By.id(app_package_name + "enter_promo.edit_text");
    By addCouponConfirmationPopup = By.id(app_package_name + "popup_notify_wa.title");
    By fromToIcon = By.id(app_package_name + "from_to");
    By dismiss_button = By.xpath("//android.widget.Button[@text='DISMISS']");
    By wrong_coupon_popup=By.id(app_package_name+"message");
    By title_terms_and_conditions=By.xpath("//android.widget.TextView[@text='Terms and Conditions']");
    By offer_details=By.xpath("//android.widget.TextView[@text='Offer Details']");
    By expiry_date=By.id(app_package_name+"expiry_tv");



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

    public void clickBackButton() {

        waitForClickabilityOf(backButton);
        driver.findElement(backButton).click();

    }

    public void clickSavedCoupon() {
        waitForVisibilityOf(saved_coupons_name);
        List<WebElement> savedCouponsList = driver.findElements(saved_coupons_name);
        savedCouponsList.get(0).click();
    }

    public String getSavedCouponCodeText() {
        waitForVisibilityOf(savedCouponCode);
        String getCouponCode = driver.findElement(savedCouponCode).getText();
        return getCouponCode;

    }
    public void clickPopUp() {

        if (checkIfElementPresent(popUp, 5) == true) {
        System.out.println("Coupon Added PopUp is displayed, need to click on screen");
        waitForClickabilityOf(popUp);
        driver.navigate().back();
    } else {
        waitForVisibilityOf(saved_coupon_area);
        driver.findElement(saved_coupon_area).click();
    }
}
//    public String getCouponCodeTextOnSlotScreen() {
//        waitForVisibilityOf(couponText);
//        String getCouponText = driver.findElement(couponText).getText();
//        return getCouponText;
//    }
    public String getSavedCouponScreenAfterCouponRedemption() {
        waitForVisibilityOf(getSavedCouponTabAfterBooking);
        String CouponTabAfterRedeem = driver.findElement(getSavedCouponTabAfterBooking).getText();
        return CouponTabAfterRedeem;
}

    public void clickEnterCouponCodeArea()
    {
        waitForClickabilityOf(enter_coupon_area);
        driver.findElement(enter_coupon_area).click();
    }


    public String getFindMyEnterCouponText() {
        waitForVisibilityOf(enable_coupon_code_area);
        String FindMyEnterCouponText = driver.findElement(enable_coupon_code_area).getText();
        return FindMyEnterCouponText;
    }

    public void clickCouponCodeArea() {
        waitForClickabilityOf(enable_coupon_code_area);
        driver.findElement(enable_coupon_code_area).click();
    }

    public void enterCouponCode(String keyforcouponcode) throws Exception {
        driver.findElement(enable_coupon_code_area).sendKeys(getValueFromPPFile(keyforcouponcode));

    }

    public void clickSaveButton() {
        waitForClickabilityOf(save_coupon_button);
        driver.findElement(save_coupon_button).click();
    }

    public String getAddCouponConfirmationPopupText() {
        waitForVisibilityOf(addCouponConfirmationPopup);
        String Text = driver.findElement(addCouponConfirmationPopup).getText();
        return Text;
    }

    public boolean isVisible() {
        Boolean flag = false;
        try {
            waitForVisibilityOf(fromToIcon);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return flag;
    }


    public void isRebook() {
        //waitForVisibilityOf(fromToIcon);
        driver.navigate().back();
    }

    public void clickSavedCouponsArea() {
        waitForClickabilityOf(saved_coupon_area);
        driver.findElement(saved_coupon_area).click();
    }

    public void clickTermOfService() {
        waitForVisibilityOf(terms_of_service);
        driver.findElement(terms_of_service).click();
    }

    public boolean checkAddedCouponMessage() {
        waitForVisibilityOf(addCouponConfirmationPopup);
        return driver.findElement(addCouponConfirmationPopup).isDisplayed();

    }

    public void clickOnSavedCoupon() {
        waitForClickabilityOf(saved_coupons_name);
        driver.findElement(saved_coupons_name).click();

    }

    public void clickDismissButton() {
        waitForClickabilityOf(dismiss_button);
        driver.findElement(dismiss_button).click();

    }

    public String getWrongCouponPopup()
    {
        waitForVisibilityOf(wrong_coupon_popup);
        return driver.findElement(wrong_coupon_popup).getText();

    }

    public String getTermsOfServiceTitle()
    {
        waitForVisibilityOf(title_terms_and_conditions);
        return driver.findElement(title_terms_and_conditions).getText();

    }

    public boolean offerDetailVisibility()
    {
        waitForVisibilityOf(offer_details);
        return driver.findElement(offer_details).isDisplayed();
    }

    public String getExpiryDate()
    {
        waitForVisibilityOf(expiry_date);
        String expiry =driver.findElement(expiry_date).getText();
        return expiry;
    }

    public void addCouponIntegrated() throws Exception {
        clickCouponCodeArea();
        enterCouponCode("couponcode");
        AndroidDriver androidDriver = (AndroidDriver) driver;
        androidDriver.hideKeyboard();
        clickSaveButton();
       // driver.navigate().back();
    }
}