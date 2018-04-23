package pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class WebSetup {
    public WebDriver driver;

    protected void prepareBrowser(String env) throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "Resources//chromedriver");
        if (env == "local")
        {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            driver = new ChromeDriver(options);
            //driver = new ChromeDriver();
            driver.manage().window().maximize();
            //driver.navigate().to(appURL);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            //return driver;
        }
        else {
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability("platform", "Windows XP");
            caps.setCapability("version", "43.0");

            WebDriver driver = new RemoteWebDriver(caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }



    public void setUpPage() {

    }
}
