Feature:Customers

Background:Below are the common steps for every scenario
Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" ans Password as "admin"
And Click on Login
Then User can view Dashboard

@sanity
Scenario: Add a new Customer
When user click on customer Menu
And click on customer menu Item
And click on add new Button
Then user can view Add new customer Page
When user enter customer info
And click on save button
Then user can view confirmation message "The new customer has been added successfully."
And close browser

@regression
Scenario: search customer by EmailId
When user click on customer Menu
And click on customer menu Item
And Enter customer EMail
When Click on search button
Then user should found Email in the Search table
And close browser

@regression
Scenario: Search customer by name
When user click on customer menu
And click on customer Menu item
And Enter customer FirstName
And Enter customer LastName
When Click on search button
Then user should found Email in the Search table
And close browser