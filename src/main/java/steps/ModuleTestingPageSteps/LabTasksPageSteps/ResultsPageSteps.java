package steps.ModuleTestingPageSteps.LabTasksPageSteps;

import framework.browser.Browser;
import org.testng.Assert;
import pages.ModuleTestingPage.LabTaskspage.ResultsPage;

public class ResultsPageSteps {

    private static ResultsPage resultsPage = new ResultsPage();


    public static void selectGroup(String group) {
        if(!resultsPage.getSelectedGroup().equals(group)) {
            resultsPage.clickSelectGroupPopMenu();
            resultsPage.clickSelectGroupPopMenuItem(group);
        }
    }

    public static void openMenuScoreLab(String date) {
        resultsPage.clickLab(date);
    }

    public static void clickMorePopMenu() {
        resultsPage.clickMorePopMenu();
    }

    public static void clickExitBtn() {
        resultsPage.clickExitBtn();
    }

    public static void assertCheck(String studentName, String lab, String score) {
        Assert.assertTrue(resultsPage.checkStudentScore(studentName, lab, score),
                "Truancy isn't visible");
    }

    public static void assertIsOpen() {
        resultsPage.switchToIframe();
        Assert.assertTrue(resultsPage.isFormOpen(), "Results page isn't open.");
        Browser.switchToDefaultContent();
    }
}
