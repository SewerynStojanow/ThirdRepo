package adminAreaTests;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Browser;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        Browser.setup();
    }


    @AfterMethod
    public void quit() {
        Browser.quit();
    }

    protected void click(By locator) {
        Browser.driver.findElement(locator).click();
    }

    protected void type(By locator, String textToType) {
        Browser.driver.findElement(locator).sendKeys(textToType);
    }

    protected boolean isDisplayed(By locator) {
        return Browser.driver.findElements(locator).isEmpty();
    }

    protected String getElementText(By locator) {
        return Browser.driver.findElement(locator).getText();
    }

    public String randomestring() {
        String generatedstring = RandomStringUtils.randomAlphabetic(7);
        return(generatedstring);
    }
    public static String randomeNum() {
        String generatedString2 = RandomStringUtils.randomNumeric(5);
        return (generatedString2);
    }

}
