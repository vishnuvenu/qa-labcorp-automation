package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class GetApiSteps {
    Response response;


    @Given("I send a GET request to {string}")
    public void i_send_get_request(String url) {
        response = APIHelper.get(url);
        assertEquals(200, response.getStatusCode());
    }

    @Then("the response should contain fields {string}, {string}, and {string}")
    public void validate_fields(String field1, String field2, String field3) {
        String body = response.getBody().asString();
        System.out.println(body);
        assertTrue(body.contains(field1));
        assertTrue(body.contains(field2));
        assertTrue(body.contains(field3));
    }
}
