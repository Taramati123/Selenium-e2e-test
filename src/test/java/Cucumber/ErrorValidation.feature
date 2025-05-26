
@tag
Feature: ErrorValidation
  I want to use this template for my feature file


 
  @tag2
  Scenario Outline: negative scenario
  Given I landed on Ecommerce page
    When Logged in with username<name> and password<password>
    Then "Incorrect email or password." message is displayed 

    Examples: 
      | name  								| Password 									| productname  |
      | taramatirmn@gmail.com |     Gavdabhesi123			| ZARA COAT 3  |
