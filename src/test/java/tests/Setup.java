package tests;

import common.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Setup {

    public WebDriver driver = null;

    protected Properties loadPropertyFile() throws Exception {
        FileInputStream fileInput = new FileInputStream(new File(Constants.dataPropertiesFile));
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
        //capabilities.setCapability("device", "Android");

        //mandatory capabilities
        // capabilities.setCapability("deviceName","Samsung Galaxy S8 Plus GoogleAPI Emulator");
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("noReset", noreset );
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("launchApp", getValueFromPPFile("androidAppActivity"));
        capabilities.setCapability("appWaitActivity","app.goplus.in.myapplication.*");  // to handle multiple appActivity names
        capabilities.setCapability("app", app.getAbsolutePath());

        //capabilities.setCapability("app", "sauce-storage:app-qa-3.6.0-qa.apk");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        //driver = new AndroidDriver(new URL("http://nitishtest1991:11a0fed8-8611-471c-9f17-541f3bd68617@ondemand.saucelabs.com:80/wd/hub"), capabilities);

    }

}
