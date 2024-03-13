package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.AppiumUtils;
import utils.MyLogger;

public class GetStartedPage extends BasePage{

    MyLogger myLogger;

    public GetStartedPage(MyLogger myLogger){
        this.myLogger = myLogger;
    }

    @AndroidFindBy(xpath = "//android.widget.Button")
    WebElement getStartedButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create new wallet']")
    WebElement createNewWalletButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add existing wallet']")
    WebElement addExistingWalletButton;

    public void clickGetStarted() {
        AppiumUtils.waitAndClickOnElement(getStartedButton, driver);
        myLogger.info("Clicked Get Started button");
    }

    public boolean isCreateNewWalletButtonDisplayed(){
        return AppiumUtils.isElementDisplayed(createNewWalletButton, driver);
    }

    public boolean isAddExistingWalletButtonDisplayed(){
        return AppiumUtils.isElementDisplayed(addExistingWalletButton, driver);
    }

    public void clickCreateNewWalletButton() {
        AppiumUtils.waitAndClickOnElement(createNewWalletButton, driver);
        myLogger.info("Clicked Create New Wallet button");
    }
}
