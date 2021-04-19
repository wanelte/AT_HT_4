package com.miamato.pages;

import com.miamato.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//button[@data-test-id ='cart-remove-item']")
    public WebElement deleteButton;
    @FindBy(xpath = "//a[@aria-label='Your shopping cart is empty']")
    public WebElement emptyCart;

    public CartPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }
}
