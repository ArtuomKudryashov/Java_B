package pageObjectsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.SubNewLan;


public class MainToApp extends  BaseTest {
    @Test
    public void findElement99BofB(){
        String expectedResult = "99 Bottles of Beer";
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.get99BofB().equals(expectedResult));
    }
    @Test
    public void subNewLang() {
        String expectedResult1 = "SUBMIT NEW LANGUAGE";
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertEquals(mainPage.subNewLang(),expectedResult1);
    }
    @Test
    public void subNewLangArr() {
        String expectedResult1 = "SUBMIT NEW LANGUAGE";
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertEquals(mainPage.subNewLangArr(),expectedResult1);
    }


}
