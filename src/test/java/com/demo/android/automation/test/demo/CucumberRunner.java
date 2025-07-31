package com.demo.android.automation.test.demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com/demo/android/automation/test/demo"},
        plugin = {"json:build/cucumber.json", "pretty", "html:build/result.html"},
        features = "src/test/resources/features",
        stepNotifications = true,
        tags = "@TC001",
        publish = true
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
