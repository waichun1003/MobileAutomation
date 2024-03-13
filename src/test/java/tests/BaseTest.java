package tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.*;
import utils.AppiumUtils;
import utils.DriverUtils;
import utils.MyLogger;

import java.io.IOException;

public class BaseTest {
    protected HomePage homePage;
    protected GetStartedPage getStartedPage;
    protected BackUpPage backUpPage;
    protected SetupPasscodePage setupPasscodePage;
    protected SettingsPage settingsPage;
    protected WalletsPage walletsPage;
    protected SendPage sendPage;
    MyLogger myLogger;

    @Parameters("platformName")
    @BeforeMethod
    public void setUp(ITestContext context, String platformName) throws IOException {
        myLogger = new MyLogger(BaseTest.class);
        context.setAttribute("logger", myLogger);
        DriverUtils.initializeDriver(platformName);
        homePage = new HomePage(myLogger);
        getStartedPage = new GetStartedPage(myLogger);
        backUpPage = new BackUpPage(myLogger);
        setupPasscodePage = new SetupPasscodePage(myLogger);
        settingsPage = new SettingsPage(myLogger);
        walletsPage = new WalletsPage(myLogger);
        sendPage = new SendPage(myLogger);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        DriverUtils.quitDriver();
    }

    public void assertionTrue(boolean condition, String message, MyLogger logger){
        Assert.assertTrue(condition, message.replace("is ", "is not "));
        logger.info(message);
    }

    public void assertionFalse(boolean condition, String message, MyLogger logger){
        Assert.assertFalse(condition, message.replace("is not", "is"));
        logger.info(message);
    }

    public void assertionEquals(Object expected, Object actual, String message, MyLogger logger){
        Assert.assertEquals(expected, actual, message.replace("is ", "is not "));
        logger.info(message.replace("is ", "is not "));
    }

}
