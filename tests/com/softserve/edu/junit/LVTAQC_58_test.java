package com.softserve.edu.junit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.softserve.edu.HomePage;
import com.softserve.edu.SignUpPage;
import com.softserve.edu.User;
import com.softserve.edu.UserRepository;

/**
 * Verify that user is not registered when 'Email' field is empty.
 * 
 * @author Iryna Polihas
 *
 */
public class LVTAQC_58_test {
	private final String url = "https://ita-social-projects.github.io/GreenCityClient/#/welcome";
	private User inValidUserWithoutEmail = UserRepository.getSignUpInValidUser_WithoutEmail();
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

		driver.manage().window().maximize();
	}

	@BeforeClass
	public void appSetup() {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void IsErrorMessageToEmptyEmailField() {
		HomePage homePage = new HomePage(driver);
		SignUpPage signUpPage = new SignUpPage(driver);
		homePage.clickOnSingUpButton();
		signUpPage.getEmail().sendKeys(Keys.TAB);
		Assert.assertTrue(signUpPage.getEmailErrorMessage().isDisplayed());
	}

	@Test(dependsOnMethods = "IsErrorMessageToEmptyEmailField")
	public void logInWithEmptyEmailField() {
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.setSignUpFormValue(inValidUserWithoutEmail);
		WebElement expected = signUpPage.getSignUpButton();
		Assert.assertFalse(expected.isEnabled());
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
