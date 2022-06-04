package elements;

import framework.BaseElement;
import framework.browser.Browser;
import framework.browser.WaiterUtils;
import framework.utils.SmartLogger;
import org.openqa.selenium.By;

public class Iframe extends BaseElement {

    public Iframe(By locator, String elementName) {
        super(locator, elementName);
    }

    public void switchToIframe() {
        try {
            SmartLogger.logInfo("Switch to " + getElementName() + ".");
            Browser.getDriver().switchTo().frame(WaiterUtils.visibilityOfElementLocated(this.getLocator()));
        } catch (Exception ex) {
            SmartLogger.logError("Don't switch to " + getElementName() + ".");
        }
    }
}
