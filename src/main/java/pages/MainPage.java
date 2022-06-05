package pages;

import elements.Iframe;
import elements.PopMenu;
import elements.PopMenuItem;
import framework.BaseForm;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {

    public MainPage() {
        super(new Iframe(By.xpath("//iframe[@src='/statistics']"), "Main page uniq element"), "Main page");
    }

    public void clickSelectItems() {
        new PopMenu(By.xpath("//h2[text()='Выберите предмет']/parent::span/parent::button"), "Select items").click();
    }

    public void clickModuleTestingItem() {
        new PopMenuItem(By.xpath("//span[text()='Модульное тестирование']/parent::a"), "Module testing item").click();
    }
}
