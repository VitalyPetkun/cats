package pages.ModuleTestingPage.LabTasksPage;

import elements.*;
import framework.BaseForm;
import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import steps.ModuleTestingPageSteps.LabTasksPageSteps.VisitStatisticsPageSteps;

import java.util.ArrayList;
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
                .doubleClickItemOfIndex(this.getIndexLabDate(date));
        Browser.switchToDefaultContent();
    }

    public boolean checkStudentTruancy(String studentName, String date, String truancy) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Browser.refresh();
        VisitStatisticsPageSteps.assertIsOpen();
        this.switchToIframe();
        String truancyNumber = "";
        for (List<String> row : this.getBodyList()) {
            if (row.contains(studentName)) {
                int index = this.getIndexLabDate(date);
                truancyNumber = row.get(index + 2).replaceAll("[^0-9]", "");
                break;
            }
        }
        Browser.switchToDefaultContent();
        return truancyNumber.contains(truancy);
    }

    public void switchToIframe() {
        new Iframe(By.xpath("//iframe"), "Labs").switchToIframe();
    }

    public void clickMorePopMenu() {
        new PopMenu(By.xpath("//mat-icon[contains(text(),'more_vert')]/parent::span/parent::button"), "More").click();
    }

    public void clickExitBtn() {
        new PopMenuItem(By.xpath("//span[contains(text(),'Выйти')]/parent::button"), "More").click();
    }

    private int getIndexLabDate(String date) {
        int index = new PopMenuItem(By.xpath("//th//div"), "Labs dates")
                .getItems().indexOf(date);
        return index;
    }

    private List<List<String>> getBodyList() {
        List<WebElement> body = Browser.getDriver().findElements(By.xpath("//tbody//tr"));
        List<List<String>> newList = new ArrayList<>();
        for (int i = 0; i < body.size(); i++) {
            List<String> strRows = new ArrayList<>();
            List<WebElement> rows = body.get(i).findElements(By.xpath("*"));
            for (int j = 0; j < rows.size(); j++) {
                strRows.add(rows.get(j).getText());
            }
            newList.add(strRows);
        }
        return newList;
    }
}
