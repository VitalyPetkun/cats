package pages.ModuleTestingPage.LecturesPage;

import elements.Button;
import elements.Iframe;
import elements.Link;
import framework.BaseForm;
import framework.browser.Browser;
import org.openqa.selenium.By;

public class LecturesPage extends BaseForm {

    public LecturesPage() {
        super(new Link(By.xpath("//div[@class='labs-component__body']"), "Lectures page uniq element"),
                "Lectures page");
    }

    public void switchToIframeLectures() {
        new Iframe(By.xpath("//iframe"), "Lectures").switchToIframe();
    }

    public void clickVisitLectures() {
        this.switchToIframeLectures();
        new Button(By.xpath("//span[contains(text(),'Посещение лекций')]/parent::span/parent::button"),
                "Visit lectures").click();
        Browser.switchToDefaultContent();
    }
}
