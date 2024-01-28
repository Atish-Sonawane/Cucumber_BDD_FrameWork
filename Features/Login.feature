Feature: Login
@Sanity
Scenario: Successful Login with Valid Credentials
Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" ans Password as "admin"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Logout link
Then close browser

@Regression
Scenario Outline:
Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "<email>" ans Password as "<password>"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Logout link
Then close browser

Examples:
|email | password|
| admin@yourstore.com | admin |
| dmin@yourstore.com | admin123 |