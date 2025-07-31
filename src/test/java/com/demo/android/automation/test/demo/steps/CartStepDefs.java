package com.demo.android.automation.test.demo.steps;

import com.demo.android.automation.test.demo.base.PageBaseObject;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CartStepDefs extends PageBaseObject {

    @Given("user on My Demo App Catalog Page")
    public void userOnMyDemoAppCatalogPage(){
        waitUntilPresent(MobileBy.id("mTvTitle"));
        Assertions.assertTrue(isDisplayed(MobileBy.id("mTvTitle")),"Page failed to load!");

    }

    @When("user click product {string} on Catalog Page")
    public void userClickProductOnCatalogPage(String productName) {
        click(MobileBy.xpath(String.format("//android.widget.ImageView[@content-desc='%s']",productName)));
    }
}
