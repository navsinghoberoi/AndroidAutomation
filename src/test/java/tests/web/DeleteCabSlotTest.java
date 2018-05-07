package tests.web;

import org.testng.annotations.Test;
import pages.web.b2b.B2bSetup;
import pages.web.b2b.ViewCabTrips;
import tests.LoginPanelPageTest;

public class DeleteCabSlotTest extends B2bSetup {

    @Test
    public void deleteCabSlotTest()
    {
        LoginPanelPageTest loginpagetest = new LoginPanelPageTest();
        loginpagetest.verifyValidLogin();

        ViewCabTrips deletetrip = new ViewCabTrips();
        waitForVisibilityOf(deletetrip.getEmployeesPlus());
        deletetrip.clickOnEmployeePlus();
        waitForVisibilityOf(deletetrip.getViewCabTrips());
        deletetrip.clickOnViewCabTrips();
        waitForVisibilityOf(deletetrip.getDeleteTrip());
        deletetrip.deleteTrip();
        waitForVisibilityOf(deletetrip.getDeleteWarning());
        deletetrip.deleteWarningAccepted();

    }
}
