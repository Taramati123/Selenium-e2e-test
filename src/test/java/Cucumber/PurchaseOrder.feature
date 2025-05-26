
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

Background: 
Given : I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username<name> and password<password>
    When add product<productname> to cart
    And Checkout<productname> and submit the order
    Then "THANK YOU FOR THE ORDER" message is displayed on ConfirmationPage

    Examples: 
      | name  								| Password 									| productname  |
      | taramatirmn@gmail.com |     Gavdabhesi123!@				| ZARA COAT 3  |
     
