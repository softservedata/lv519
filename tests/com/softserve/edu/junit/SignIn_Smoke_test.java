package com.softserve.edu.junit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.HomePage;
import com.softserve.edu.SignInPage;

public class SignIn_Smoke_test {
	private final String url = "https://ita-social-projects.github.io/GreenCityClient/#/welcome";
	private WebDriver driver;

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) {
		if (browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", "./resources/drivers/fireFox-win/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./resources/drivers/chrome-win/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeClass
	public void appSetup() {
		driver.get(url);
	}

	@Test
	public void IsPresentSignInElement() {
		HomePage homePage = new HomePage(driver);
		SignInPage signInPage = new SignInPage(driver);
		Assert.assertTrue(homePage.getSingInButton().isDisplayed());
		homePage.clickOnSingInButton();
		Assert.assertTrue(signInPage.getEmail().isDisplayed());
		Assert.assertTrue(signInPage.getPassword().isDisplayed());
		Assert.assertTrue(signInPage.getSignInButton().isDisplayed());
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
