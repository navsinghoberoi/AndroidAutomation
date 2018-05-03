package pages.web.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class B2bSetup {

    public WebDriver driver;
    public void launchBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/Desktop/chrome/chromedriver");
        driver = new ChromeDriver();
        BasePage basePage=new BasePage(driver);
        Dimension d = new Dimension(1424, 768);
        driver.manage().window().setSize(d);
        driver.get("https://qa-sso.goplus.in/login?targetUrl=http://qab2bui.goplus.in/home.html");
    }

    public void waitForVisibilityOf(By locator)
     {
             WebDriverWait wait = new WebDriverWait(driver, 30);
           wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
       }

}
