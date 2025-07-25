package api.stepdefs;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import steps.APIHelper;
import utils.FileUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class PostApiSteps {
    Response response;

    @Given("I send a POST request to {string} with valid payload")
    public void send_post(String url) {
        String payload = FileUtils.readJsonFileAsString("src/test/java/utils/payload.json");


        response = APIHelper.post(url,payload);

        assertEquals(200, response.getStatusCode());
    }

    @Then("the response should include order details, customer, payment and items")
    public void validate_post_response() {
        String body = response.getBody().asString();
        assertTrue(body.contains("order_id"));
        assertTrue(body.contains("customer"));
        assertTrue(body.contains("payment"));
        assertTrue(body.contains("items"));
    }
}
