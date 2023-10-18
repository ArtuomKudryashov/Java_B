package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
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

    public String subBrowsLangNewlAngArr(String menu) {
        String answer = "";
        List<WebElement> liElements = driver.findElements(By.xpath("//ul[@id='submenu']/li/a"));
        for (int i = 0; i < liElements.size(); i++) {
//            WebElement liElement = liElements.get(i);
            if (liElements.get(0).getText().equals(menu)) {
                System.out.println("Элемент найден!");
                answer = menu;
                break;
               }
        }
        return answer;
    }
    public void clickSubMenuItem(String subItemMenuName) {
        for (int i = 0; i < getSubmenuList().size(); i++) {  // SubmenuList - метод вытягивающий все (меню листы)
            if (getSubmenuList().get(i).getText().equalsIgnoreCase(subItemMenuName)) {
                getSubmenuList().get(i).click();
            }

        }
    }
    private WebElement getALSwithJAreShownSortedByL(){
        return  driver.findElement(By.xpath("(//div[@id='main']//p)[1]"));
    }
    public boolean verifyTextSortByLang(){
        return   getALSwithJAreShownSortedByL().getText().equals("All languages starting with the letter J are shown, sorted by Language.");


    }
    //12_02

    public List< WebElement>  getTable(){
        return driver.findElements(By.xpath("//table//tr//a"));
    }
    public  int  numberOfLanguage(String a){
        for (int i = 0; i < getTable().size() ; i++) {
            if (getTable().get(i).getText().equalsIgnoreCase(a)){
                return i+1;
            }
        }
        return 0;
    }
    public boolean verifySQLIsLast() {
        return numberOfLanguage("MySQl")==getTable().size();
    }
    List<String> actRsult= new ArrayList<>();
    //12_04
    List<WebElement> trs = driver.findElements(By.xpath("//table[@id='category']/tbody/tr"));

    public  void MathDate() {
        List<String>actualResult = new ArrayList<>();

        for(WebElement tr: trs){
            if(tr.getText().contains("Mathematica"))
               actualResult.add(tr.getText());

        }


    }
    //12_05
    public List<WebElement>getAllLanguages(){
        return driver.findElements(By.xpath("//tbody//a[contains(@href,'language')]"));
    }



}





