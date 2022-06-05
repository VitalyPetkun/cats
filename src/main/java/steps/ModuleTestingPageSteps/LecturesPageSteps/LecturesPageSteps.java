package steps.ModuleTestingPageSteps.LecturesPageSteps;

import framework.browser.Browser;
import org.testng.Assert;
import pages.ModuleTestingPage.LecturesPage.LecturesPage;

public class LecturesPageSteps {

    private static LecturesPage lecturesPage = new LecturesPage();

    private LecturesPageSteps() {
    }

    public static void clickVisitLectures() {
        lecturesPage.clickVisitLectures();
    }

    public static void assertIsOpen() {
        lecturesPage.switchToIframeLectures();
        Assert.assertTrue(lecturesPage.isFormOpen(), "Lectures page isn't open.");
        Browser.switchToDefaultContent();
    }
}
