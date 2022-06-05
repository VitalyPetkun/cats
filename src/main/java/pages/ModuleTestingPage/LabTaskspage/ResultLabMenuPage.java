package pages.ModuleTestingPage.LabTaskspage;

import elements.Button;
import elements.Iframe;
import elements.TextBox;
import framework.BaseForm;
import framework.browser.Browser;
import org.openqa.selenium.By;

public class ResultLabMenuPage extends BaseForm {

    public ResultLabMenuPage() {
        super(new TextBox(By.xpath("//h2[contains(text(),'Выставление оценки')]"), "Result lab menu page uniq element"),
                "Result lab menu page");
    }

    public void switchToIframe() {
        new Iframe(By.xpath("//iframe"), "Labs").switchToIframe();
    }

    public void sendScore(String score) {
        this.switchToIframe();
        new TextBox(By.xpath("//input[contains(@ng-reflect-placeholder,'Оценка')]"), "Score").clickAndClear();
        new TextBox(By.xpath("//input[contains(@ng-reflect-placeholder,'Оценка')]"), "Score").inputText(score);
        Browser.switchToDefaultContent();

    }

    public void clickSave() {
        this.switchToIframe();
        new Button(By.xpath("//span[contains(text(),'Сохранить')]/parent::button"), "Save").click();
        Browser.switchToDefaultContent();
    }
}
