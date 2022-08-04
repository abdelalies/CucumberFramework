Feature: Sauce Demo Login
  This feature focuses on positive and negative
  login tests

  Background:
    Given I'm on the SauceDemo home page

@SauceValidLogin @SmokeTests
Scenario: Valid login test
  When  I enter valid username "standard_user" password "secret_sauce"
  And I click on the login button
  Then I should be directed to user homepage
  And  There should be 6 items in the page


@SauceInvalidLogin
Scenario: Invalid Login test
  When  I enter invalid username "standard_user" invalid password "secret_invalid"
  And I click on the login button
  Then I shouldn't be logged in, still at the homepage
  And I receive the following error message should display under password field "Epic sadface: Username and password do not match any user in this service"


#  This is just another way of doing the above one in scenario outline
@SauceInvalidTests
Scenario Outline: User is not able to log in with invalid credentials
  When I enter invalid username "<username>" invalid password <Ipassword>"
  And I click on the login button
  Then I shouldn't be logged in, still at the homepage
  And An error message should be displayed "Epic sadface: Username and password do not match any user in this service"

  Examples: Credentials
  |username|  |Ipassword|
  |standard_user| |secret_invalid|
  |standard     | |standarddddd  |
  |standard123  | |standard652   |
