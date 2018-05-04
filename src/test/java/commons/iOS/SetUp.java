package commons.iOS;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class SetUp {


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


    public void createIosSession() throws Exception {
        File appDir = new File(getValueFromPPFile("iosFilePath"));
        File app = new File(appDir, getValueFromPPFile("iosFileName"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName" , getValueFromPPFile("platformName"));
        capabilities.setCapability("platformVersion" , getValueFromPPFile("platformVersion"));
        capabilities.setCapability("deviceName ", getValueFromPPFile("deviceName"));
        capabilities.setCapability("udid" , getValueFromPPFile("udid"));
        capabilities.setCapability("xcodeOrgId" , getValueFromPPFile("xcodeOrgId"));
        capabilities.setCapability("xcodeSigningId" , getValueFromPPFile("xcodeSigningId"));
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

}
