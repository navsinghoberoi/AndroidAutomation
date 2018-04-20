package tests.android;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.*;
import common.android.*;

public class ProfileTest extends Setup {

    private HomePage  homePage;
    private Commons common;
    private MenuPage menuPage;
    private ProfilePage profilePage;

    @BeforeClass
    public void setUp() {

        try
        {
            createAndroidSession(true);

            common = new Commons(driver);
            common.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
            common.enterPersonalDetailsNewUser();
            common.enterHomeAddressDetailsNewUser();
            common.enterOfficeAddressDetailsNewUser();

            common.goToHomepage();
            Thread.sleep(2000);


            homePage = new HomePage(driver);
            homePage.clickMenu();

            menuPage = new MenuPage(driver);
            menuPage.clickProfile();

            profilePage = new ProfilePage(driver);
        }
        catch(Exception e )
        {
            e.printStackTrace();
        }

    }


    @Test(priority = 1 , groups = {"New User"})
    public void verifyNewUserDefaultNumber() throws Exception {
        String Text = profilePage.getNumber();
        Assert.assertEquals(Text, "+91"+getValueFromPPFile("newUserPhoneNumber"));
    }

    @Test(priority = 2 , groups = {"New User"})
    public void verifyNewUserDefaultName() throws Exception {
        String Text = profilePage.getName();
        Assert.assertEquals(Text, getValueFromPPFile("userName"));
    }



    @Test(priority = 3 , groups = {"New User"})
    public void verifyNewUserDefaultProfilePicture() {
        String Text = profilePage.getProfileImage();
        System.out.println("Profile SRC : " + Text);
        Assert.assertEquals(Text, "Profile SRC");
    }



    @Test(priority = 4 , groups = {"New User"})
    public void verifyNewUserDefaultBirthday(){
        String Text = profilePage.getBirthday();
        System.out.println("Birthday : " + Text);
        Assert.assertEquals(Text, "");
    }


    @Test(priority = 5 , groups = {"New User"})
    public void verifyNewUserDefaultGender() throws Exception {
        String Text = profilePage.getGender();
        System.out.println("Gender : " + Text);

        if (getValueFromPPFile("gender").equalsIgnoreCase("F"))
            Assert.assertEquals(Text, "Female");
        else if (getValueFromPPFile("gender").equalsIgnoreCase("M"))
            Assert.assertEquals(Text, "Male");
    }


    @Test(priority = 6 , groups = {"New User"})
    public void verifyNewUserDefaultEmail(){
        String Text = profilePage.getEmail();
        System.out.println("Email : " + Text);
        Assert.assertEquals(Text, "");
    }


    @Test(priority = 7 , groups = {"New User"})
    public void verifyNewUserDefaultHomeAddress(){
        String Text = profilePage.getHomeAddress();
        System.out.println("Home Address : " + Text);
        Assert.assertEquals(Text, "Home Address");
    }


    @Test(priority = 8 , groups = {"New User"})
    public void verifyNewUserDefaultHomeLeaveTime(){
        String Text = profilePage.getHomeLeaveTime();
        System.out.println("Home Leave Time : " + Text);
        Assert.assertEquals(Text, "Home Leave Time");
    }


    @Test(priority = 9 , groups = {"New User"})
    public void verifyNewUserDefaultOfficeAddress() {
        String Text = profilePage.getOfficeAddress();
        System.out.println("Office Address : " + Text);
        Assert.assertEquals(Text, "Office Address");
    }


    @Test(priority = 10 , groups = {"New User"})
    public void verifyNewUserDefaulOfficeLeaveTime() {
        String Text = profilePage.getOfficeLeaveTime();
        System.out.println("Office Leave Time  : " + Text);
        Assert.assertEquals(Text, "Office Leave Time ");
    }


    @Test(priority = 11 , groups = {"New User"})
    public void verifyNewUserDefaultCorporateEmail(){
        String Text = profilePage.getCorporateEmail();
        System.out.println("Corporate Email : " + Text);
        Assert.assertEquals(Text, "Corporate Email");
    }



    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        System.out.println("Test cases completed");
        driver.quit();
    }


}
