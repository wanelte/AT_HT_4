package com.miamato;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTitleTest extends BaseTest {


    @Test
    public void verifyHomePageTitle() {
        final String PAGE_TITLE = propertyManager.getProperty("homepage.title");
        homePage.open();
        Assert.assertEquals(PAGE_TITLE, homePage.getPageTitle(assertLogger));
    }
}

