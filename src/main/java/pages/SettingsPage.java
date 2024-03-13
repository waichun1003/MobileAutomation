package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.AppiumUtils;
import utils.MyLogger;

public class SettingsPage extends BasePage{

    MyLogger myLogger;

    public SettingsPage(MyLogger myLogger){
        this.myLogger = myLogger;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wallets']")
    WebElement walletsMenuOption;

    public void clickOnWalletsMenuOption(){
        AppiumUtils.waitAndClickOnElement(walletsMenuOption, driver);
    }
}
