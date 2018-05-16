package tests.ios;

import common.ios.Commons;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ios.HomePage;

import java.net.MalformedURLException;

public class SignUpTest extends Setup {



    Commons common ;
    HomePage homePage ;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        createIosSession(false);
        common = new Commons(driver);
        homePage = new HomePage(driver);
    }


    @Test
    public void signUpTest() throws Exception {
        // Write Code to Test SignUp
        common.signUp("newUserPhoneNumber", "OTP", "gender", "userName"
                , "homeAddress", "ReferralCode", "flatNum",
                      "officeAddress");

        String findRouteButtonText = homePage.getFindRouteButtonText();
        Assert.assertEquals(findRouteButtonText,"FIND A ROUTE");


    }
}


