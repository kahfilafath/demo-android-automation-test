package com.demo.android.automation.test.demo.base;

import com.demo.android.automation.test.demo.drivers.AndroidDriverInit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageBaseObject extends AndroidDriverInit {

    public AndroidDriver<AndroidElement> getDriver(){
        return driver;
    }
    public AndroidElement find(By locator){
        return getDriver().findElement(locator);
    }
    public void click(By locator){
        find(locator).click();
    }
    public void input(By locator, String text){
        AndroidElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }
    public String getText(By locator){
        return find(locator).getText();
    }
    public List<AndroidElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }


    public void waitUntilPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilTextPresent(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.textToBePresentInElement(find(locator), text));
    }
    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

}
