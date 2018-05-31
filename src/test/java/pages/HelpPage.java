package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelpPage extends BasePage{


    public HelpPage(WebDriver driver) {
        super(driver);
    }

    By FAQS= By.id(app_package_name+"help.container");
    //inside FAQS
    By what_is_subscription=By.xpath("//android.widget.LinearLayout[@index='0']");
    By what_is_auto_booking_sub=By.xpath("//android.widget.LinearLayout[@index='1']");
    By text_inside_questions=By.id(app_package_name+"fa.answer");
    By what_is_pay_per_ride=By.xpath("//android.widget.LinearLayout[@index='2']");
    By one_way_two_way=By.xpath("//android.widget.LinearLayout[@index='3']");
    By eat_inside_shuttl=By.xpath("//android.widget.LinearLayout[@index='4']");
    By what_is_shuttl_service_and_shuttl=By.xpath("//android.widget.LinearLayout[@index='5']");
    By what_is_shuttl_service=By.xpath("//android.widget.LinearLayout[@index='6']");
    By not_getting_shuttl_credits=By.xpath("//android.widget.LinearLayout[@index='7']");
    By call_us_button=By.id(app_package_name+"faq.need_help");
    //------------
    By call_customer_care_NCR=By.xpath("//android.widget.LinearLayout[@index='1']");
    By number_NCR=By.className("android.widget.EditText");
    By call_customer_care_kolkata=By.xpath("//android.widget.LinearLayout[@index='2']");
    By number_kolkata=By.className("android.widget.EditText");
    By email_us=By.xpath("//android.widget.LinearLayout[@index='3']");
    By gmail_to=By.className("android.widget.MultiAutoCompleteTextView");
    By we_are_hiring=By.xpath("//android.widget.LinearLayout[@index='4']");
    By open_positions=By.xpath("//android.view.View[@index='1']");
    By terms_and_conditions=By.id(app_package_name+"terms_conditions");
    By title_terms_and_conditions=By.className("android.widget.TextView");
    By please_wait_popup=By.id(app_package_name+"body");


    public void clickFAQS()
    {
        waitForClickabilityOf(FAQS);
        driver.findElement(FAQS).click();

    }

    public void clickCallCustomerCareNCR()
    {
        waitForClickabilityOf(call_customer_care_NCR);
        driver.findElement(call_customer_care_NCR).click();

    }

    public void clickCallCustomerCareKolkata()
    {
        waitForClickabilityOf(call_customer_care_kolkata);
        driver.findElement(call_customer_care_kolkata).click();

    }

    public void clickEmailUs()
    {
        waitForClickabilityOf(email_us);
        driver.findElement(email_us).click();

    }
    public void clickweAreHiring()
    {
        waitForClickabilityOf(we_are_hiring);
        driver.findElement(we_are_hiring).click();

    }

    public void clickTermsAndConditions()
    {
        waitForClickabilityOf(terms_and_conditions);
        driver.findElement(terms_and_conditions).click();
    }

    public void clickWhatIsSubscription()
    {
        waitForClickabilityOf(what_is_subscription);
        driver.findElement(what_is_subscription).click();
    }

    public void clickWhatIsAutoBookingSub()
    {
        waitForClickabilityOf(what_is_auto_booking_sub);
        driver.findElement(what_is_auto_booking_sub).click();
    }

    public void clickWhatIsPayPerRide()
    {
        waitForClickabilityOf(what_is_pay_per_ride);
        driver.findElement(what_is_pay_per_ride).click();
    }

    public void clickOneWayTwoWay()
    {
        waitForClickabilityOf(one_way_two_way);
        driver.findElement(one_way_two_way).click();
    }

    public void clickEatInsideShuttl()
    {
        waitForClickabilityOf(eat_inside_shuttl);
        driver.findElement(eat_inside_shuttl).click();
    }

    public void clickWhatIsShuttlServiceAndShuttl()
    {
        waitForClickabilityOf(what_is_shuttl_service_and_shuttl);
        driver.findElement(what_is_shuttl_service_and_shuttl).click();
    }

    public void clickWhatIsShuttlService()
    {
        waitForClickabilityOf(what_is_shuttl_service);
        driver.findElement(what_is_shuttl_service).click();
    }

    public void clickNotGettingShuttlCredits()
    {
        waitForClickabilityOf(not_getting_shuttl_credits);
        driver.findElement(not_getting_shuttl_credits).click();
    }

    public void clickCallUsButton()
    {
        waitForClickabilityOf(call_us_button);
        driver.findElement(call_us_button).click();
    }

    public String getNumberOfNCR()
    {
        waitForVisibilityOf(number_NCR);
        return driver.findElement(number_NCR).getText();
    }

    public String getNumberOfKolkata()
    {
        waitForVisibilityOf(number_kolkata);
        return driver.findElement(number_kolkata).getText();
    }

    public String getToOfEmailUs()
    {
        waitForVisibilityOf(gmail_to);
        return driver.findElement(gmail_to).getText();
    }

    public boolean openPositions()
    {
        waitForVisibilityOf(open_positions);
        return driver.findElement(open_positions).isDisplayed();
    }

    public String titleDisplayedOfTermsAndConditions()
    {
        waitForVisibilityOf(title_terms_and_conditions);
        return driver.findElement(title_terms_and_conditions).getText();
    }

    public int textInsideQuestions()
    {
        String text=driver.findElement(text_inside_questions).getText();
        return text.length();
    }

}
