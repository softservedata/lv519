package academy.softserve.testsLogic;

import academy.softserve.constantParameters.SingUpFieldsSelectorsValue;
import academy.softserve.widgets.MainPage;
import academy.softserve.widgets.SingUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static academy.softserve.constantParameters.SingUpFieldsSelectorsValue.*;
import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class SignUpTest {
    private ChromeDriver driver;
    public static final int random = (int) System.currentTimeMillis() / 1000;

    @BeforeClass
    public void setUpClass() {
        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("driver teardown");
        }
    }

    @Test
    public void testSingUp() {
        new MainPage(driver)
                .open()
                .singUp();
        new SingUpPage(driver)
                .setFor(EMAIL, "nagrebetski.p" + random + "@gmail.com")
                .setFor(USER_NAME, "Pavel")
                .setFor(PASSWORD, "1234qwerTY-")
                .setFor(PASSWORD_CONFIRM, "1234qwerTY-")
                .confirmSingUp();
    }

}
