# Author: Irin
# Description: Basic Cucumber Feature Template

@tag
Feature: Purchase an order from Ecommerce Page
  This feature describes the behaviour of Test application

Background:
Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Testcase for submitting an order 
    Given Login with username <username>and password <password>
    When I add product <productName> to cart
    And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples:
      | username                  | password    | productName |
      | testemail2026@outlook.com | T3ster@.    | ZARA COAT 3 |
    
