Feature: Google Search Automation
  @smoke @xxx
  Scenario: Google Search Automation
    Given I am the "login" Page
    And I set the "userID" field to "Valid User Name"
    And I set the "userPassword" field to "Valid Password"
    When I click the "login" button
    When verify user is on HomePage "Google Search Automation"
    Then user signouts from portal "Google Search Automation"

  @smoke
  Scenario: Google Search Automation3434
   Given user logins to the application using "Valid User Name" and "Valid Password" and "Google Search Automation3434"
    When verify user is on HomePage "Google Search Automation3434"
    Then user signouts from portal "Google Search Automation3434"