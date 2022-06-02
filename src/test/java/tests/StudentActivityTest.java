package tests;

import framework.browser.Browser;
import framework.utils.PropertiesManager;
import framework.utils.SmartLogger;
import org.testng.annotations.Test;
import services.ConfigVariables;
import services.Files;
import services.Paths;
import services.TestDataVariables;
import steps.AuthorizationPageSteps;
import steps.DashBoardPageSteps;
import steps.MainPageSteps;

public class StudentActivityTest extends BaseTest{

    private final String LECTURER_LOGIN = PropertiesManager
            .getValue(
                    Paths.MAIN_RESOURCES_PATH.getPath(),
                    Files.CONFIG.getFile(),
                    ConfigVariables.LECTURER_LOGIN.getVariable()
            );
    private final String LECTURER_PASSWORD = PropertiesManager
            .getValue(
                    Paths.MAIN_RESOURCES_PATH.getPath(),
                    Files.CONFIG.getFile(),
                    ConfigVariables.LECTURER_PASSWORD.getVariable()
            );
    private final String STUDENT_LOGIN = PropertiesManager
            .getValue(
                    Paths.MAIN_RESOURCES_PATH.getPath(),
                    Files.CONFIG.getFile(),
                    ConfigVariables.STUDENT_LOGIN.getVariable()
            );
    private final String STUDENT_PASSWORD = PropertiesManager
            .getValue(
                    Paths.MAIN_RESOURCES_PATH.getPath(),
                    Files.CONFIG.getFile(),
                    ConfigVariables.STUDENT_PASSWORD.getVariable()
            );
    private final String STUDENT_NAME = PropertiesManager
            .getValue(
                    Paths.TEST_RESOURCES_PATH.getPath(),
                    Files.TEST_DATA.getFile(),
                    TestDataVariables.STUDENT_NAME.getVariable()
            );

    private final Integer SCORE = Integer.parseInt(PropertiesManager
            .getValue(
                    Paths.TEST_RESOURCES_PATH.getPath(),
                    Files.TEST_DATA.getFile(),
                    TestDataVariables.SCORE.getVariable()
            ));

    @Test
    public void score() {
        SmartLogger.logStep(1, "Open authorization page");
        Browser.openUrl(EDUCATS_URL);
        AuthorizationPageSteps.assertIsOpen();

        SmartLogger.logStep(2, "Authorization lecturer");
        AuthorizationPageSteps.sendLogin(LECTURER_LOGIN);
        AuthorizationPageSteps.sendPassword(LECTURER_PASSWORD);
        AuthorizationPageSteps.clickSubmitBtn();
        DashBoardPageSteps.assertIsOpen();

        SmartLogger.logStep(3, "Click Items");
        DashBoardPageSteps.clickItems();
        MainPageSteps.assertIsOpen();

        SmartLogger.logStep(4, "Select module testing");
        MainPageSteps.clickSelectItems();
        MainPageSteps.clickModuleTestingItem();


    }
}
