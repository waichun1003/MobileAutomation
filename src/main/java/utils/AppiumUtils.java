package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AppiumUtils {

    public static void waitForElementToBeVisible(WebElement ele, AppiumDriver driver) {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.visibilityOf((ele)));
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOf((ele)));
        }
    }

    public static void waitForElementToBeClickable(WebElement ele, AppiumDriver driver) {
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.elementToBeClickable((ele)));
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable((ele)));
        }
    }

    public static boolean isElementDisplayed(WebElement element, AppiumDriver driver){
        try {
            waitForElementToBeVisible(element, driver);
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }



    public static void waitAndClickOnElement(WebElement element, AppiumDriver driver){
        AppiumUtils.waitForElementToBeClickable(element, driver);
        element.click();
    }


    public static String getScreenshotPath(String testCaseName) throws IOException {
        File source = DriverUtils.getDriver().getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "/reports/"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }

    public static String getTestData(String key) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new File(System.getProperty("user.dir") + "/src/test/java/testData/testData.json"));
        return rootNode.path(key).asText();
    }
}
