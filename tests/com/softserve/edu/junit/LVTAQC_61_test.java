package com.softserve.edu.junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
 * Verify that user sees popup about successfully registration after
 * registration on the site.
 * 
 * @author Iryna Polihas
 *
 */
public class LVTAQC_61_test {
	private final String url = "https://ita-social-projects.github.io/GreenCityClient/#/welcome";
	private final String SignUpSuccesRegistrMessage = "Congrats! Your profile is created. Please check the email sent with a link to confirm your email address.";
	private User validUserSignUp = UserRepository.getSignUpValidUserGenerated();
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
	}

	@Test
	public void SuccessSignUp() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		SignUpPage signUpPage = new SignUpPage(driver);
		homePage.clickOnSingUpButton();
		signUpPage.setSignUpFormValue(validUserSignUp);
		signUpPage.clickOnSingUpButton();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPage.getLocatorSuccesRegistrMessage()));
		String actualText = signUpPage.getTextSuccesRegister();
		Assert.assertTrue(actualText.contains(SignUpSuccesRegistrMessage));
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
