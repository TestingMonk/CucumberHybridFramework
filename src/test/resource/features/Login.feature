Feature: Login Functionality

Scenario Outline: Login with valid credentials
Given User has navigates to login page 
When  User enters valid email address <username> into email field
And   User enters valid password <password> into password field
And   User clicks on login button 
Then  User should get successfully logged in 
Examples:
|username           |password|
|testuser7@gmail.com|qwerty@123|
|testuser6@gmail.com|qaz123|
|viratkohli1@gmail.com|12345|


Scenario: Login with Invalid Credentials 
Given User has navigates to login page 
When User enters invalid email address into email field 
And  User enters invalid password "12345" into password field 
And  User clicks on login button 
Then User should get a warning message about credentials mismatch

Scenario: Login with valid email address and invalid password
Given User has navigates to login page
When User enters valid email address "testuser7@gmail.com" into email field 
And  User enters invalid password "12345" into password field 
And  User clicks on login button 
Then User should get a warning message about credentials mismatch

Scenario: Login with invalid email address and valid password
Given User has navigates to login page
When  User enters invalid email address into email field
And   User enters valid password "qwerty@123" into password field 
And   User clicks on login button 
Then User should get a warning message about credentials mismatch

Scenario: Login without providing any credentials
Given  User has navigates to login page 
When   User do not enter any email address into email field 
And    User do not enter any password into password field 
And    User clicks on login button 
Then User should get a warning message about credentials mismatch


