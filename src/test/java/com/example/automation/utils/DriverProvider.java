package com.example.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class DriverProvider {

    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    private static final long DEFAULT_WAIT_TIME_IN_SECONDS = 20;

    private static WebDriver driver;

    private static WebDriverWait wait;

    public DriverProvider(String driverName) {
        LOGGER.info("selecting driver " + driverName);
        System.setProperty("webdriver.chrome.driver", resolveDriverLocation(driverName));
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(this.driver, DEFAULT_WAIT_TIME_IN_SECONDS);
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        throw new IllegalStateException("web driver has not been configured");
    }

    public static WebDriverWait getWait() {
        if (wait != null) {
            return wait;
        }
        throw new IllegalStateException("web driver wait has not been configured");
    }

    private String resolveDriverLocation(String driver) {
        LOGGER.info("resolve driver location---" + Thread.currentThread().getContextClassLoader().getResource("webdrivers/" + driver).getPath());
        return Thread.currentThread().getContextClassLoader().getResource("webdrivers/" + driver).getPath();
    }
}
