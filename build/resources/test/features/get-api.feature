Feature: Validate GET API response

  Scenario: Validate fields in GET response
    Given I send a GET request to "https://echo.free.beeceptor.com/sample-request?author=beeceptor"
    Then the response should contain fields "path", "ip", and "headers"
