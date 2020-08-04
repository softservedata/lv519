package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver driver;
	private By signUpButton = By.xpath("//div[@class='navigation-menu-right']//span[contains(text(),'Sign up')]");
	private By signInButton = By.xpath("//*[@class='ng-star-inserted' and contains(text(),' Sign in ')]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSingUpButton() {
		return driver.findElement(signUpButton);
	}

	public WebElement getSingInButton() {
		return driver.findElement(signInButton);
	}

	public void clickOnSingUpButton() {
		getSingUpButton().click();
	}

	public void clickOnSingInButton() {
		getSingInButton().click();
	}
}
