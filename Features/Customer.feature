Feature:Customers

Background:Below are the common steps for every scenario
Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" ans Password as "admin"
And Click on Login
Then User can view Dashboard

@sanity
Scenario: Add a new Customer
When User click on customer Menu
And click on customer Menu Item
And click on Add new button
Then User can View Add new customer page
When User enter customer info
And click on Save button
Then User can view confirmation message "The new customer has been added successfully."
And close browser

@regression
Scenario: Search customer by EmailId
When User click on customer Menu
And click on customer Menu Item
And Enter customer EMail
When Click on search button
Then User should found Email in the Search table
And close browser

@regression
Scenario: Search customer by name
When user click on customer Menu
And click on customer Menu Item
And Enter customer FirstName
And Enter customer LastName
When Click on search button
Then user should found Email in the Search table
And close browser