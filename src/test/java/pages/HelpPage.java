package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelpPage extends BasePage{

    public HelpPage(WebDriver driver) {
        super(driver);
    }

    By FAQs= By.id("app.goplus.in.myapplication.qa:id/help.container");
    By call_custmomer_support_NCR=By.id("app.goplus.in.myapplication.qa:id/help.container");
}
