package pages.ModuleTestingPage.LabTaskspage;

import elements.TextBox;
import framework.BaseForm;
import org.openqa.selenium.By;

public class VisitLabMenuPage extends BaseForm {

    public VisitLabMenuPage() {
        super(new TextBox(By.xpath("//span[@class='title-date']"), "Visit lab menu page uniq element"),
                "Visit lab menu page");
    }


}
