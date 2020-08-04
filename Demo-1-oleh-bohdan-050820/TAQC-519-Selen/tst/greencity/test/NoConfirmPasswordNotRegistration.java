/*
 * NoConfirmPasswordNotRegistration
 * 
 * Version 1.1
 * 
 * Date 08/04/2020
 * 
 * SoftServe IT Academy
 * 
 * Verify that user is not registered when 
 * 'Confirm password' field is empty
 * Test-case 56
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

public class NoConfirmPasswordNotRegistration {
	@Test
	public void noConfirmPasswordNotRegistration() throws InterruptedException {
		
		List<String> expectedErrors = new ArrayList<>();
		expectedErrors.add("Password is required");
		
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
		.putConfirmPassword("")
		.finishSignUp()
		.assertErrors(expectedErrors);
		 
		driver.quit();
	}
}
