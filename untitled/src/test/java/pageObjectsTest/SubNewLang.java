package pageObjectsTest;

import org.bouncycastle.operator.AADProcessor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.SubNewLan;
//import pageObjects.SubNewLan;

public class SubNewLang extends BaseTest {
    @Test
    public void TC_11_03_subNewLangSubTest() {
        String expectedResult1 = "Submit New Language";

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        WebElement element = driver.findElement(By.xpath("(//*[text()='Submit new Language'])[1]"));
        element.click();
        WebElement elementSNL = driver.findElement(By.xpath("(//*[text()='Submit New Language'])[1]"));
        String actualText = elementSNL.getText();


        Assert.assertEquals(actualText, expectedResult1);
    }

    @Test
    public void TC_11_03_SubNewLang2Test() {
        String expectedResult = "Submit New Language";
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        SubNewLan subNewLan = mainPage.getSubNewLangPage();
        Assert.assertEquals(subNewLan.getTextSNL(), expectedResult);
    }
//    @Test
//    public void subNewLangSub1Test()  {
//        String expectedResult1 = "Submit New Language";
//        MainPage mainPage = new MainPage(driver);
//        mainPage.open();
//        SubNewLan subNewLan = mainPage.getSubNewLangPage();
//     Assert.assertEquals(subNewLan.verifyErrorPFII(),expectedResult1);

    @Test
    public void TC_11_11_Mistake() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        SubNewLan subNewLan = mainPage.getSubNewLangPage();
        boolean actualRes = subNewLan.verifyErrorPFII();
        Assert.assertEquals(actualRes, true);
    }

    @Test
    public void TC_11_11_Error2MetTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        SubNewLan subNewLan = mainPage.getSubNewLangPage();
        boolean actualRes = subNewLan.verifyErrorPFII1();
        Assert.assertEquals(actualRes, true);
    }

    @Test
    public void TC_11_11_ErrorViaArrayTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        SubNewLan subNewLan = mainPage.getSubNewLangPage();
        boolean actualRes = subNewLan.verifyErrorPFII2();
        Assert.assertEquals(actualRes, true);

    }

    @Test
    public void TC_11_12_verifyErrorPFIIContainsAllRequarement() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        SubNewLan subNewLan = mainPage.getSubNewLangPage();
//        String actRes= subNewLan.verifyErrorPFII3();
        Assert.assertEquals(subNewLan.verifyErrorPFII3(), true);

    }

    @Test
    public void TC_11_13_verifyImportans() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        SubNewLan subNewLan = mainPage.getSubNewLangPage();
        Assert.assertTrue(subNewLan.verifyFirstImportantListItem());

    }

    //21
    @Test
    public void testWordWhiteFront() {
        MainPage mainpage = new MainPage(driver);
        mainpage.open();
        SubNewLan subNewLan = mainpage.getSubNewLangPage();
        System.out.println("//Нашли слово импортант");
        String bold = driver.findElement(By.xpath("//li//span[@style='background-color:red; color: white']/b")
                )
                .getTagName();
        Assert.assertEquals(bold, "b");

        System.out.println(2);
        WebElement important = driver.findElement(
                By.xpath("//body/div[@id= 'wrap']/div[@id='main']/ul/li/span[@style='background-color:red; color: white']")
        );
        System.out.println(3);
        String expRes = "IMPORTANT:";
        String actRes = important.getText();
        Assert.assertEquals(actRes, expRes.toUpperCase());

        System.out.println(4);
        String backgroundColor = important.getCssValue("background-color");
        System.out.println(backgroundColor);
        Assert.assertTrue(Color.fromString("#ff0000").equals(Color.fromString(backgroundColor)));

        System.out.println(5);
        String color = important.getCssValue("color");
        System.out.println(color);
        Assert.assertTrue(Color.fromString("#ffffff").equals(Color.fromString(color)));

    }

    @Test
    public void testWordWhiteFront2() {
        String expectedResultCapital = "IMPORTANT:";
        String expectedResultStyle = "background-color: red; color: white;";
        String expectedResultBolt = "b";

        MainPage mainpage = new MainPage(driver);
        mainpage.open();
        SubNewLan subNewLan = mainpage.getSubNewLangPage();
        System.out.println(1);
        WebElement submitNewLanguageImportantStyle = driver.findElement(By.xpath
                ("//span[@style='background-color:red; color: white']"));
        String actualResultStyle = submitNewLanguageImportantStyle.getAttribute("style");
        System.out.println(2);

        WebElement submitNewLanguagelmportantBolt = driver.findElement(By.xpath(
                "//span[@style='background-color:red; color: white']/b"));
        String actualResultBolt = submitNewLanguagelmportantBolt.getTagName();
//        String actualResultBolt = submitNewLanguagelmportantBolt.getCssValue("font-weight").
        System.out.println(3);
        WebElement submitNewLanguagelmportantCapital = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id ='main']/ul/li/span/b"));
        String actualResultCapital = submitNewLanguagelmportantCapital.getText();

        System.out.println(4);
        Assert.assertEquals(actualResultStyle, expectedResultStyle);
        System.out.println(5);
        Assert.assertEquals(actualResultBolt, expectedResultBolt);
        System.out.println(6);
        Assert.assertEquals(actualResultCapital, expectedResultCapital.toUpperCase());
        System.out.println(7);

    }
}
