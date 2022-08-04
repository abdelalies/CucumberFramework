Feature: Amazon Search
    As a user, I should be able to search an item and the searched item should be relevant to search

  @amazonSearch @SmokeTests
  Scenario Outline: User is able to search multiple data set
    Given I am on amazon home page
    When I search item "<items>"
    And I click the search button
    Then search item "<items>" should be displayed in the search bar


    Examples: items
     |items|
     |coffee mug|
     |Pretty coffee mug|
     |Cool coffee mug  |
     |cute coffee mug  |
     |Ugly coffee mug  |