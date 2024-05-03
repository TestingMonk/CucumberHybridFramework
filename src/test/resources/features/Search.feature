@Search
Feature: Search Functionality 

@Smoke
Scenario: User searches for a valid product
Given User opens the application 
When  User enter valid product "HP" into the Search box field
And  User clicks on Search button 
Then User should get valid product displayed in Search results 

@Smoke
Scenario: User searches for an invalid product
Given User opens the application 
When  User enter invalid product "Honda" into the Search box field
And  User clicks on Search button 
Then User should get a message about no product matching 

@Regression @skip_scenario  
Scenario: User searches without any product 
Given User opens the application 
When  User dont enter any product name into the Search box field 
And  User clicks on Search button 
Then User should get a message about no product matching 