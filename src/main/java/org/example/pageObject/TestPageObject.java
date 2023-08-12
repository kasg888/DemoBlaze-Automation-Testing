package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPageObject {

    public static WebDriver driver;

    public TestPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//    Locator
    @FindBy(xpath = "//a[@id='nava']")
    private WebElement DBLogo;
    @FindBy(xpath = "//h5[@id='signInModalLabel']")
    private WebElement signupTitle;
    @FindBy(xpath = "//input[@id='sign-username']")
    private WebElement signupUser;
    @FindBy(xpath = "//input[@id='sign-password']")
    private WebElement signupPass;
    @FindBy(xpath = "//button[.='Sign up']")
    private WebElement signupBtn;
    @FindBy(xpath = "//h5[@id='logInModalLabel']")
    private WebElement loginTitle;
    @FindBy(xpath = "//input[@id='loginusername']")
    private WebElement loginUser;
    @FindBy(xpath = "//input[@id='loginpassword']")
    private WebElement loginPass;
    @FindBy(xpath = "//button[.='Log in']")
    private WebElement loginBtn;
    @FindBy(xpath = "//h2[@class='name']")
    private WebElement productTitle;
    @FindBy(xpath = "//a[.='Add to cart']")
    private WebElement cartBtn;
    @FindBy(xpath = "//h2[.='Products']")
    private WebElement cartTitle;
    @FindBy(xpath = "//button[@class='btn btn-success']")
    private WebElement orderBtn;
    @FindBy(xpath = "//h5[@id='orderModalLabel']")
    private WebElement orderTitle;
    @FindBy(xpath = "//input[@id='name']")
    private WebElement orderName;
    @FindBy(xpath = "//input[@id='country']")
    private WebElement orderCountry;
    @FindBy(xpath = "//input[@id='city']")
    private WebElement orderCity;
    @FindBy(xpath = "//input[@id='card']")
    private WebElement orderCard;
    @FindBy(xpath = "//input[@id='month']")
    private WebElement orderMonth;
    @FindBy(xpath = "//input[@id='year']")
    private WebElement orderYear;
    @FindBy(xpath = "//button[.='Purchase']")
    private WebElement purchaseBtn;
    @FindBy(xpath = "//p[@class='lead text-muted ']")
    private WebElement purchaseConfirm;
    @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
    private WebElement OKBtn;
    @FindBy(xpath = "//h3[@id='totalp']")
    private WebElement cartTotal;


//    Custom Locator
    public By navbarLoc (String navbarBtn) {
        if (navbarBtn.equals("Home")) {
            return By.xpath("//a[.='" +navbarBtn+ " (current)']");
        } else {
            return By.xpath("//a[.='" +navbarBtn+ "']");
        }
    }

    public By catFilter (String catBtn) {
        return By.xpath("//a[.='" +catBtn+ "']");
    }

    public By productLoc (String product) {
        return By.xpath("//a[.='" +product+ "']");
    }


//    Function
    public boolean verifyHome () {
        return DBLogo.isDisplayed();
    }

    public void clickNavbarBtn (String navbar) {
        WebElement navBtn = driver.findElement(navbarLoc(navbar));
        navBtn.click();
    }

    public boolean verifySignup () {
        return signupTitle.isDisplayed();
    }

    public void setSignupUser (String username) {
        signupUser.sendKeys(username);
    }

    public void setSignupPass (String pass) {
        signupPass.sendKeys(pass);
    }

    public void clickSignupBtn () {
        signupBtn.click();
    }

    public boolean verifyLogin () {
        return loginTitle.isDisplayed();
    }

    public void setLoginUser (String username) {
        loginUser.sendKeys(username);
    }

    public void setLoginPass (String pass) {
        loginPass.sendKeys(pass);
    }

    public void clickLoginBtn () {
        loginBtn.click();
    }

    public void clickCategories (String categories) {
        WebElement catBtn = driver.findElement(catFilter(categories));
        catBtn.click();
    }

    public void clickProducts (String product) {
        WebElement prodBtn = driver.findElement(productLoc(product));
        prodBtn.click();
    }

    public boolean verifyProductPage () {
        return productTitle.isDisplayed();
    }

    public String verifyProductTitle () {
        return productTitle.getText();
    }

    public void clickCartBtn () {
        cartBtn.click();
    }

    public boolean verifyCartPage () {
        return cartTitle.isDisplayed();
    }

    public void clickOrderBtn () {
        orderBtn.click();
    }

    public boolean verifyOrderPage () {
        return orderTitle.isDisplayed();
    }

    public void setOrderName (String name) {
        orderName.sendKeys(name);
    }

    public void setOrderCountry (String country) {
        orderCountry.sendKeys(country);
    }

    public void setOrderCity (String city) {
        orderCity.sendKeys(city);
    }

    public void setOrderCard (String card) {
        orderCard.sendKeys(card);
    }

    public void setOrderMonth (String month) {
        orderMonth.sendKeys(month);
    }

    public void setOrderYear (String year) {
        orderYear.sendKeys(year);
    }

    public void clickPurchaseBtn () {
        purchaseBtn.click();
    }

    public boolean verifyPurchase () {
        return purchaseConfirm.isDisplayed();
    }

    public void clickOKBtn () {
        OKBtn.click();
    }

    public boolean verifyCartEmpty () {
        return cartTotal.isDisplayed();
    }
}