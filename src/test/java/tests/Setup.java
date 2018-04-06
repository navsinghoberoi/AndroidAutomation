package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class Setup {
    public AndroidDriver driver;

    protected void prepareAndroidForAppium(boolean reset) throws MalformedURLException {
        File appDir = new File("/Users/nitish/Downloads");
        File app = new File(appDir, "app-release-3.6.0.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("noReset", reset);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("launchApp", "app.goplus.in.myapplication");


        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }


}
