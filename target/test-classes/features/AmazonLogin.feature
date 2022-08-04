@tag
  Feature: Amazon Login
    I want to be able to login with valid credentials.
    I shouldn't be logged in with invalid credentials.

  @amazonLogin
  Scenario: User should be directed to log in page
    Given I am on amazon home page
    And the sign in button displays
    When I click on the Sign in button
    Then I should be directed to log in page


  @amazonLogin @amazonInvalidUser
  Scenario: User should not be directed to password field when an invalid email is provided
    Given I'm on the login page
    When I enter an invalid email address "jon.dow@gmail.com"
    And I click continue button
    Then An error message should be displayed "We cannot find an account with that email address"
    And I should still be in the login page
