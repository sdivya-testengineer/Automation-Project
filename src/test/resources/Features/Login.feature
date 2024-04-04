Feature: To login to a website with the Credentials
@desktop
Scenario Outline: To login with the credentials provided.

Given  I am on the Main page 
When   I can enter the  <userid> and <pwd>
Then I have logged in successfully

Examples:
| product | userid   |pwd      | 
| start   | Admin    | admin123  |