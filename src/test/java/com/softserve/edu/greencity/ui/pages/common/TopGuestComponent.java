package com.softserve.edu.greencity.ui.pages.common;

import com.softserve.edu.greencity.ui.pages.cabinet.LoginComponent;
import com.softserve.edu.greencity.ui.pages.cabinet.RegisterComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopGuestComponent {
    private WebDriver driver;
    private WebElement signinLink;
    private WebElement signupLink;

    public TopGuestComponent(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public WebElement getSigninLink() {
        return signinLink = driver.findElement(By.cssSelector("li.sign-in-link.tertiary-global-button a"));
    }

    @Step
    public LoginComponent clickSignInLink() {
        getSigninLink().click();
        return new LoginComponent(driver);
    }
    @Step
    public WebElement getSignupLink() {
        return signupLink = driver.findElement(By.cssSelector("li.sign-up-link.ng-star-inserted div"));
    }
    @Step
    public String getSignupLinkText() {
        return getSignupLink().getText();
    }
    @Step
    public RegisterComponent clickSignUpLink() {
        getSignupLink().click();
        return new RegisterComponent(driver);
    }
}
