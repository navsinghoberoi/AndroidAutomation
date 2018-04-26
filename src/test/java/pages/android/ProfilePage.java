package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }


    By edit_button = By.id("action_edit_profile");
    By gender_button = By.id("edit_profile_gender");
    By nameField = By.id("profile_name");
    By mobileNumberField = By.xpath("//android.widget.TextView[contains(@resource-id,'profile_number')]");
    By birthdayField = By.id("edit_profile_birthday");
    By emailField = By.id("edit_profile_email");
    By homeAddressField = By.id("profile_home_edit_text");
    By homeLeaveTime = By.id("profile_home_time_user");
    By officeAddress = By.id("profile_office_edit_text");
    By officeLeaveTime = By.id("profile_office_edit_time");
    By corporateEmail = By.id("profile_connected_account_tv");
    By profileImageField = By.id("profile_picture");


    public String getProfileImage() {
        waitForVisibilityOf(profileImageField);
        String profileSRC = driver.findElement(profileImageField).getText();
        return profileSRC;
    }

    public String getGender() {
        waitForVisibilityOf(gender_button);
        String GenderText = driver.findElement(gender_button).getText();
        return GenderText;
    }


    public String getNumber() {
        waitForVisibilityOf(mobileNumberField);
        String userNumber = driver.findElement(mobileNumberField).getText();
        return userNumber;
    }


    public String getName() {
        waitForVisibilityOf(nameField);
        String userName = driver.findElement(nameField).getText();
        return userName;
    }


    public String getEmail() {
        waitForVisibilityOf(emailField);
        String email = driver.findElement(emailField).getText();
        return email;
    }


    public String getBirthday() {
        waitForVisibilityOf(birthdayField);
        String userBirthday = driver.findElement(birthdayField).getText();
        return userBirthday;
    }


    public String getHomeAddress() {
        waitForVisibilityOf(homeAddressField);
        String address = driver.findElement(homeAddressField).getText();
        return address;
    }


    public String getHomeLeaveTime() {
        waitForVisibilityOf(homeLeaveTime);
        String leaveTime = driver.findElement(homeLeaveTime).getText();
        return leaveTime;
    }


    public String getOfficeAddress() {
        waitForVisibilityOf(officeAddress);
        String address = driver.findElement(officeAddress).getText();
        return address;
    }


    public String getOfficeLeaveTime() {
        waitForVisibilityOf(officeLeaveTime);
        String leaveTime = driver.findElement(officeLeaveTime).getText();
        return leaveTime;
    }


    public String getCorporateEmail() {
        waitForVisibilityOf(corporateEmail);
        String corpoEmail = driver.findElement(corporateEmail).getText();
        return corpoEmail;
    }


    public boolean checkEditButton() {
        if (checkIfElementPresent(edit_button)) {
            driver.findElement(edit_button).click();
            return true;
        } else
            return false;

    }


}


