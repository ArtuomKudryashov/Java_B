package pageObjectsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BrowseLanguagesPage;
import pageObjects.MainPage;
import pageObjects.SubNewLan;


public class MainToApp extends  BaseTest {
    @Test
    public void findElement99BofBTest(){
        String expectedResult = "99 Bottles of Beer";
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.get99BofB().equals(expectedResult));
    }
    @Test
    public void subNewLangTest() {
        String expectedResult1 = "SUBMIT NEW LANGUAGE";
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertEquals(mainPage.subNewLang(),expectedResult1);
    }
    @Test
    public void subNewLangArrTest() {
        String expectedResult1 = "SUBMIT NEW LANGUAGE";
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertEquals(mainPage.subNewLangArr(),expectedResult1);
    }
    @Test
    public void TC_11_03_SubNewLang2Test()  {
        MainPage mainPage = new MainPage(driver);
        String expectedResult = "Submit New Language";
        mainPage.open();
        Assert.assertEquals(mainPage.getTextSNL(),expectedResult);


    }
    @Test
    public void TC_11_04_FItemTest(){
        MainPage mainPage =new MainPage(driver);
        mainPage.open();
        BrowseLanguagesPage browseLanguagesPage = mainPage.navigateToBrowseLanguagePage();
        Assert.assertTrue(browseLanguagesPage.verifySubmenuItem());
    }
    @Test
    public void TC_11_06_NameOfCreatersTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.subItems("Team");
        Assert.assertTrue(mainPage.verifyCreatorsNames());
    }
    @Test
    public void TC_11_06_NameOfCreatersATest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.subItems("Team");
        Assert.assertTrue(mainPage.verifyCreatorsNamesA());
    }
}
