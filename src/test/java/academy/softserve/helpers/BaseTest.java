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
    public static final int random = (int) System.currentTimeMillis() / 1000;
    public static ChromeDriver driver;
    public static List<String> errData;

    static {
        errData = new ArrayList<>();
        errData.add("Please check that your e-mail address is indicated correctly");
        errData.add("User name is required");
        errData.add("Password is required");
        errData.add("Password is required");
    }


    @BeforeMethod
    public void setUpClass() {
        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void open(String url) {
        this.driver.get(url);
    }

    public Object open(String url, Object obj) {
        this.driver.get(url);
        return obj;
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("driver teardown");
        }
    }


    @BeforeGroups(value = {"ErrorPositive"})
    @DataProvider(name = "ErrorsDataProvider")
    public Object[][] testData() {
        return new Object[][]{
                {errData}};
    }
}
