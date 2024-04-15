Feature: Toi di code dao page
  Scenario: Check display home page
    Given I open Home Page
    Then I see ten posts last most recent
  Scenario: Check date of post
    Given I open Home Page
    When I hover Chuyen Coding on menu bar
    And I hover and click Series bao mat nhap mon
    Then Series bao mat nhap mon page open in a new tab
    When I click December 2020 in Luu Tru
    Then I see post in December 2020
    And Link Continue Reading is displayed in each post
