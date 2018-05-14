package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {


    // ByAccessibilityId
    String findRoute = "FIND A ROUTE";


    public HomePage(IOSDriver driver) {
        super(driver);
    }


    public String getFindRouteButtonText() {
        WebElement element = driver.findElementByAccessibilityId(findRoute);
        return element.getText();

    }
}
