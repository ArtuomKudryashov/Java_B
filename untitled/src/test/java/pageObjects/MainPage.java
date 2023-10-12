package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void open() {
        driver.get("http://www.99-bottles-of-beer.net/");
    }

    // TC_11_01
    public String get99BofB() {
        By elBy = By.xpath("(//*[text()='99 Bottles of Beer'])[1]");
        WebElement element = driver.findElement(elBy);
        String text = element.getText();
        return text;
    }

    // TC_11_02
    public String subNewLang() {
        By sNL = By.xpath("(//*[text()='Submit new Language'])[1]");
        WebElement element = driver.findElement(sNL);
        String text = element.getText();
        return text;
    }

    // TC_11_02Arr
    public String subNewLangArr() {
        String answer = "";
        List<WebElement> liElements = driver.findElements(By.xpath("//ul[@id='menu']/li"));
        for (int i = 0; i < liElements.size(); i++) {
            System.out.println(liElements.size());
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
    // TC_11_03
    private WebElement getSubNewLang() {
        By SNLBy = By.xpath("(//*[text()='Submit new Language'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SNLBy));
        return driver.findElement(SNLBy);

    }
    // TC_11_03
    public String getTextSNL() {
        getSubNewLang().click();
        WebElement elementSNL = driver.findElement(By.xpath("(//*[text()='Submit New Language'])[1]"));
        String actualText = elementSNL.getText();
        return actualText;
    }
    //TC_11_04
    public BrowseLanguagesPage navigateToBrowseLanguagePage() {
        for (int i = 0; i < getMainMenuList().size(); i++) {
            System.out.println(getMainMenuList().size());
            if (getMainMenuList().get(i).getText().equalsIgnoreCase("BROWSE LANGUAGES")) {
                getMainMenuList().get(i).click();
                return new BrowseLanguagesPage(driver);
            }
        }
        return null;
    }

    private List<WebElement> getMainMenuList() {
        return driver.findElements(By.xpath("//ul[@id='menu']/li/a"));
    }
    private List<WebElement>getSubMenuList(){
        return driver.findElements(By.xpath("//ul[@id='submenu']/li/a"));

    }
    public void subItems(String nameOfItem){
        for (int i = 0; i <getSubMenuList().size() ; i++) {
            if(getSubMenuList().get(i).getText().equalsIgnoreCase(nameOfItem)){
                getSubMenuList().get(i).click();
            }
        }
    }
    private List<WebElement> getCreatorList() {
        return driver.findElements(By.xpath("//div[@id='main']/h3"));
    }
    public boolean verifyCreatorsNames() {
        boolean result = false;
        String[] creatorsNames = new String[]{"Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"};//Как бы exp result
        for (int i = 0; i < creatorsNames.length; i++) {
            result = false;
            for (int j = 0; j < getCreatorList().size(); j++) {
                if (getCreatorList().get(i).getText().equals(creatorsNames[j])) {
                    result = true;
                }
            }
        }
        return result;
    }
    public boolean verifyCreatorsNamesA() {
        boolean result = false;
        List<String> name= new ArrayList<>(List.of("Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"));//Как бы exp result
        for (int i = 0; i < name.size(); i++) {
            result = false;
            for (int j = 0; j < getCreatorList().size(); j++) {
                if (getCreatorList().get(i).getText().equals(name.get(j))) {
                    result = true;
                }
            }
        }
        return result;
    }
}