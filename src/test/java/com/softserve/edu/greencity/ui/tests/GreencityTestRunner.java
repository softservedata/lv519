package com.softserve.edu.greencity.ui.tests;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.softserve.edu.greencity.ui.pages.habits.MyHabitsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author
 *         <h1>Lv519.TAQC/Java
 *         <h1>
 */
public abstract class GreencityTestRunner {
    private final Long ONE_SECOND_DELAY = 1000L;
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        // System.setProperty("webdriver.chrome.verboseLogging", "false");
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        java.util.logging.Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setUpBeforeClass() throws Exception {
        System.out.println("@BeforeClass");
//        ChromeOptions options = new ChromeOptions();
//      String chromeProfilePath = System.getenv("USERPROFILE")
//              + "\\AppData\\Local\\Google\\Chrome\\User Data";
//      System.out.println("chromeProfilePath: " + chromeProfilePath);
//      String chromeChooseProfile = "Profile 1";
//      options.addArguments("user-data-dir=" + chromeProfilePath);
//      options.addArguments("profile-directory=" + chromeChooseProfile);
//        options.addArguments("--silent");
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // driver.manage().window().setSize(new Dimension(640, 480));
        // driver.manage().window().setSize(new Dimension(480, 640));
    }

    @AfterClass(alwaysRun = true)
    public void tearDownAfterClass() throws Exception {
        presentationSleep();
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("@BeforeMethod");
        driver.get("https://ita-social-projects.github.io/GreenCityClient/#/welcome");
//      driver.get("http://localhost:4200/#/welcome");
//      driver.manage().window().maximize();
        presentationSleep(); // For Presentation Only
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        if (!result.isSuccess()) {
            logger.warn("Test " + result.getName() + " ERROR");
            // System.out.println("Test " + result.getName() + " ERROR");
            // Take Screenshot, save sourceCode, save to log, prepare report, Return to
            // previous state, logout, etc.
            // TODO Logout (Delete cookie, session)
            // driver.get("https://ita-social-projects.github.io/GreenCityClient/#/welcome");
        }
        // logout, get(urlLogout), delete cookie, delete cache
    }

    public MyHabitsPage loadApplication() {
        return new MyHabitsPage(driver);
    }

    protected void presentationSleep() {
        presentationSleep(1);
    }

    protected void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}