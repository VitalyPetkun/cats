package pages.ModuleTestingPage.LabTasksPage;

import elements.Iframe;
import elements.PopMenu;
import elements.PopMenuItem;
import elements.TextBox;
import framework.BaseForm;
import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import steps.ModuleTestingPageSteps.LabTasksPageSteps.ResultsPageSteps;

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

    public void clickLab(String studentName, String lab) {
        this.switchToIframe();
        List<WebElement> body = Browser.getDriver().findElements(By.xpath("//tbody//tr"));
        for (int i = 0; i < body.size(); i++) {
            List<WebElement> rows = body.get(i).findElements(By
                    .xpath("//td[not(contains(@class,'position')) and not(contains(@class,'total'))]"));
            if (rows.get(0).getText().contains(studentName)) {
                Actions actions = new Actions(Browser.getDriver());
                actions.doubleClick(rows.get(this.getIndexLabNumbers(lab) + 1));
                actions.build().perform();
                break;
            }
        }
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
        String scoreNumber = "";
        for (List<String> row : this.getBodyList()) {
            if (row.contains(studentName)) {
                int index = this.getIndexLabNumbers(lab);
                scoreNumber = row.get(index + 2);
                break;
            }
        }
        Browser.switchToDefaultContent();
        return scoreNumber.contains(score);
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
