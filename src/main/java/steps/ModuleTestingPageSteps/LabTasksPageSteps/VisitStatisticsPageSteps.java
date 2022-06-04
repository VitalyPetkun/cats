package steps.ModuleTestingPageSteps.LabTasksPageSteps;

import org.testng.Assert;
import pages.ModuleTestingPage.LabTaskspage.VisitStatisticsPage;

public class VisitStatisticsPageSteps {

    private static final VisitStatisticsPage visitStatisticsPage = new VisitStatisticsPage();

    public void selectGroup(String group) {
        visitStatisticsPage.clickSelectGroupPopMenu();
        visitStatisticsPage.clickSelectGroupPopMenuItem(group);
    }

    public void openMenuVisitLab(String date) {
        visitStatisticsPage.clickLab(date);
    }

    public static void assertIsOpen() {
        Assert.assertTrue(visitStatisticsPage.isFormOpen(), "Visit statistics page isn't open.");
    }
}
