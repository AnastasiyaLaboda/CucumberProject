package com.it_academy.pages.onliner;

import com.codeborne.selenide.SelenideElement;
import com.it_academy.pages.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class BasketPage extends BasePage {
    private static final SelenideElement productInCart =
            $x("//div[contains(@class, 'offers-item')]//div[contains(@class, 'offers-part_data')]");


    private static final SelenideElement productInCartTitle =
            $x("//div[contains(@class, 'cart-form')]//div[contains(@class, 'description_primary')]/a[@href]");

    private static final SelenideElement productInCartPrice =
            $x("//div[contains(@class, 'part_action')]//div[contains(@class, 'offers-part_price')]//span");

    private static final SelenideElement productInCartCount =
            $x("//div[contains(@class, 'cart-form')]//div[contains(@class, 'offers-part_count')]");
}
