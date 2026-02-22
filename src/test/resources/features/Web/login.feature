@Web
Feature: Login

  @invalid-Login
  Scenario: login with valid username and password
    Given user is on login page
    And user input username and password text with "standard_user" and "secret_sauce"
    When user click login button
    Then user will be redirected to homepage

    @invalid-Login
  Scenario: login with invalid password
    Given user is on login page
    And user input username and password text with "standard_user" and "invalid"
    When user click login button
    Then user will see error message "Epic sadface: Username and password do not match any user in this service"