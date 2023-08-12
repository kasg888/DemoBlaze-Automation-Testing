package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageObject.TestPageObject;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.Utils.Hooks;

import java.time.Duration;

public class TestSteps {

    private WebDriver webDriver;

    public TestSteps() {
        super();
        this.webDriver = Hooks.webDriver;
    }

    @Given("User already on DemoBlaze home page")
    public void verifyLandingPage () {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(testPageObject.verifyHome());
    }

    @And("click \"(.*)\" on navigation bar")
    public void clickNavBar (String navtext) throws InterruptedException {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        testPageObject.clickNavbarBtn(navtext);
        Thread.sleep(5000);
    }

    @And("sign up pop up will appear")
    public void verifySignupPage () {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        Assert.assertTrue(testPageObject.verifySignup());
    }

    @Then("input \"(.*)\" as username and \"(.*)\" as password in sign up")
    public void inputSignup (String username, String pass) {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        testPageObject.setSignupUser(username);
        testPageObject.setSignupPass(pass);
    }

    @And("click sign up button")
    public void clickSignupBtn () throws InterruptedException {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        testPageObject.clickSignupBtn();
        Thread.sleep(3000);
    }

    @Then("alert message will appear \"(.*)\"")
    public void messageAlert (String alertmsg) throws InterruptedException {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertEquals(alertmsg, alertMessage);
        Thread.sleep(3000);
        alert.accept();
    }

    @And("log in pop up will appear")
    public void verifyLoginPage () {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        Assert.assertTrue(testPageObject.verifyLogin());
    }

    @Then("input \"(.*)\" as username and \"(.*)\" as password in log in")
    public void inputLogin (String username, String pass) {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        testPageObject.setLoginUser(username);
        testPageObject.setLoginPass(pass);
    }

    @And("click log in button")
    public void clickLoginBtn () throws InterruptedException {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        testPageObject.clickLoginBtn();
        Thread.sleep(3000);
    }

    @Then("User will redirect to home page")
    public void verifyHomePage () {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(testPageObject.verifyHome());
    }

    @And("click \"(.*)\" filter")
    public void clickFilter (String categories) throws InterruptedException {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        testPageObject.clickCategories(categories);
        Thread.sleep(3000);
    }

    @Then("click on \"(.*)\"")
    public void clickProducts (String product) throws InterruptedException {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        testPageObject.clickProducts(product);
        Thread.sleep(5000);
    }

    @And("User will redirect to \"(.*)\" product page")
    public void verifyProductPage (String product) {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(testPageObject.verifyProductPage());
        Assert.assertEquals(product, testPageObject.verifyProductTitle());
    }

    @And("click add to cart button")
    public void clickCartBtn () throws InterruptedException {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        testPageObject.clickCartBtn();
        Thread.sleep(3000);
    }

    @Then("User will redirect to cart page")
    public void verifyCartpage () {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(testPageObject.verifyCartPage());
    }

    @And("click place order")
    public void clickOrderBtn () throws InterruptedException {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        testPageObject.clickOrderBtn();
        Thread.sleep(3000);
    }

    @And("place order pop up will appear")
    public void verifyOrderPage () {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        Assert.assertTrue(testPageObject.verifyOrderPage());
    }

    @Then("input \"(.*)\" as name, \"(.*)\" as country, \"(.*)\" as city, \"(.*)\" as credit card, \"(.*)\" as month, and \"(.*)\" as year")
    public void inputOrder (String name, String country, String city, String card, String month, String year) {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        testPageObject.setOrderName(name);
        testPageObject.setOrderCountry(country);
        testPageObject.setOrderCity(city);
        testPageObject.setOrderCard(card);
        testPageObject.setOrderMonth(month);
        testPageObject.setOrderYear(year);
    }

    @When("click purchase")
    public void clickPurchaseBtn () throws InterruptedException {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        testPageObject.clickPurchaseBtn();
        Thread.sleep(3000);
    }

    @Then("purchase confirmation message will appear")
    public void verifyPurchaseConfirm () {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        Assert.assertTrue(testPageObject.verifyPurchase());
        testPageObject.clickOKBtn();
    }

    @And("cart should be empty")
    public void verifyItemTable () {
        TestPageObject testPageObject = new TestPageObject(webDriver);
        Assert.assertFalse(testPageObject.verifyCartEmpty());
    }
}
