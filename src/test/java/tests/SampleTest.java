package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;

import static utils.DriverUtils.restartApp;

public class SampleTest extends BaseTest {

    @Test(description = "[Positive] Verify user is able to set up Passcode for Create new wallet")
    public void verifyPasscodeSetupForCreateNewWallet() throws InterruptedException, IOException {
        getStartedPage.clickGetStarted();
        assertionTrue(getStartedPage.isCreateNewWalletButtonDisplayed(), "Create new wallet button is displayed", myLogger);
        assertionTrue(getStartedPage.isAddExistingWalletButtonDisplayed(), "Add existing wallet button is displayed", myLogger);
        getStartedPage.clickCreateNewWalletButton();
        assertionTrue(backUpPage.isBackupManuallyButtonDisplayed(), "Backup Manually button is displayed", myLogger);
        assertionTrue(backUpPage.isBackupToGoogleDriveButtonDisplayed(), "Backup to Google Drive button is displayed", myLogger);
        assertionTrue(backUpPage.isSkipButtonDisplayed(), "Skip button is displayed", myLogger);
        backUpPage.clickSkipButton();
        setupPasscodePage.enterPasscode();
        setupPasscodePage.enterConfirmPasscode();
        assertionTrue(homePage.isWelcomePopupDisplayed(), "Welcome Popup is displayed", myLogger);
        homePage.clickOnStartUsingTrustWalletButton();
        assertionTrue(homePage.isHomePageTitleDisplayed(), "Home Page is displayed", myLogger);
    }

    @Test(description = "[Positive] Verify user is able to log in")
    public void verifyUserIsAbleToLoginToTheAccount() throws InterruptedException, IOException {
        getStartedPage.clickGetStarted();
        getStartedPage.clickCreateNewWalletButton();
        backUpPage.clickSkipButton();
        setupPasscodePage.enterPasscode();
        setupPasscodePage.enterConfirmPasscode();
        homePage.clickOnStartUsingTrustWalletButton();
        assertionTrue(homePage.isHomePageTitleDisplayed(), "Home Page is displayed", myLogger);
        restartApp();
        setupPasscodePage.enterPasscodeForLogin();
        assertionTrue(homePage.isHomePageTitleDisplayed(), "Home Page is displayed", myLogger);
    }

    @Test(description = "[Negative] Verify user is not able to log in if wrong passcode entered")
    public void verifyUserIsNotAbleToLoginToTheAccountIfWrongPasscodeEntered() throws InterruptedException, IOException {
        getStartedPage.clickGetStarted();
        getStartedPage.clickCreateNewWalletButton();
        backUpPage.clickSkipButton();
        setupPasscodePage.enterPasscode();
        setupPasscodePage.enterConfirmPasscode();
        homePage.clickOnStartUsingTrustWalletButton();
        assertionTrue(homePage.isHomePageTitleDisplayed(), "Home Page is displayed", myLogger);
        restartApp();
        setupPasscodePage.enterWrongPasscodeForLogin();
        assertionFalse(homePage.isHomePageTitleDisplayed(), "Home Page is not displayed", myLogger);
    }

    @Test(description = "[Positive] Verify Search Functionality for newly created wallet")
    public void verifySearchFunctionality() throws InterruptedException, IOException {
        getStartedPage.clickGetStarted();
        getStartedPage.clickCreateNewWalletButton();
        backUpPage.clickSkipButton();
        setupPasscodePage.enterPasscode();
        setupPasscodePage.enterConfirmPasscode();
        homePage.clickOnStartUsingTrustWalletButton();
        assertionTrue(homePage.isHomePageTitleDisplayed(), "Home Page is displayed", myLogger);
        homePage.enterSearchKeyword();
        assertionTrue(homePage.isFirstResultDisplayedForSearchedKeyword(), "First Result Displayed for Searched Keyword is displayed", myLogger);
    }

