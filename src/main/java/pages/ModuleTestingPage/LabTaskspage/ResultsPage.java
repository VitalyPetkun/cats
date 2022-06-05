package pages.ModuleTestingPage.LabTaskspage;

import elements.Iframe;
import elements.PopMenu;
import elements.PopMenuItem;
import elements.TextBox;
import framework.BaseForm;
import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import steps.ModuleTestingPageSteps.LabTasksPageSteps.VisitStatisticsPageSteps;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends BaseForm {

    public ResultsPage() {
        super(new TextBox(By.xpath("//table"), "Results page uniq element"),
                "Results page");
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

    public void clickLab(String lab) {
        this.switchToIframe();
        new PopMenuItem(By
                .xpath("//td[not(contains(@class,'position')) and not(contains(@class,'name')) and not(contains(@class,'total'))]"),
                "Labs scores").doubleClickItemOfIndex(this.getIndexLabNumbers(lab));
        Browser.switchToDefaultContent();
    }

    private int getIndexLabNumbers(String lab) {
        int index = new PopMenuItem(By.xpath("//th//div"), "Labs numbers")
                .getItems().indexOf(lab);
        return index;
    }

    public boolean checkStudentScore(String studentName, String lab, String score) {
        Browser.refresh();
        ResultsPageSteps.assertIsOpen();
        this.switchToIframe();
        String truancyNumber = "";
        for (List<String> row : this.getBodyList()) {
            if (row.contains(studentName)) {
                int index = this.getIndexLabNumbers(lab);
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

    public void clickMorePopMenu() {
        new PopMenu(By.xpath("//mat-icon[contains(text(),'more_vert')]/parent::span/parent::button"), "More").click();
    }

    public void clickExitBtn() {
        new PopMenuItem(By.xpath("//span[contains(text(),'Выйти')]/parent::button"), "More").click();
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
