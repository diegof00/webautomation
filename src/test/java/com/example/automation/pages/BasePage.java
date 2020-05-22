package com.example.automation.pages;

import com.example.automation.utils.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class BasePage {

    private static final Logger LOGGER = Logger.getLogger(BasePage.class.getName());

    protected WebDriver driver = DriverProvider.getDriver();

    protected WebDriverWait wait = DriverProvider.getWait();

    protected String windowName = driver.getWindowHandle();


    public void scrollDown(String pixels) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

    public void scrollUntilElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public boolean isPageNamePresentInTitle(String pageName) {
        return this.wait.until(ExpectedConditions.titleContains(pageName));
    }

    public void retakeMainFocus(String title) {
        while (!driver.getWindowHandles().stream().map(s -> {
            driver.switchTo().window(s);
            return currenPageTitleMatches(title);
        }).anyMatch(a -> a.equals(true))) ;
    }

    private boolean currenPageTitleMatches(String title) {
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body"))));
        LOGGER.info("comparing title " + driver.getTitle() + " and param " + title);
        return driver.getTitle().contains(title);
    }


    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }


}
