@api
Feature: Gorest Test

    Scenario: Post new users
        Given I set POST api endpoint
        When I send POST HTTP request
        Then I receive valid HTTP response code 201
        And I receive valid data for new user


    Scenario: Get user details
        Given I set GET api endpoint
        When I send GET HTTP request
        Then I receive valid HTTP response code 200
