package com.miamato;
import org.testng.annotations.Test;


public class SearchItemTest extends BaseTest {


    @Test
    public void searchItem() {
        final String SEARCH_TERM = propertyManager.getProperty("product.name");
        homePage.open()
                .searchByName(SEARCH_TERM);
        softAssert.assertTrue(searchResultsPage.searchedProductResult.isDisplayed());
        softAssert.assertAll();
    }
}
