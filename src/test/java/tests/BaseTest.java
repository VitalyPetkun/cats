package tests;

import framework.browser.Browser;
import framework.utils.PropertiesManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.Files;
import services.Paths;
import services.Url;

public class BaseTest {

    protected final String EDUCATS_URL = PropertiesManager
            .getValue(
                    Paths.MAIN_RESOURCES_PATH.getPath(),
                    Files.CONFIG.getFile(),
                    Url.EDUCATS_URL.getUrl()
            );

    @BeforeMethod
    protected void setup() {
        Browser.setMaximizeWindow();
        Browser.timeouts();
    }

    @AfterMethod
    protected void quitDriver() {
        Browser.quit();
    }
}
