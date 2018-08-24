package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TripRatingPage extends BasePage {

    By rateTripPageTitle = By.xpath(("//android.widget.TextView[@text='Rate Your Last Ride']"));
    By pickupPointName = By.id("pdwl.pick_up_name");
    By dropPointName = By.id("pdwl.drop_name");
    By ratingBar = By.id("ride_rating.rating_bar");
    By categoryNames = By.id("lirf.text");
    //  By categoryNames = By.id("ride_rating.options_list");
    By subcategoryNames = By.id("lirfsc.text");
    By ratingSubmitButton = By.id("ride_feedback.submit_button");
    By ratingPopupTitle = By.id("dsf.title");
    By ratingPopupMessage = By.id("dsf.message");
    By ratingPopupContinueButton = By.id("dsf.button");
    By additionalComments = By.id("ride_feedback.comment_input");

    public TripRatingPage(WebDriver driver) {
        super(driver);
    }


    public String getPageTitle() {
        waitForVisibilityOf(rateTripPageTitle);
        return driver.findElement(rateTripPageTitle).getText();
    }

    public String getPickupPointName() {
        waitForVisibilityOf(pickupPointName);
        return driver.findElement(pickupPointName).getText();
    }

    public String getDropPointName() {
        waitForVisibilityOf(dropPointName);
        return driver.findElement(dropPointName).getText();
    }

    public void selectRatingStars() {
        waitForVisibilityOf(ratingBar);
        // Check is raring bar enabled
        boolean isRatingEnabled = driver.findElement(ratingBar).isEnabled();
        if (isRatingEnabled) {
            driver.findElement(ratingBar).click();
        } else {
            System.out.println("Rating bar is not enabled");
        }
    }

    public void selectTripCategory(int index) {

        waitForVisibilityOf(categoryNames);
        int size = driver.findElements(categoryNames).size();
        for (int i = 0; i < size; i++) {
            String categoryName = driver.findElements(categoryNames).get(i).getText();
            System.out.println("Category Name " + (i + 1) + " is = " + categoryName);
        }
        driver.findElements(categoryNames).get(index).click();
    }

    public void selectTripSubcategory(int index) {

        waitForVisibilityOf(subcategoryNames);
        int size = driver.findElements(subcategoryNames).size();
        for (int i = 0; i < size; i++) {
            String subCategoryName = driver.findElements(subcategoryNames).get(i).getText();
            System.out.println("Subcategory Name " + (i + 1) + " is = " + subCategoryName);
        }
        driver.findElements(subcategoryNames).get(index).click();
    }

    public void submitTripRating() {
        waitForClickabilityOf(ratingSubmitButton);
        driver.findElement(ratingSubmitButton).click();
    }


    public boolean isSubmitTripRatingButtonDisplayed() {
        boolean isDisplayed;
        if (checkIfElementPresent(ratingSubmitButton, 10)) {
            System.out.println("Submit rating button is displayed");
            isDisplayed = true;
        } else {
            System.out.println("Submit rating button is NOT displayed");
            isDisplayed = false;
        }
        return isDisplayed;
    }


    public boolean isSubmitTripRatingButtonEnabled() {
        boolean isEnabled;
        if (checkIfElementPresent(ratingSubmitButton, 10)) {
            System.out.println("Submit rating button is enabled");
            isEnabled = driver.findElement(ratingSubmitButton).isEnabled();
        } else {
            System.out.println("Submit rating button is NOT enabled");
            isEnabled = false;
        }
        return isEnabled;
    }


    public String getSubmitRatingPopupTitle() {
        waitForVisibilityOf(ratingPopupTitle);
        return driver.findElement(ratingPopupTitle).getText();
    }


    public String getSubmitRatingPopupMessage() {
        waitForVisibilityOf(ratingPopupMessage);
        return driver.findElement(ratingPopupMessage).getText();
    }


    public String getSubmitRatingPopupCTAName() {
        waitForVisibilityOf(ratingPopupContinueButton);
        return driver.findElement(ratingPopupContinueButton).getText();
    }


    public void clickSubmitRatingPopupCTA() {
        waitForClickabilityOf(ratingPopupContinueButton);
        driver.findElement(ratingPopupContinueButton).click();
    }

    public void enterComments(String comment) {
        waitForClickabilityOf(additionalComments);
        driver.findElement(additionalComments).sendKeys(comment);
    }


}
