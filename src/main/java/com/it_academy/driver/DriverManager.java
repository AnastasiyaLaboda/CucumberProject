package com.it_academy.onliner.driver;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DriverManager {
    public static void initDriver() {
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
        Configuration.pageLoadTimeout = 50000;
        open();
        getWebDriver().manage().window().maximize();
    }
}
