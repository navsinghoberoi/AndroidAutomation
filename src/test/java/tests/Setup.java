package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.*;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class Setup {

    public AndroidDriver driver;

        // Method to load properties file
      protected Properties loadPropertyFile() throws Exception
    {
        FileInputStream fileInput = new FileInputStream(new File("src/Resources/data.properties"));
        Properties prop = new Properties();
        prop.load(fileInput);
        return prop;
    }

   protected String getValueFromPPFile(String key) throws Exception {
        String fileName = loadPropertyFile().getProperty(key);
        return fileName;
    }

    protected void prepareAndroidForAppium() throws Exception {

        Properties prop= loadPropertyFile();
        File appDir = new File(getValueFromPPFile("filePath"));
        File app = new File(appDir, getValueFromPPFile("fileName"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("noReset", true );
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("launchApp", getValueFromPPFile("appActivity"));

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }


}
