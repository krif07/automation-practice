package com.globant.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TShirtsPage extends BasePage {

    private String productName;

    @FindBy(xpath = "(//a[@class='product_img_link'])[1]")
    private WebElement productImgLink;

    @FindBy(css = "a.button.ajax_add_to_cart_button.btn.btn-default")
    private WebElement addToCartButton;

    @FindBy(css = "h5[itemprop='name'] .product-name")
    private WebElement productNameWebElement;

    @FindBy(css = ".button-container .btn.btn-default.button.button-medium")
    private WebElement proceedToCheckout;

    public TShirtsPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(productImgLink)
                .moveToElement(addToCartButton)
                .click()
                .build()
                .perform();

        productName = getText(productNameWebElement);
    }

    public ShoppingCartSummary clickProceedToCheckout(){
        click(proceedToCheckout);
        return new ShoppingCartSummary(getDriver());
    }

    public String getProductName(){
        return productName.trim();
    }
}
