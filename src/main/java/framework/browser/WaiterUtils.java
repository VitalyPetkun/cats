package framework.browser;

import framework.services.ConfigVariables;
import framework.services.Files;
import framework.services.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.utils.PropertiesManager;
import java.time.Duration;

public class WaiterUtils {

    private static final Integer EXPECTED_NUMBER_OF_WINDOWS = Integer.parseInt(PropertiesManager
            .getValue(
                    Paths.FRAMEWORK_RESOURCES_PATH.getPath(),
                    Files.FRAMEWORK_CONFIG.getFile(),
                    ConfigVariables.EXPECTED_NUMBER_OF_WINDOWS.getVariables()
            ));
    private static final Long WAITING_TIME = Long.parseLong(PropertiesManager
            .getValue(
                    Paths.FRAMEWORK_RESOURCES_PATH.getPath(),
                    Files.FRAMEWORK_CONFIG.getFile(),
                    ConfigVariables.WAITING_TIME.getVariables()
            ));

    public static WebElement elementToBeClickable(By locator) {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(WAITING_TIME))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void numberOfWindowsToBe() {
        new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(WAITING_TIME))
                .until(ExpectedConditions.numberOfWindowsToBe(EXPECTED_NUMBER_OF_WINDOWS));
    }

    public static boolean invisibilityOfElementLocated(By locator) {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(WAITING_TIME))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static WebElement visibilityOfElementLocated(By locator) {
        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(WAITING_TIME))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
