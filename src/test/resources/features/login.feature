Feature: Login feature of the automation practice

  Scenario Outline: Login successful with valid credentials
    Given User is on application login page
    When User enters valid "<emailid>" and "<password>"
    Then The user is able to login successfully

    Examples:
      | emailid       | password   |
      | sannn@med.com | Saibaba1@3 |
