@Signup
Feature: As a User I want to sign up in website DemoBlaze

  @Test @PositiveCase
  Scenario: User sign up with valid and complete data
    Given User already on DemoBlaze home page
    And click "Sign up" on navigation bar
    And sign up pop up will appear
    When input "asg100" as username and "test123" as password in sign up
    And click sign up button
    Then alert message will appear "Sign up successful."

  @Test @NegativeCase
  Scenario Outline: User sign up with missing data
    Given User already on DemoBlaze home page
    And click "Sign up" on navigation bar
    And sign up pop up will appear
    When input "<user>" as username and "<pass>" as password in sign up
    And click sign up button
    Then alert message will appear "Please fill out Username and Password."
  Examples:
    | user   | pass    |
    |        |         |
    | asg200 |         |
    |        | test123 |

  @Test @NegativeCase
  Scenario: User sign up with username that already registered
    Given User already on DemoBlaze home page
    And click "Sign up" on navigation bar
    And sign up pop up will appear
    When input "asg001" as username and "test123" as password in sign up
    And click sign up button
    Then alert message will appear "This user already exist."