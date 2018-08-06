package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	By signIn_button = By.className("android.widget.TextView");
	By gplus_button = By.className("android.widget.ImageView");
	By gplus_account_button = By.className("android.widget.LinearLayout");
	By facebook_button = By.className("android.widget.ImageView");
	By skip_to_login_button = By.id("ob.skip_button");
	By continueButtonAtDeviceRegisterAlert = By.id("button1");

	public void clickSignIn() {
		waitForClickabilityOf(signIn_button);
		driver.findElements(signIn_button).get(2).click();
	}

	public void clickGplus() {
		waitForClickabilityOf(gplus_button);
		driver.findElements(gplus_button).get(3).click();
	}

	public void clickGplusAccount() {
		waitForVisibilityOf(gplus_account_button);
		driver.findElements(gplus_account_button).get(0).click();

	}

	public void clickFacebook() {
		waitForVisibilityOf(facebook_button);
		driver.findElements(facebook_button).get(2).click();
	}


	public void clickSkipToLogin() {
		if (checkIfElementPresent(skip_to_login_button, 10) == true) {
		driver.findElement(skip_to_login_button).click();
		System.out.println("Skip button is displayed");}
		else {
			System.out.println("Skip button is not displayed");
		}
	}


	public void registeredDeviceAlertAcceptAtSignup() {
		if (checkIfElementPresent(continueButtonAtDeviceRegisterAlert, 5) == true) {
			driver.findElement(continueButtonAtDeviceRegisterAlert).click();
			System.out.println("Registered device alert is displayed");
		} else {
			System.out.println("Registered device alert is not displayed");
		}
	}


	//        //Perform tap
	//        WebElement applyFilter=driver.findElement(By.id(app_package_name+ "coupon_parent"));
	//        performTapAction(applyFilter);
	//
	//        waitForVisibilityOf(By.id(app_package_name + "filter_image"));
}
