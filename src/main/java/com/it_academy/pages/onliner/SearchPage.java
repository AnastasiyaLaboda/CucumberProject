package com.it_academy.onliner.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.time.Duration.ofSeconds;

public class SearchPage extends BasePage {

    private static final SelenideElement searchForm =
            $x("//div[contains(@class, 'b-top')]//input[contains(@class, 'fast-search')]");
    private static final SelenideElement searchFrame =
            $x("//div[@class='modal-content']//iframe[@class='modal-iframe']");

    private static final String PRODUCT_SEARCH_RESULT_IN_FRAME_LINK =
            "//div[contains(@class, 'item_product')]";

    public SearchPage writeSearchQuery(String searchQuery) {
        searchForm.click();
        searchForm.sendKeys(searchQuery);
        return this;
    }

    public SearchPage switchToSearchFrame() {
        getWebDriver().switchTo().frame(searchFrame);
        return this;
    }

    public ElementsCollection getFoundProductsInSearchFrame() {
        return $$x(PRODUCT_SEARCH_RESULT_IN_FRAME_LINK)
                .should(allMatch("Verify that each element is visible",
                        element -> element.isDisplayed()), ofSeconds(30));
    }

    public ProductPage clickOnFoundProduct() {
        $x(PRODUCT_SEARCH_RESULT_IN_FRAME_LINK)
                .shouldBe(and("clickable", visible, enabled), ofSeconds(30))
                .click();
        return new ProductPage();
    }
}
