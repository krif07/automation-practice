package com.globant.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private int timeOut = 15;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, timeOut);
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait() {
        return wait;
    }

    protected void dispose(){
        if(driver != null){
            driver.quit();
        }
    }

    protected int getTimeOut(){
        return timeOut;
    }

    protected WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    protected String getText(WebElement element){
        return element.getText().trim();
    }

    protected void setText(WebElement element, String text){
        getWait().until(
          ExpectedConditions.visibilityOf(element)
        );
        element.sendKeys(text);
    }

    protected void click(WebElement element){
        getWait().until(
                ExpectedConditions.elementToBeClickable(element)
        ).click();
    }
}
