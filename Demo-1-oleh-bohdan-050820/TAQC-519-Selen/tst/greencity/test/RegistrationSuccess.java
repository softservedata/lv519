/*
 * RegistrationSuccess
 * 
 * Version 1.1
 * 
 * Date 08/04/2020
 * 
 * SoftServe IT Academy
 * 
 * This test Verify that Password must contain at least one digit,
 * special character, upper- and lower-case letter when user registered
 * Test-case 68
 */

package greencity.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static greencity.selectors.MainPageSelectors.randomEmail;

import greencity.pages.MainPage;

public class RegistrationSuccess {
	@Test
	public void registrationSuccess() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ita-social-projects.github.io/GreenCityClient/#/welcome/");
		
		new MainPage(driver)
		.clickSignUp()
		.putEmailField("olehb54+"+randomEmail+"@gmail.com")
		.putUserName("Oleh Bohdan")
		.putPassword("Zxcvb11!")
		.putConfirmPassword("Zxcvb11!")
		.finishSignUp()
		.isRegistrationSuccessful();
		 
		driver.quit();
	}
}