    @Test(description = "[Positive] Create multiple wallets and switch to newly created wallet")
    public void createMultipleWalletsAndSwitchToNewlyCreateWallet() throws InterruptedException, IOException {
        getStartedPage.clickGetStarted();
        getStartedPage.clickCreateNewWalletButton();
        backUpPage.clickSkipButton();
        setupPasscodePage.enterPasscode();
        setupPasscodePage.enterConfirmPasscode();
        homePage.clickOnStartUsingTrustWalletButton();
        assertionTrue(homePage.isHomePageTitleDisplayed(), "Home Page is displayed", myLogger);
        homePage.clickOnSettingsIcon();
        settingsPage.clickOnWalletsMenuOption();
        assertionTrue(walletsPage.isWalletPageDisplayed(), "Wallet Page is displayed", myLogger);
        assertionTrue(walletsPage.isFirstMainWalletDisplayed(), "First Main Wallet is displayed", myLogger);
        walletsPage.clickOnAddNewWalletIcon();
        getStartedPage.clickCreateNewWalletButton();
        backUpPage.clickSkipButton();
        homePage.clickOnStartUsingTrustWalletButton();
        assertionTrue(homePage.isHomePageTitleDisplayed(), "Home Page is displayed", myLogger);
        assertionTrue(homePage.isSecondMainWalletDisplayed(), "Second Main Wallet is displayed", myLogger);
    }

    @Test(description = "[Positive] Verify user can switch to first wallet")
    public void verifyUserCanSwitchToFirstWallet() throws InterruptedException, IOException {
        getStartedPage.clickGetStarted();
        getStartedPage.clickCreateNewWalletButton();
        backUpPage.clickSkipButton();
        setupPasscodePage.enterPasscode();
        setupPasscodePage.enterConfirmPasscode();
        homePage.clickOnStartUsingTrustWalletButton();
        assertionTrue(homePage.isHomePageTitleDisplayed(), "Home Page is displayed", myLogger);
        homePage.clickOnSettingsIcon();
        settingsPage.clickOnWalletsMenuOption();
        assertionTrue(walletsPage.isWalletPageDisplayed(), "Wallet Page is displayed", myLogger);
        assertionTrue(walletsPage.isFirstMainWalletDisplayed(), "First Main Wallet is displayed", myLogger);
        walletsPage.clickOnAddNewWalletIcon();
        getStartedPage.clickCreateNewWalletButton();
        backUpPage.clickSkipButton();
        homePage.clickOnStartUsingTrustWalletButton();
        assertionTrue(homePage.isHomePageTitleDisplayed(), "Home Page is displayed", myLogger);
        assertionTrue(homePage.isSecondMainWalletDisplayed(), "Second Main Wallet is displayed", myLogger);
        homePage.clickOnSecondMainWallet();
        walletsPage.clickOnFirstMainWallet();
        assertionTrue(homePage.isHomePageTitleDisplayed(), "Home Page is displayed", myLogger);
        assertionTrue(homePage.isFirstMainWalletDisplayed(), "First Main Wallet is displayed", myLogger);
    }

    @Test(description = "[Positive] Verify user can Hide Main Balance")
    public void verifyUserCanHideMainBalance() throws InterruptedException, IOException {
        getStartedPage.clickGetStarted();
        getStartedPage.clickCreateNewWalletButton();
        backUpPage.clickSkipButton();
        setupPasscodePage.enterPasscode();
        setupPasscodePage.enterConfirmPasscode();
        homePage.clickOnStartUsingTrustWalletButton();
        assertionTrue(homePage.isHomePageTitleDisplayed(), "Home Page is displayed", myLogger);
        homePage.clickOnMainBalance();
        assertionTrue(homePage.isMainBalanceHiddenAmountDisplayed(), "Main Balance Hidden Amount is displayed", myLogger);
        homePage.clickOnMainBalance();
        assertionTrue(homePage.isMainBalanceAmountDisplayed(), "Main Balance Amount is displayed", myLogger);
    }

