package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.example.pageObject.BuyingFunction;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import step_definitions.Utils.Hooks;

import java.time.Duration;

public class BuyingSteps {

    private WebDriver webDriver;

    public BuyingSteps() {
        super();
        this.webDriver = Hooks.webDriver;
    }

    @Given("User already on DemoBlaze home page")
    public void verifyLandingPage () {
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

    @And("sign up pop up will appear")
    public void verifySignupPage () {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        Assert.assertTrue(buyingFunction.verifySignup());
    }

    @Then("input \"(.*)\" as username and \"(.*)\" as password in sign up")
    public void inputSignup (String username, String pass) {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        buyingFunction.setSignupUser(username);
        buyingFunction.setSignupPass(pass);
    }

    @And("click sign up button")
    public void clickSignupBtn () throws InterruptedException {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        buyingFunction.clickSignupBtn();
        Thread.sleep(3000);
    }

    @Then("alert message will appear \"(.*)\"")
    public void signupAlert (String alertmsg) {
        Alert alert = webDriver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals(alertmsg, alertMessage);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        alert.accept();
    }

    @And("log in pop up will appear")
    public void verifyLoginPage () {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        Assert.assertTrue(buyingFunction.verifyLogin());
    }

    @Then("input \"(.*)\" as username and \"(.*)\" as password in log in")
    public void inputLogin (String username, String pass) {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        buyingFunction.setLoginUser(username);
        buyingFunction.setLoginPass(pass);
    }

    @And("click log in button")
    public void clickLoginBtn () throws InterruptedException {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        buyingFunction.clickLoginBtn();
        Thread.sleep(3000);
    }

    @Then("User will redirect to home page")
    public void verifyHomePage () {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(buyingFunction.verifyHome());
    }

    @And("click \"(.*)\" filter")
    public void clickFilter (String categories) {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        buyingFunction.clickCategories(categories);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Then("click on \"(.*)\"")
    public void clickProducts (String product) throws InterruptedException {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        buyingFunction.clickProducts(product);
        Thread.sleep(5000);
    }

    @And("User will redirect to \"(.*)\" product page")
    public void verifyProductPage (String product) {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(buyingFunction.verifyProductPage());
        Assert.assertEquals(product, buyingFunction.verifyProductTitle());
    }

    @And("click add to cart button")
    public void clickCartBtn () throws InterruptedException {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        buyingFunction.clickCartBtn();
        Thread.sleep(3000);
    }

    @Then("User will redirect to cart page")
    public void verifyCartpage () {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(buyingFunction.verifyCartPage());
    }

    @And("click place order")
    public void clickOrderBtn () throws InterruptedException {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        buyingFunction.clickOrderBtn();
        Thread.sleep(3000);
    }

    @And("place order pop up will appear")
    public void verifyOrderPage () {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        Assert.assertTrue(buyingFunction.verifyOrderPage());
    }

    @Then("input \"(.*)\" as name, \"(.*)\" as country, \"(.*)\" as city, \"(.*)\" as credit card, \"(.*)\" as month, and \"(.*)\" as year")
    public void inputOrder (String name, String country, String city, String card, String month, String year) {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        buyingFunction.setOrderName(name);
        buyingFunction.setOrderCountry(country);
        buyingFunction.setOrderCity(city);
        buyingFunction.setOrderCard(card);
        buyingFunction.setOrderMonth(month);
        buyingFunction.setOrderYear(year);
    }

    @When("click purchase")
    public void clickPurchaseBtn () throws InterruptedException {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        buyingFunction.clickPurchaseBtn();
        Thread.sleep(3000);
    }

    @Then("purchase confirmation message will appear")
    public void verifyPurchaseConfirm () {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        Assert.assertTrue(buyingFunction.verifyPurchase());
        buyingFunction.clickOKBtn();
    }

    @And("cart should be empty")
    public void verifyItemTable () {
        BuyingFunction buyingFunction = new BuyingFunction(webDriver);
        Assert.assertFalse(buyingFunction.verifyItemTable());
    }
}
