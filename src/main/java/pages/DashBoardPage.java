package pages;

import elements.Button;
import elements.Link;
import framework.BaseForm;
import org.openqa.selenium.By;

public class DashBoardPage extends BaseForm {

    public DashBoardPage() {
        super(new Link(By.xpath("//div[@class='news']"), "Dash board page uniq element"), "Dash board page");
    }

    public void clickItems() {
        new Button(By.xpath("//span[text()='Предметы']"), "Items").click();
    }
}
