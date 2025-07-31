package com.demo.android.automation.test.demo.hooks;

import com.demo.android.automation.test.demo.drivers.AndroidDriverInit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class AndroidDriverHook {

    @Autowired
    AndroidDriverInit androidDriverInit;
    @Before
    public void init(){
        androidDriverInit.initialize();
    }
    @After
    public void quit(){
        androidDriverInit.quit();
    }
}
