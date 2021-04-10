package adminAreaTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import utils.Browser;
import java.util.List;


public class CreatingVoucher extends BaseTest {

    String name = randomestring() + " " + randomestring();
    String name2 = randomestring() + " " + randomestring();
    String email = randomestring() + "@abv.bg";
    String email2 = randomestring() + "@abv.bg";
    String voucherCode = randomeNum();
    String amount = randomeNum();

    @Given("A Voucher with given Name does exist - delete it")
    public void makingSureMethod() {

        List<WebElement> vouchers = Browser.driver.findElements(By.cssSelector(".table tbody tr"));
        for (WebElement voucher : vouchers) {
            if (voucher.getText().contains(name)) {
                System.out.println("got it");
                WebElement checkbox = voucher.findElement(By.cssSelector("input"));
                checkbox.click();
                Browser.driver.findElement(By.cssSelector(".btn-danger")).click();
                Browser.driver.switchTo().alert().accept();
                break;
            }
        }
    }

    @When("it doesn't - create one")
    public void CreatingVoucherMethod() {
        click(By.cssSelector(".pull-right .btn-primary"));
        type(By.cssSelector("#input-code"), voucherCode);
        type(By.cssSelector("#input-from-name"), name);
        type(By.cssSelector("#input-from-email"), email);
        type(By.cssSelector("#input-to-name"), name2);
        type(By.cssSelector("#input-to-email"), email2);
        type(By.cssSelector("#input-amount"), amount);
        click(By.cssSelector(".pull-right .btn-primary"));
    }

    @Then("make sure the Voucher is created")
    public void makeSureTheVoucherIsCreated() {
        Assert.assertTrue(getElementText(By.cssSelector(".alert-success")).contains("Success: You have modified vouchers!"));
    }

    @Then("we are on the <Gift Vouchers> page , <Gift Vouchers list> is visible")
    public void weAreOnTheGiftVouchersPageGiftVouchersListIsVisible() {
        adminAreaPages.AdminDashboardPage.verifyDashboardHeadingText("Gift Vouchers", "No Vouchers in Sight!");
    }


    @Then("A Voucher with the Name we entered exists - delete it")
    public void aVoucherWithTheNameWeEnteredExists() {

        List<WebElement> vouchers = Browser.driver.findElements(By.cssSelector(".table tbody tr"));
        for (WebElement voucher : vouchers) {
            if (voucher.getText().contains(name)) {
                System.out.println("got it");
                WebElement checkbox = voucher.findElement(By.cssSelector("input"));
                checkbox.click();
                Browser.driver.findElement(By.cssSelector(".btn-danger")).click();
                Browser.driver.switchTo().alert().accept();
                break;
            }
        }
    }

    @AfterMethod
    @Override
    public void quit() {
        super.quit();
    }
}