package com.globant.automation.tests;

import com.globant.automation.drivers.DriverController;
import com.globant.automation.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {

    private DriverController driverController;
    private String browser;

    private HomePage homePage;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser){
        this.browser = browser;
        newDriverController();
    }

    @BeforeMethod
    public void goHomePage(){
        newDriverController();
        driverController.getDriver().manage().window().maximize();
        homePage = new HomePage(driverController.getDriver());
    }

    @AfterMethod
    public void finishHomePage(){
        driverController = null;
        //homePage.dispose();
    }

    public HomePage getHomePage(){
        return homePage;
    }

    private void newDriverController(){
        if(driverController == null){
            driverController = new DriverController(browser);
        }
    }
}
