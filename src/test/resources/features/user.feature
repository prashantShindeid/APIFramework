Feature: User API Testing


  @Smoke
    @AllureId(101)
    @Severity(CRITICAL)
  Scenario Outline: Create User
    Given I create user with the "<name>","<email>","<gender>","<status>"
    Then the response status code should be 201

    Examples:
      | name  | email         | gender | status   |
      | test4 | pra4@test.com | male   | inactive |

  @Smoke
  @AllureId(101)
  @Severity(NORMAL)
  Scenario: get user details by ID
    Given I have created new user
    When I send GET request for that user
    Then the response status code should be 200
    And response body should contain correct "Test User3", "testuser3@gmail.com"

  @AllureId(101)
  @Severity(TRIVIAL)
  @Smoke
  Scenario: Update existing user using ID
    Given the user id is "7681934"
    And the update payload is:
    """
    {
      "name": "NewUserName"
    }
    """
    When I send a PUT request to "/users/{id}"
    Then the response status code should be 200
    And the response body field name should be "NewUserName"


     @Smoke
     @AllureId(101)
     @Severity(MINOR)
     Scenario: Delete exisiting user using ID
       Given the user id is "7681934"
       When I send a delete request to "/users/{id}"
       Then the response status code should be 404


