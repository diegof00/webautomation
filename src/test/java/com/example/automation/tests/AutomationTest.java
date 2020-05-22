package com.example.automation.tests;

import com.example.automation.pages.HomePage;
import com.example.automation.pages.TryPage;
import com.example.automation.utils.DriverProvider;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class AutomationTest extends BaseTest {

    private static final Logger LOGGER = Logger.getLogger(AutomationTest.class.getName());

    private HomePage homePage;

    private TryPage tryPage;

    @BeforeTest
    public void setup() {
        LOGGER.info("create initial page and go...");
        homePage = PageFactory.initElements(DriverProvider.getDriver(), HomePage.class);
        tryPage = PageFactory.initElements(DriverProvider.getDriver(), TryPage.class);
        homePage.go();
    }


    @Test
    public void goAtlassianTryItFreeTest() throws InterruptedException {
        LOGGER.info("go to second page through homepage...");
        homePage.goToTryPage();
        //validate if the second page appears
        assert tryPage.isPageNamePresentInTitle("Try Atlassian Products");
        tryPage.clickInSearch();
        tryPage.searchForSomething("JIRA");
        Thread.sleep(5000); //just as example.
        tryPage.scrollDown("2000");
        Thread.sleep(5000);
    }


}
