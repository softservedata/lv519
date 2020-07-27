package academy.softserve.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class BaseTest {

    public static ChromeDriver driver;

    /**
     * create new driver before each test method
     */
    @BeforeMethod
    public void setUpClass() {
        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * @param url - url that should be opened
     */
    public void open(String url) {
        this.driver.get(url);
    }

    /**
     * close driver after each test method and clear cash
     */
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            WebDriverManager.chromedriver().clearResolutionCache().clearCache();
            driver.quit();
            System.out.println("driver teardown");
        }
    }
}
