package step_definitions;

import cucumber.api.java.cs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en_scouse.An;
import org.example.pageObject.BuyingFunction;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import step_definitions.Utils.Hooks;

import java.time.Duration;

public class BuyingSteps {

    private WebDriver webDriver;

    public BuyingSteps() {
        super();
        this.webDriver = Hooks.webDriver;
    }

    @Given("User already on DemoBlaze home page")
    public void verifyHomePage () {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(buyingFunction.verifyHome());
    }

    @And("click \"(.*)\" on navigation bar")
    public void clickNavBar (String navtext) throws InterruptedException {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        buyingFunction.clickNavbarBtn(navtext);
        Thread.sleep(5000);
    }
}
