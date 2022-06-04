package pages.ModuleTestingPage.LabTaskspage;

import elements.*;
import framework.BaseForm;
import framework.browser.Browser;
import org.openqa.selenium.By;

import java.util.List;

public class VisitLabMenuPage extends BaseForm {

    public VisitLabMenuPage() {
        super(new TextBox(By.xpath("//span[@class='title-date']"), "Visit lab menu page uniq element"),
                "Visit lab menu page");
    }

    public void switchToIframe() {
        new Iframe(By.xpath("//iframe"),"Labs").switchToIframe();
    }

    public void clickTruancyPopMenu(String studentName) {
        this.switchToIframe();
        new PopMenuItem(By.xpath("//mat-cell//mat-form-field[contains(@class,'select')]"), "Student truancy")
                .clickItemOfIndex(this.getStudentIndex(studentName));
        Browser.switchToDefaultContent();
    }

    public void clickTruancyPopMenuItem(String truancy) {
        this.switchToIframe();
        new PopMenuItem(By.xpath("//mat-option//span"), "Student truancies")
                .clickItemOfIndex(this.getStudentTruancyIndex(truancy));
        Browser.switchToDefaultContent();
    }

    public void clickSave() {
        this.switchToIframe();
        new Button(By.xpath("//span[text()='Сохранить']/parent::button"), "Save").click();
        Browser.switchToDefaultContent();
    }

    private int getStudentIndex(String studentName) {
        this.switchToIframe();
        int index = -1;
        List<String> studentNames = new PopMenuItem(
                By.xpath("//mat-cell[contains(@class,'name')]"), "Student names").getItems();
        for (int i = 0; i < studentNames.size();i++) {
            if(studentNames.get(i).contains(studentName))
                index = i;
        }
        Browser.switchToDefaultContent();
        return index;
    }

    private int getStudentTruancyIndex(String studentTruancy) {
        this.switchToIframe();
        int index = -1;
        List<String> studentTruancies = new PopMenuItem(
                By.xpath("//mat-option//span"), "Student truancies").getItems();
        for (int i = 0; i < studentTruancies.size();i++) {
            if(studentTruancies.get(i).contains(studentTruancy))
                index = i;
        }
        Browser.switchToDefaultContent();
        return index;
    }
}
