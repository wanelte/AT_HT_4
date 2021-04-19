package com.miamato;

import com.miamato.listeners.TestReporter;
import com.miamato.listeners.TestResultsListener;
import com.miamato.pages.CartPage;
import com.miamato.pages.HomePage;
import com.miamato.pages.ProductPage;
import com.miamato.pages.SearchResultsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

@Listeners({TestResultsListener.class, TestReporter.class})
public abstract class BaseTest {

    public final Logger assertLogger = LogManager.getLogger("Assert");
    protected WebDriver driver;
    protected HomePage homePage;
    protected SearchResultsPage searchResultsPage;
    protected CartPage cartPage;
    protected ProductPage productPage;
    protected DriverManager driverManager;
    protected PropertyManager propertyManager;
    protected SoftAssert softAssert;

    @Parameters({"browserName", "testDataFileName"})
    @BeforeClass
    public void setup(@Optional("Chrome") String browserName
            , @Optional("default.properties") String testDataFileName
            , ITestContext context) {
        driverManager = new DriverManager();
        driver = driverManager.getDriver(browserName);
        context.setAttribute("WebDriver", driver);
        //driver.manage().window().maximize();

        propertyManager = new PropertyManager(testDataFileName);
        softAssert = new SoftAssert();

        homePage = new HomePage(driver, propertyManager);
        searchResultsPage = new SearchResultsPage(driver, propertyManager);
        cartPage = new CartPage(driver, propertyManager);
        productPage = new ProductPage(driver, propertyManager);
    }

    @AfterMethod
    public void browserReset() {
        driver.manage().deleteAllCookies();

    }

    @AfterClass
    public void cleanUp() {
        driver.quit();
    }

    public WebElement waitForElementToBeVisible(WebElement element, WebDriver driver, Logger logger) {
        WebElement visibleElement = null;
        try {
            visibleElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(1))
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.error(" ---- Element with XPath: " + element + "  was not found on the page.");
            LogUtil.logStackTrace(e, logger);
        }
        return visibleElement;
    }
}