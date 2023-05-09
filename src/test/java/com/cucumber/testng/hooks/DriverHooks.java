package com.cucumber.testng.hooks;

import com.it_academy.driver.DriverManager;
import io.cucumber.java.BeforeAll;

public class DriverHooks {
    @BeforeAll
    public static void setUpDriver() {
        System.out.println("start");
        DriverManager.initDriver();
    }
}
