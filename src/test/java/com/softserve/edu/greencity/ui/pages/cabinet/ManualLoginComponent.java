package com.softserve.edu.greencity.ui.pages.cabinet;

import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.tools.StableWebElementSearch;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManualLoginComponent extends LoginComponent implements StableWebElementSearch {
    private By emailField = By.cssSelector("#email");
    private By passwordField = By.cssSelector("#password");

    private By signInButton = By.xpath("//button[@type='submit' and @class='primary-global-button']");

    private By emailValidationError = By.cssSelector(".validation-email-error");
    private By passwordValidationError = By.cssSelector(".validation-password-error");
    private By wrongEmailOrPassError = By.cssSelector(".alert-general-error.ng-star-inserted");

    private By passwordFieldWrapper = By.cssSelector(".password-input-btn-show-hide");
    private By successEmailValidation = By.cssSelector(".successful-email-validation");
    private By unSuccessEmailValidation = By.cssSelector(".alert-email-validation");
    private By successfulPasswordValidation = By.cssSelector(".successful-password-validation");
    private By unSuccessPasswordValidation = By.cssSelector(".alert-password-validation");

    private WebDriverWait wait;

    public ManualLoginComponent(WebDriver driver) {
        super(driver);
    }

    //Email Field
    @Step
    public WebElement getEmailField() {
        return $(emailField);
    }
    @Step
    public boolean isDisplayedEmailField() {
        return getEmailField().isDisplayed();
    }
    @Step
    public void clickEmailField(){
        getEmailField().click();
    }

    //Password field
    @Step
    public WebElement getPasswordField() {
        return $(passwordField);
    }
    @Step
    public boolean isDisplayedPasswordField() {
        return getPasswordField().isDisplayed();
    }
    @Step
    public WebElement getPasswordFieldWrapper() {
        return $(passwordFieldWrapper);
    }

    //Sign in button
    @Step
    public WebElement getSignInButton() {
        return $x(signInButton);
    }
    @Step
    public boolean isDisplayedSignInButton() {
        return getSignInButton().isDisplayed();
    }
    @Step
    public boolean isEnabledSignInButton() {
        return getSignInButton().isEnabled();
    }
    @Step
    public ManualLoginComponent clickSignInButton() {
        getSignInButton().click();
        return this;
    }

    //Email Or Password Error
    @Step
    public WebElement getWrongEmailOrPassError() {
        wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(wrongEmailOrPassError));
        return $(wrongEmailOrPassError);
    }
    @Step
    public String getWrongEmailOrPassErrorText() {
        return getWrongEmailOrPassError().getText();
    }


    //Email Validator
    @Step
    public WebElement getEmailValidationError() {
        return $(emailValidationError);
    }
    @Step
    public boolean IsDisplayedEmailValidationError() {
        return getEmailValidationError().isDisplayed();
    }
    @Step
    public boolean isSuccessfulEmailValidation() {
        return $(successEmailValidation).isDisplayed();
    }
    @Step
    public boolean isUnsuccessfulEmailValidation() {
        return $(unSuccessEmailValidation).isDisplayed();
    }

    //Password Validator
    @Step
    public WebElement getPasswordValidationError() {
        return $(passwordValidationError);
    }
    @Step
    public boolean IsPasswordValidationError() {
        return getPasswordValidationError().isDisplayed();
    }
    @Step
    public boolean isSuccessfulPasswordValidation() {
        return $(successfulPasswordValidation).isDisplayed();
    }
    @Step
    public boolean isUnsuccessfulPasswordValidation() {
        return $(unSuccessPasswordValidation).isDisplayed();
    }

    //Fill email field
    @Step
    public ManualLoginComponent inputEmail(String email) {
        getEmailField().sendKeys(email);
        return this;
    }

    //Fill email field
    @Step
    public ManualLoginComponent inputPassword(String password) {
        getPasswordField().sendKeys(password);
        return this;
    }

    //Fill email and password fields
    @Step
    private void fillFields(User user) {
        inputEmail(user.getEmail());
        inputPassword(user.getPassword());
    }

    //Login???? which page return?
    @Step
    public MyCabinetPage successfullyLogin(User user) {
        fillFields(user);
        clickSignInButton();
        return new MyCabinetPage(driver);
    }
    @Step
    public ManualLoginComponent unsuccessfullyLogin(User user) {
        fillFields(user);
        clickSignInButton();
        return this;
    }

    @Override
    public WebDriver setDriver() {
        return this.driver;
    }
}