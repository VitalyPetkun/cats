package steps.ModuleTestingPageSteps.LecturesPageSteps;

import framework.browser.Browser;
import org.testng.Assert;
import pages.ModuleTestingPage.LecturesPage.VisitLecturesMenuPage;

public class VisitLecturesMenuPageSteps {

    private static VisitLecturesMenuPage visitLecturesMenuPage = new VisitLecturesMenuPage();

    private VisitLecturesMenuPageSteps() {
    }

    public static void clickTruancyPopMenu(String studentName) {
        visitLecturesMenuPage.clickTruancyPopMenu(studentName);
    }

    public static void clickTruancyPopMenuItem(String truancy) {
        visitLecturesMenuPage.clickTruancyPopMenuItem(truancy);
    }

    public static void clickSave() {
        visitLecturesMenuPage.clickSave();
    }

    public static void assertIsOpen(String date) {
        visitLecturesMenuPage.switchToIframe();
        Assert.assertEquals(visitLecturesMenuPage.getTextUniqElement(), date, "Visit lectures menu page isn't open.");
        Browser.switchToDefaultContent();
    }
}
