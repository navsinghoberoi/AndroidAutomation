package tests.ios;

import common.ios.Commons;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ios.Setup;
public class NewTest extends Setup {



    Commons common ;

    @BeforeClass
    public void set() {
        createIosSession(true);
      //  common = new Commons(driver);
    }


    @Test
    public void firstTest() throws Exception {
        Thread.sleep(10000);
        driver.findElementByAccessibilityId("SKIP TO LOGIN   ").click();
        Thread.sleep(3000);
        //driver.findElementByAccessibilityId("SKIP TO LOGIN").click();
        driver.findElementByAccessibilityId("WHY?");
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("WHY?").click();
        //driver.findElementByName("SKIP TO LOGIN");
       // driver.findElementByName("SKIP TO LOGIN").click();
        Thread.sleep(5000);
        driver.findElementByXPath("//XCUIElementTypeApplication[@name=\\\"Shuttl QA\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField").click();

        Thread.sleep(10000);

        //driver.findElementByIosUIAutomation()// Write Code to Test SignUp
        common.signUp("newUserPhoneNumber", "OTP", "gender", "userName"
                , "homeAddress", "ReferralCode", "flatNum",
                      "officeAddress");


    }
}


