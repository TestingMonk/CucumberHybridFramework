Feature: Registration functionality 

Scenario: User creates an account only with mandatory fields
Given User navigates to registration page 
When  User enters below details into the corresponding fields
|firstName|Virat                |
|lastName |Kohli                |
|telephone|123456789            |
|password |12345                |
And User selects Privacy Policy
And User clicks on Continue button
Then User Account should get created successfully 

Scenario: User creates an account with all the fields
Given User navigates to registration page 
When  User enters below details into the corresponding fields
|firstName|Virat                |
|lastName |Kohli                |
|telephone|123456789            |
|password |12345                |
And User selects Yes for newsletter 
And User selects Privacy Policy
And User clicks on Continue button
Then User Account should get created successfully 

Scenario: User creates duplicate account
Given User navigates to registration page 
When  User enters below details into the corresponding fields with duplicate address
|firstName|Virat                |
|lastName |Kohli                |
|email    |viratkohli2@gmail.com|
|telephone|123456789            |
|password |12345                |
And User selects Yes for newsletter 
And User selects Privacy Policy
And User clicks on Continue button
Then User should get proper warning message about duplicate email address

Scenario: User creates an account without providing any details 
Given User navigates to registration page 
When  User doesnt enters any details into fields
And User clicks on Continue button
Then User should get proper warning message for every mandatory field 
  


