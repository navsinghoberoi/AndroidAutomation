package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaytmPage extends BasePage {

	public PaytmPage(WebDriver driver) {
		super(driver);
	}

	By paytmLogin_button = By.xpath("//android.view.View[@content-desc='Login Link']");
	By paytmText_button = By.className("android.widget.EditText");
	By paytmSingin_button = By.className("android.widget.Button");
	//By addMoney_button = By.id(app_package_name + "app.goplus.in.myapplication.qa:id/wallet_recharge.add_money");
	//   By gplus_account_button = By.className("android.widget.LinearLayout");


	public void clickPaytmLogin() {
		waitForVisibilityOf(paytmLogin_button);
		driver.findElement(paytmLogin_button).click();
		//System.out.println(Elements);
	}

	public void enterPaytmCredientials() throws InterruptedException {
		waitForClickabilityOf(paytmText_button);
		//clear(paytmLogin_button);
		//Thread.sleep(5000);
		driver.findElements(paytmText_button).clear();
		Thread.sleep(5000);
		driver.findElements(paytmText_button).get(0).sendKeys("9560727888");
		waitForClickabilityOf(paytmText_button);
		driver.findElements(paytmText_button).get(1).sendKeys("Paytm@197");

	}

	public void clickPaytmSignin() {
		waitForVisibilityOf(paytmSingin_button);
		driver.findElements(paytmSingin_button).get(0).click();

	}
}
