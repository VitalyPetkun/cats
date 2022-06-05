package framework;

import framework.browser.WaiterUtils;
import framework.utils.SmartLogger;

public abstract class BaseForm {

    private BaseElement uniqElement;

    private String formName;

    protected BaseForm(BaseElement uniqElement, String formName) {
        this.uniqElement = uniqElement;
        this.formName = formName;
    }

    public void setUniqElement(BaseElement uniqElement) {
        this.uniqElement = uniqElement;
    }

    public boolean isFormOpen() {
        if (WaiterUtils.visibilityOfElementLocated(uniqElement.getLocator()).isDisplayed())
            SmartLogger.logInfo("Open " + formName + ".");
        else
            SmartLogger.logWarn("Don't open " + formName + ".");

        return uniqElement.isPresent();
    }

    public boolean isFormClose() {
        if (WaiterUtils.invisibilityOfElementLocated(uniqElement.getLocator()))
            SmartLogger.logInfo("Close " + formName + ".");
        else
            SmartLogger.logWarn("Don't close " + formName + ".");

        return WaiterUtils.invisibilityOfElementLocated(uniqElement.getLocator());
    }

    public String getTextUniqElement() {
        return uniqElement.getText();
    }
}
