package pages;

import elements.Button;
import elements.TextBox;
import framework.BaseForm;
import org.openqa.selenium.By;

public class AuthorizationPage extends BaseForm {

    public AuthorizationPage() {
        super(new Button(By.xpath("//button[@type='submit']"),"Authorization page uniq element"), "Authorization page");
    }

    public void sendLogin(String login) {
        new TextBox(By.xpath("//input[@formcontrolname='userName']"), "Login").click();
        new TextBox(By.xpath("//input[@formcontrolname='userName']"), "Login").inputText(login);
    }

    public void sendPassword(String password) {
        new TextBox(By.xpath("//input[@formcontrolname='userName']"), "Login").click();
        new TextBox(By.xpath("//input[@formcontrolname='password']"), "Password").inputText(password);
    }

    public void clickSubmitBtn() {
        new Button(By.xpath("//button[@type='submit']"), "Submit button").click();
    }
}
