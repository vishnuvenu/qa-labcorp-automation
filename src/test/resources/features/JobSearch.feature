Feature: Job Search on LabCorp Website

  Scenario: Search and verify details of a QA job posting
    Given I open LabCorp careers website
    When I search for job titled "QA Test Automation Developer"
    And I select the job from search results
    Then I should see the correct job details
    |Job_title| Job_location | Job_id |
    | Application Developer| Navi Mumbai, Maharashtra, India |2524429|


#    And I click Apply Now and verify job details again