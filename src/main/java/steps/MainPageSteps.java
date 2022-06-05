package steps;

import org.testng.Assert;
import pages.MainPage;

public class MainPageSteps {

    private static final MainPage mainPage = new MainPage();

    private MainPageSteps() {
    }

    public static void clickSelectItems() {
        mainPage.clickSelectItems();
    }

    public static void clickModuleTestingItem() {
        mainPage.clickModuleTestingItem();
    }

    public static void assertIsOpen() {
        Assert.assertTrue(mainPage.isFormOpen(), "Main page isn't open.");
    }
}
