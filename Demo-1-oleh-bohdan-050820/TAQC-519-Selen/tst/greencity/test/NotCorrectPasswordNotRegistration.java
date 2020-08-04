/*
 * NotCorrectPasswordNotRegistration
 * 
 * Version 1.1
 * 
 * Date 08/04/2020
 * 
 * SoftServe IT Academy
 * 
 * Verify that user is not registered with password, 
 * which does not contain all required characters
 * Test-case 45
 */

package greencity.test;

import static greencity.selectors.MainPageSelectors.randomEmail;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import greencity.pages.MainPage;

public class NotCorrectPasswordNotRegistration {
	@Test
	public void notCorrectPasswordNotRegistration() throws InterruptedException {
		
		List<String> expectedErrors = new ArrayList<>();
		expectedErrors.add("Password has contain at least one character of Uppercase letter (A-Z), "
		+ "Lowercase letter (a-z), Digit (0-9), Special character (~`!@#$%^&*()+=_-{}[]|:;”’?/<>,.)");
		
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ita-social-projects.github.io/GreenCityClient/#/welcome/");
		
		new MainPage(driver)
		.clickSignUp()
		.putEmailField("olehb54+"+randomEmail+"@gmail.com")
		.putUserName("Oleh Bohdan")
		.putPassword("Zxcvb111")
		.putConfirmPassword("")
		.finishSignUp()
		.assertErrors(expectedErrors);
		 
		driver.quit();
	}
}
