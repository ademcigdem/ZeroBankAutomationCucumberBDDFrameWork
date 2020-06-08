@ZB_001 @login
Feature: Only authorized users should be able to login to the application.

  @positive
  Scenario: Login with valid credentials
    Given the user is logged in
    Then the "Account Summary." page should be displayed

  @negative
  Scenario: Login with invalid wrong credentials
    Given the user should not be able to login with "userName" and "passWord" credentials
    Then login error message should be displayed

  @negative
  Scenario: Login with invalid blank credentials
    Given the user should not be able to login with " " and " " credentials
    Then login error message should be displayed


  @negative @outline
  Scenario Outline: Login with <type>
    Given the user should not be able to login with "<userName>" and "<Password>" credentials
    Then login error message should be displayed
    Examples: Credential Informations
      | userName | Password | type                         |
      | username | PASSword | Wrong Password               |
      | UserNAME | password | Wrong User Name              |
      | UserNAME | Pasword  | Wrong User Name and Password |
      |          | password | Blank User Name              |
      | username |          | Blank Password               |
      |          |          | Blank User Name and Password |

