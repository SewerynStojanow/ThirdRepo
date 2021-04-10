package adminAreaTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class LoginAndNavigate extends BaseTest {

    @Given("we are logged in as Admin on the <Admin Dashboard page>")
    public void LoginAndNavigateMethod() {
            setup();
            adminAreaPages.AdminLoginPage.navigate();
            adminAreaPages.AdminLoginPage.login("admin21","parola123!");
            adminAreaPages.AdminDashboardPage.verifyDashboardHeadingText("Dashboard", "Not Logged In!");
    }


    @When("we click <Sales> <Gift Vouchers> <Gift Vouchers>")
    public void weClickSalesGiftVouchersGiftVouchers() {
            click(By.cssSelector("#menu-sale"));
            click(By.cssSelector("#menu-sale li:nth-of-type(4)"));
            click(By.cssSelector("#menu-sale li:nth-of-type(4) li:nth-of-type(1)"));
    }

    @Then("we end up on the <Gift Vouchers> page. <Gift Vouchers list> is visible")
    public void weEndUpOnTheGiftVouchersPageGiftVouchersListIsVisible() {
        adminAreaPages.AdminDashboardPage.verifyDashboardHeadingText("Gift Vouchers", "No Vouchers in Sight!");
    }
}
