package greencity.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SignUpPage {

	private WebDriver driver;

	public SignUpPage(WebDriver driver) {
		this.driver=driver;
	}

	public SignUpPage putEmailField(String email) {
		driver.findElement(By.name("email")).sendKeys(email);
//		new WebDriverWait(driver, 10)
//		.until(ExpectedConditions.textToBe(By.name("email"), email));
		return this;
	}

	public SignUpPage putUserName(String userName) {
		driver.findElement(By.name("fistName")).sendKeys(userName);
		return this;
	}

	public SignUpPage putPassword(String password) {
		driver.findElement(By.name("form-control password")).sendKeys(password);
		return this;
		
	}

	public SignUpPage putConfirmPassword(String confirmPassword) {
		driver.findElement(By.name("form-control password-confirm")).sendKeys(confirmPassword);
		return this;
		
	}

	public SignUpPage finishSignUp() {
		driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
		return this;
	}
	
	public List<WebElement> findErrors() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver.findElements(By.className("error-message error-message-show"));
    }

    public SignUpPage assertErrors(List<String> expectedErrorMsg) {
    List<WebElement> errors = findErrors();
    for (WebElement actual : errors) {
        for (String expected : expectedErrorMsg) {
            Assert.assertEquals(expected, actual.getText());
        }
    }
    return this;
}
    public SignUpPage isRegistrationSuccessful() {
    	  try {
              driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
              WebElement SuccessfulRegistrationPopUp = driver.findElement(By.id("mat-dialog-1"));
                return this;
          } catch (org.openqa.selenium.StaleElementReferenceException e) {
              driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
              new WebDriverWait(driver, 5).until(visibilityOfElementLocated(By.id("mat-dialog-1")));
              return this;
          }
    }
}
