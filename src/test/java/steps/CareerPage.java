package steps;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CareerPage extends BasePage{


    // Locators
    private final By searchInput = By.id("typehead");

    public CareerPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(searchInput));
    }

    public void searchForJob(String title) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        input.clear(); // Ensures no leftover text
        input.sendKeys(title, Keys.ENTER);
    }

    public void safeClick(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (ElementClickInterceptedException e) {
            WebElement fallbackElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fallbackElement);
        }
    }
}
