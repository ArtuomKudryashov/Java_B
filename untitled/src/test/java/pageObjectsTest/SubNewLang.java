package pageObjectsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MainPage;
//import pageObjects.SubNewLan;

public class SubNewLang extends BaseTest{
    @Test
    public void subNewLangSub() {
        String expectedResult1 = "Submit New Language";

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        WebElement element = driver.findElement(By.xpath("(//*[text()='Submit new Language'])[1]"));
        element.click();
        WebElement elementSNL = driver.findElement(By.xpath("(//*[text()='Submit New Language'])[1]"));
        String actualText = elementSNL.getText();


        Assert.assertEquals(actualText,expectedResult1);
    }
    @Test
    public void subNewLangSub1()  {
        String expectedResult1 = "Submit New Language";

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        String acText = mainPage.getTextSNL();
        Assert.assertEquals(acText,expectedResult1);


    }
}
