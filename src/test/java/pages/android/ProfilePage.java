package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	By edit_button = By.id("action_edit_profile");
	By gender_button = By.id("profile_gender_text");



	public String getGenderText() {
		waitForVisibilityOf(gender_button);
		String GenderText =  driver.findElement(gender_button).getText();
		return GenderText;
	}



	public boolean checkEditButton() {
		if (checkIfElementPresent(edit_button))
		return true;
		else
			return false;

	}


}

