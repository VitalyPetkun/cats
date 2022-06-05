package steps.ModuleTestingPageSteps.LabTasksPageSteps;

import framework.browser.Browser;
import org.testng.Assert;
import pages.ModuleTestingPage.LabTasksPage.VisitLabMenuPage;

public class VisitLabMenuPageSteps {

    private static final VisitLabMenuPage visitLabMenuPage = new VisitLabMenuPage();

    private VisitLabMenuPageSteps() {
    }

    public static void clickTruancyPopMenu(String studentName) {
        visitLabMenuPage.clickTruancyPopMenu(studentName);
    }

    public static void clickTruancyPopMenuItem(String truancy) {
        visitLabMenuPage.clickTruancyPopMenuItem(truancy);
    }

    public static void clickSave() {
        visitLabMenuPage.clickSave();
    }

    public static void assertIsOpen(String date) {
        visitLabMenuPage.switchToIframe();
        Assert.assertEquals(visitLabMenuPage.getTextUniqElement(), date, "Visit lab menu page isn't open.");
        Browser.switchToDefaultContent();
    }
}
