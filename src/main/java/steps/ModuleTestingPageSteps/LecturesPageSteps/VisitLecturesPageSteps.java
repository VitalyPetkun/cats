package steps.ModuleTestingPageSteps.LecturesPageSteps;

import framework.browser.Browser;
import org.testng.Assert;
import pages.ModuleTestingPage.LecturesPage.VisitLecturesPage;

public class VisitLecturesPageSteps {

    private static VisitLecturesPage visitLecturesPage = new VisitLecturesPage();

    private VisitLecturesPageSteps() {
    }

    public static void selectGroup(String group) {
        if (!visitLecturesPage.getSelectedGroup().equals(group)) {
            visitLecturesPage.clickSelectGroupPopMenu();
            visitLecturesPage.clickSelectGroupPopMenuItem(group);
        }
    }

    public static void openVisitLectureMenu(String date) {
        visitLecturesPage.clickLecture(date);
    }

    public static void clickMorePopMenu() {
        visitLecturesPage.clickMorePopMenu();
    }

    public static void clickExitBtn() {
        visitLecturesPage.clickExitBtn();
    }

    public static void assertCheck(String studentName, String date, String truancy) {
        Assert.assertTrue(visitLecturesPage.checkStudentTruancy(studentName, date, truancy),
                "Truancy isn't visible");
    }

    public static void assertIsOpen() {
        visitLecturesPage.switchToIframe();
        Assert.assertTrue(visitLecturesPage.isFormOpen(), "Visit lectures page isn't open.");
        Browser.switchToDefaultContent();
    }
}
