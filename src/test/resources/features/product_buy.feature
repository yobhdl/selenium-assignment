Feature: Buy a Product
  Scenario: Buy a Jacket

    Given user navigates to registration page
    When  user registers with user information
    And   user buy montana jacket
    Then order is placed successfully


