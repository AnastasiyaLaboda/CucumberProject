package com.it_academy.navigation;

import static com.codeborne.selenide.Selenide.open;

public class OnlinerNavigation {
    public static void navigateToOnlinerPage(OnlinerUrls page) {
        open(page.getUrl());
    }
}
