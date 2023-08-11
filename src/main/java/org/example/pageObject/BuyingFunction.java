package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyingFunction {

    public static WebDriver driver;

    public BuyingFunction(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//    Locator
    @FindBy(xpath = "//a[@id='nava']")
    private WebElement DBLogo;


//    Custom Locator
    public By navbarLoc (String navbarBtn) {
        if (navbarBtn.equals("Home")) {
            return By.xpath("//a[.='" +navbarBtn+ " (current)']");
        } else {
            return By.xpath("//a[.='" + navbarBtn + "']");
        }
    }


//    Function
    public boolean verifyHome () {
        return DBLogo.isDisplayed();
    }

    public void clickNavbarBtn (String navbar) {
        WebElement navBtn = driver.findElement(navbarLoc(navbar));
        navBtn.click();
    }
}