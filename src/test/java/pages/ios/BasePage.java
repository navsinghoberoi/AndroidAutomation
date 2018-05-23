package pages.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.ios.Setup;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class BasePage extends Setup {


    By allownotifications = By.xpath("//XCUIElementTypeButton[@name=\"Allow\"]\n");
    By dontAllownotifications = By.xpath("//XCUIElementTypeButton[@name=\"Don’t Allow\"]\n");

    String keyBoardReturnButton = "Return";

    public IOSDriver driver;

    public BasePage(IOSDriver driver)
    {
        this.driver = driver;
    }


    protected void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    protected void waitForClickabilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public void allowAppNotifications() {
        waitForVisibilityOf(allownotifications);
        driver.findElement(allownotifications).click();
    }

    public void dontAllowAppNotifications() {
        waitForVisibilityOf(dontAllownotifications);
        driver.findElement(dontAllownotifications).click();
    }


    public boolean swipeToDirection(MobileElement el, String direction) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            HashMap<String, String> swipeObject = new HashMap<String, String>();
            if (direction.equalsIgnoreCase("down")) {
                swipeObject.put("direction", "down");
            } else if (direction.equalsIgnoreCase("up")) {
                swipeObject.put("direction", "up");
            } else if (direction.equalsIgnoreCase("left")) {
                swipeObject.put("direction", "left");
            } else if (direction.equalsIgnoreCase("right")) {
                swipeObject.put("direction", "right");
            }
            swipeObject.put("element", el.getId());
            js.executeScript("mobile:swipe", swipeObject);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void hideKeyboard() {
        driver.findElementByAccessibilityId(keyBoardReturnButton).click();
    }


    public void takeScreenshot(String destinationFilePath) throws IOException {
        File scrFile = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(destinationFilePath));

    }


    public void deleteFileFromDirectory(String filePath) {
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("File Has Been Deleted");
        }
    }


    //   --------------------------      CHECK IMAGE DIFFERENCE     ----------------------------

    public boolean compareScreenshots(String expectedImagePath, String newImagePath) throws IOException {

        BufferedImage img1 = ImageIO.read(new File(expectedImagePath));
        BufferedImage img2 = ImageIO.read(new File(newImagePath));

        int width = img1.getWidth();
        int height = img1.getHeight();
        int width2 = img2.getWidth();
        int height2 = img2.getHeight();
        if (width != width2 || height != height2) {
            throw new IllegalArgumentException(String.format("Images must have the same dimensions: (%d,%d) vs. (%d,%d)", width, height, width2, height2));
        }

        long diff = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                diff += pixelDiff(img1.getRGB(x, y), img2.getRGB(x, y));
            }
        }
        long maxDiff = 3L * 255 * width * height;


        // If Difference Percentage > 3 then images are different
        double percentage = 100.0 * diff / maxDiff;
        System.out.println("Difference : " + percentage);
        if (percentage > 3.0)
            return false;
        else
            return true;
    }

    private int pixelDiff(int rgb1, int rgb2) {
        int r1 = (rgb1 >> 16) & 0xff;
        int g1 = (rgb1 >> 8) & 0xff;
        int b1 = rgb1 & 0xff;
        int r2 = (rgb2 >> 16) & 0xff;
        int g2 = (rgb2 >> 8) & 0xff;
        int b2 = rgb2 & 0xff;
        return Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
    }
}
