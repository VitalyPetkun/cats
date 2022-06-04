package elements;

import framework.BaseElement;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PopMenuItem extends BaseElement {
    public PopMenuItem(By locator, String name) {
        super(locator, name);
    }

    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (WebElement item:super.findElements()) {
            items.add(item.getText());
        }
        return items;
    }

    public void clickItem(String nameItem) {
        super.findElements().get(this.getItems().indexOf(nameItem)).click();
    }

    public void clickItemOfIndex(int index) {
        super.findElements().get(index).click();
    }
}
