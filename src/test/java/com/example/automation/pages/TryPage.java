package com.example.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TryPage extends BasePage{

    @FindBy(className = "global-nav--wac__search-icon")
    private WebElement searchButton;

    @FindBy(className = "global-nav--wac__search-input")
    private WebElement searchTextBox;

    @FindBy(className = "global-nav--wac__search-submit")
    private WebElement submitSearchButton;

    public void clickInSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public void searchForSomething(String something) {
        wait.until(ExpectedConditions.visibilityOf(searchTextBox));
        searchTextBox.clear();
        searchTextBox.sendKeys(something);
        wait.until(ExpectedConditions.elementToBeClickable(submitSearchButton));
        submitSearchButton.click();
    }


}
