package steps.ModuleTestingPageSteps.LabTasksPageSteps;

import framework.browser.Browser;
import org.testng.Assert;
import pages.ModuleTestingPage.LabTaskspage.VisitLabMenuPage;

public class VisitLabMenuPageSteps {

    private static final VisitLabMenuPage visitLabMenuPage = new VisitLabMenuPage();

    public static void assertIsOpen(String date) {
        visitLabMenuPage.switchToIframe();
        Assert.assertEquals(visitLabMenuPage.getTextUniqElement(), date, "Visit lab menu page isn't open.");
        Browser.switchToDefaultContent();
    }
}
