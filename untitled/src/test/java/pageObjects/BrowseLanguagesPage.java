package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrowseLanguagesPage extends BasePage {
    public BrowseLanguagesPage(WebDriver driver) {
        super(driver);
    }

    //Сверяем 4 кейс
    public boolean verifySubmenuItem() {
        return getSubmenuList().get(0).getText().equals("0-9");
    }
    private List<WebElement> getSubmenuList() {
        return driver.findElements(By.xpath("//ul[@id='submenu']/li/a"));
    }
}




