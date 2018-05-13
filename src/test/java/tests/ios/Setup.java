package tests.ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;


public class Setup {



        public IOSDriver driver = null;


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


        // noResert = True : Currrent Session
        // noResert = False : New Session
        public void createIosSession(boolean noReset) {


            try {
                File appDir = new File(getValueFromPPFile("iosFilePath"));
                File app = new File(appDir, getValueFromPPFile("iosFileName"));
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", getValueFromPPFile("platformName"));
                capabilities.setCapability("platformVersion", getValueFromPPFile("platformVersion"));
                capabilities.setCapability("deviceName", getValueFromPPFile("deviceName"));
                capabilities.setCapability("udid", getValueFromPPFile("udid"));
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("xcodeOrgId", getValueFromPPFile("xcodeOrgId"));
                capabilities.setCapability("xcodeSigningId", getValueFromPPFile("xcodeSigningId"));
                capabilities.setCapability("noReset", noReset);
                capabilities.setCapability("app", app.getAbsolutePath());
                //capabilities.setCapability("autoAcceptAlerts", true);
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }

