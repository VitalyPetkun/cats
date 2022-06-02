package pages;

import elements.Button;
import elements.PopMenu;
import elements.PopMenuItem;
import framework.BaseForm;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {

    public MainPage() {
        super(new Button(By.xpath("//div[@class='diagram']"), "Main page uniq element"), "Main page");
    }

    public void clickSelectItems() {
        new PopMenu(By.xpath("//h2[text()='Выберите предмет']/parent::span"), "Select items").click();
    }

    public void clickModuleTestingItem() {
        new PopMenuItem(By.xpath("//span[text()='Модульное тестирование']"), "Module testing item").click();
    }
}
