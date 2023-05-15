package com.it_academy.pages.onliner;

import com.codeborne.selenide.SelenideElement;
import com.it_academy.pages.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class CartPage extends BasePage {
    private static final SelenideElement productInCart =
            $x("//div[contains(@class, 'offers-item_secondary')]");
    private static final SelenideElement productInCartTitle =
            $x("//div[contains(@class, 'cart-form')]//div[contains(@class, 'description_primary')]/a[@href]");
    private static final SelenideElement productInCartPrice =
            $x("//div[contains(@class, 'part_action')]//div[contains(@class, 'offers-part_price')]//span");

    public void verifyProductInCartIsDisplayed() {
        productInCart.shouldBe(visible, ofSeconds(20));
    }

    public String getProductInCartTitle() {
        return productInCartTitle.getText();
    }

    public String getProductInCartPrice() {
        return productInCartPrice.getText().trim();
    }
}
