package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShuttlWalletDetailsPage extends BasePage {

	public ShuttlWalletDetailsPage(WebDriver driver) {
		super(driver);
	}

	By enterAmount_button = By.id(app_package_name + "wallet_recharge.amount");
	By addMoney_button = By.id(app_package_name + "wallet_recharge.add_money");
	//   By gplus_account_button = By.className("android.widget.LinearLayout");

	public void clickaddMoney() {
		waitForClickabilityOf(addMoney_button);
		driver.findElement(addMoney_button).click();
	}

	public void enterAmount(String Amount) {
		waitForClickabilityOf(enterAmount_button);
		driver.findElement(enterAmount_button).click();
		driver.findElement(enterAmount_button).sendKeys(Amount);
	}

	/*   public void clickGplusAccount() {
    	 waitForVisibilityOf(gplus_account_button);
         driver.findElements(gplus_account_button).get(0).click();

    }
	 */

	//        //Perform tap
	//        WebElement applyFilter=driver.findElement(By.id(app_package_name+ "apply_filters"));
	//        performTapAction(applyFilter);
	//
	//        waitForVisibilityOf(By.id(app_package_name + "filter_image"));
}
