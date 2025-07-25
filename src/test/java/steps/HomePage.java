package steps;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{


    // Locators
    private final By acceptCookiesButton = By.xpath("//button[text()='Accept All Cookies']");
    private final By careersLink = By.linkText("Careers");

    public HomePage(WebDriver driver) {
        super(driver);

    }

    public void goToHomePage() {
        driver.get("https://www.labcorp.com");
        driver.manage().window().maximize();
        safeClick(acceptCookiesButton);
    }

    public void clickCareersLink() {
        safeClick(careersLink);
    }

    private void safeClick(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (ElementClickInterceptedException e) {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
}
