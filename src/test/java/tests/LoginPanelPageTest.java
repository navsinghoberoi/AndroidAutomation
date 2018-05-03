package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.web.b2b.B2bSetup;
import pages.web.b2b.LoginPanelPage;


public class LoginPanelPageTest extends B2bSetup{

    @Test
    public void verifyValidLogin() {

        LoginPanelPage loginb2b = new LoginPanelPage(driver);

        loginb2b.launchBrowser();
        waitForVisibilityOf(loginb2b.getUsername());
        System.out.print(loginb2b.getUsername());
        waitForVisibilityOf(loginb2b.getPassword());
        waitForVisibilityOf(loginb2b.getSubmitLogin());

        loginb2b.typeUsername("jai");
        loginb2b.typePassword("b2b");
        loginb2b.pressLoginButton();


        // WebDriverWait wait=new WebDriverWait(driver,30);
        // WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath()))
        //driver.quit();

    }

}
