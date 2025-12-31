Feature: Login Fuctionality


# ----------> https://naveenautomationlabs.com/opencart/

@Sanity
Scenario: Login with Valid credientals
Given User open the Browser and click on MyAccountButtton 
When User Click on Outer_Login button 
And user enter valid emial "pavanoltraining@gmail.com"
And user enter valid passwords "test@123"
Then user click on inner_login button  

@Sanity
Scenario Outline: login with valid and Invalid inputs
Given User open the Browser and click on MyAccountButtton 
When User Click on Outer_Login button
And User Pass Email "<email>" and password "<password>"
Then user click on inner_login button 

Examples:
|email                        | password |
|padigampraveen6467@gmail.com |GM12*#pk  |
|dyd@gmail.com|12344|
|bdskjfd|kjsdvhdsfs|

@Sanity
Scenario: Single column
Given User open the Browser and click on MyAccountButtton 
When user Click on Registeration button
Then User pass values in Single Column
|praveen,|
|Kumar ,|
|padigam| 

@Sanity
Scenario: Single Row Key Value
Given User open the Browser and click on MyAccountButtton 
When user Click on Registeration button
When User Enter FirstName Lastname Email phonnumber
|Firstname | praveen |
|LastName  | Kumar   |
| Password | GM12*#pk|
| Cpassword|GM12*#pk |



 
#  Keep it in configure file  -->  https://opensource-demo.orangehrmlive.com/web/index.php/auth/login   
# --> NAvigate Method should be in BASEPAGE only for Good Practice 
 #@Frame
#Scenario:  switch to frame 
#Given  User switch to frame2
#When user send some message in text
#And User comeback from frame2


