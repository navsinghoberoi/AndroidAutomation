package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShuttlWalletCheckoutPage extends BasePage {

	public ShuttlWalletCheckoutPage(WebDriver driver) {
		super(driver);
	}

	By selectWallet_button = By.id(app_package_name + "pco_name");
	//By addMoney_button = By.id(app_package_name + "app.goplus.in.myapplication.qa:id/wallet_recharge.add_money");
	//   By gplus_account_button = By.className("android.widget.LinearLayout");

	/*
	public void clickaddMoney() {
		waitForClickabilityOf(addMoney_button);
		driver.findElement(addMoney_button).click();
	}
	*/

	public void selectPaytmWallet() {
		waitForClickabilityOf(selectWallet_button);
		driver.findElements(selectWallet_button).get(1).click();
	}

	/*   public void clickGplusAccount() {
    	 waitForVisibilityOf(gplus_account_button);
         driver.findElements(gplus_account_button).get(0).click();

    }
	 */
}
