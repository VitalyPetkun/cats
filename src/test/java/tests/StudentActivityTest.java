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
import steps.ModuleTestingPageSteps.LabTasksPageSteps.LabTasksPageSteps;
import steps.ModuleTestingPageSteps.LabTasksPageSteps.VisitLabMenuPageSteps;
import steps.ModuleTestingPageSteps.LabTasksPageSteps.VisitStatisticsPageSteps;
import steps.ModuleTestingPageSteps.ModuleTestingPageSteps;

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
    private final String GROUP = PropertiesManager
            .getValue(
                    Paths.TEST_RESOURCES_PATH.getPath(),
                    Files.TEST_DATA.getFile(),
                    TestDataVariables.GROUP.getVariable()
            );
    private final String LAB_DATE = PropertiesManager
            .getValue(
                    Paths.TEST_RESOURCES_PATH.getPath(),
                    Files.TEST_DATA.getFile(),
                    TestDataVariables.LAB_DATE.getVariable()
            );
    private final String SCORE = PropertiesManager
            .getValue(
                    Paths.TEST_RESOURCES_PATH.getPath(),
                    Files.TEST_DATA.getFile(),
                    TestDataVariables.SCORE.getVariable()
            );
    private final String TRUANCY = PropertiesManager
            .getValue(
                    Paths.TEST_RESOURCES_PATH.getPath(),
                    Files.TEST_DATA.getFile(),
                    TestDataVariables.TRUANCY.getVariable()
            );

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
        ModuleTestingPageSteps.assertIsOpen();

        SmartLogger.logStep(5, "Open results");
        ModuleTestingPageSteps.clickLabTasksItem();
        LabTasksPageSteps.assertIsOpen();
        LabTasksPageSteps.clickResults();
        VisitStatisticsPageSteps.assertIsOpen();

        SmartLogger.logStep(6, "Open visit lab menu");
        VisitStatisticsPageSteps.selectGroup(GROUP);
        VisitStatisticsPageSteps.openMenuVisitLab(LAB_DATE);
        VisitLabMenuPageSteps.assertIsOpen(LAB_DATE);

        SmartLogger.logStep(7, "Set truancy");
        VisitLabMenuPageSteps.clickTruancyPopMenu(STUDENT_NAME);
        VisitLabMenuPageSteps.clickTruancyPopMenuItem(TRUANCY);
        VisitLabMenuPageSteps.clickSave();
        VisitStatisticsPageSteps.assertCheck(STUDENT_NAME, LAB_DATE, TRUANCY);

        SmartLogger.logStep(8, "Exit lecturer");
        VisitStatisticsPageSteps.clickMorePopMenu();
        VisitStatisticsPageSteps.clickExitBtn();
        AuthorizationPageSteps.assertIsOpen();

        SmartLogger.logStep(9, "Authorization student");
        AuthorizationPageSteps.sendLogin(STUDENT_LOGIN);
        AuthorizationPageSteps.sendPassword(STUDENT_PASSWORD);
        AuthorizationPageSteps.clickSubmitBtn();
        DashBoardPageSteps.assertIsOpen();

        SmartLogger.logStep(10, "Click Items");
        DashBoardPageSteps.clickItems();
        MainPageSteps.assertIsOpen();

        SmartLogger.logStep(11, "Select module testing");
        MainPageSteps.clickSelectItems();
        MainPageSteps.clickModuleTestingItem();
        ModuleTestingPageSteps.assertIsOpen();

        SmartLogger.logStep(11, "Open visit statistics");
        ModuleTestingPageSteps.clickLabTasksItem();
        LabTasksPageSteps.assertIsOpen();
        LabTasksPageSteps.clickVisitStatistics();
        VisitStatisticsPageSteps.assertIsOpen();

        SmartLogger.logStep(12, "Check truancy");
        VisitStatisticsPageSteps.assertCheck(STUDENT_NAME, LAB_DATE, TRUANCY);
    }

    @Test
    public void truancy() {
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
        ModuleTestingPageSteps.assertIsOpen();

        SmartLogger.logStep(5, "Open visit statistics");
        ModuleTestingPageSteps.clickLabTasksItem();
        LabTasksPageSteps.assertIsOpen();
        LabTasksPageSteps.clickVisitStatistics();
        VisitStatisticsPageSteps.assertIsOpen();

        SmartLogger.logStep(6, "Open visit lab menu");
        VisitStatisticsPageSteps.selectGroup(GROUP);
        VisitStatisticsPageSteps.openMenuVisitLab(LAB_DATE);
        VisitLabMenuPageSteps.assertIsOpen(LAB_DATE);

        SmartLogger.logStep(7, "Set truancy");
        VisitLabMenuPageSteps.clickTruancyPopMenu(STUDENT_NAME);
        VisitLabMenuPageSteps.clickTruancyPopMenuItem(TRUANCY);
        VisitLabMenuPageSteps.clickSave();
        VisitStatisticsPageSteps.assertCheck(STUDENT_NAME, LAB_DATE, TRUANCY);

        SmartLogger.logStep(8, "Exit lecturer");
        VisitStatisticsPageSteps.clickMorePopMenu();
        VisitStatisticsPageSteps.clickExitBtn();
        AuthorizationPageSteps.assertIsOpen();

        SmartLogger.logStep(9, "Authorization student");
        AuthorizationPageSteps.sendLogin(STUDENT_LOGIN);
        AuthorizationPageSteps.sendPassword(STUDENT_PASSWORD);
        AuthorizationPageSteps.clickSubmitBtn();
        DashBoardPageSteps.assertIsOpen();

        SmartLogger.logStep(10, "Click Items");
        DashBoardPageSteps.clickItems();
        MainPageSteps.assertIsOpen();

        SmartLogger.logStep(11, "Select module testing");
        MainPageSteps.clickSelectItems();
        MainPageSteps.clickModuleTestingItem();
        ModuleTestingPageSteps.assertIsOpen();

        SmartLogger.logStep(11, "Open visit statistics");
        ModuleTestingPageSteps.clickLabTasksItem();
        LabTasksPageSteps.assertIsOpen();
        LabTasksPageSteps.clickVisitStatistics();
        VisitStatisticsPageSteps.assertIsOpen();

        SmartLogger.logStep(12, "Check truancy");
        VisitStatisticsPageSteps.assertCheck(STUDENT_NAME, LAB_DATE, TRUANCY);
    }


}
