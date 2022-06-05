package steps;

import org.testng.Assert;
import pages.DashBoardPage;

public class DashBoardPageSteps {

    private static final DashBoardPage dashBoardPage = new DashBoardPage();

    private DashBoardPageSteps() {
    }

    public static void clickItems() {
        dashBoardPage.clickItems();
    }

    public static void assertIsOpen() {
        Assert.assertTrue(dashBoardPage.isFormOpen(), "Dash board page isn't open.");
    }
}
