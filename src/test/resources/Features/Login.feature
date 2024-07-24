Feature: Test Feature
  @smoke
  Scenario:Login Test First Script
    Given user logins to the application using "Valid User Name" and "Valid Password" and "Login Test First Script"
    When user runs file "Login Test First Script"
    Then user signouts "Login Test First Script"

  @smoke
  Scenario: Login Test First Script34234
    Given user logins to the application using "Valid User Name" and "Valid Password" and "Login Test First Script34234"
    When user runs file "Login Test First Script34234"
    Then user signouts "Login Test First Script34234"
#
  @smoke
  Scenario: Login Test First Ganesh
    Given user logins to the application using "Valid User Name" and "Valid Password" and "Login Test First Ganesh"
    And verify user is on HomePage "Login Test First Ganesh"
    Then user signouts from portal "Login Test First Ganesh"