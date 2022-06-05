package elements;

import framework.BaseElement;
import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class PopMenuItem extends BaseElement {
    public PopMenuItem(By locator, String name) {
        super(locator, name);
    }

    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (WebElement item : super.findElements()) {
            items.add(item.getText());
        }
        return items;
    }

    public void clickItem(String nameItem) {
        int index = this.getItems().indexOf(nameItem);
        super.findElements().get(index).click();
    }

    public void clickItemOfIndex(int index) {
        super.findElements().get(index).click();
    }

    public void doubleClickItemOfIndex(int index) {
        WebElement element = super.findElements().get(index);
        Actions actions = new Actions(Browser.getDriver());
        actions.doubleClick(element);
        actions.build().perform();
    }

    public String getTextOfIndex(int index) {
        return super.findElements().get(index).getText();
    }
}
