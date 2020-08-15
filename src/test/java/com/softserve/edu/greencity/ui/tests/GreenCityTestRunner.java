package com.softserve.edu.greencity.ui.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.WebStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.softserve.edu.greencity.ui.pages.common.WelcomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class GreenCityTestRunner {
    public static final String BASE_URL = "https://ita-social-projects.github.io/GreenCityClient/#/welcome";
//    public static final String BASE_URL = "http://localhost:4200/#/welcome";

    private final boolean CHROME_HEADLESS_OPTION = false;
    private final String CHROME_LANGUAGE_OPTION = "en";

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setUpBeforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(CHROME_HEADLESS_OPTION);
        chromeOptions.addArguments("--lang=" + CHROME_LANGUAGE_OPTION);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownAfterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void setUp() {
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            logger.warn("Test " + result.getName() + " ERROR");
        }
        if (isLoginingNow()){
            singOutByStorage();}
        //System.out.println("@AfterMethod tearDown");
    }

    public WelcomePage loadApplication() {
        return new WelcomePage(driver);
    }
    //To Do

    /**
     * check sing in status by storage
     * @return
     */
    public boolean isLoginingNow() {
        WebStorage webStorage = (WebStorage) driver;
        return !((webStorage.getLocalStorage().getItem("name")) == null);
    }

    /**
     * sing out using storage
     * @return
     */
    public void singOutByStorage(){
        WebStorage webStorage = (WebStorage) driver;
        webStorage.getLocalStorage().clear();
    }

    protected void downloadAllDrivers(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.operadriver().setup();
        WebDriverManager.phantomjs().setup();
        WebDriverManager.iedriver().setup();
        WebDriverManager.chromiumdriver().setup();
    }
}