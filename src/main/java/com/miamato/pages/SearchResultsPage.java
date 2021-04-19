package com.miamato.pages;

import com.miamato.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class,'s-item') and contains(@data-view, 'iid:1')][1]//a[@class='s-item__link']")
    public WebElement firstPositionLink;

    @FindBy(xpath = "//h1[@class='srp-controls__count-heading']//span[@class='BOLD'][2]")
    public WebElement searchedProductResult;

    @FindBy(xpath = "//h2[contains(text(),'Buy It Now')]")
    public WebElement buyItNowFilterButton;


    public SearchResultsPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }
}
