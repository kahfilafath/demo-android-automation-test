package com.demo.android.automation.test.demo.steps;

import com.demo.android.automation.test.demo.base.PageBaseObject;
import com.demo.android.automation.test.demo.properties.OrderDataProperties;
import com.demo.android.automation.test.demo.properties.RecipientDataTable;
import io.appium.java_client.MobileBy;
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
        waitUntilPresent(MobileBy.id("mTvTitle"));
        Assertions.assertTrue(isDisplayed(MobileBy.id("mTvTitle")),"Page failed to load!");

    }

    @When("user click product {string} on Catalog Page")
    public void userClickProductOnCatalogPage(String productName) {
        click(MobileBy.xpath(String.format("//android.widget.ImageView[@content-desc='%s']",productName)));
        orderDataProperties.setProductName(productName);
    }

    @And("user add {int} product qty on Product Detail Page")
    public void userAddProductQtyOnProductDetailPage(int qty) {
        int i =0;
        while( i < qty){
            click(MobileBy.id("cartBt"));
            i++;
        }

    }

    @And("user click button add to cart on Product Detail Page")
    public void userClickButtonAddToCartOnProductDetailPage() {
        click(MobileBy.id("cartRL"));
    }

    @Then("user verify the total product price on Cart Page")
    public void userVerifyTheTotalProductPriceOnCartPage() {
        String productPrice = getText(MobileBy.id("priceTV"));
        String totalPrice = getText(MobileBy.id("totalPriceTV"));
        int productQty = Integer.parseInt(getText(MobileBy.id("noTV")));
        totalPrice.replace("$","").trim();
        Double expectedTotalPrice = Double.parseDouble(productPrice.replace("$","").trim()) * productQty;
        Assertions.assertEquals(expectedTotalPrice, Double.valueOf(totalPrice.replace("$","").trim()));
        orderDataProperties.setTotalPrice(expectedTotalPrice);

    }

    @When("user click checkout button on Cart Page")
    public void userClickCheckoutButtonOnCartPage() {
        click(MobileBy.id("cartBt"));
    }

    @And("user fill out username and password on Login Page")
    public void userFillOutUsernameAndPasswordOnLoginPage() {
        input(MobileBy.id("nameET"),orderDataProperties.getUsername());
        input(MobileBy.id("passwordET"),orderDataProperties.getPassword());
        click(MobileBy.id("loginBtn"));
    }

    @And("user fill out recipient data on Checkout Page:")
    public void userFillOutRecipientDataOnCheckoutPage(List<RecipientDataTable> recipientDataTables) {
        for(RecipientDataTable data : recipientDataTables){
            input(MobileBy.id("fullNameET"),data.getFullname());
            input(MobileBy.id("address1ET"),data.getAddressLine1());
            input(MobileBy.id("address2ET"),data.getAddressLine2());
            input(MobileBy.id("cityET"),data.getCity());
            input(MobileBy.id("stateET"),data.getState());
            input(MobileBy.id("zipET"),data.getZipCode());
            input(MobileBy.id("countryET"),data.getCountry());

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
        click(MobileBy.id("paymentBtn"));
    }

    @When("user fill out payment credential on Payment Page")
    public void userFillOutPaymentCredentialOnPaymentPage() {
        input(MobileBy.id("nameET"), orderDataProperties.getCardHolder());
        input(MobileBy.id("cardNumberET"),orderDataProperties.getCardNumber());
        input(MobileBy.id("expirationDateET"),orderDataProperties.getExpirationDate());
        input(MobileBy.id("securityCodeET"),orderDataProperties.getSecurityCode());
        click(MobileBy.id("paymentBtn"));
    }

    @And("user review the order summary prior place order on Review Order Page")
    public void userReviewTheOrderSummaryPriorPlaceOrderOnReviewOrderPage() {

        Assertions.assertEquals(orderDataProperties.getProductName(),getText(MobileBy.id("titleTV")));
        Assertions.assertEquals(orderDataProperties.getFullname(),getText(MobileBy.id("fullNameTV")));
        Assertions.assertEquals(orderDataProperties.getAddress(),getText(MobileBy.id("addressTV")));
        Assertions.assertEquals(orderDataProperties.getCity()+", "+orderDataProperties.getState()
                ,getText(MobileBy.id("cityTV")));
        Assertions.assertEquals(orderDataProperties.getCountry()+", "+orderDataProperties.getZipcode()
                ,getText(MobileBy.id("countryTV")));

        find(MobileBy.AndroidUIAutomator(String.format(
                "new UiScrollable(new UiSelector().resourceIdMatches(\".*%s.*\")"
                        + ".scrollable(true)).scrollIntoView(new UiSelector().resourceIdMatches(\".*%s.*\"))",
                "checkoutSV", "billingAddressTV")));

        Assertions.assertEquals(orderDataProperties.getCardHolder(),getText(MobileBy.id("cardHolderTV")));
        Assertions.assertEquals(orderDataProperties.getCardNumber(),getText(MobileBy.id("cardNumberTV")));
        Assertions.assertEquals(orderDataProperties.getExpirationDate(),getText(MobileBy.id("expirationDateTV"))
                .replace("Exp: ","").trim());
        Assertions.assertTrue(isDisplayed(MobileBy.id("amountTV")));
        Double expectedFinalAmount = orderDataProperties.getTotalPrice() + Double.parseDouble
                (getText(MobileBy.id("amountTV")).replace("$","").trim());
        Assertions.assertEquals(expectedFinalAmount,Double.parseDouble(getText(MobileBy.id("totalAmountTV"))
                .replace("$","").trim()));
        click(MobileBy.id("paymentBtn"));

    }

    @Then("user successfully purchase the order by seeing {string} message on Thank You Page")
    public void userSuccessfullyPurchaseTheOrderBySeeingMessageOnThankYouPage(String message) {
        Assertions.assertEquals(message,getText(MobileBy.id("completeTV")));
    }
}
