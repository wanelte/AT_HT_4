package com.miamato;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {


    @Test
    public void addItemToCart() {
        final String SEARCH_TERM = propertyManager.getProperty("product.name");
        homePage.open()
                .searchByName(SEARCH_TERM);
        softAssert.assertTrue(searchResultsPage.searchedProductResult.isDisplayed());
        searchResultsPage.buyItNowFilterButton.click();
        searchResultsPage.firstPositionLink.click();
        productPage.addToCartButton.click();
        softAssert.assertNotEquals(waitForElementToBeVisible(productPage.oneItemInCart, driver, assertLogger), null);
        softAssert.assertAll();
    }
}
