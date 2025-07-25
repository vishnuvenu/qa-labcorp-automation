package steps;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CareerSearchResultsPage extends BasePage {

    private final By jobItems = By.xpath("//li[@class='jobs-list-item']//a");

    public CareerSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void selectFirstJob() {
        List<WebElement> jobLinks = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(jobItems));
        if (!jobLinks.isEmpty()) {
            safeClick(jobLinks.get(0));
        } else {
            throw new NoSuchElementException("No job listings found to select.");
        }
    }

//    public List<JobListing> getAllJobListings() {
//        List<JobListing> listings = new ArrayList<>();
//        List<WebElement> jobElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(jobItems));
//
//        for (WebElement job : jobElements) {
//            String title = job.getText();
//            String href = job.getAttribute("href");
//            listings.add(new JobListing(title, href));
//        }
//        return listings;
//    }

    private void safeClick(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
}
