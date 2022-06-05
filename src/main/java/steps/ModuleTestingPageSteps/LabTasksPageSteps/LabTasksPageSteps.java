package steps.ModuleTestingPageSteps.LabTasksPageSteps;

import framework.browser.Browser;
import org.testng.Assert;
import pages.ModuleTestingPage.LabTasksPage.LabTasksPage;

public class LabTasksPageSteps {

    private static final LabTasksPage labTasksPage = new LabTasksPage();

    private LabTasksPageSteps() {
    }

    public static void clickVisitStatistics() {
        labTasksPage.clickVisitStatistics();
    }

    public static void clickResults() {
        labTasksPage.clickResults();
    }

    public static void assertIsOpen() {
        labTasksPage.switchToIframeLabs();
        Assert.assertTrue(labTasksPage.isFormOpen(), "Lab tasks page isn't open.");
        Browser.switchToDefaultContent();
    }
}
