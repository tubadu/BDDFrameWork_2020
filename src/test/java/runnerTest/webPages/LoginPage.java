package runnerTest.webPages;

import org.openqa.selenium.By;

public class LoginPage extends  ElementUtil {
    private By emailTextField=By.id("email");
    private By PasswordTextField=By.id("pass");
    private By loginButton=By.id("u_0_b");
    public void enterEmail(String enteremail){
        sendValue(emailTextField,enteremail);

    }
    public void enterPassword(String enterPassword){
        sendValue(PasswordTextField,enterPassword);

    }
    public void clickLoginButton(){
        clickOn(loginButton);
    }


}
