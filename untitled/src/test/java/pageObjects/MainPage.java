package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void open() {
        driver.get("http://www.99-bottles-of-beer.net/");
    }

    public String get99BofB() {
        By elBy = By.xpath("(//*[text()='99 Bottles of Beer'])[1]");

//        wait.until(ExpectedConditions.visibilityOfElementLocated(elBy));
        WebElement element = driver.findElement(elBy);
        String text = element.getText();
        return text;


    }


    public String subNewLang() {
        By sNL = By.xpath("(//*[text()='Submit new Language'])[1]");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(sNL));
        WebElement element = driver.findElement(sNL);
        String text = element.getText();
        return text;


    }

    public String subNewLangArr() {
        String answer = "";
//        By sNL = By.xpath("(//*[text()='Submit new Language'])[1]");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(sNL));
        List<WebElement> liElements = driver.findElements(By.xpath("//ul[@id='menu']/li"));
        for (int i = 0; i < liElements.size(); i++) {
            WebElement liElement = liElements.get(i);
            WebElement aElement = liElement.findElement(By.tagName("a"));
            String linkText = aElement.getText();
            if (linkText.equals("SUBMIT NEW LANGUAGE")) {
                System.out.println("Элемент найден!");
                answer = "SUBMIT NEW LANGUAGE";

            }

        }
        return answer;
    }
    private WebElement getSubNewLang() {
        By SNLBy = By.xpath("(//*[text()='Submit new Language'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SNLBy));
        return driver.findElement(SNLBy);

    }

    public String getTextSNL() {
        getSubNewLang().click();
        WebElement elementSNL = driver.findElement(By.xpath("(//*[text()='Submit New Language'])[1]"));
        String actualText = elementSNL.getText();
        return actualText;
    }

}
