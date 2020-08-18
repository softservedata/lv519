package com.softserve.edu.greencity.ui.pages.common;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public abstract class ForgotPasswordPart {
    WebElement emailField;
    WebElement submitButton;
    WebElement googleSigningButton;
    WebElement backLink;
    @Step
    public ForgotPasswordPart inputEmail(String email) {
        this.getEmailField().sendKeys(email);
        return this;
    }
    @Step
    public WebElement getEmailField() {
        return emailField;
    }
    @Step
    public WebElement getSubmitButton() {
        return submitButton;
    }
    @Step
    public WebElement getGoogleSigningButton() {
        return googleSigningButton;
    }
    @Step
    public WebElement getBackLink() {
        return backLink;
    }
    @Step
    public ForgotPasswordPart setEmailField(WebElement emailField) {
        this.emailField = emailField;
        return this;
    }
    @Step
    public ForgotPasswordPart setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
        return this;
    }
    @Step
    public ForgotPasswordPart setGoogleSigningButton(WebElement googleSigningButton) {
        this.googleSigningButton = googleSigningButton;
        return this;
    }
    @Step
    public ForgotPasswordPart setBackLink(WebElement backLink) {
        this.backLink = backLink;
        return this;
    }
}
