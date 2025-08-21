package com.demo.android.automation.test.demo.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface CartLocator {
    By LABEL_ECOMM_HEADER = MobileBy.id("mTvTitle");
    String LABEL_PRODUCT_NAME = "//android.widget.ImageView[@content-desc='%s']";
    By BUTTON_ADD_TO_CART = MobileBy.id("cartBt");
    By BUTTON_ADD_TO_CART_PDP = MobileBy.id("cartRL");
    By LABEL_PRODUCT_PRICE = MobileBy.id("priceTV");
    By LABEL_TOTAL_PRODUCT_PRICE = MobileBy.id("totalPriceTV");
    By LABEL_PRODUCT_QTY = MobileBy.id("noTV");
    By INPUT_USERNAME = MobileBy.id("nameET");
    By INPUT_PASSWORD = MobileBy.id("passwordET");
    By BUTTON_LOGIN = MobileBy.id("loginBtn");
    By LABEL_RECIPIENT_FULLNAME = MobileBy.id("fullNameET");
    By LABEL_RECIPIENT_ADDRESS1 = MobileBy.id("address1ET");
    By LABEL_RECIPIENT_ADDRESS2 = MobileBy.id("address2ET");
    By LABEL_RECIPIENT_CITY = MobileBy.id("cityET");
    By LABEL_RECIPIENT_STATE = MobileBy.id("stateET");
    By LABEL_RECIPIENT_ZIPCODE = MobileBy.id("zipET");
    By LABEL_RECIPIENT_COUNTRY = MobileBy.id("countryET");
    By BUTTON_PAYMENT = MobileBy.id("paymentBtn");
    By INPUT_CARD_HOLDER = MobileBy.id("nameET");
    By INPUT_CARD_NUMBER = MobileBy.id("cardNumberET");
    By INPUT_CARD_EXPIRY_DATE = MobileBy.id("expirationDateET");
    By INPUT_CARD_CVC = MobileBy.id("securityCodeET");
    By LABEL_PRODUCT_NAME_ORDER = MobileBy.id("titleTV");
    By LABEL_RECIPIENT_NAME_ORDER = MobileBy.id("fullNameTV");
    By LABEL_RECIPIENT_ADDRESS_ORDER = MobileBy.id("addressTV");
    By LABEL_RECIPIENT_CITY_ORDER = MobileBy.id("cityTV");
    By LABEL_RECIPIENT_COUNTRY_ORDER = MobileBy.id("countryTV");
    String CONTAINER_ORDER_SUMMARY = "checkoutSV";
    String LABEL_BILLING_ADDRESS = "billingAddressTV";
    By LABEL_CARD_HOLDER_ORDER = MobileBy.id("cardHolderTV");
    By LABEL_CARD_NUMBER_ORDER = MobileBy.id("cardNumberTV");
    By LABEL_CARD_EXPIRY_DATE_ORDER = MobileBy.id("expirationDateTV");
    By LABEL_PRODUCT_PRICE_AMOUNT = MobileBy.id("amountTV");
    By LABEL_COMPLETED_ORDER = MobileBy.id("completeTV");
}
