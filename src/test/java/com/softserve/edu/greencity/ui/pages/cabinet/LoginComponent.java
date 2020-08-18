package com.softserve.edu.greencity.ui.pages.cabinet;

import com.softserve.edu.greencity.ui.pages.common.TopPart;
import com.softserve.edu.greencity.ui.tools.ElementsCustomMethods;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginComponent extends TopPart {
    private WebDriverWait wait;

    private WebElement modalWindow;
    public static final String MODAL_WINDOW_CSS = "app-sign-in div";

    private WebElement title;
    private WebElement subtitle;
    private WebElement forgotPasswordLink;
    private WebElement singUpLink;
    private WebElement singInWithGoogleButton;
    private WebElement closeFormButton;
    private WebElement googleSignInButton;

    private ManualLoginComponent manualLoginComponent;

    private final String FORGOT_PASSWORD_LINK_CLASS = "forgot-password";
    private final String REGISTRATION_LINK_CLASS = "signup-link";
    private final String SING_IN_WITH_GOOGLE_BUTTON_CLASS = ".google-sign-in";
    private final String SIGN_UP_LINK_CLASS = ".missing-account .sign-up-link";
    private final String CLOSE_BUTTON_CLASS = ".cross-btn";
    private final String TITLE_CLASS = ".right-side h1";
    private final String SUBTITLE_CLASS = ".right-side h2";
    private final String GOOGLE_SIGN_IN_BUTTON_CLASS = ".google-sign-in";
    private final String LOGIN_COMPONENT_OVERLAY_CLASS = ".cdk-overlay-pane";



    public LoginComponent(WebDriver driver) {
        super(driver);
        init();
    }
    @Step
    public void init(){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(getTitle()));

    }
    @Step
    public ManualLoginComponent getManualLoginComponent() {
        return manualLoginComponent = new ManualLoginComponent(driver);
    }
    @Step
    protected WebElement getLoginModalWindow(){
        this.modalWindow = driver
                .findElement(By.cssSelector(MODAL_WINDOW_CSS));
        return modalWindow;

    }
    @Step
    protected WebElement getTitle() {
        return title = driver.findElement(By.cssSelector(TITLE_CLASS));
    }
    @Step
    public String getTitleString() {
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TITLE_CLASS)));

        return this.getTitle().getText();
    }
    @Step
    protected WebElement getSubtitle() {
        return subtitle = driver.findElement(By.cssSelector(SUBTITLE_CLASS));
    }
    @Step
    public String getSubtitleString() {
        return this.getSubtitle().getText();
    }
    @Step
    public WebElement getSignUpLink() {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SIGN_UP_LINK_CLASS)));

        return singUpLink = driver.findElement(By.cssSelector(SIGN_UP_LINK_CLASS));
    }
    @Step
    public RegisterComponent clickSignUpLink() {
        getSignUpLink().click();

        return new RegisterComponent(driver);
    }
    @Step
    public WebElement getSingInWithGoogleButton() {
        return singInWithGoogleButton = driver.findElement(By.cssSelector(SING_IN_WITH_GOOGLE_BUTTON_CLASS));
    }
    @Step
    public WebElement getCloseFormButton() {
        return closeFormButton = driver.findElement(By.cssSelector(CLOSE_BUTTON_CLASS));
    }
    @Step
    public void closeLoginComponent() {
        getCloseFormButton().click();
    }
    @Step
    public boolean isLoginComponentClosed() {
        closeLoginComponent();

        ElementsCustomMethods elementsCustomMethods = new ElementsCustomMethods(driver);
        return elementsCustomMethods.waitTillElementGone(driver, By.cssSelector(LOGIN_COMPONENT_OVERLAY_CLASS), 6000, 2000);
    }
    @Step
    protected WebElement getGoogleSignUpButton() {
        return googleSignInButton = driver.findElement(By.cssSelector(GOOGLE_SIGN_IN_BUTTON_CLASS));
    }
    @Step
    public GoogleLoginPage clickGoogleSignInButton() {
        getGoogleSignUpButton().click();

        return new GoogleLoginPage(driver);
    }
}
