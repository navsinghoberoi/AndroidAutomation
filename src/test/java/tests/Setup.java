package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.util.*;
import java.io.FileInputStream;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Setup {

    public WebDriver driver = null;

    protected Properties loadPropertyFile() throws Exception {
        FileInputStream fileInput = new FileInputStream(new File("src/Resources/data.properties"));
        Properties prop = new Properties();
        prop.load(fileInput);
        return prop;
    }

    protected String getValueFromPPFile(String key) throws Exception {
        String fileName = loadPropertyFile().getProperty(key);
        return fileName;
    }

    protected void createAndroidSession(boolean noreset) throws Exception {

        Properties prop = loadPropertyFile();
        File appDir = new File(getValueFromPPFile("androidFilePath"));
        File app = new File(appDir, getValueFromPPFile("androidFileName"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("noReset", noreset);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("launchApp", getValueFromPPFile("androidAppActivity"));
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }


    public void createIosSession() throws Exception {
        Properties prop = loadPropertyFile();
        File appDir = new File(getValueFromPPFile("iosFilePath"));
        File app = new File(appDir, getValueFromPPFile("iosFileName"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "8.2");
        capabilities.setCapability("deviceName", "iPhone 5s");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

    }


    public void createBrowserSession(String env) throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "src/Resources/chromedriver");
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

}
