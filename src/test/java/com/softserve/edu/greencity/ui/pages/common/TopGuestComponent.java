package com.softserve.edu.greencity.ui.pages.common;

import com.softserve.edu.greencity.ui.pages.cabinet.LoginComponent;
import com.softserve.edu.greencity.ui.pages.cabinet.RegisterComponent;
import com.softserve.edu.greencity.ui.tools.StableWebElementSearch;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopGuestComponent implements StableWebElementSearch {
    private WebDriver driver;
    private By signInLink = By.cssSelector("li.sign-in-link.tertiary-global-button a");
    private By signUpLink = By.cssSelector("li.sign-up-link.ng-star-inserted div");

    public TopGuestComponent(WebDriver driver) {
        this.driver = driver;
    }

    //Sign In link
    @Step
    public WebElement getSignInLink() {
        return SearchElementByCss(signInLink);
    }
    @Step
    public boolean isDisplayedSignInLink() {
        return getSignInLink().isDisplayed();
    }
    @Step
    public LoginComponent clickSignInLink() {
        getSignInLink().click();
        return new LoginComponent(driver);
    }

    //Sign Up link
    @Step
    public WebElement getSignUpLink() {
        return SearchElementByCss(signUpLink);
    }
    @Step
    public boolean isDisplayedSignUpLink() {
        return getSignUpLink().isDisplayed();
    }
    @Step
    public String getSignUpLinkText() {
        return getSignUpLink().getText();
    }
    @Step
    public RegisterComponent clickSignUpLink() {
        getSignUpLink().click();
        return new RegisterComponent(driver);
    }
    @Override
    public WebDriver setDriver() {
        return this.driver;
    }
}