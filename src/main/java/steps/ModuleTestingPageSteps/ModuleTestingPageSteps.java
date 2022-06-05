package steps.ModuleTestingPageSteps;

import framework.browser.Browser;
import org.testng.Assert;
import pages.ModuleTestingPage.ModuleTestingPage;

public class ModuleTestingPageSteps {

    private static final ModuleTestingPage moduleTestingPage = new ModuleTestingPage();

    private ModuleTestingPageSteps() {
    }

    public static void clickLabTasksItem() {
        moduleTestingPage.clickLabTasksItem();
    }

    public static void clickLecturesItem() {
        moduleTestingPage.clickLecturesItem();
    }

    public static void assertIsOpen() {
        moduleTestingPage.switchToIframeNews();
        Assert.assertTrue(moduleTestingPage.isFormOpen(), "Module testing page isn't open.");
        Browser.switchToDefaultContent();
    }
}
