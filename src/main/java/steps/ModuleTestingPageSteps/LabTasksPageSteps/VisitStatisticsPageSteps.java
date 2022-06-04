package steps.ModuleTestingPageSteps.LabTasksPageSteps;

import framework.browser.Browser;
import org.testng.Assert;
import pages.ModuleTestingPage.LabTaskspage.VisitStatisticsPage;

public class VisitStatisticsPageSteps {

    private static final VisitStatisticsPage visitStatisticsPage = new VisitStatisticsPage();

    public static void selectGroup(String group) {
        if(!visitStatisticsPage.getSelectedGroup().equals(group)) {
            visitStatisticsPage.clickSelectGroupPopMenu();
            visitStatisticsPage.clickSelectGroupPopMenuItem(group);
        }
    }

    public static void openMenuVisitLab(String date) {
        visitStatisticsPage.clickLab(date);
    }

    public static void assertIsOpen() {
        visitStatisticsPage.switchToIframe();
        Assert.assertTrue(visitStatisticsPage.isFormOpen(), "Visit statistics page isn't open.");
        Browser.switchToDefaultContent();
    }
}
