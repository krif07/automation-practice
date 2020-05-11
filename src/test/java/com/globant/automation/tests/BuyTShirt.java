package com.globant.automation.tests;

import com.globant.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyTShirt extends BaseTest{

    @Test
    public void testBuyTShirWithCart(){
        HomePage homePage = getHomePage();
        AuthenticationPage authenticationPage = homePage.clickSignInButton();

        authenticationPage.setEmailText("krif07@gmail.com");
        authenticationPage.setPasswordText("backtira1");
        MyAccountPage myAccountPage = authenticationPage.clickLoginButton();

        TShirtsPage tShirtsPage = myAccountPage.clickTShirtsMenuButton();

        tShirtsPage.addProductToCart();
        String productName = tShirtsPage.getProductName();
        ShoppingCartSummary shoppingCartSummary = tShirtsPage.clickProceedToCheckout();
        String productNameObtained = shoppingCartSummary.getCartDescriptionProductName();

        System.out.println("1.productName " + productName);
        System.out.println("2.productNameObtained " + productNameObtained);

        Assert.assertEquals(
                productName,
                productNameObtained,
                String.format("Expected [%s], but optain [%s]", productName, productNameObtained)
        );

        shoppingCartSummary.clickProceedToCheckout();
        shoppingCartSummary.clickProcessAddress();
        shoppingCartSummary.clickTermsOfServiceCheck();
        shoppingCartSummary.clickProcessCarrier();
        shoppingCartSummary.clickPayByCheque();
        shoppingCartSummary.clickConfirmOrder();

        String message = "Your order on My Store is complete.";
        String messageGetted = shoppingCartSummary.getAlertSuccess();
        Assert.assertEquals(
                message,
                messageGetted,
                String.format("Message expected [%s], message receive [%s]",
                        message, messageGetted)
        );

    }
}
