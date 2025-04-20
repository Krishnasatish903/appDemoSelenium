Feature: Login Functionality
  I want to test the login functionality
  
  Scenario Outline:  Login with Various Inputs
    Given I am on the Login Page
    When user enters username "<userName>" and password "<password>"
    Then I should see "<result>"
    
    Examples:
    |userName|password|result|
    |Admin|admin123|Dashboard|
    |Admin|wrongPass|Invalid credentials|
    |wrongUserName|admin123|Invalid credentials|
    |null|null|Invalid credentials|
