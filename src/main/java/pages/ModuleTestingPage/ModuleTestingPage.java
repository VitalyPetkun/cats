package pages.ModuleTestingPage;

import elements.Link;
import framework.BaseForm;
import org.openqa.selenium.By;

public class ModuleTestingPage extends BaseForm {

    public ModuleTestingPage() {
        super(new Link(By.xpath("//h2[text()='Модульное тестирование']/parent::span"),
                "Module testing page uniqelement"), "Module testing page");
    }

    public void clickLabTasksItem() {
        new Link(By.xpath("//div[text()='Лабораторные работы']/parent::div"), "Lab tasks item").click();
    }
}
