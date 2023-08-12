@Login
Feature: As a User I want to log in in website DemoBlaze

  @Test @PositiveCase
  Scenario: User log in with valid and complete data
    Given User already on DemoBlaze home page
    And click "Log in" on navigation bar
    And log in pop up will appear
    When input "asg011" as username and "test123" as password in log in
    And click log in button
    Then User will redirect to home page

  @Test @NegativeCase
  Scenario Outline: User log in with missing data
    Given User already on DemoBlaze home page
    And click "Log in" on navigation bar
    And log in pop up will appear
    When input "<user>" as username and "<pass>" as password in log in
    And click log in button
    Then alert message will appear "Please fill out Username and Password."
  Examples:
    | user   | pass    |
    |        |         |
    | asg001 |         |
    |        | test123 |

  @Test @NegativeCase
  Scenario: User log in with username that not registered
    Given User already on DemoBlaze home page
    And click "Log in" on navigation bar
    And log in pop up will appear
    When input "username baru" as username and "test123" as password in log in
    And click log in button
    Then alert message will appear "User does not exist."

  @Test @NegativeCase
  Scenario: User log in with wrong password
    Given User already on DemoBlaze home page
    And click "Log in" on navigation bar
    And log in pop up will appear
    When input "asg001" as username and "salah" as password in log in
    And click log in button
    Then alert message will appear "Wrong password."