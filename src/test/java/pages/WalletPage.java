package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WalletPage extends BasePage {
	
    public WalletPage(WebDriver driver) {
		super(driver);
	}

	By wallet_button = By.id(app_package_name + "item_coupon.parent");
 //   By gplus_button = By.className("android.widget.ImageView");
 //   By gplus_account_button = By.className("android.widget.LinearLayout");
   
 /*   public void clickSignIn() {
        waitForClickabilityOf(signIn_button);
        driver.findElement(signIn_button).click();
    }
   */ 
    public void clickShuttlWallet() {
        waitForClickabilityOf(wallet_button);
        driver.findElements(wallet_button).get(0).click();
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
