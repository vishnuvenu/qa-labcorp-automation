package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import utils.DriverFactory;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class JobSearchSteps {
    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String jobTitle, jobLocation, jobId;
    CareerPage careerPage;
    CareerSearchResultsPage careerSearchResultsPage;

    @Given("I open LabCorp careers website")
    public void open_labcorp() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        homePage.clickCareersLink();
        careerPage = new CareerPage(driver);

    }

    @When("I search for job titled {string}")
    public void search_job(String title) {
        careerPage.searchForJob(title);
        careerSearchResultsPage = new CareerSearchResultsPage(driver);
    }

    @When("I select the job from search results")
    public void select_job() {

        careerSearchResultsPage.selectFirstJob();

    }

    @Then("I should see the correct job details")
    public void verify_job_details(DataTable dataTable) {

        JobDetailsPage jobDetailsPage = new JobDetailsPage(driver);
        List<Map<String, String>> jobDetails = dataTable.asMaps(String.class, String.class);
        Map<String, String> expected = jobDetails.get(0);
        String expectedTitle = expected.get("Job_title");
        String expectedLocation = expected.get("Job_location");
        String expectedId = expected.get("Job_id");
        jobDetailsPage.verifyDetails(expectedTitle,expectedLocation,expectedId);







    }

    @Then("I click Apply Now and verify job details again")
    public void click_apply_and_verify() {
        driver.findElement(By.linkText("Apply Now")).click();
        assertTrue(driver.getPageSource().contains(jobTitle));
        assertTrue(driver.getPageSource().contains(jobLocation));
        assertTrue(driver.getPageSource().contains(jobId));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}