package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	private WebDriver driver;
	private By email = By.id("email");
	private By password = By.id("password");
	private By passwordErrorMessage = By.xpath(("//*[@class='alert-general-error ng-star-inserted']"));
	private By signINButton = By.xpath("//button[@class='primary-global-button' and @type='submit']");

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getSignInButton() {
		return driver.findElement(signINButton);
	}

	public WebElement getPasswordErrorMessage() {
		return driver.findElement(passwordErrorMessage);
	}

	private void setEmailValue(User user) {
		getEmail().click();
		getEmail().sendKeys(user.getEmail());
	}

	private void setPasswordValue(User user) {
		getPassword().click();
		getPassword().sendKeys(user.getPassword());
	}

	public void setSignInForm(User user) {
		setEmailValue(user);
		setPasswordValue(user);
	}

	public void clickOnSingInButton() {
		getSignInButton().click();
	}

	public String getTextFailRegister() {
		return getPasswordErrorMessage().getText();
	}
	public By getEmailLocator() {
		return email;
	}
	public By getFailRegistLocator() {
		return passwordErrorMessage;
	}
}
