package runnerTest.webPages;

import org.openqa.selenium.By;

public class Messenger extends  ElementUtil {
    private By messengerlink=By.linkText("Messenger");
    private  By emailFiled=By.id("email");
    private By passwordField=By.id("pass");
    private  By signInutton=By.id("loginbutton");
    private  By errorMessage=By.xpath("//div[contains(text(),'Incorrect Email')]");

    public  void clickOnMessenger(){
        clickOn(messengerlink);
    }
    public void enterEmail(String email){
        sendValue(emailFiled,email);

    }
    public void enterPassword(String password){
        sendValue(passwordField,password);
    }
    public void clickOnSignIn(){
        clickOn(signInutton);
    }
    public  String getErrorMessage(){
        return getTextFromElement(errorMessage);
    }
    
}
