package pageObjectsTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.TopListsPage;

public class TopList extends BaseTest{
    //7
    @Test
    public void TC_11_07_columnHeadings(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        TopListsPage topListPage = mainPage.navigateToTopListPage("Top Lists");
        Assert.assertEquals(topListPage.verifyColumnHeading(),true);

    }
    //15
    @Test
    public void TC_TC_11_15_noComments(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        TopListsPage topListPage = mainPage.navigateToTopListPage("Top Lists");
        topListPage.clickSubMenuItem("New Comments");
        topListPage.verifyNoNewComments();
        Assert.assertEquals(topListPage.verifyNoNewComments(),true);

    }



}
