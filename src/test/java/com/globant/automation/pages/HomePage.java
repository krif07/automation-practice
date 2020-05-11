package com.globant.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class HomePage extends BasePage{

    @FindBy(className = "header_user_info")
    private WebElement signInButton;

    public HomePage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, getTimeOut()), this);
        driver.get("http://automationpractice.com/index.php");
    }

    public AuthenticationPage clickSignInButton(){
        click(signInButton);
        return new AuthenticationPage(getDriver());
    }
}
