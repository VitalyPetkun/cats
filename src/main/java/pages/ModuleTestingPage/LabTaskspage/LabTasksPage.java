package pages.ModuleTestingPage.LabTaskspage;

import elements.Link;
import framework.BaseForm;
import org.openqa.selenium.By;

public class LabTasksPage extends BaseForm{

    public LabTasksPage() {
        super(new Link(By.xpath("//app-labs-work//button"), "Lab tasks page uniq element"),
                "Lab tasks page");
    }

    public void clickVisitStatistics() {
        new Link(By.xpath("//span[contains(text(),'Статистика посещения')]"),"Visit statistics").click();
    }
}
