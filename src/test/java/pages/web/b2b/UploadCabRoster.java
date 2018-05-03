package pages.web.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadCabRoster extends B2bSetup {


    private By employeesPlus = By.xpath("//ul[@class='text-uppercase']/li[4]");
    private By addrosterTab = By.xpath("//*[@id='roster-tab']/a");
    private By addcabroster = By.xpath("//span[@class='uploadFileBtn pointer' and @data-iscabroster='true']");
    private By clickOnSelectFile = By.xpath("//*[@id='csvUploadForm']/div[2]/span");
    private By uploadRoster = By.id("_file");
    private By showdetails = By.xpath("//div[@href='#cabRecommendations']/div[1]");
    private By ignorerec = By.xpath(".//*[@id='cabRecommendations']/div[2]");
    private By yestoignore = By.xpath(".//*[@id='ignore-recommendation-modal']/div/div/div[3]/button[2]");

    public UploadCabRoster(WebDriver driver)
    {
        this.driver= driver;
    }
    public void gotoEmployeesPlus()
    {
        WebElement element = driver.findElement(employeesPlus);
        System.out.println("This is Element to be Clickable :" + element);
        element.click();
    }

    public void clickOnAddRosterTab()
    {
        driver.findElement(addrosterTab).click();
    }

    public void clickOnAddCabRoster()
    {
        driver.findElement(addcabroster).click();
    }
    public void setClickOnSelectFile()
    {
        driver.findElement(clickOnSelectFile).click();

    }
    public void uploadRoster(String filePath)
    {
        driver.findElement(uploadRoster).sendKeys(filePath);

       // WebElement element = driver.findElement(By.id("_file"));
       // "/Users/admin/Downloads/escort jai (2).xlsx"
       // element.sendKeys(filePath);

    }
    public void showDetails()
    {
        driver.findElement(showdetails).click();
    }
    public void ignoreRec()
    {
       driver.findElement(ignorerec).click();
    }
    public void yesToIgnore()
    {
        driver.findElement(yestoignore).click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public By getEmployeesPlus() {
        return employeesPlus;
    }

    public void setEmployeesPlus(By employeesPlus) {
        this.employeesPlus = employeesPlus;
    }

    public By getAddrosterTab() {
        return addrosterTab;
    }

    public void setAddrosterTab(By addrosterTab) {
        this.addrosterTab = addrosterTab;
    }

    public By getAddcabroster() {
        return addcabroster;
    }

    public void setAddcabroster(By addcabroster) {
        this.addcabroster = addcabroster;
    }

    public By getClickOnSelectFile() {
        return clickOnSelectFile;
    }

    public void setClickOnSelectFile(By clickOnSelectFile) {
        this.clickOnSelectFile = clickOnSelectFile;
    }

    public By getUploadRoster() {
        return uploadRoster;
    }

    public void setUploadRoster(By uploadRoster) {
        this.uploadRoster = uploadRoster;
    }

    public By getShowdetails() {
        return showdetails;
    }

    public void setShowdetails(By showdetails) {
        this.showdetails = showdetails;
    }

    public By getIgnorerec() {
        return ignorerec;
    }

    public void setIgnorerec(By ignorerec) {
        this.ignorerec = ignorerec;
    }

    public By getYestoignore() {
        return yestoignore;
    }

    public void setYestoignore(By yestoignore) {
        this.yestoignore = yestoignore;
    }
}

