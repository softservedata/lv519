package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
	private WebDriver driver;
	private By email = By.name("email");
	private By userName = By.name("fistName");
	private By password = By.name("form-control password");
	private By confPassword = By.name("form-control password-confirm");
	private By signUpButton = By.xpath("//button[@class='primary-global-button' and @type='submit']");
	private By signInLink = By.className("exist-sign-in");
	private By signUpWithGoo = By.xpath("//button[@class='cta-button-google']");
	private By emailErrorMessage = By.xpath("//*[@class='ng-star-inserted' and contains(text(),'Email is required')]");
	private By succesRegistrMessage = By.xpath("//div[@class='submit-email']");

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getUserName() {
		return driver.findElement(userName);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getConfPassword() {
		return driver.findElement(confPassword);
	}

	public WebElement getSignUpButton() {
		return driver.findElement(signUpButton);
	}

	public WebElement getSignInLink() {
		return driver.findElement(signInLink);
	}

	public WebElement getSignUpWithGoo() {
		return driver.findElement(signUpWithGoo);
	}

	public WebElement getEmailErrorMessage() {
		return driver.findElement(emailErrorMessage);
	}

	public WebElement getSuccesRegistrMessage() {
		return driver.findElement(succesRegistrMessage);
	}

	public By getLocatorSuccesRegistrMessage() {
		return succesRegistrMessage;
	}

	public void setEmailValue(User user) {
		getEmail().click();
		getEmail().sendKeys(user.getEmail());
	}

	public void setUserNameValue(User user) {
		getUserName().click();
		getUserName().sendKeys(user.getUserName());
	}

	public void setPasswordValue(User user) {
		getPassword().click();
		getPassword().sendKeys(user.getPassword());
	}

	public void setConfPasswordValue(User user) {
		getConfPassword().click();
		getConfPassword().sendKeys(user.getConfPassword());

	}

	public void setSignUpFormValue(User user) {
		setEmailValue(user);
		setUserNameValue(user);
		setPasswordValue(user);
		setConfPasswordValue(user);
	}

	public void clickOnSingUpButton() {
		getSignUpButton().click();
	}

	public String getTextSuccesRegister() {
		return getSuccesRegistrMessage().getText();
	}

}
