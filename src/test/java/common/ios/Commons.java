package common.ios;

import io.appium.java_client.ios.IOSDriver;
import pages.ios.BasePage;
import pages.ios.SignUpLoginPage;

import java.net.MalformedURLException;

public class Commons extends BasePage {


    SignUpLoginPage signUpLoginPage = new SignUpLoginPage(driver);

    public Commons(IOSDriver driver) throws MalformedURLException {
        super(driver);
    }


    public void login(String newUserPhoneNumberKey, String otpKey) throws Exception {

        signUpLoginPage.enterUserPhoneNumberOTP(newUserPhoneNumberKey, otpKey);
        try {

            // Allow Location Permission
            allowAppNotifications();
            // Allow App Notifications Permission
            allowAppNotifications();
        } catch (Exception e) {
        }
        System.out.println("User Has Logged In Successfully");



    }


    public void signUp(String newUserPhoneNumberKey, String otpKey,
                       String genderKey, String userNameKey, String homeAddressKey,
                       String referralCodeKey, String flatNumKey, String officeAddressKey) throws Exception {

        signUpLoginPage.enterUserPhoneNumberOTP(newUserPhoneNumberKey, otpKey);
        signUpLoginPage.enterUserDetails(userNameKey, genderKey, referralCodeKey);
        signUpLoginPage.enterHomeAddressDetailsNewUser(homeAddressKey, flatNumKey);
        signUpLoginPage.enterOfficeAddressDetailsNewUser(officeAddressKey);
        System.out.println("User Has Signed Up Successfully");




    }
}
