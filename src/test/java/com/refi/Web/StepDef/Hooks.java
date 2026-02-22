package com.refi.Web.StepDef;

import com.refi.Web.Base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseTest {

    @Before
    public void setUp() {
        getDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            }
        }
}
