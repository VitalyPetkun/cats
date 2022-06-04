package pages.ModuleTestingPage.LabTaskspage;

import elements.Iframe;
import elements.PopMenu;
import elements.PopMenuItem;
import elements.TextBox;
import framework.BaseForm;
import framework.browser.Browser;
import org.openqa.selenium.By;

public class VisitStatisticsPage extends BaseForm {

    public VisitStatisticsPage() {
        super(new TextBox(By.xpath("//table"), "Visit statistics page uniq element"),
                "Visit statistics page");
    }

    public void clickSelectGroupPopMenu() {
        this.switchToIframe();
        new PopMenu(By.xpath("//span[contains(@class,'container')]"), "Select group").click();
        Browser.switchToDefaultContent();
    }

    public String getSelectedGroup() {
        this.switchToIframe();
        String selectedGroup = new PopMenu(By.xpath("//span[contains(@class,'container')]"), "Select group")
                .getText();
        Browser.switchToDefaultContent();
        return selectedGroup;
    }

    public void clickSelectGroupPopMenuItem(String group) {
        this.switchToIframe();
        new PopMenuItem(By.xpath("//span[contains(@class,'container')]"), "Groups").clickItem(group);
        Browser.switchToDefaultContent();
    }

    public void clickLab(String date) {
        this.switchToIframe();
        new PopMenuItem(By.xpath("//td[contains(@class,'mark-cell')]"), "Labs dates")
                .doubleClickItemOfIndex(this.getIndexDateLab(date));
        Browser.switchToDefaultContent();
    }

    public void switchToIframe() {
        new Iframe(By.xpath("//iframe"),"Labs").switchToIframe();
    }

    private int getIndexDateLab(String date) {
        int index = new PopMenuItem(By.xpath("//th//div"), "Labs dates")
                .getItems().indexOf(date);
        return index;
    }
}
