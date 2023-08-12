@PlaceOrder
Feature: As a User I want to place order in website DemoBlazes

  @Test @PositiveCase
  Scenario: User place order with valid and complete data
    Given User already on DemoBlaze home page
    And click "Cart" on navigation bar
    When click place order
    And place order pop up will appear
    Then input "AndersenASG" as name, "Indonesia" as country, "Semarang" as city, "8012380" as credit card, "August" as month, and "2023" as year
    And click purchase
    Then purchase confirmation message will appear
    Then User will redirect to home page

  @Test @NegativeCase
  Scenario Outline: User place order with missing data
    Given User already on DemoBlaze home page
    And click "Cart" on navigation bar
    When click place order
    And place order pop up will appear
    Then input "<name>" as name, "<country>" as country, "<city>" as city, "<cc>" as credit card, "<month>" as month, and "<year>" as year
    And click purchase
    Then alert message will appear "Please fill out Name and Creditcard."
  Examples:
    | name        | country   | city     | cc      | month  | year |
    |             |           |          |         |        |      |
    | AndersenASG |           |          |         |        |      |
    |             | Indonesia |          |         |        |      |
    |             |           | Semarang |         |        |      |
    |             |           |          | 8012380 |        |      |
    |             |           |          |         | August |      |
    |             |           |          |         |        | 2023 |

  @Test @NegativeCase
  Scenario: User place order with invalid data
    Given User already on DemoBlaze home page
    And click "Cart" on navigation bar
    When click place order
    And place order pop up will appear
    Then input "AndersenASG" as name, "+62" as country, "@5m9" as city, "kartu" as credit card, "@ug-" as month, and "-&&$" as year
    And click purchase
    Then alert message will appear "Please fill out with correct format."