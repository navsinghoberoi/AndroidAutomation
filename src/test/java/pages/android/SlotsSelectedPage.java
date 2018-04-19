package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SlotsSelectedPage extends BasePage {

	public SlotsSelectedPage(WebDriver driver) {
		super(driver);
	}

	By book_button = By.id(app_package_name + "booking_btn_book");

public void clickBook() {
	waitForClickabilityOf(book_button);
	driver.findElement(book_button).click();
}
}