package com.miamato;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveItemFromCartTest extends BaseTest {


    @Test
    public void removeItemFromCart() {
        final String SEARCH_TERM = propertyManager.getProperty("product.name");
        homePage.open()
                .searchByName(SEARCH_TERM);
        softAssert.assertTrue(searchResultsPage.searchedProductResult.isDisplayed());
        searchResultsPage.buyItNowFilterButton.click();
        searchResultsPage.firstPositionLink.click();
        productPage.addToCartButton.click();
        Assert.assertNotEquals(waitForElementToBeVisible(productPage.goToCartButton, driver, assertLogger), null);
        productPage.goToCartButton.click();
        cartPage.deleteButton.click();
        softAssert.assertNotEquals(waitForElementToBeVisible(cartPage.emptyCart, driver, assertLogger), null);
        softAssert.assertAll();
    }
}
