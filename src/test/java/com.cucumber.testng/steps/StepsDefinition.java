package com.cucumber.testng.steps;

import com.it_academy.navigation.OnlinerUrls;
import com.it_academy.pages.onliner.CartPage;
import com.it_academy.pages.onliner.ProductPage;
import com.it_academy.pages.onliner.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.it_academy.navigation.OnlinerNavigation.navigateToOnlinerPage;
import static org.assertj.core.api.Assertions.*;

public class StepsDefinition {
    private SearchPage searchPage = new SearchPage();
    private ProductPage productPage = new ProductPage();
    private CartPage cartPage = new CartPage();
    private String productTitle;
    private String productPrice;

    @Given("the user is navigated to Onliner website")
    public void userIsNavigatedToOnlinerWebsite() {
        navigateToOnlinerPage(OnlinerUrls.HOME);
    }

    @When("the user enters {string} in Search form")
    public void entersQueryInSearchForm(String Query) {
        searchPage.writeSearchQuery(Query);
    }

    @When("the user clicks on the {int} product in the search result")
    public void userClicksOnTheProductInTheSearchResult(int foundProductNumber) {
        searchPage
                .switchToSearchFrame()
                .clickOnFoundProduct(foundProductNumber);
    }

    @When("the user add the {int} seller's offer product to the cart")
    public void userAddProductToTheCart(int sellerOfferNumber) {
        productPage.exitFrame();
        productPage.clickOnSellerOfferCartButton(sellerOfferNumber);
        productTitle = productPage.getAddedToCartProductTitle();
        productPrice = productPage.getAddedToCartProductPrice();
    }

    @When("the user goes to the shopping cart")
    public void userGoesToCart() {
        productPage.clickOnGoToCartButton();
    }

    @Then("added to the cart product is displayed")
    public void addedToTheCartProductIsDisplayed() {
        cartPage.verifyProductInCartIsDisplayed();
    }

    @And("the product title is the same")
    public void compareProductTitle() {
        assertThat(cartPage.getProductInCartTitle())
                .as("The product with title " + productTitle + " was added to the cart, but another title is displayed in the cart")
                .isEqualTo(productTitle);
    }

    @And("the product price is the same")
    public void compareProductPrice() {
        assertThat(cartPage.getProductInCartPrice())
                .as("The product with price " + productPrice + " was added to the cart, but another price is displayed in the cart")
                .isEqualTo(productPrice);
    }
}
