package academy.softserve.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class BaseTest {

    public static ChromeDriver driver;

    @Step("create driver")
    @BeforeMethod
    public void setUpClass() {
        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Mail.connectToEmail();
    }


    @Step("open url")
    public void open(String url) {
        driver.get(url);
    }

    @Step("kill driver")
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            WebDriverManager.chromedriver().clearResolutionCache();
            driver.quit();
            System.out.println("driver teardown");
        }
    }
}
