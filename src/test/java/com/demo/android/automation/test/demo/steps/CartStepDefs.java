package com.demo.android.automation.test.demo.steps;

import com.demo.android.automation.test.demo.base.PageBaseObject;
import com.demo.android.automation.test.demo.pages.CartPage;
import com.demo.android.automation.test.demo.properties.OrderDataProperties;
import com.demo.android.automation.test.demo.properties.RecipientDataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class CartStepDefs extends PageBaseObject {

    @Autowired
    OrderDataProperties orderDataProperties;
    @Autowired
    CartPage cartPage;

    @DataTableType
    public RecipientDataTable recipientDataEntry(Map<String, String> entry){
        return new RecipientDataTable(
                entry.get("FullName"),
                entry.get("Address Line 1"),
                entry.get("Address Line 2"),
                entry.get("City"),
                entry.get("State/Region"),
                entry.get("Zip Code"),
                entry.get("Country")
        );
    }

    @Given("user on My Demo App Catalog Page")
    public void userOnMyDemoAppCatalogPage(){
        Assertions.assertTrue(cartPage.isLabelHeaderDisplayed(),"Page failed to load!");

    }

    @When("user click product {string} on Catalog Page")
    public void userClickProductOnCatalogPage(String productName) {
        cartPage.clickProductName(productName);
        orderDataProperties.setProductName(productName);
    }

    @And("user add {int} product qty on Product Detail Page")
    public void userAddProductQtyOnProductDetailPage(int qty) {
       cartPage.clickCartButton(qty);
    }

    @And("user click button add to cart on Product Detail Page")
    public void userClickButtonAddToCartOnProductDetailPage() {
        cartPage.clickCartButtonOnPdp();
    }

    @Then("user verify the total product price on Cart Page")
    public void userVerifyTheTotalProductPriceOnCartPage() {
        Double expectedTotalPrice = cartPage.getProductPrice() * cartPage.getProductQty();
        Assertions.assertEquals(expectedTotalPrice,cartPage.getTotalProductPrice());
        orderDataProperties.setTotalPrice(expectedTotalPrice);

    }

    @When("user click checkout button on Cart Page")
    public void userClickCheckoutButtonOnCartPage() {
        cartPage.clickCheckoutButton();
    }

    @And("user fill out username and password on Login Page")
    public void userFillOutUsernameAndPasswordOnLoginPage() {
        cartPage.inputUsername(orderDataProperties.getUsername());
        cartPage.inputPassword(orderDataProperties.getPassword());
        cartPage.clickLoginButton();
    }

    @And("user fill out recipient data on Checkout Page:")
    public void userFillOutRecipientDataOnCheckoutPage(List<RecipientDataTable> recipientDataTables) {
        for(RecipientDataTable data : recipientDataTables){
            cartPage.inputFullname(data.getFullname());
            cartPage.inputAddress1(data.getAddressLine1());
            cartPage.inputAddress2(data.getAddressLine2());
            cartPage.inputCity(data.getCity());
            cartPage.inputState(data.getState());
            cartPage.inputZipcode(data.getZipCode());
            cartPage.inputCountry(data.getCountry());

            //store data on setter
            orderDataProperties.setFullname(data.getFullname());
            orderDataProperties.setAddress(data.getAddressLine1());
            orderDataProperties.setCity(data.getCity());
            orderDataProperties.setState(data.getState());
            orderDataProperties.setZipcode(data.getZipCode());
            orderDataProperties.setCountry(data.getCountry());
        }


    }

    @And("user click button payment on Checkout Page")
    public void userClickButtonPaymentOnCheckoutPage() {
      cartPage.clickPaymentButton();
    }

    @When("user fill out payment credential on Payment Page")
    public void userFillOutPaymentCredentialOnPaymentPage() {
        cartPage.inputCardHolder(orderDataProperties.getCardHolder());
        cartPage.inputCardNumber(orderDataProperties.getCardNumber());
        cartPage.inputCardExpiryDate(orderDataProperties.getExpirationDate());
        cartPage.inputCardCvc(orderDataProperties.getSecurityCode());
        cartPage.clickPaymentButton();
    }

    @And("user review the order summary prior place order on Review Order Page")
    public void userReviewTheOrderSummaryPriorPlaceOrderOnReviewOrderPage() {
        Assertions.assertEquals(orderDataProperties.getProductName(),cartPage.getProductNameOrder());
        Assertions.assertEquals(orderDataProperties.getFullname(),cartPage.getRecipientNameOrder());
        Assertions.assertEquals(orderDataProperties.getAddress(),cartPage.getRecipientAddressOrder());
        Assertions.assertEquals(orderDataProperties.getCity()+", "+orderDataProperties.getState()
                ,cartPage.getRecipientCityOrder());
        Assertions.assertEquals(orderDataProperties.getCountry()+", "+orderDataProperties.getZipcode()
                ,cartPage.getRecipientCountryOrder());
        cartPage.scrollByIdToBillingAddress();
        Assertions.assertEquals(orderDataProperties.getCardHolder(),cartPage.getRecipientCardHolder());
        Assertions.assertEquals(orderDataProperties.getCardNumber(),cartPage.getRecipientCardNumber());
        Assertions.assertEquals(orderDataProperties.getExpirationDate(),cartPage.getRecipientCardExpiryDate());
        Assertions.assertTrue(cartPage.isProductAmountDisplayed());
        Double expectedFinalAmount = orderDataProperties.getTotalPrice() + cartPage.getProductPriceAmount();
        Assertions.assertEquals(expectedFinalAmount,cartPage.getTotalAmount());
        cartPage.clickPaymentButton();

    }

    @Then("user successfully purchase the order by seeing {string} message on Thank You Page")
    public void userSuccessfullyPurchaseTheOrderBySeeingMessageOnThankYouPage(String message) {
        Assertions.assertEquals(message,cartPage.getOrderCompleted());
    }
}
