@ZB_003 @account_activity
Feature:Account Activity all page verifications

  Scenario: Account drop down and table columns check
    Given the user is logged in
    Then the user navigate to "Account Activity" tab
    When the "Account Activity" page should be displayed
    And the account drop down default option should be "Savings"
    And following drop down options should be have
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    Then following columns name at transactions table should have
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |

