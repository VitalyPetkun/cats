package steps.ModuleTestingPageSteps.LabTasksPageSteps;

import framework.browser.Browser;
import org.testng.Assert;
import pages.ModuleTestingPage.LabTasksPage.VisitStatisticsPage;

public class VisitStatisticsPageSteps {

    private static final VisitStatisticsPage visitStatisticsPage = new VisitStatisticsPage();

    private VisitStatisticsPageSteps() {
    }

    public static void selectGroup(String group) {
        if (!visitStatisticsPage.getSelectedGroup().equals(group)) {
            visitStatisticsPage.clickSelectGroupPopMenu();
            visitStatisticsPage.clickSelectGroupPopMenuItem(group);
        }
    }

    public static void openVisitLabMenu(String date) {
        visitStatisticsPage.clickLab(date);
    }

    public static void clickMorePopMenu() {
        visitStatisticsPage.clickMorePopMenu();
    }

    public static void clickExitBtn() {
        visitStatisticsPage.clickExitBtn();
    }

    public static void assertCheck(String studentName, String date, String truancy) {
        Assert.assertTrue(visitStatisticsPage.checkStudentTruancy(studentName, date, truancy),
                "Truancy isn't visible");
    }

    public static void assertIsOpen() {
        visitStatisticsPage.switchToIframe();
        Assert.assertTrue(visitStatisticsPage.isFormOpen(), "Visit statistics page isn't open.");
        Browser.switchToDefaultContent();
    }
}
