package steps.ModuleTestingPageSteps.LabTasksPageSteps;

import framework.browser.Browser;
import org.testng.Assert;
import pages.ModuleTestingPage.LabTasksPage.ResultLabMenuPage;

public class ResultLabMenuPageSteps {

    private static ResultLabMenuPage resultLabMenuPage = new ResultLabMenuPage();

    public static void sendScore(String score) {
        resultLabMenuPage.sendScore(score);
    }

    public static void clickSave() {
        resultLabMenuPage.clickSave();
    }

    public static void assertIsOpen() {
        resultLabMenuPage.switchToIframe();
        Assert.assertTrue(resultLabMenuPage.isFormOpen(), "Result lab menu page isn't open.");
        Browser.switchToDefaultContent();
    }
}
