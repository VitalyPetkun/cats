package pages.ModuleTestingPage;

import elements.Iframe;
import elements.Link;
import framework.BaseForm;
import org.openqa.selenium.By;

public class ModuleTestingPage extends BaseForm {

    public ModuleTestingPage() {
        super(new Link(By.xpath("//div[@class='body__content']"),
                "Module testing page uniqelement"), "Module testing page");
    }

    public void switchToIframeNews() {
        new Iframe(By.xpath("//iframe[@src='/subject/news']"),"News").switchToIframe();
    }

    public void clickLabTasksItem() {
        new Link(By.xpath("//div[text()='Лабораторные работы']/parent::div"), "Lab tasks item").click();
    }
}
