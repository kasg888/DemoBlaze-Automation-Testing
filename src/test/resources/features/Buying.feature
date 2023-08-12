@Buying
Feature: As a User I want to buy something in website DemoBlaze

  @Test @PositiveCase
  Scenario: New User buying products
    Given User already on DemoBlaze home page
    And click "Sign up" on navigation bar
    And sign up pop up will appear
    Then input "asg011" as username and "test123" as password in sign up
    And click sign up button
    Then alert message will appear "Sign up successful."
    And click "Log in" on navigation bar
    And log in pop up will appear
    Then input "asg011" as username and "test123" as password in log in
    And click log in button
    Then User will redirect to home page
    And click "Phones" filter
    Then click on "Sony xperia z5"
    And User will redirect to "Sony xperia z5" product page
    And click add to cart button
    Then alert message will appear "Product added."
    And click "Home" on navigation bar
    Then User will redirect to home page
    And click "Laptops" filter
    Then click on "Sony vaio i5"
    And User will redirect to "Sony vaio i5" product page
    And click add to cart button
    Then alert message will appear "Product added."
    And click "Home" on navigation bar
    Then User will redirect to home page
    And click "Monitors" filter
    Then click on "ASUS Full HD"
    And User will redirect to "ASUS Full HD" product page
    And click add to cart button
    Then alert message will appear "Product added."
    And click "Cart" on navigation bar
    Then User will redirect to cart page
    And click place order
    And place order pop up will appear
    Then input "AndersenASG" as name, "Indonesia" as country, "Semarang" as city, "8012380" as credit card, "August" as month, and "2023" as year
    When click purchase
    Then purchase confirmation message will appear
    Then User will redirect to home page
    And click "Cart" on navigation bar
    Then User will redirect to cart page
    And cart should be empty
    And click "Log out" on navigation bar
    Then User will redirect to home page