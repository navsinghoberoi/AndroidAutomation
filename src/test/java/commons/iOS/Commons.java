package commons.iOS;

import org.openqa.selenium.WebDriver;
import pages.iOS.BasePage;
import pages.iOS.SignUpLoginPage;

public class Commons extends BasePage {


    public Commons(WebDriver driver) {
        super(driver);
    }

    SignUpLoginPage signUpLoginPage = new SignUpLoginPage(driver);


    // Login Function
    public void login(String phoneNumberKey, String otpKey) throws Exception {
        signUpLoginPage.enterUserPhoneNumberOTP(phoneNumberKey, otpKey);
    }


    // Signup Function
    public void signUp(String userPhoneNumberKey, String otpKey,
                       String genderKey, String userNameKey, String homeAddressKey
            , String referralCode, String flatNumberKey, String officeAddressKey) throws Exception {
        signUpLoginPage.enterUserPhoneNumberOTP(userPhoneNumberKey, otpKey);
        signUpLoginPage.enterUserDetails(userNameKey, genderKey, referralCode);
        signUpLoginPage.enterHomeAddressDetailsNewUser(homeAddressKey, flatNumberKey);
        signUpLoginPage.enterOfficeAddressDetailsNewUser(officeAddressKey);
        allowAppNotifications();
        System.out.println("User has signed up successfully");

    }






}
