package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.AppiumUtils;
import utils.MyLogger;

public class WalletsPage extends BasePage{

    MyLogger myLogger;

    public WalletsPage(MyLogger myLogger){
        this.myLogger = myLogger;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wallets']")
    WebElement walletsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Main Wallet 1']")
    WebElement mainWalletFirst;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wallets']/following-sibling::android.widget.Button")
    WebElement addNewWalletIcon;

    public boolean isWalletPageDisplayed(){
        return AppiumUtils.isElementDisplayed(walletsTitle, driver);
    }

    public boolean isFirstMainWalletDisplayed(){
        return AppiumUtils.isElementDisplayed(mainWalletFirst, driver);
    }

    public void clickOnAddNewWalletIcon(){
        AppiumUtils.waitAndClickOnElement(addNewWalletIcon, driver);
    }

    public void clickOnFirstMainWallet(){
        AppiumUtils.waitAndClickOnElement(mainWalletFirst, driver);
    }
}
