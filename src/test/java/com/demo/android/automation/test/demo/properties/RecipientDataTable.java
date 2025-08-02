package com.demo.android.automation.test.demo.properties;



public class RecipientDataTable {
    public String fullname;
    public String addressLine1;
    public String addressLine2;
    public String city;
    public String state;
    public String zipCode;
    public String country;

    public RecipientDataTable(String fullname, String addressLine1, String addressLine2, String city, String state, String zipCode, String country){
        this.fullname = fullname;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }
    public String getFullname(){
        return fullname;
    }
    public String getAddressLine1(){
        return addressLine1;
    }
    public String getAddressLine2(){
        return addressLine2;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public String getZipCode(){
        return zipCode;
    }
    public String getCountry(){
        return country;
    }
}
