package com.miamato.pages;

import com.miamato.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(text(),'Checkout 1 item')]")
    public WebElement oneItemInCart;

    @FindBy(xpath = "//span[contains(text(),'Go to cart')]")
    public WebElement goToCartButton;

    public ProductPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }
}

