#@ZB_005 @navigating_account_activity
#Feature: Navigating to specific accounts in Accounts Activity
#
#  Background:
#    Given the user is logged in
#    And the user accesses the "Account Summary"
#
#@savings_accounts
#  Scenario: Savings account redirect
#    When the user clicks on "Savings" link on the Account Summary page
#    Then the "Account Activity" page should be displayed
#    And Account drop down should have "Savings" selected
#
#  @brokerage_accounts
#  Scenario: Brokerage account redirect
#    When the user clicks on "Brokerage" link on the Account Summary page
#    Then the "Account Activity" page should be displayed
#    And Account drop down should have "Brokerage" selected
#
#  @checking_accounts
#  Scenario: Checking account redirect
#    When the user clicks on "Checking" link on the Account Summary page
#    Then the "Account Activity" page should be displayed
#    And Account drop down should have "Checking" selected
#
#  @credit_card_accounts
#  Scenario: Credit Card account redirect
#    When the user clicks on "Credit Card" link on the Account Summary page
#    Then the "Account Activity" page should be displayed
#    And Account drop down should have "Credit Card" selected
#
#  @loan_accounts
#  Scenario: Loan account redirect
#    When the user clicks on "Loan" link on the Account Summary page
#    Then the "Account Activity" page should be displayed
#    And Account drop down should have "Loan" selected