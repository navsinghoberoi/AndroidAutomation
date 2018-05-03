package pages.web.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPanelPage extends B2bSetup {

    private By username = By.id("user-name");
    private By password = By.id("pwd");
    private By submitLogin = By.id("loginBtn");

    public LoginPanelPage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void typeUsername(String user_name)

    {
        driver.findElement(username).sendKeys(user_name);
    }

    public void typePassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void pressLoginButton() {
        driver.findElement(submitLogin).click();
    }
       /* public void launchBrowser()
        {
            System.setProperty("webdriver.chrome.driver", "/Users/admin/Desktop/chrome/chromedriver");
            driver = new ChromeDriver();
            BasePage basePage=new BasePage(driver);
            Dimension d = new Dimension(1424, 768);
            driver.manage().window().setSize(d);
            driver.get("https://qa-sso.goplus.in/login?targetUrl=http://qab2bui.goplus.in/home.html");
        }*/

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public By getUsername() {
        return username;
    }

    public void setUsername(By username) {
        this.username = username;
    }

    public By getPassword() {
        return password;
    }

    public void setPassword(By password) {
        this.password = password;
    }

    public By getSubmitLogin() {
        return submitLogin;
    }

    public void setSubmitLogin(By submitLogin) {
        this.submitLogin = submitLogin;
    }
}


