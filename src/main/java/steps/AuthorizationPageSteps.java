package steps;

import org.testng.Assert;
import pages.AuthorizationPage;

public class AuthorizationPageSteps {

    private static final AuthorizationPage authorizationPage = new AuthorizationPage();

    private AuthorizationPageSteps() {}

    public static void sendLogin(String login) {
        authorizationPage.sendLogin(login);
    }

    public static void sendPassword(String password) {
        authorizationPage.sendPassword(password);
    }

    public static void clickSubmitBtn() {
        authorizationPage.clickSubmitBtn();
    }

    public static void assertIsOpen() {
        Assert.assertTrue(authorizationPage.isFormOpen(), "Authorization page isn't open.");
    }
}
