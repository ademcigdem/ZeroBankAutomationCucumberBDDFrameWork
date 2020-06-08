@ZB_005
Feature: Navigating to specific accounts

   @navigating_outline
  Scenario Outline: Different Types <tab_module> redirect verify to <selected_drop_down>
    Given the user is logged in
    And the user accesses the "<module_name>"
    When the user clicks on "<tab_module>" link on the Account Summary page
    Then the "<navigate_page>" page should be displayed
    And Account drop down should have "<selected_drop_down>" selected

    Examples: Credential Information
      | module_name     | tab_module  | navigate_page    | selected_drop_down |
      | Account Summary | Savings     | Account Activity | Savings            |
      | Account Summary | Brokerage   | Account Activity | Brokerage          |
      | Account Summary | Checking    | Account Activity | Checking           |
      | Account Summary | Credit Card | Account Activity | Credit Card        |
      | Account Summary | Loan        | Account Activity | Loan               |


