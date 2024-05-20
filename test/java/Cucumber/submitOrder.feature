
@tag
Feature: Purchase the order from Ecommerce website

Background:
Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive test of submitting the order.
  
    Given Logged in with username <username> and password <password>
    When I add the product <productName> to the cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is disaplayed on ConfirmationPage
    
Examples: 
      | username               | password     | productName   |
      | Tejaswini@test.com     | Test@123     | ZARA COAT 3   |