package com.softserve.edu.greencity.ui.pages.common;

import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.tools.ElementsCustomMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordComponent {
    private WebDriver driver;

    private By title = By.cssSelector("div.right-side h1");

    private By subTitle = By.cssSelector("div.right-side h2");

    private By emailField = By.id("email");

    private By emailErrorMassage = By.cssSelector(".validation-email-error .ng-star-inserted");

    private By submitButton = By.cssSelector(".send-btn");
    private By googleSignInButton = By.cssSelector(".google-sign-in");
    private By backLink = By.cssSelector(".mentioned-password .sign-in-link");
    private By closeFormButton = By.cssSelector(".cross-btn");
    protected By forgotPasswordComponent = By.cssSelector(".cdk-overlay-pane");

    protected WebDriverWait wait;

    public ForgotPasswordComponent(WebDriver driver) {
        this.driver = driver;
        checkElements();
    }

    private void checkElements() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(getTitle()));
    }

    // Page Object
    //Title
    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public String getTitleText() {
        return getTitle().getText();
    }

    //SubTitle
    public WebElement getSubTitle() {
        return driver.findElement(subTitle);
    }

    public String getSubTitleText() {
        return getSubTitle().getText();
    }

    //Email Field
    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }

    public void pressTabEmail() {
        getEmailField().sendKeys(Keys.TAB);
    }

    //Email Error Massage
    public WebElement getEmailErrorMassage() {
        return driver.findElement(emailErrorMassage);
    }

    public String getEmailErrorMassageText() {
        return getEmailErrorMassage().getText();
    }

    //Submit a login link
    public WebElement getSubmitButton() {
        return driver.findElement(submitButton);
    }

    public void clickSubmitButton() {
        getSubmitButton().click();
    }

    //Google Sign In Button
    public WebElement getGoogleSigningButton() {
        return driver.findElement(googleSignInButton);
    }

    public void clickGoogleSigningButton() {
        getGoogleSigningButton().click();
    }

    //Back Link
    public WebElement getBackLink() {
        return driver.findElement(backLink);
    }

    public void clickBackLink() {
        getBackLink().click();
    }

    //Close Sign in popup window
    public WebElement getCloseFormButton() {
        return driver.findElement(closeFormButton);
    }

    public void closeForgotPasswordComponent() {
        getCloseFormButton().click();
    }

    public boolean isForgotPasswordComponentClosed() {
        closeForgotPasswordComponent();
        ElementsCustomMethods elementsCustomMethods = new ElementsCustomMethods(driver);
        return elementsCustomMethods.waitTillElementGone(driver, forgotPasswordComponent, 6000, 2000);
    }

    //Fill email field
    public ForgotPasswordComponent inputEmail(String email) {
        getEmailField().sendKeys(email);
        return this;
    }

    private void fillEmail(User user) {
        inputEmail(user.getEmail());
    }

    public WelcomePage setForgotPasswordForm(User user) {
        fillEmail(user);
        clickSubmitButton();
        return new WelcomePage(driver);
    }
}
