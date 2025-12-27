Feature: User API Testing

  Scenario Outline: Create User
    Given I create user with the "<name>","<email>","<gender>","<status>"
    Then the response status code should be 201

    Examples:
      | name  | email         | gender | status   |
      | test4 | pra4@test.com | male   | inactive |


  Scenario: get user details by ID
    Given I have created new user
    When I send GET request for that user
    Then the response status code should be 200
    And response body should contain correct "Test User3", "testuser3@gmail.com"

  Scenario: update existing user
    Given get the user details by ID
    When I update the user name to "NewUserName"
    Then the response status code should be 200
    And response body should contain name "NewUserName"



