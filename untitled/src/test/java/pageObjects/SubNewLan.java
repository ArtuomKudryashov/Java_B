package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubNewLan extends BasePage {
    public SubNewLan(WebDriver driver) {
        super(driver);
    }

    // TC_11_03
    public String getTextSNL() {
        WebElement elementSNL = driver.findElement(By.xpath("(//*[text()='Submit New Language'])[1]"));
        String actualText = elementSNL.getText();
        return actualText;
    }


//        private WebElement getSubNewLang() {
//        By SNLBy = By.xpath("(//*[text()='Submit new Language'])[1]");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(SNLBy));
//        return driver.findElement(SNLBy);
//
//    }
//
//    public SubNewLan mainPage() {
//
//        getSubNewLang().click();
//        return  new SubNewLan(driver);
//
//    }
    //11_11

    public WebElement getTextEr() {
        By textError = By.xpath("//*[contains(@style,'border: 1px solid red; ')]");
        return driver.findElement(textError);
    }

    public WebElement buttonSubLang() {
        By subLangButton = By.xpath("//input[@type='submit']");
        WebElement butSubLang = driver.findElement(subLangButton);
        return butSubLang;
    }

    public boolean verifyErrorPFII() {
        buttonSubLang().click();
        return (getTextEr().getText().equals("Error: Precondition failed - Incomplete Input."));
    }

    //Combining 2 Methods
    public boolean verifyErrorPFII1() {
        buttonSubLang().click();
        By textError = By.xpath("//*[contains(@style,'border: 1px solid red; ')]");
        WebElement errorElement = driver.findElement(textError);
        String errorText = errorElement.getText();
        System.out.println(errorText);
        return errorText.equals("Error: Precondition failed - Incomplete Input.");

    }

    public List<WebElement> getTextEr1() {
        By textError = By.xpath("//*[contains(@style,'border: 1px solid red; ')]");
        return driver.findElements(textError);
    }

    //solution via array
    public boolean verifyErrorPFII2() {
        buttonSubLang().click();
        String[] textMessage = new String[]{"Error: Precondition failed - Incomplete Input."};
        List<WebElement> textErrors = getTextEr1();
        if (textErrors.size() != textMessage.length) {
            return false;
        }
        for (int i = 0; i < textMessage.length; i++) {
            boolean result = false;
            for (int j = 0; j < textErrors.size(); j++) {
                if (textErrors.get(j).getText().contains(textMessage[i])) {
                    result = true;
                    break;
                }
            }
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public List<WebElement> getTextEr2() {
        By textError = By.xpath("//*[contains(@style,'border: 1px solid red; ')]");
        return driver.findElements(textError);
    }


    public boolean verifyErrorPFII3() {
        buttonSubLang().click();
        String errMessage = driver.findElement(By.xpath("//*[contains(@style,'border: 1px solid red; ')]")).getText().trim();
        System.out.println(errMessage);

        String[] arrWordErr = errMessage.split(" ");
        System.out.println(Arrays.toString(arrWordErr));

        for (String s : arrWordErr) {
            if (s.equals("Error") && !Character.isUpperCase(s.charAt(0))) {
                System.out.println("1");
                return false;
            }
            if (s.equals("Precondition") && !Character.isUpperCase(s.charAt(0))) {
                System.out.println("2");
                return false;
            }
            if (s.equals("failed") && !Character.isLowerCase(s.charAt(0))) {
                return false;
            }
            if (s.equals("Incomplete") && !Character.isUpperCase(s.charAt(0))) {
                System.out.println("3");
                return false;
            }
            if (s.equals("Input.") && !Character.isUpperCase(s.charAt(0))) {
                System.out.println("4");
                return false;
            }
        }

        if (!errMessage.contains(".") || !errMessage.contains(":") || !errMessage.contains("-")) {
            return false;
        }

        return true;
    }

    public WebElement noteImportant() {
        By subLangButton = By.xpath("//input[@type='submit']");
        WebElement butSubLang = driver.findElement(subLangButton);
        return butSubLang;
    }

    //11_13
    private List<WebElement> getImportantInfoList() {
        return driver.findElements(By.xpath("//div[@id='main']//ul/li"));
    }

    public boolean verifyFirstImportantListItem() {
        return getImportantInfoList().get(0).getText().equals("IMPORTANT: Take your time! " +
                "The more carefully you fill out this form (especially the language name and description)," +
                " the easier it will be for us and the faster your language will show up on this page. " +
                "We don't have the time to mess around with fixing your descriptions etc." +
                " Thanks for your understanding.");

    }
    //11_21
}





