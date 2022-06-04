package pages.ModuleTestingPage.LabTaskspage;

import elements.PopMenu;
import elements.PopMenuItem;
import elements.TextBox;
import framework.BaseForm;
import org.openqa.selenium.By;

public class VisitStatisticsPage extends BaseForm {

    public VisitStatisticsPage() {
        super(new TextBox(By.xpath("//table"), "Visit statistics page uniq element"),
                "Visit statistics page");
    }

    public void clickSelectGroupPopMenu() {
        new PopMenu(By.xpath("//span[contains(@class,'container')]"), "Select group").click();
    }

    public void clickSelectGroupPopMenuItem(String group) {
        new PopMenuItem(By.xpath("//span[contains(@class,'container')]"), "Groups").clickItem(group);
    }

    public void clickLab(String date) {
        new PopMenuItem(By.xpath("//th//div"), "Labs dates")
                .clickItemOfIndex(this.getIndexDateLab(date));
    }

    private int getIndexDateLab(String date) {
        return new PopMenuItem(By.xpath("//th//div"), "Labs dates")
                .getItems().indexOf(date);
    }
}
