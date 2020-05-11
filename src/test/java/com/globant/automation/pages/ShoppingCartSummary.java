package com.globant.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartSummary extends BasePage{

    @FindBy(css = ".cart_description .product-name")
    private WebElement cartDescriptionProductName;

    @FindBy(css = "p a[title='Proceed to checkout']")
    private WebElement proceedToCheckout;

    @FindBy(css = "button[name='processAddress']")
    private WebElement processAddress;

    @FindBy(id = "cgv")
    private WebElement termsOfServiceCheck;

    @FindBy(css = "button[name='processCarrier']")
    private WebElement processCarrier;

    @FindBy(className = "bankwire")
    private WebElement payByBackWire;

    @FindBy(className = "cheque")
    private WebElement payByCheque;

    @FindBy(css = "button.button.btn.btn-default.button-medium")
    private WebElement confirmOrder;

    @FindBy(css = "p.alert.alert-success")
    private WebElement alertSuccess;

    public ShoppingCartSummary(WebDriver driver) {
        super(driver);
    }

    public String getCartDescriptionProductName(){
        return getText(cartDescriptionProductName);
    }

    public void clickProceedToCheckout(){
        click(proceedToCheckout);
    }

    public void clickProcessAddress(){
        click(processAddress);
    }

    public void clickTermsOfServiceCheck(){
        termsOfServiceCheck.click();
    }

    public void clickProcessCarrier(){
        click(processCarrier);
    }

    public void clickPayByBackWire(){
        click(payByBackWire);
    }

    public void clickPayByCheque(){
        click(payByCheque);
    }

    public void clickConfirmOrder(){
        click(confirmOrder);
    }

    public String getAlertSuccess(){
        return getText(alertSuccess);
    }
}
