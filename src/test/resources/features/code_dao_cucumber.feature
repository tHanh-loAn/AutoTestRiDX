Feature: Test feature
  Scenario Outline: Check display home page
    Given I open Login Page
    Then Input user name: <username> and password: <password>

    Examples:
    | username       | password |
    | user@gmail.com | 12345678 |
    | admin@ridx.com | 12345678 |