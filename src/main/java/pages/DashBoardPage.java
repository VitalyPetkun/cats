package pages;

import elements.Button;
import elements.Iframe;
import framework.BaseForm;
import org.openqa.selenium.By;

public class DashBoardPage extends BaseForm {

    public DashBoardPage() {
        super(new Iframe(By.xpath("//iframe"), "Dash board page uniq element"), "Dash board page");
    }

    public void clickItems() {
        new Button(By.xpath("//span[text()='Предметы']"), "Items").click();
    }
}
