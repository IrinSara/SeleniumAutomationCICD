# Author: Irin
# Description: Basic Cucumber Feature Template

@tag
Feature: Error validation in login page
  This feature describes the behaviour of Test application

  @Errorvalidation
  Scenario Outline: Testcase for login error validation 
  	Given I landed on Ecommerce page
    When  Login with username <username>and password <password> 
    Then "Incorrect email or password." message is displayed on LoginPage

    Examples:
      | username                    | password    |
      | testemail112026@outlook.com | T3ster@.    |
      | testemail2026@outlook.com   | T3ste       |
    