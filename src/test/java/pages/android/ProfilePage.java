package pages.android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}


	By edit_button = By.id("action_edit_profile");
	By gender_button = By.id("app.goplus.in.myapplication.qa:id/edit_profile_gender");
	By nameField = By.id("app.goplus.in.myapplication.qa:id/profile_name");
	By mobileNumberField = By.xpath("//android.widget.TextView[contains(@resource-id,'profile_number')]");
	By birthdayField = By.id("app.goplus.in.myapplication.qa:id/edit_profile_birthday");
	By emailField = By.id("app.goplus.in.myapplication.qa:id/edit_profile_email");
	By homeAddressField = By.id("app.goplus.in.myapplication.qa:id/profile_home_edit_text");
	By homeLeaveTime = By.id("app.goplus.in.myapplication.qa:id/profile_home_time_user");
	By officeAddress = By.id("app.goplus.in.myapplication.qa:id/profile_office_text");
	By officeLeaveTime = By.id("app.goplus.in.myapplication.qa:id/profile_office_edit_time");
	By corporateEmail = By.id("app.goplus.in.myapplication.qa:id/profile_connected_account_tv");
	By profileImageField = By.id("app.goplus.in.myapplication.qa:id/profile_picture");



	public String getProfileImage(){
		waitForVisibilityOf(profileImageField);
		String profileSRC =  driver.findElement(profileImageField).getText();
		scrollDown();
		return profileSRC;
	}

	public String getGender() {
		waitForVisibilityOf(gender_button);
		String GenderText =  driver.findElement(gender_button).getText();
		return GenderText;
	}


	public String getNumber() {
		waitForVisibilityOf(mobileNumberField);
		String userNumber =  driver.findElement(mobileNumberField).getText();
		return userNumber;
	}


	public String getName() {
		waitForVisibilityOf(nameField);
		String userName =  driver.findElement(nameField).getText();
		return userName;
	}


	public String getEmail() {
		waitForVisibilityOf(emailField);
		String email =  driver.findElement(emailField).getText();
		return email;
	}


	public String getBirthday() {
		waitForVisibilityOf(birthdayField);
		String userBirthday =  driver.findElement(birthdayField).getText();
		return userBirthday;
	}


	public String getHomeAddress(){
		waitForVisibilityOf(homeAddressField);
		String address =  driver.findElement(homeAddressField).getText();
		return address;
	}


	public String getHomeLeaveTime(){
		waitForVisibilityOf(homeLeaveTime);
		String leaveTime =  driver.findElement(homeLeaveTime).getText();
		return leaveTime;
	}


	public String getOfficeAddress(){
		waitForVisibilityOf(officeAddress);
		String address =  driver.findElement(officeAddress).getText();
		return address;
	}


	public String getOfficeLeaveTime(){
		waitForVisibilityOf(officeLeaveTime);
		String leaveTime =  driver.findElement(officeLeaveTime).getText();
		return leaveTime;
	}


	public String getCorporateEmail(){
		waitForVisibilityOf(corporateEmail);
		String corpoEmail =  driver.findElement(corporateEmail).getText();
		return corpoEmail;
	}


	public boolean checkEditButton() {
		if (checkIfElementPresent(edit_button))
			return true;
		else
			return false;

	}


	public void scrollDown()
	{

		String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/profile_name\")";
		System.out.println("I am here");
		String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/profile_home_edit_text\")";
		System.out.println("I am here");System.out.println("I am here");

		WebElement abc = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
				".scrollIntoView(" + neededElement_finder + ")"));
		System.out.println("I am here");
	}


}


