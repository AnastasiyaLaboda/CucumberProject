package com.it_academy.onliner.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage {
    private static final SelenideElement productTitle =
            $x("//div[contains(@class, 'catalog-masthead')]//h1[contains(@class, 'title')]");

    private static final String PRODUCT_ASIDE_OFFERED_PRICE_LINK =
            "//div[contains(@class, 'offers-list')]//div[contains(@class, 'description')]/a[contains(@class, 'price')]/span";

    private static final String PRODUCT_ASIDE_BUTTON_CART_LINK =
            "//div[contains(@class, 'offers-list')]//*[contains(@class, 'button_cart')]";

    private static final SelenideElement addedToCartProductTitle =
            $x("//div[contains(@class, 'list_alter')]//div[contains(@class, 'title')]");

    private static final SelenideElement addedToCartProductPrice =
            $x("//div[contains(@class, 'list_alter')]//div[contains(@class, 'price')]");

    private static final SelenideElement goToCartButton =
            $x("//div[contains(@class, 'control_checkout')]//*[contains(@href, 'cart')]");


    public ProductPage addProductToCart() {
        $x(PRODUCT_ASIDE_BUTTON_CART_LINK).click();
        return this;
    }

    public BasketPage clickOnGoToCartButton() {
        goToCartButton.click();
        return new BasketPage();
    }


}
