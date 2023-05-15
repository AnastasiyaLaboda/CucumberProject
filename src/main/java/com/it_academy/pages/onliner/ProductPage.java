package com.it_academy.pages.onliner;

import com.codeborne.selenide.SelenideElement;
import com.it_academy.pages.BasePage;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.CollectionCondition.anyMatch;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class ProductPage extends BasePage {
    private static final String PRODUCT_ASIDE_BUTTON_CART_LINK =
            "//div[contains(@class, 'offers-list')]//*[contains(@class, 'button_cart')]";

    private static final SelenideElement addedToCartProductTitle =
            $x("//div[contains(@class, 'list_alter')]//div[contains(@class, 'title')]");

    private static final SelenideElement addedToCartProductPrice =
            $x("//div[contains(@class, 'list_alter')]//div[contains(@class, 'price')]");

    private static final SelenideElement goToCartButton =
            $x("//div[contains(@class, 'control_checkout')]//*[contains(@href, 'cart')]");

    public CartPage clickOnGoToCartButton() {
        goToCartButton
                .shouldBe(visible, ofSeconds(20))
                .click();
        return new CartPage();
    }

    public ProductPage clickOnSellerOfferCartButton(int sellerOfferNumber) {
        try {
            $$x(PRODUCT_ASIDE_BUTTON_CART_LINK)
                    .should(anyMatch("Verify that each element is visible", WebElement::isEnabled), ofSeconds(30))
                    .get(sellerOfferNumber - 1).click();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The seller's offers result is less than the specified index");
            e.printStackTrace();
        }
        return this;
    }

    public String getAddedToCartProductTitle() {
        return addedToCartProductTitle.getText();
    }

    public String getAddedToCartProductPrice() {
        return addedToCartProductPrice.getText().trim();
    }
}
