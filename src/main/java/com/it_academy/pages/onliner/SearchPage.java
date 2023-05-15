package com.it_academy.pages.onliner;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.pages.BasePage;
import org.openqa.selenium.WebElement;

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
    private static final String PRODUCTS_SEARCH_RESULT_IN_FRAME_LINK = "//div[contains(@class, 'item_product')]";

    public SearchPage writeSearchQuery(String searchQuery) {
        searchForm.shouldBe(visible, ofSeconds(20)).click();
        searchForm.clear();
        searchForm.sendKeys(searchQuery);
        return this;
    }

    public SearchPage switchToSearchFrame() {
        getWebDriver().switchTo().frame(searchFrame);
        return this;
    }

    public ElementsCollection getFoundProductsInSearchFrame() {
        return $$x(PRODUCTS_SEARCH_RESULT_IN_FRAME_LINK)
                .should(allMatch("Verify that each element is visible",
                        WebElement::isDisplayed), ofSeconds(30));
    }

    public ProductPage clickOnFoundProduct(int productNumber) {
        try {
            $$x(PRODUCTS_SEARCH_RESULT_IN_FRAME_LINK)
                    .should(allMatch("Verify that each element is visible", WebElement::isDisplayed), ofSeconds(30))
                    .get(productNumber - 1).click();
            return new ProductPage();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The search result is less than the specified index");
            e.printStackTrace();
        }
        return null;
    }
}
