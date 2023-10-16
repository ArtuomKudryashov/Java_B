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
        List<WebElement> liElements = driver.findElements(By.xpath("//ul[@id='menu']/li/a"));
        for (int i = 0; i < liElements.size(); i++) {
            WebElement liElement = liElements.get(i);
            if (liElements.get(i).getText().equals("SUBMIT NEW LANGUAGE")) {
                System.out.println("Элемент найден!");
                answer = "SUBMIT NEW LANGUAGE";
            }
        }
        return answer;
    }

    //    TC_11_03
    public SubNewLan getSubNewLangPage() {
        By sNLBy = By.xpath("(//*[text()='Submit new Language'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(sNLBy));
        WebElement suNewlpage = driver.findElement(By.xpath("(//*[text()='Submit new Language'])[1]"));
        suNewlpage.click();
        return new SubNewLan(driver);

    }


    //TC_11_04
    private List<WebElement> getSubMenuList() {
        return driver.findElements(By.xpath("//ul[@id='menu']/li/a"));
    }

    public BrowseLanguagesPage navigateToBrowseLanguagePage() {
        for (int i = 0; i < getSubMenuList().size(); i++) {
            if (getSubMenuList().get(i).getText().equalsIgnoreCase("BROWSE LANGUAGES")) {
                getSubMenuList().get(i).click();

            }
        }
        return new BrowseLanguagesPage(driver);
    }



    public StartPage navigateToStartPage() {
        for (int i = 0; i < getSubMenuList().size(); i++) {
                if (getSubMenuList().get(i).getText().equalsIgnoreCase("Start")) {
                getSubMenuList().get(i).click();
                break;
                                }
        }
        return new StartPage(driver);
    }
    //15
    public TopListsPage navigateToTopListPage() {
        for (int i = 0; i < getSubMenuList().size(); i++) {
            if (getSubMenuList().get(i).getText().equalsIgnoreCase("Top Lists")) {
                getSubMenuList().get(i).click();
                break;
            }
        }
        return new TopListsPage(driver);
    }

//    public void subItems(String nameOfItem){
//        for (int i = 0; i <getSubMenuList().size() ; i++) {
//            if(getSubMenuList().get(i).getText().equalsIgnoreCase(nameOfItem)){
//                getSubMenuList().get(i).click();
//            }
//        }
//    }
//    private List<WebElement> getCreatorList() {
//        return driver.findElements(By.xpath("//div[@id='main']/h3"));
//    }
//
//    public boolean verifyCreatorsNamesA() {
//        boolean result = false;
//        List<String> name= new ArrayList<>(List.of("Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"));//Как бы exp result
//        for (int i = 0; i < name.size(); i++) {
//            result = false;
//            for (int j = 0; j < getCreatorList().size(); j++) {
//                if (getCreatorList().get(i).getText().equals(name.get(j))) {
//                    result = true;
//                }
//            }
//        }
//        return result;
//    }
//    //7
//    public TopLists navigateTopListsPage() {
//        for (int i = 0; i < getMainMenuList().size(); i++) {
//            System.out.println(getMainMenuList().size());
//            if (getMainMenuList().get(i).getText().equalsIgnoreCase("Top Lists")) {
//                getMainMenuList().get(i).click();
//                return new TopLists(driver);
//            }
//        }
//        return null;
//    }
//    //7
//    public boolean verifyColumnHeaders() {
//        boolean result = false;
//        List<String> colHead= new ArrayList<>(List.of("#","Languвage", "Author", "Date", "Comments", "Rate"));//Как бы exp result
//        for (int i = 0; i < colHead.size(); i++) {
//            result = false;
//            for (int j = 0; j < getColumnHeadersList().size(); j++) {
//                if (getColumnHeadersList().get(i).getText().equals(colHead.get(j))) {
//                    result = true;
//                }
//            }
//        }
//        return result;
//    }
//    private List<WebElement> getColumnHeadersList() {
//        return driver.findElements(By.xpath("//table[@id='category']//th"));
//    }
//

}

