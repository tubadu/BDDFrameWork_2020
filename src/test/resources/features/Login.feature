
 @web
   Feature: Login facebook Page
     Background:
       Given I am on Home Page

       @login
       Scenario Outline: Verify invalid login for multiple users
         When I enter <username> into username text fields on home screen
         And I enter <password> into password text fields on home screen
         And I click on login button on Homepage
         Then I verify that I am invalid login page

         Examples:
         | username |password|
         |ilhan@gmail.com|test1234|
         |tuba@gmkdf.com |asds23234|
         |drsfd@gmail.com   |fksfkl2424  |

