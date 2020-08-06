package stepdefinition;

import Utils.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import runnerTest.webPages.Messenger;

public class MessengerSD {
    private Messenger messenger = new Messenger();

    @Given("^I am on messenger page$")
    public void setMessenger() {
        messenger.clickOnMessenger();
        Assert.assertEquals(BasePage.get().getCurrentUrl(), "https://www.messenger.com/");
    }

    @When("^I enter (.+) into (username|password) field on the messenger page$")
    public void enterDataIntoTextField(String value, String textfield) {
        switch (textfield) {
            case "username":
                messenger.enterEmail(value);
                break;
            case "password":
                messenger.enterPassword(value);
                break;
        }
    }
    @And("^I click on login button on messenger page$")
    public void clickLogin(){
        messenger.clickOnSignIn();
    }
    @Then("^I verify invalid login message on sign in page$")
    public void verifySignInErrorMessage(){
        Assert.assertEquals(messenger.getErrorMessage(),"Incorrect Email");
    }
}