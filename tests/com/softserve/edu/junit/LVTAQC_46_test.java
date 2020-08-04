package com.softserve.edu.junit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.HomePage;
import com.softserve.edu.SignUpPage;
import com.softserve.edu.User;
import com.softserve.edu.UserRepository;

/**
 * Verify that user is not registered with password, that does not contain all
 * required characters.
 * 
 * @author Iryna Polihas
 *
 */
public class LVTAQC_46_test {
	private final String url = "https://ita-social-projects.github.io/GreenCityClient/#/welcome";
	private User passwordWithSpaces = UserRepository.getSignUpInValidPassword_WithSpaces();
	private User passwordWithoutUperCase = UserRepository.getSignUpInValidPassword_WithoutUpperCase();
	private User passwordWithoutLowercase = UserRepository.getSignUpInValidPassword_WithoutLowerCase();
	private User passwordWithoutDigit = UserRepository.getSignUpInValidPassword_WithoutDigit();
	private User passwordWithoutSpecChar = UserRepository.getSignUpInValidPassword_WithoutSpecChar();
	private WebDriver driver;

	@DataProvider
	public Object[][] inValidPasswordDP() {
		return new Object[][] { { passwordWithSpaces }, { passwordWithoutUperCase }, { passwordWithoutLowercase },
				{ passwordWithoutDigit }, { passwordWithoutSpecChar } };
	}

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
		driver.manage().window().maximize();
	}

	@BeforeClass
	public void appSetup() {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "inValidPasswordDP")
	public void checkLogInwithInValidPassword(User user) {
		HomePage homePage = new HomePage(driver);
		SignUpPage signUpPage = new SignUpPage(driver);
		homePage.clickOnSingUpButton();
		signUpPage.setSignUpFormValue(user);
		signUpPage.clickOnSingUpButton();
		WebElement expected = signUpPage.getSignUpButton();
		Assert.assertFalse(expected.isEnabled());
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
