@ZB_005 @navigating_account_activity
Feature: Navigating to specific accounts

  Background:

 # Scenario Outline: Savings account redirect
  #  Given the user is logged in
  #  And the user acceses the <module_name>
  #  When the user clicks on <tab_module> link on the Account Summary page
  #  Then the <navigate_page> page should be displayed
  #  And Account drop down should have <selected_drop_down> selected

  #  Examples: Credential Information
    |module_name|tab_module|navigate_page|selected_drop_down|
    |Account Summary|Savings|Account Activity|Savings|
    |Account Summary|Brokerage|Account Activity|Brokerage|
    |module_name|tab_module|navigate_page|selected_drop_down|
    |module_name|tab_module|navigate_page|selected_drop_down|


  Scenario: Brokerage account redirect
    When the user clicks on "Brokerage" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Brokerage" selected

  Scenario: Checking account redirect
    When the user clicks on "Checking" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Checking" selected

  Scenario: Credit Card account redirect
    When the user clicks on "Credit Card" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Credit Card" selected

  Scenario: Loan account redirect
    When the user clicks on "Loan" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Loan" selected