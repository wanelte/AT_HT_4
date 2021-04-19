package com.miamato.pages;
import com.miamato.PropertyManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private final Logger logger = LogManager.getLogger(HomePage.class.getSimpleName());
    private final String HOME_PAGE_URL = propertyManager.getProperty("homepage.url");

    @FindBy(xpath = "//input[@aria-label='Search for anything']") //input[@id='bq']")
    public WebElement searchField;

    @FindBy(xpath = "//input[@value='Search']") //button[@title='Szukaj']")
    public WebElement searchButton;


    public HomePage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }

    @Step("Open application home page")
    public HomePage open(){
        logger.info("Trying to open application home page");
        driver.navigate().to(HOME_PAGE_URL);
        return this;
    }

    @Step("Search for a product with name: {itemName}")
    public HomePage searchByName(String itemName){
        logger.info("Performing search for product with name: " + itemName);
        clickOnElement(searchField, logger);
        searchField.sendKeys(itemName);
        clickOnElement(searchButton, logger);
        return this;
    }
}

