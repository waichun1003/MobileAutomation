package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.AppiumUtils;
import utils.MyLogger;

public class BackUpPage extends BasePage{
    MyLogger myLogger;

    public BackUpPage(MyLogger myLogger){
        this.myLogger = myLogger;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Back up manually']")
    WebElement backupManuallyButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Back up to Google Drive']")
    WebElement backupToGoogleDriveButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SKIP']")
    WebElement skipButton;

    public boolean isBackupManuallyButtonDisplayed(){
        return AppiumUtils.isElementDisplayed(backupManuallyButton, driver);
    }

    public boolean isBackupToGoogleDriveButtonDisplayed(){
        return AppiumUtils.isElementDisplayed(backupToGoogleDriveButton, driver);
    }

    public boolean isSkipButtonDisplayed(){
        return AppiumUtils.isElementDisplayed(skipButton, driver);
    }

    public void clickSkipButton() {
        AppiumUtils.waitAndClickOnElement(skipButton, driver);
        myLogger.info("Clicked Skip button");
    }
}
