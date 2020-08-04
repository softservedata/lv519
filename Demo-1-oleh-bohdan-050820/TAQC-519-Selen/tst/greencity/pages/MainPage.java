package greencity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static greencity.selectors.MainPageSelectors.signUpButton;

public class MainPage {

	private WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver=driver;
	}

	public SignUpPage clickSignUp() {
		driver.findElement(By.xpath(signUpButton)).click();
		return new SignUpPage(driver);
		}

}
