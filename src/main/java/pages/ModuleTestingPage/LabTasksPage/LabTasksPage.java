package pages.ModuleTestingPage.LabTasksPage;

import elements.Button;
import elements.Iframe;
import elements.Link;
import framework.BaseForm;
import framework.browser.Browser;
import org.openqa.selenium.By;

public class LabTasksPage extends BaseForm {

    public LabTasksPage() {
        super(new Link(By.xpath("//div[@class='labs-component__body']"), "Lab tasks page uniq element"),
                "Lab tasks page");
    }

    public void switchToIframeLabs() {
        new Iframe(By.xpath("//iframe[@src='/subject/news']"), "Labs").switchToIframe();
    }

    public void clickVisitStatistics() {
        this.switchToIframeLabs();
        new Button(By.xpath("//span[contains(text(),'Статистика посещения')]/parent::span/parent::span/parent::button"),
                "Visit statistics").click();
        Browser.switchToDefaultContent();
    }

    public void clickResults() {
        this.switchToIframeLabs();
        new Button(By.xpath("//span[contains(text(),'Результаты')]/parent::span/parent::span/parent::button"),
                "Visit statistics").click();
        Browser.switchToDefaultContent();
    }
}
