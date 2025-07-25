package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIHelper {

    private static final String BASE_URI = "https://echo.free.beeceptor.com";

    public static Response get(String endpoint) {
        RestAssured.baseURI = BASE_URI;

        RequestSpecification request = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json");

        return request.get(endpoint);
    }

    public static Response post(String endpoint, String jsonPayload) {
        RestAssured.baseURI = BASE_URI;

        RequestSpecification request = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .body(jsonPayload);

        return request.post(endpoint);
    }
}
