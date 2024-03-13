package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.AppiumUtils;
import utils.MyLogger;

import java.io.IOException;

public class SetupPasscodePage extends BasePage{
    MyLogger myLogger;

    public SetupPasscodePage(MyLogger myLogger){
        this.myLogger = myLogger;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create passcode']")
    WebElement createPasscodeLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Confirm passcode']")
    WebElement confirmPasscodeLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter passcode']")
    WebElement enterPasscodeLabel;

    public void enterPasscode() throws InterruptedException, IOException {
        AppiumUtils.waitForElementToBeVisible(createPasscodeLabel, driver);
        String passcode = AppiumUtils.getTestData("passcode");
        for (int i = 0; i < passcode.length(); i++) {
            char currentChar = passcode.charAt(i);
            WebElement webElement = driver.findElement(By.xpath("//android.widget.TextView[@text=\""+currentChar+"\"]"));
            AppiumUtils.waitAndClickOnElement(webElement, driver);
        }
        myLogger.info("entered passcode "+passcode);
    }

    public void enterPasscodeForLogin() throws InterruptedException, IOException {
        AppiumUtils.waitForElementToBeVisible(enterPasscodeLabel, driver);
        String passcode = AppiumUtils.getTestData("confirmPasscode");
        for (int i = 0; i < passcode.length(); i++) {
            char currentChar = passcode.charAt(i);
            WebElement webElement = driver.findElement(By.xpath("//android.widget.TextView[@text=\""+currentChar+"\"]"));
            AppiumUtils.waitAndClickOnElement(webElement, driver);
        }
        myLogger.info("entered passcode "+passcode);
    }

    public void enterWrongPasscodeForLogin() throws InterruptedException, IOException {
        AppiumUtils.waitForElementToBeVisible(enterPasscodeLabel, driver);
        String passcode = AppiumUtils.getTestData("incorrectPasscode");
        for (int i = 0; i < passcode.length(); i++) {
            char currentChar = passcode.charAt(i);
            WebElement webElement = driver.findElement(By.xpath("//android.widget.TextView[@text=\""+currentChar+"\"]"));
            AppiumUtils.waitAndClickOnElement(webElement, driver);
        }
        myLogger.info("entered passcode "+passcode);
    }

    public void enterConfirmPasscode() throws IOException {
        AppiumUtils.waitForElementToBeVisible(confirmPasscodeLabel, driver);
        String passcode = AppiumUtils.getTestData("passcode");
        for (int i = 0; i < passcode.length(); i++) {
            char currentChar = passcode.charAt(i);
            WebElement webElement = driver.findElement(By.xpath("//android.widget.TextView[@text=\""+currentChar+"\"]"));
            AppiumUtils.waitAndClickOnElement(webElement, driver);

        }
        myLogger.info("entered confirm passcode "+passcode);
    }
}
