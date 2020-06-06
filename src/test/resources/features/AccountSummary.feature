@ZB_002
Feature:Account Summary all page verifications


  @account_summary
  Scenario: Account types and table colums check
    Given the user is logged in
    When the "Account Summary" page should be displayed
    Then following account types should be displayed
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    And following colums at Credit Account table must have
      | Account     |
      | Credit Card |
      | Balance     |
