package pages;

import elements.Button;
import elements.TextBox;
import framework.BaseForm;
import framework.utils.PropertiesManager;
import org.openqa.selenium.By;
import services.ConfigVariables;
import services.Files;
import services.Paths;

public class AuthorizationPage extends BaseForm {

    public AuthorizationPage() {
        super(new Button(By.xpath("//button[@type='submit']"),"Submit button"), "Authorization page");
    }

    public void sendLogin(String login) {
        new TextBox(By.xpath("//input[@formcontrolname='userName']"), "Login").inputText(login);
    }

    public void sendPassword(String password) {
        new TextBox(By.xpath("//input[@formcontrolname='password']"), "Password").inputText(password);
    }

    public void clickSubmitBtn() {
        new Button(By.xpath("//button[@type='submit']"), "Submit button").click();
    }
}
