package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected WebDriver driver;

    public BaseClass() {

    }

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitMethod(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "D:/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        waitMethod(10);
    }

    public HomePage openHomePage() {
        beforeTest();
        driver.get("https://ita-social-projects.github.io/GreenCityClient/#/welcome");
        return new HomePage(driver);
    }

    public void afterTest() {
        driver.quit();
    }
}
