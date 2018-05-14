package pages.web.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TripReportPage extends B2bSetup {


   private By busReportTab = By.xpath("//*[@id='reports-tab']/a");
   private By busReportStartDateInput = By.xpath("//*[@id='startPicker']/input");
   private By busReportEndDateInput = By.xpath(".//*[@id='endPicker']/input");
   private By trips = By.xpath(".//*[@value='TRIPS']");
   private By getReport = By.xpath(".//*[@id='getReport']");
   private By visibilityOfDownloadReport = By.xpath("//a[@class='reportLinkBtn']");
   private By cabReportTab = By.xpath("//a[@data-type='cab']");
   private By bookings = By.xpath(".//*[@value='BOOKINGS']");


    public void goTOReportTab()
    {
        WebElement element = driver.findElement(busReportTab);
        element.click();
    }

    public void goToCabReportTab()
    {
        WebElement element = driver.findElement(cabReportTab);
        element.click();
    }
    public void enterStartDate(String startDate)
   {
       driver.findElement(busReportStartDateInput).sendKeys(startDate);
    }
    public void enterEndDate()
    {
        WebElement element = driver.findElement(busReportEndDateInput);
        element.click();
    }
    public void enterEndDate(String endDate)
    {
        driver.findElement(busReportEndDateInput).sendKeys(endDate);
    }
    public void selectTrips()
    {
        WebElement element = driver.findElement(trips);
        element.click();
    }
    public void selectBookings()
    {
        WebElement element = driver.findElement(bookings);
        element.click();
        boolean text = driver.findElement(bookings).isDisplayed();
        System.out.print(text);
    }

    public void getReport()
    {
        WebElement element = driver.findElement(getReport);
        element.click();
    }
//    public String downloadReport()
//    {
//        WebElement element = driver.findElement(downloadReport);
//        return element.getText();
//    }

    public String visibilityOfDownloadReport()
    {
        WebElement element = driver.findElement(visibilityOfDownloadReport);
        return element.getAttribute("class");
    }


    public By getBusReportTab() {
        return busReportTab;
    }

    public void setBusReportTab(By busReportTab) {
        this.busReportTab = busReportTab;
    }

    public By getCabReportTab() {
        return cabReportTab;
    }

    public void setCabReportTab(By cabReportTab) {
        this.cabReportTab = cabReportTab;
    }

    public By getBusReportStartDateInput() {
        return busReportStartDateInput;
    }

    public void setBusReportStartDateInput(By busReportStartDateInput) {
        this.busReportStartDateInput = busReportStartDateInput;
    }

    public By getBusReportEndDateInput() {
        return busReportEndDateInput;
    }

    public void setBusReportEndDateInput(By busReportEndDateInput) {
        this.busReportEndDateInput = busReportEndDateInput;
    }

    public By getTrips() {
        return trips;
    }

    public void setTrips(By trips) {
        this.trips = trips;
    }

    public By getBookings() {
        return bookings;
    }

    public void setBookings(By bookings) {
        this.bookings = bookings;
    }

    public By getGetReport() {
        return getReport;
    }

    public void setGetReport(By getReport) {
        this.getReport = getReport;
    }

    public By getVisibilityOfDownloadReport() {
        return visibilityOfDownloadReport;
    }

    public void setVisibilityOfDownloadReport(By visibilityOfDownloadReport) {
        this.visibilityOfDownloadReport = visibilityOfDownloadReport;
    }
}
