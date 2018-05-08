package pages.web.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadCabRosterPage extends B2bSetup {


    private By employeesPlus = By.xpath("//ul[@class='text-uppercase']/li[4]");
    private By addRosterTab = By.xpath("//*[@id='roster-tab']/a");
    private By addCabRoster = By.xpath("//span[@class='uploadFileBtn pointer' and @data-iscabroster='true']");
    private By clickOnSelectFile = By.xpath("//*[@id='csvUploadForm']/div[2]/span");
    private By uploadRoster = By.id("_file");
    private By showDetails = By.xpath("//div[@href='#cabRecommendations']/div[1]");
    private By ignoreRec = By.xpath(".//*[@id='cabRecommendations']/div[2]");
    private By yesToIgnore = By.xpath(".//*[@id='ignore-recommendation-modal']/div/div/div[3]/button[2]");

    public void gotoEmployeesPlus()
    {
        WebElement element = driver.findElement(employeesPlus);
        element.click();
    }

    public void clickOnAddRosterTab()
    {
        driver.findElement(addRosterTab).click();
    }
    public void clickOnAddCabRoster()
    {
        driver.findElement(addCabRoster).click();
    }
    public void setClickOnSelectFile()
    {
        driver.findElement(clickOnSelectFile).click();

    }
    public void uploadRoster(String filePath)
    {
        driver.findElement(uploadRoster).sendKeys(filePath);

    }
    public void showDetails()
    {
        driver.findElement(showDetails).click();
    }
    public void ignoreRec()
    {
       driver.findElement(ignoreRec).click();
    }
    public void yesToIgnore()
    {
        driver.findElement(yesToIgnore).click();
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

    public By getAddRosterTab() {
        return addRosterTab;
    }

    public void setAddRosterTab(By addRosterTab) {
        this.addRosterTab = addRosterTab;
    }

    public By getAddCabRoster() {
        return addCabRoster;
    }

    public void setAddCabRoster(By addCabRoster) {
        this.addCabRoster = addCabRoster;
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

    public By getShowDetails() {
        return showDetails;
    }

    public void setShowDetails(By showDetails) {
        this.showDetails = showDetails;
    }

    public By getIgnoreRec() {
        return ignoreRec;
    }

    public void setIgnoreRec(By ignoreRec) {
        this.ignoreRec = ignoreRec;
    }

    public By getYesToIgnore() {
        return yesToIgnore;
    }

    public void setYesToIgnore(By yesToIgnore) {
        this.yesToIgnore = yesToIgnore;
    }
}

