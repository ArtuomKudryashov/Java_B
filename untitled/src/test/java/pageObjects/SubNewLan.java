package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SubNewLan extends  BasePage {
    public SubNewLan(WebDriver driver) {
        super(driver);
    }

    private WebElement getSubNewLang() {
        By SNLBy = By.xpath("(//*[text()='Submit new Language'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SNLBy));
        return driver.findElement(SNLBy);

    }

    public SubNewLan mainPage() {

        getSubNewLang().click();
        return  new SubNewLan(driver);

    }
}






