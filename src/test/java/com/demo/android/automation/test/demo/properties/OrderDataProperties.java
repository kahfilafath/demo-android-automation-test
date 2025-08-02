package com.demo.android.automation.test.demo.properties;

import org.springframework.stereotype.Component;

@Component
public class OrderDataProperties {
    private String username = "bod@example.com";
    private String password = "10203040";
    private String productName;
    private Double totalPrice;
    private String cardHolder = "Rebbeca Winter";
    private String cardNumber = "3258125675687891";
    private String expirationDate = "03/25";
    private String securityCode = "123";
    private String fullname;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getProductName(){
        return productName;
    }
    public Double getTotalPrice(){
        return totalPrice;
    }
    public String getCardHolder(){
        return cardHolder;
    }
    public String getCardNumber(){
        return cardNumber;
    }
    public String getExpirationDate(){
        return expirationDate;
    }
    public String getSecurityCode(){
        return securityCode;
    }
    public String getFullname(){
        return fullname;
    }
    public String getAddress(){
        return address;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public String getCountry(){
        return country;
    }
    public String getZipcode(){
        return zipcode;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCardHolder(String cardHolder){
        this.cardHolder = cardHolder;
    }
    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }
    public void setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate;
    }
    public void setSecurityCode(String securityCode){
        this.securityCode =securityCode;
    }
    public void setFullname(String fullname){
        this.fullname = fullname;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setState(String state){
        this.state = state;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public void setZipcode(String zipcode){
        this.zipcode = zipcode;
    }


}
