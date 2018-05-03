package common.android;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.android.*;

import java.io.*;
import java.net.MalformedURLException;
import java.util.List;

public class Commons extends BasePage {

    public Commons(WebDriver driver) throws MalformedURLException {
        super(driver);
    }

    private LandingPage landingPage = new LandingPage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private HomePage homePage = new HomePage(driver);
    private OtpPage otpPage = new OtpPage(driver);
    private HomeAddressPage homeAddressPage = new HomeAddressPage(driver);
    private OfficeAddressPage officeAddressPage = new OfficeAddressPage(driver);
    private PersonalDetailsPage personalDetails = new PersonalDetailsPage(driver);

    public void login() throws InterruptedException {
        Thread.sleep(5000);
        landingPage.clickSkipToLogin();
        //Thread.sleep(2000);
        loginPage.enterMobileNumber("9555814581");
        //loginPage.clickGetOtp();
        //loginPage.enterOtp("1111");
        loginPage.clickVerify();
        otpPage.enterOtp("2344");
        String Text = new HomePage(driver).getHeaderText();

    }

    public void goToHomepage() throws InterruptedException {
        if (!homePage.checkBuddyButton())
            login();
    }


    /* This method lets user login by specifying phonenumber and OTP*/
    public void enterUserPhoneNumberOTP(String phoneNumberKey, String otpKey) throws Exception {
        String userPhoneNumber = getValueFromPPFile(phoneNumberKey);
        String userOTP = getValueFromPPFile(otpKey);
        Thread.sleep(5000);
        landingPage.clickSkipToLogin();
        loginPage.enterMobileNumber(userPhoneNumber);
        loginPage.clickVerify();
        otpPage.enterOtp(userOTP);


    }


    public void enterUserDetails(String userNameKey, String genderKey) throws Exception {
        personalDetails.enterUserNameAtSignUp(getValueFromPPFile(userNameKey));
        personalDetails.selectGender(getValueFromPPFile(genderKey));
        personalDetails.personalDetailSubmitAtSignup();

    }

    public void enterHomeAddressDetailsNewUser(String homeAddressKey) throws Exception {
        String homeText = homeAddressPage.whereDoYouLiveText();
        homeAddressPage.selectHomeLocationClick();
        homeAddressPage.searchBarClick();
        homeAddressPage.enterHomeAddress(getValueFromPPFile(homeAddressKey));
        homeAddressPage.selectHomeAddress();   // Adding homeAddressPage by searching address
        homeAddressPage.useThisPlaceAddressText();
        homeAddressPage.selectLocationClick();
        /*homeAddressPage.flatNumSet(getValueFromPPFile("flatNum")); // Commenting for avoiding NPE on hidekeyboard
        androidDriver.hideKeyboard();*/
        homeAddressPage.homeAddressSubmit();
    }

    public void enterOfficeAddressDetailsNewUser() {
        officeAddressPage.whereDoYouWorkText();
        officeAddressPage.selectOfficeLocationClick();
        officeAddressPage.selectThisLocationClick();  // Adding officeAddressPage by using Select this location feature
        officeAddressPage.useThisPlaceAddressText();
        officeAddressPage.selectLocationClick();
        officeAddressPage.officeAddressSubmit();
    }


    public void signUp(String userPhoneNumberKey, String otpKey,
                       String genderKey, String userNameKey, String homeAddressKey) throws Exception {

        enterUserPhoneNumberOTP(userPhoneNumberKey, otpKey);
        enterUserDetails(userNameKey, genderKey);
        enterHomeAddressDetailsNewUser(homeAddressKey);
        enterOfficeAddressDetailsNewUser();
        System.out.println("User has signed up successfully");

    }



    public void clickSearchBar() {
        homePage.clickSearchBar();
    }

    public void closeSearchPopup() {
        homePage.closeSearchPopup();
    }


    public void clearTextField(By fieldLocator) {
        driver.findElement(fieldLocator).clear();
    }



    // ------------------------     CREATE TEXT FILE      -------------------------



    public void writeTextFile(String filePath , String lineText) throws IOException {
        File f = new File(filePath);
        FileUtils.write(f,lineText,true);
    }



    public List<String> readTextFileFromEnd(String filePath , int startLine , int endLine)
    {

        List<String> lines = null;
        try {

            LineIterator it = IOUtils.lineIterator(
                    new BufferedReader(new FileReader(filePath)));

            for (int i = startLine ; i < endLine ; i++)
                lines.add(it.next());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines ;
    }

}
