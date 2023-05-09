package com.it_academy.onliner.pages;

import com.it_academy.onliner.driver.DriverManager;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage {
    public BasePage() {
        DriverManager.initDriver();
    }

    public void exitFrame() {
        getWebDriver().switchTo().defaultContent();
    }
}
