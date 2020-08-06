package stepdefinition;

import Utils.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import runnerTest.webPages.LoginPage;

public class LoginPageSD {
    LoginPage loginPage=new LoginPage();
    @Given("^I am on Home Page$")
    public void onHomePage(){
        Assert.assertEquals(BasePage.get().getCurrentUrl(),"https://www.facebook.com/");

    }
    @When("^I enter (.+) into (username|password) text fields on home screen$")
    public void enterDataUserandPass(String anytext,String textfield){
        switch (textfield){
            case "username":
            loginPage.enterEmail(anytext);
            break;
            case "password" :
            loginPage.enterPassword(anytext);
            break;
    
        }   
    }
    
    @And("^I click on login button on Homepage$")
    public void clickLogin(){
        loginPage.clickLoginButton();
    }
    @Then("^I verify that I am invalid login page$")
    public void verifyInvalidLogin(){
        Assert.assertEquals(BasePage.get().getTitle(),"Log into Facebook | Facebook");
    }
}

