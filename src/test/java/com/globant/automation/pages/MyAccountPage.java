package com.globant.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    @FindBy(xpath = "(//a[@title='T-shirts'])[2]")
    private WebElement tShirtsMenuButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public TShirtsPage clickTShirtsMenuButton(){
        click(tShirtsMenuButton);
        return new TShirtsPage(getDriver());
    }
}