    @Test(description = "[Positive] Verify navigation of Send, Receive, Buy and Sell")
    public void verifyNavigationOfSendReceiveBuyAndSell() throws IOException, InterruptedException {
        getStartedPage.clickGetStarted();
        getStartedPage.clickCreateNewWalletButton();
        backUpPage.clickSkipButton();
        setupPasscodePage.enterPasscode();
        setupPasscodePage.enterConfirmPasscode();
        homePage.clickOnStartUsingTrustWalletButton();
        assertionTrue(homePage.isHomePageTitleDisplayed(), "Home Page is displayed", myLogger);

        homePage.clickOnSendButton();
        assertionTrue(homePage.isSendPageTitleDisplayed(), "Send Page Title is displayed", myLogger);
        homePage.clickOnBackButtonOnSendPage();

        homePage.clickOnReceiveButton();
        assertionTrue(homePage.isReceivePageTitleDisplayed(), "Receive Page Title is displayed", myLogger);
        homePage.clickOnBackButtonOnReceivePage();

        homePage.clickOnBuyButton();
        assertionTrue(homePage.isBuyPageTitleDisplayed(), "Buy Page Title is displayed", myLogger);
        homePage.clickOnBackButtonOnBuyPage();

        homePage.clickOnSellButton();
        assertionTrue(homePage.isSellPageTitleDisplayed(), "Sell Page Title is displayed", myLogger);
        homePage.clickOnBackButtonOnSellPage();
    }

    @Test(description = "[Positive] Verify navigation of Swap, Earn, Discover and Browser")
    public void verifyNavigationOfSwapEarnDiscoverAndBrowser() throws IOException, InterruptedException {
        getStartedPage.clickGetStarted();
        getStartedPage.clickCreateNewWalletButton();
        backUpPage.clickSkipButton();
        setupPasscodePage.enterPasscode();
        setupPasscodePage.enterConfirmPasscode();
        homePage.clickOnStartUsingTrustWalletButton();
        assertionTrue(homePage.isHomePageTitleDisplayed(), "Home Page is displayed", myLogger);
        homePage.clickOnSwapButton();
        assertionTrue(homePage.isSwapPageTitleDisplayed(), "Swap Page Title is displayed", myLogger);
        homePage.clickOnEarnButton();
        assertionTrue(homePage.isEarnPageTitleDisplayed(), "Earn Page Title is displayed", myLogger);
        homePage.clickOnDiscoverButton();
        assertionTrue(homePage.isDiscoverPageTitleDisplayed(), "Discover Page Title is displayed", myLogger);
        homePage.clickOnBrowserButton();
        assertionTrue(homePage.isBrowserPageTitleDisplayed(), "Browser Page Title is displayed", myLogger);
    }

    @Test(description = "[Positive] Verify Send Crypto page shows Address and Amount field")
    public void verifySendCryptoPageShowsAddressAndAmountField() throws IOException, InterruptedException {
        getStartedPage.clickGetStarted();
        getStartedPage.clickCreateNewWalletButton();
        backUpPage.clickSkipButton();
        setupPasscodePage.enterPasscode();
        setupPasscodePage.enterConfirmPasscode();
        homePage.clickOnStartUsingTrustWalletButton();
        assertionTrue(homePage.isHomePageTitleDisplayed(), "Home Page is displayed", myLogger);
        homePage.enterSearchKeyword();
        assertionTrue(homePage.isFirstResultDisplayedForSearchedKeyword(), "First Result Displayed for Searched Keyword is displayed", myLogger);
        homePage.clickOnSearchedKeyword();
        homePage.clickOnSendButton();
        assertionTrue(sendPage.isAddressInputDisplayed(), "Address Input field is displayed", myLogger);
        assertionTrue(sendPage.isAmountInputDisplayed(), "Amount Input field is displayed", myLogger);
    }
}