package pageObjectsTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.TopListsPage;


public class MainToApp extends  BaseTest {
    //1
    @Test
    public void findElement99BofBTest(){
        String expectedResult = "99 Bottles of Beer";
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertTrue(mainPage.get99BofB().equals(expectedResult));
    }
    //2
    @Test
    public void subNewLangTest() {
        String expectedResult1 = "SUBMIT NEW LANGUAGE";
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertEquals(mainPage.subNewLang(),expectedResult1);
    }
    //2Arr
    @Test
    public void subNewLangArrTest() {
        String expectedResult1 = "SUBMIT NEW LANGUAGE";
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        Assert.assertEquals(mainPage.subNewLangArr(),expectedResult1);
    }



//    @Test
//    public void TC_11_06_NameOfCreatersTest() throws InterruptedException {
//        MainPage mainPage = new MainPage(driver);
//        mainPage.open();
//        mainPage.subItems("Team");
//        Assert.assertTrue(mainPage.verifyCreatorsNames());
//    }
//    @Test
//    public void TC_11_06_NameOfCreatersATest() {
//        MainPage mainPage = new MainPage(driver);
//        mainPage.open();
//        mainPage.subItems("Team");
//        Assert.assertTrue(mainPage.verifyCreatorsNamesA());
//    }
    @Test
    public void TC_11_07_NameOfCreateTest()  {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        TopListsPage topList = mainPage.navigateToTopListPage();

//        Assert.assertTrue(mainPage.navigateToTopListPage());

    }


}
