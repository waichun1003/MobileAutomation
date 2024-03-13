package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.AppiumUtils;
import utils.MyLogger;

import java.io.IOException;

public class HomePage extends BasePage {

    MyLogger myLogger;

    public HomePage(MyLogger myLogger){
        this.myLogger = myLogger;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    WebElement homePageTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Welcome aboard']")
    WebElement welcomeAboardTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Start using Trust Wallet']")
    WebElement startUsingTrustWalletButton;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    WebElement searchBar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Home\"]/preceding-sibling::android.widget.Button")
    WebElement settingsIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Main Wallet 2']")
    WebElement mainWallerSecond;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Main Wallet 1']")
    WebElement mainWallerFirst;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='main_balance']")
    WebElement mainBalance;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='$0.00']")
    WebElement mainBalanceAmount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='●●●●●']")
    WebElement mainBalanceHiddenAmount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Send\"]")
    WebElement sendButton;

    @AndroidFindBy(xpath = "//android.view.View/following-sibling::android.widget.TextView[@text=\"Send\"]")
    WebElement sendPageTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Send\"]/preceding-sibling::android.view.View")
    WebElement backButtonOnSendPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Receive\"]")
    WebElement receiveButton;

    @AndroidFindBy(xpath = "//android.view.View/following-sibling::android.widget.TextView[@text=\"Receive\"]")
    WebElement receivePageTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Receive\"]/preceding-sibling::android.view.View")
    WebElement backButtonOnReceivePage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Buy\"]")
    WebElement buyButton;

    @AndroidFindBy(xpath = "//android.view.View/following-sibling::android.widget.TextView[@text=\"Buy\"]")
    WebElement buyPageTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Buy\"]/preceding-sibling::android.view.View")
    WebElement backButtonOnBuyPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sell\"]")
    WebElement sellButton;

    @AndroidFindBy(xpath = "//android.view.View/following-sibling::android.widget.TextView[@text=\"Sell\"]")
    WebElement sellPageTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sell\"]/preceding-sibling::android.view.View")
    WebElement backButtonOnSellPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Swap\"]")
    WebElement swapButton;

    @AndroidFindBy(xpath = "//android.widget.Button/preceding-sibling::android.widget.TextView[@text=\"Swap\"]")
    WebElement swapPageTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Earn\"]")
    WebElement earnButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Earn\"]")
    WebElement earnPageTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Discover\"]")
    WebElement discoverButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Discover\"]")
    WebElement discoverPageTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Browser\"]")
    WebElement browserButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Browser\"]")
    WebElement browserPageTitle;

    public boolean isHomePageTitleDisplayed(){
        return AppiumUtils.isElementDisplayed(homePageTitle, driver);
    }

    public boolean isWelcomePopupDisplayed(){
        return AppiumUtils.isElementDisplayed(welcomeAboardTitle, driver);
    }

    public void clickOnStartUsingTrustWalletButton(){
        AppiumUtils.waitAndClickOnElement(startUsingTrustWalletButton, driver);
        myLogger.info("Clicked Start using trust wallet button");
    }

    public void enterSearchKeyword() throws IOException {
        AppiumUtils.waitForElementToBeVisible(searchBar, driver);
        String keyword = AppiumUtils.getTestData("searchKeyword");
        searchBar.click();
        searchBar.sendKeys(keyword);
        myLogger.info("entered search keyword "+ keyword);
    }

    public boolean isFirstResultDisplayedForSearchedKeyword() throws IOException {
        return AppiumUtils.isElementDisplayed(driver.findElement(By.xpath("//android.view.View[1]/android.widget.TextView[@text=\""+AppiumUtils.getTestData("searchKeyword")+"\"]")), driver);
    }

    public void clickOnSearchedKeyword() throws IOException {
        AppiumUtils.waitAndClickOnElement(driver.findElement(By.xpath("//android.view.View[1]/android.widget.TextView[@text=\""+AppiumUtils.getTestData("searchKeyword")+"\"]")), driver);
    }

    public void clickOnSettingsIcon(){
        AppiumUtils.waitAndClickOnElement(settingsIcon, driver);
    }

    public void clickOnSecondMainWallet(){
        AppiumUtils.waitAndClickOnElement(mainWallerSecond, driver);
    }

    public void clickOnMainBalance(){
        AppiumUtils.waitAndClickOnElement(mainBalance, driver);
    }

    public boolean isSecondMainWalletDisplayed(){
        return AppiumUtils.isElementDisplayed(mainWallerSecond, driver);
    }

    public boolean isFirstMainWalletDisplayed(){
        return AppiumUtils.isElementDisplayed(mainWallerFirst, driver);
    }

    public boolean isMainBalanceAmountDisplayed(){
        return AppiumUtils.isElementDisplayed(mainBalanceAmount, driver);
    }

    public boolean isMainBalanceHiddenAmountDisplayed(){
        return AppiumUtils.isElementDisplayed(mainBalanceHiddenAmount, driver);
    }

    public void clickOnSendButton(){
        AppiumUtils.waitAndClickOnElement(sendButton, driver);
    }
    public void clickOnReceiveButton(){
        AppiumUtils.waitAndClickOnElement(receiveButton, driver);
    }
    public void clickOnBuyButton(){
        AppiumUtils.waitAndClickOnElement(buyButton, driver);
    }
    public void clickOnSellButton(){
        AppiumUtils.waitAndClickOnElement(sellButton, driver);
    }

    public boolean isSendPageTitleDisplayed(){
        return AppiumUtils.isElementDisplayed(sendPageTitle, driver);
    }
    public boolean isReceivePageTitleDisplayed(){
        return AppiumUtils.isElementDisplayed(receivePageTitle, driver);
    }
    public boolean isBuyPageTitleDisplayed(){
        return AppiumUtils.isElementDisplayed(buyPageTitle, driver);
    }
    public boolean isSellPageTitleDisplayed(){
        return AppiumUtils.isElementDisplayed(sellPageTitle, driver);
    }

    public void clickOnBackButtonOnSendPage(){
        AppiumUtils.waitAndClickOnElement(backButtonOnSendPage, driver);
    }
    public void clickOnBackButtonOnReceivePage(){
        AppiumUtils.waitAndClickOnElement(backButtonOnReceivePage, driver);
    }
    public void clickOnBackButtonOnSellPage(){
        AppiumUtils.waitAndClickOnElement(backButtonOnSellPage, driver);
    }
    public void clickOnBackButtonOnBuyPage(){
        AppiumUtils.waitAndClickOnElement(backButtonOnBuyPage, driver);
    }


    public void clickOnSwapButton(){
        AppiumUtils.waitAndClickOnElement(swapButton, driver);
    }
    public void clickOnEarnButton(){
        AppiumUtils.waitAndClickOnElement(earnButton, driver);
    }
    public void clickOnDiscoverButton(){
        AppiumUtils.waitAndClickOnElement(discoverButton, driver);
    }
    public void clickOnBrowserButton(){
        AppiumUtils.waitAndClickOnElement(browserButton, driver);
    }

    public boolean isSwapPageTitleDisplayed(){
        return AppiumUtils.isElementDisplayed(swapPageTitle, driver);
    }
    public boolean isEarnPageTitleDisplayed(){
        return AppiumUtils.isElementDisplayed(earnPageTitle, driver);
    }
    public boolean isDiscoverPageTitleDisplayed(){
        return AppiumUtils.isElementDisplayed(discoverPageTitle, driver);
    }
    public boolean isBrowserPageTitleDisplayed(){
        return AppiumUtils.isElementDisplayed(browserPageTitle, driver);
    }
}
