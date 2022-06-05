package pages.ModuleTestingPage.LabTaskspage;

import elements.*;
import framework.BaseForm;
import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public boolean checkStudentTruancy(String studentName, String date, String truancy) {
        this.switchToIframe();
        String truancyNumber = "";
        for (List<String> row : this.getBodyList()) {
            if (row.contains(studentName)) {
                int index = this.getIndexDateLab(date);
                truancyNumber = row.get(index + 2);
                break;
            }
        }
        Browser.switchToDefaultContent();
        return truancyNumber.contains(truancy);
    }

    public void switchToIframe() {
        new Iframe(By.xpath("//iframe"), "Labs").switchToIframe();
    }

    private int getIndexDateLab(String date) {
        int index = new PopMenuItem(By.xpath("//th//div"), "Labs dates")
                .getItems().indexOf(date);
        return index;
    }

    private List<List<String>> getBodyList() {
        List<List<String>> newList = new ArrayList<>();
        for (int i = 0; i < Browser.getDriver().findElements(By.xpath("//tbody//tr")).size(); i++) {
            List<String> strRows = new ArrayList<>();
            for (int j = 0; j < Browser.getDriver()
                    .findElements(By.xpath("//tbody//tr")).get(i).findElements(By.xpath("*")).size(); j++) {
                strRows.add(Browser.getDriver()
                        .findElements(By.xpath("//tbody//tr")).get(i).findElements(By.xpath("*")).get(j).getText());
            }
            newList.add(strRows);
        }
        return newList;
    }
}
