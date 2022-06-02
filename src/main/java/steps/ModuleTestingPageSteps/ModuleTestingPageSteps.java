package steps.ModuleTestingPageSteps;

import org.testng.Assert;
import pages.ModuleTestingPage.ModuleTestingPage;

public class ModuleTestingPageSteps {

    private static final ModuleTestingPage moduleTestingPage = new ModuleTestingPage();

    private ModuleTestingPageSteps() {}

    public static void clickLabTasks() {
        moduleTestingPage.clickLabTasksItem();
    }

    public static void assertIsOpen() {
        Assert.assertTrue(moduleTestingPage.isFormOpen(), "Module testing page isn't open.");
    }
}
