package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverUtils {

    private static AppiumDriver driver;
    public static Properties prop;

    public static void initializeDriver(String platformName) throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Config/config.properties");
        prop.load(fis);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", System.getProperty("user.dir") + "/" + prop.getProperty("app"));
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", prop.getProperty("deviceName"));
        capabilities.setCapability("automationName", prop.getProperty("automationName"));
        capabilities.setCapability("autoGrantPermissions", prop.getProperty("autoGrantPermissions"));
        capabilities.setCapability("appPackage", prop.getProperty("appPackage"));

        try {
            driver = new AppiumDriver(new URL("http://"+prop.getProperty("remoteHost")+":"+prop.getProperty("remotePort")+prop.getProperty("remotePath")), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is invalid", e);
        }
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Please call initializeDriver first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void restartApp() {
        String appPackage = driver.getCapabilities().getCapability("appPackage").toString();
        JavascriptExecutor jsDriver = driver;
        jsDriver.executeScript("mobile: terminateApp", ImmutableMap.of("appId", appPackage));
        jsDriver.executeScript("mobile: activateApp", ImmutableMap.of("appId", appPackage));
    }
}
