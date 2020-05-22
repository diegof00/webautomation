package com.example.automation.tests;

import com.example.automation.utils.DriverProvider;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected DriverProvider driverProvider;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"driverName"})
    public void beforeSuite(String driverName) {
        this.driverProvider = new DriverProvider(driverName);
    }

    @AfterSuite(alwaysRun = true)
    public void afterTest() {
        DriverProvider.getDriver().quit();
    }

}
