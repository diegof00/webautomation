package com.example.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(className = "global-nav--wac__logo")
    private WebElement logoAtlassianTitle;

    @FindBy(className = "global-nav--wac__button--primary")
    private WebElement tryItButton;

    public void go() {
        driver.manage().window().maximize();
        driver.get("https://www.atlassian.com");
        wait.until(ExpectedConditions.visibilityOf(logoAtlassianTitle));
    }


    public void goToTryPage() {
        wait.until(ExpectedConditions.visibilityOf(tryItButton));
        tryItButton.click();
    }
}
