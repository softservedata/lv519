package com.softserve.edu.greencity.ui.pages.cabinet;

import com.softserve.edu.greencity.ui.pages.common.TopPart;
import com.softserve.edu.greencity.ui.tools.ElementsCustomMethods;
import com.softserve.edu.greencity.ui.tools.StableWebElementSearch;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginComponent extends TopPart implements StableWebElementSearch {
    public static final String MODAL_WINDOW_CSS = "app-sign-in div";
    protected WebDriverWait wait;

    private By modalWindow = By.cssSelector(".wrapper");
    private By title = By.cssSelector(".right-side h1");
    private By subtitle = By.cssSelector(".right-side h2");
    private By forgotPasswordLink = By.cssSelector(".forgot-password");
    private By singInWithGoogleButton = By.cssSelector(".google-sign-in");
    private By singUpLink = By.cssSelector(".missing-account .sign-up-link");
    private By closeFormButton = By.cssSelector(".cross-btn");
    protected By loginComponent = By.cssSelector(".cdk-overlay-pane");

    private ManualLoginComponent manualLoginComponent;

    public LoginComponent(WebDriver driver) {
        super(driver);
        checkElements();
    }
    @Step
    public void checkElements() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(getTitle()));
    }
    @Step
    public ManualLoginComponent getManualLoginComponent() {
        return manualLoginComponent = new ManualLoginComponent(driver);
    }

    //Sign in popup window
    @Step
    protected WebElement getLoginModalWindow() {
        return $(modalWindow);
    }

    //Title
    @Step
    protected WebElement getTitle() {
        return $(title);
    }
    @Step
    public String getTitleText() {
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return getTitle().getText();
    }

    //SubTitle
    @Step
    protected WebElement getSubtitle() {
        return $(subtitle);
    }
    @Step
    public String getSubtitleText() {
        return this.getSubtitle().getText();
    }

    //Forgot password
    @Step
    public WebElement getForgotPasswordLink() {
        return $(forgotPasswordLink);
    }
    @Step
    public boolean isDisplayedForgotPasswordLink() {
        return getForgotPasswordLink().isDisplayed();
    }

    //Sign in with Google
    @Step
    public WebElement getSingInWithGoogleButton() {
        return $(singInWithGoogleButton);
    }
    @Step
    public boolean isDisplayedSingInWithGoogleButton() {
        return getSingInWithGoogleButton().isDisplayed();
    }
    @Step
    public GoogleLoginPage clickSingInWithGoogleButton() {
        getSingInWithGoogleButton().click();
        return new GoogleLoginPage(driver);
    }

    //Sign up link
    @Step
    public WebElement getSignUpLink() {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(singUpLink));
        return $(singUpLink);
    }
    @Step
    public boolean isDisplayedSignUpLink() {
        return getSignUpLink().isDisplayed();
    }
    @Step
    public RegisterComponent clickSignUpLink() {
        getSignUpLink().click();
        return new RegisterComponent(driver);
    }

    //Close Sign in popup window
    @Step
    public WebElement getCloseFormButton() {
        return $(closeFormButton);
    }
    @Step
    public void closeLoginComponent() {
        getCloseFormButton().click();
    }
    @Step
    public boolean isLoginComponentClosed() {
        closeLoginComponent();
        ElementsCustomMethods elementsCustomMethods = new ElementsCustomMethods(driver);
        return elementsCustomMethods.waitTillElementGone(driver, loginComponent, 6000);
    }


    @Override
    public WebDriver setDriver() {
        return this.driver;
    }
}