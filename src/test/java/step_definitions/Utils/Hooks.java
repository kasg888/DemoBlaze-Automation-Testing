package step_definitions.Utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    public static WebDriver webDriver;

    @Before
    public void openBrowser(){
        ChromeOptions co = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        co.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(co);
        String URL = "https://www.demoblaze.com/index.html";
        webDriver.get(URL);
        webDriver.manage().window().maximize();
    }

    @After
    public void closeBrowser(){
        webDriver.quit();
    }
}
