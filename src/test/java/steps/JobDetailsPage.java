package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class JobDetailsPage extends BasePage {
    // Locators
    private final By jobTitleLocator = By.cssSelector("h1");
    private final By jobLocationLocator = By.cssSelector(".job-location");
    private final By jobIdLocator = By.xpath("//span[contains(@class, 'jobId')]");

    public JobDetailsPage(WebDriver driver) {
        super(driver);
        // Wait until job title is visible to ensure page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleLocator));
    }

    public void verifyDetails(String expectedTitle, String expectedLocation, String expectedId) {
        String actualTitle = getText(jobTitleLocator);
        String actualLocation = cleanLocation(getText(jobLocationLocator));
        String actualId = getDigitsOnly(getText(jobIdLocator));

        // Clean expected values for flexible assertion
        String cleanedExpectedLocation = expectedLocation.replaceAll("[^a-zA-Z]", "");

        assertEquals("Job title mismatch", expectedTitle, actualTitle);
        assertEquals("Job location mismatch", cleanedExpectedLocation, actualLocation);
        assertEquals("Job ID mismatch", expectedId, actualId);
    }

    private String getText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText().trim();
    }

    private String cleanLocation(String locationText) {
        return locationText.replaceAll("Location", "").replaceAll("[\\[\\]]", "").replaceAll("[^a-zA-Z]", "");
    }

    private String getDigitsOnly(String text) {
        return text.replaceAll("\\D", "");
    }
}
