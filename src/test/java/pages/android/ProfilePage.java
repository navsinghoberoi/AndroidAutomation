package pages.android;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

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
	By officeAddress = By.id("profile_office_text");
	By officeLeaveTime = By.id("profile_office_edit_time");
	By corporateEmail = By.id("profile_connected_account_tv");
	By profileImageField = By.id("profile_picture");



	public String getProfileImage(){
		waitForVisibilityOf(profileImageField);
		String profileSRC =  driver.findElement(profileImageField).getText();
		WebElement element = driver.findElement(gender_button);
        scrollNewMethod(element);

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


	public void scrollDownAgain()
    {

        System.out.print("In ScrollAgain Method");
        WebElement profileElement = driver.findElement(profileImageField);
        WebElement email = driver.findElement(birthdayField);
        TouchAction touchAction = new TouchAction((MobileDriver) driver);
        touchAction.longPress(profileElement);
        touchAction.moveTo(email);
        touchAction.release();

        System.out.print("Leaving Method");
    }


    public void scrollNewMethod(WebElement element)
    {

            System.out.println("In ScrollNew Method");


            TouchActions action = new TouchActions(driver);
            action.scroll(element, 0, 200);

            System.out.println("Leaving Method");

    }

    public void getLocationOfElement(WebElement element)
    {

        System.out.println("X Location  : " + element.getLocation().getX());
        System.out.println("Y Location  : " + element.getLocation().getY());

        System.out.println("Height  : " + element.getSize());
    }


}


