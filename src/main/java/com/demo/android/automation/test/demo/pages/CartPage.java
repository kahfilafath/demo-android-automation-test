package com.demo.android.automation.test.demo.pages;

import com.demo.android.automation.test.demo.base.PageBaseObject;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.springframework.stereotype.Component;

import static com.demo.android.automation.test.demo.locators.CartLocator.*;

@Component
public class CartPage extends PageBaseObject {

    public Boolean isLabelHeaderDisplayed(){
        try {
            waitUntilPresent(LABEL_ECOMM_HEADER);
            return isDisplayed(LABEL_ECOMM_HEADER);
        }catch (Exception e){
            return false;
        }
    }
    public void clickProductName(String productName){
        click(MobileBy.xpath(String.format(LABEL_PRODUCT_NAME,productName)));
    }
    public void clickCartButton(int qty){
        int i =0;
        while( i < qty){
            click(BUTTON_ADD_TO_CART);
            i++;
        }
    }
    public void clickCartButtonOnPdp(){
        click(BUTTON_ADD_TO_CART_PDP);
    }
    public Double getProductPrice(){
        return Double.parseDouble(getText(LABEL_PRODUCT_PRICE ).replace("$","").trim());
    }
    public Double getTotalProductPrice(){
        return Double.parseDouble(getText(LABEL_TOTAL_PRODUCT_PRICE).replace("$","").trim());
    }
    public Double getProductPriceAmount(){
        return Double.parseDouble
                (getText(MobileBy.id("amountTV")).replace("$","").trim());
    }
    public Double getTotalAmount(){
        return Double.parseDouble
                (getText(MobileBy.id("totalAmountTV")).replace("$","").trim());
    }
    public Integer getProductQty(){
        return Integer.parseInt(getText(LABEL_PRODUCT_QTY ));
    }
    public void clickCheckoutButton(){
        click(BUTTON_ADD_TO_CART);
    }
    public void inputUsername(String username){
        input(INPUT_USERNAME,username);
    }
    public void inputPassword(String password){
        input(INPUT_PASSWORD,password);
    }
    public void clickLoginButton(){
        click(BUTTON_LOGIN );
    }
    public void inputFullname(String fullname){
        input(LABEL_RECIPIENT_FULLNAME,fullname);
    }
    public void inputAddress1(String address1){
        input(LABEL_RECIPIENT_ADDRESS1,address1);
    }
    public void inputAddress2(String address2){
        input(LABEL_RECIPIENT_ADDRESS2,address2);
    }
    public void inputCity(String city){
        input(LABEL_RECIPIENT_CITY,city);
    }
    public void inputState(String state){
        input(LABEL_RECIPIENT_STATE,state);
    }
    public void inputZipcode(String zipcode){
        input(LABEL_RECIPIENT_ZIPCODE,zipcode);
    }
    public void inputCountry(String country){
        input(LABEL_RECIPIENT_COUNTRY,country);
    }
    public void clickPaymentButton(){
        click(BUTTON_PAYMENT);
    }
    public void inputCardHolder(String cardHolder){
        input(INPUT_CARD_HOLDER, cardHolder);
    }
    public void inputCardNumber(String cardNumber){
        input(INPUT_CARD_NUMBER, cardNumber);
    }
    public void inputCardExpiryDate(String cardExpiryDate){
        input(INPUT_CARD_EXPIRY_DATE, cardExpiryDate);
    }
    public void inputCardCvc(String cardCvc){
        input(INPUT_CARD_CVC,cardCvc);
    }
    public String getProductNameOrder(){
        return getText(LABEL_PRODUCT_NAME_ORDER);
    }
    public String getRecipientNameOrder(){
        return getText(LABEL_RECIPIENT_NAME_ORDER);
    }
    public String getRecipientAddressOrder(){
        return getText(LABEL_RECIPIENT_ADDRESS_ORDER);
    }
    public String getRecipientCityOrder(){
       return getText(LABEL_RECIPIENT_CITY_ORDER);
    }
    public String getRecipientCountryOrder(){
        return getText(LABEL_RECIPIENT_COUNTRY_ORDER);
    }
    public String getRecipientCardHolder(){
        return getText(LABEL_CARD_HOLDER_ORDER);
    }
    public String getRecipientCardNumber(){
        return getText(LABEL_CARD_NUMBER_ORDER);
    }
    public String getRecipientCardExpiryDate(){
        return getText(LABEL_CARD_EXPIRY_DATE_ORDER).replace("Exp: ","").trim();
    }
    public Boolean isProductAmountDisplayed(){
        try {
           return isDisplayed(LABEL_PRODUCT_PRICE_AMOUNT);
        }catch (Exception e){
            return false;
        }
    }
    public String getOrderCompleted(){
        return getText(LABEL_COMPLETED_ORDER);
    }
    public AndroidElement scrollByIdToBillingAddress(){
        return find(MobileBy.AndroidUIAutomator(String.format(
                "new UiScrollable(new UiSelector().resourceIdMatches(\".*%s.*\")"
                        + ".scrollable(true)).scrollIntoView(new UiSelector().resourceIdMatches(\".*%s.*\"))",
                CONTAINER_ORDER_SUMMARY, LABEL_BILLING_ADDRESS)));
    }


}
