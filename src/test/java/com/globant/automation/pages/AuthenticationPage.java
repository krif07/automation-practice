package com.globant.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage{

    @FindBy(id="email")
    private WebElement emailText;

    @FindBy(id="passwd")
    private WebElement passwordText;

    @FindBy(id="SubmitLogin")
    private WebElement loginButton;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public void setEmailText(String text) {
        setText(emailText, text);
    }

    public void setPasswordText(String text){
        setText(passwordText, text);
    }

    public MyAccountPage clickLoginButton(){
        click(loginButton);
        return new MyAccountPage(getDriver());
    }
}
