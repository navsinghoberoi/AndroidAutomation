package tests.iOS;

import commons.iOS.Commons;
import commons.iOS.SetUp;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignUpTest extends SetUp {



    Commons common ;

    @BeforeClass
    public void setUp() {
        createIosSession(false);
        common = new Commons(driver);
    }


    @Test
    public void firstTest() throws Exception {
        // Write Code to Test SignUp
        common.signUp("newUserPhoneNumber", "OTP", "gender", "userName"
                , "homeAddress", "ReferralCode", "flatNum",
                      "officeAddress");


    }
}


