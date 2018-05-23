package pages.web.b2b;
import org.openqa.selenium.By;

public class ViewCabTripsPage extends B2bSetup{

     private By employeesPlus = By.xpath("//ul[@class='text-uppercase']/li[4]");
     private By viewCabTrips = By.xpath("//*[@href='roster.html?ref=viewTrips']");
     private By deleteTrip = By.xpath("//*[@id='trip_0']/td[4]");
     private By deleteWarning = By.xpath("//button[@class='btn btn-danger']");
     private By viewSlotTime = By.xpath("//*[@id='trip_0']/td[2]/input");

     public void clickOnEmployeePlus()
     {
         driver.findElement(employeesPlus).click();
     }

     public void clickOnViewCabTrips()
     {
         driver.findElement(viewCabTrips).click();
     }

     public void deleteTrip()
     {
         driver.findElement(deleteTrip).click();
     }

    public void deleteWarningAccepted()
     {
         driver.findElement(deleteWarning).click();
     }


    public String getSlotTime()
    {
        return driver.findElement(viewSlotTime).getAttribute("value");
    }

    public By getEmployeesPlus() {
        return employeesPlus;
    }

    public void setEmployeesPlus(By employeesPlus) {
        this.employeesPlus = employeesPlus;
    }

    public By getViewCabTrips() {
        return viewCabTrips;
    }

    public void setViewCabTrips(By viewCabTrips) {
        this.viewCabTrips = viewCabTrips;
    }

    public By getDeleteTrip() {
        return deleteTrip;
    }

    public void setDeleteTrip(By deleteTrip) {
        this.deleteTrip = deleteTrip;
    }

    public By getDeleteWarning() {
        return deleteWarning;
    }

    public void setDeleteWarning(By deleteWarning) {
        this.deleteWarning = deleteWarning;
    }

    public By getViewSlotTime() {
        return viewSlotTime;
    }

    public void setViewSlotTime(By viewSlotTime) {
        this.viewSlotTime = viewSlotTime;
    }
}