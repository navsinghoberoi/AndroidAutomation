package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CouponsPage extends BasePage{
	public CouponsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By enter_coupon= By.xpath("//android.widget.TextView[@text='Enter Coupon']");
	By saved_coupons= By.xpath("//android.widget.TextView[@text='Saved Coupons']");
	By enter_coupon_text= By.id( app_package_name + "enter_promo.text");
	By save_coupon_button =By.id(app_package_name + "enter_promo.apply_layout");
	By enable_coupon_code_area = By.id(app_package_name + "enter_promo.edit_text");
	By addCouponConfirmationPopup = By.id(app_package_name + "popup_notify_wa.message");
	By fromToIcon = By.id(app_package_name + "from_to");
	
	public String getFindMyEnterCouponText() {	
		waitForVisibilityOf(enter_coupon_text);
		String FindMyEnterCouponText= driver.findElement(enter_coupon_text).getText();
		return FindMyEnterCouponText;	
	}
	
	public void clickCouponCodeArea() {
		waitForClickabilityOf(enable_coupon_code_area);
		driver.findElement(enable_coupon_code_area).click();
	}
	
	public void enterCouponCode(){
		driver.findElement(enable_coupon_code_area).sendKeys("FREE1");
		
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
	
	public boolean isVisible(){
		Boolean flag= false;
		try{
			waitForVisibilityOf(fromToIcon);
			flag = true;
		} catch(Exception e){
			e.printStackTrace();

		}
		return flag;
	}
	
	public void isRebook() {
		//waitForVisibilityOf(fromToIcon);
		driver.navigate().back();
	}
}