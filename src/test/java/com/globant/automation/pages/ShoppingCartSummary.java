package com.globant.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartSummary extends BasePage{

    @FindBy(css = ".cart_description .product-name")
    private WebElement cartDescriptionProductName;

    public ShoppingCartSummary(WebDriver driver) {
        super(driver);
    }

    public String getCartDescriptionProductName(){
        return getText(cartDescriptionProductName);
    }
}
