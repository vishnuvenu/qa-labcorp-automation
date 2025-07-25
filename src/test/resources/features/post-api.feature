Feature: Validate POST API request

  Scenario: Submit POST request and validate fields
    Given I send a POST request to "https://echo.free.beeceptor.com/sample-request?author=beeceptor" with valid payload
    Then the response should include order details, customer, payment and items
