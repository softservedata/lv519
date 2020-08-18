package com.softserve.edu.greencity.ui.pages.cabinet;

import com.softserve.edu.greencity.ui.data.User;
import com.softserve.edu.greencity.ui.tools.API.mail.GoogleMailAPI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class ManualRegisterComponent extends RegisterComponent {

    private WebDriver driver;
    private WebElement userNameField;
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement showPasswordButton;
    private WebElement passwordConfirmField;
    private WebElement showPasswordConfirmButton;
    private WebElement signUpButton;

    private WebElement emailValidator;
    private WebElement passwordValidator;
    private WebElement passwordConfirmValidator;
    private WebElement registrationValidator;
    private WebElement firstNameValidator;
    private String confirmURL = null;

    private final String USER_NAME_FIELD_SELECTOR = "input[name='fistName']";
    private final String EMAIL_FIELD_SELECTOR = "input[name='email']";
    private final String PASSWORD_FIELD_SELECTOR = "input[name='form-control password']";
    private final String SHOW_PASSWORD_BUTTON_SELECTOR = "//input[@name='form-control password']/../span/img";
    private final String PASSWORD_CONFIRM_FIELD_SELECTOR = "input[name='form-control password-confirm']";
    private final String SHOW_PASSWORD_CONFIRM_BUTTON_SELECTOR = "//input[@name='form-control password-confirm']/../span/img";
    private final String SIGNUP_BUTTON_SELECTOR = "div[class='form-content-container'] button[class*='global-button']";


    private final String EMAIL_VALIDATOR_SELECTOR = "//input[@name='email']/following-sibling::div/div";
    private final String REGISTRATION_VALIDATOR_SELECTOR = "app-sign-up input#email + div";
    private final String FIRST_NAME_VALIDATOR_SELECTOR = "//input[@name='fistName']/following-sibling::div/div";
    private final String PASSWORD_VALIDATOR_SELECTOR = "//*[@name = 'form-control password']//parent::div//following-sibling::div";
    private final String PASSWORD_CONFIRM_VALIDATOR_SELECTOR = "//*[@name = 'form-control password-confirm']//parent::div//following-sibling::div";


    public ManualRegisterComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @Step
    public WebElement getUserNameField() {

        this.userNameField = driver
                .findElement(By.cssSelector(USER_NAME_FIELD_SELECTOR));
        return userNameField;
    }

    @Step
    protected ManualRegisterComponent inputUserName(String userName) {
        this.getUserNameField().sendKeys(userName);
        return this;
    }

    @Step
    protected ManualRegisterComponent clearFirstName() {
        this.getUserNameField().clear();
        return this;
    }

    @Step
    protected ManualRegisterComponent clickFirstName(WebDriver driver) {
        if (isDisplayedFirstNameField()) {
            this.getUserNameField().click();
            Actions action = new Actions(driver);
            action.contextClick(getUserNameField()).sendKeys(Keys.LEFT)
                    .sendKeys(Keys.RIGHT);
        }
        return this;
    }

    @Step
    protected boolean isDisplayedFirstNameField() {
        return getUserNameField().isDisplayed();
    }

    @Step
    protected RegisterComponent setFirstNameValidator(
            WebElement firstNameValidator) {
        this.firstNameValidator = firstNameValidator;
        return this;
    }

    @Step
    protected WebElement getUserNameValidator() {
        firstNameValidator = driver
                .findElement(By.xpath(FIRST_NAME_VALIDATOR_SELECTOR));
        return firstNameValidator;
    }

    @Step
    public String getUserNameValidatorText() {
        return getUserNameValidator().getText();
    }

    @Step
    protected boolean isDisplayedFirstNameValidator() {
        return getUserNameValidator().isDisplayed();
    }

    @Step
    protected boolean sizeFirstNameValidator() {
        return driver
                .findElements(By.cssSelector(FIRST_NAME_VALIDATOR_SELECTOR))
                .size() != 0;
    }

    @Step
    protected RegisterComponent setRegistrationValidator(WebElement registrationValidator) {
        this.registrationValidator = registrationValidator;
        return this;
    }

    @Step
    protected WebElement getRegistrationValidator() {
        registrationValidator = driver.findElement(By.cssSelector(REGISTRATION_VALIDATOR_SELECTOR));
        return registrationValidator;
    }

    @Step
    public String getRegistrationValidatorText() {
        return getRegistrationValidator().getText();
    }

    @Step
    public boolean isDisplayedRegistrationValidator() {
        return getRegistrationValidator().isDisplayed();
    }
    @Step
    protected boolean sizeRegistrationValidator() {
        return driver.findElements(By.cssSelector(REGISTRATION_VALIDATOR_SELECTOR))
                .size() != 0;
    }

    @Step
    protected WebElement getEmailField() {
        this.emailField = driver
                .findElement(By.cssSelector(EMAIL_FIELD_SELECTOR));
        return emailField;
    }

    @Step
    protected RegisterComponent inputEmailField(String email) {
        this.getEmailField().sendKeys(email);
        return this;
    }

    @Step
    protected RegisterComponent clearEmailField() {
        this.getEmailField().clear();
        return this;
    }

    @Step
    public RegisterComponent clickEmailField(WebDriver driver) {
        if (isDisplayedEmailField()) {
            this.getEmailField().click();
            Actions action = new Actions(driver);
            action.contextClick(getEmailField()).sendKeys(Keys.LEFT)
                    .sendKeys(Keys.RIGHT);
        }
        return this;
    }

    @Step
    protected boolean isDisplayedEmailField() {
        return getEmailField().isDisplayed();
    }

    @Step
    public String getEmailValidatorText() {
        return getEmailValidator().getText();
    }

    @Step
    protected WebElement getEmailValidator() {
        emailValidator = driver.findElement(By.xpath(EMAIL_VALIDATOR_SELECTOR));
        return emailValidator;
    }

    @Step
    protected boolean sizeEmailValidator() {
        return driver.findElements(By.xpath(EMAIL_VALIDATOR_SELECTOR))
                .size() != 0;
    }

    @Step
    public WebElement getPasswordField() {
        this.passwordField = driver
                .findElement(By.cssSelector(PASSWORD_FIELD_SELECTOR));
        return passwordField;
    }

    @Step
    protected RegisterComponent inputPassword(String password) {
        this.getPasswordField().sendKeys(password);
        return this;
    }

    @Step
    protected RegisterComponent clearPasswordField() {
        this.getPasswordField().clear();
        return this;
    }

    @Step
    protected RegisterComponent clickPasswordField(WebDriver driver) {
        if (isDisplayedPasswordField()) {
            this.getPasswordField().click();
            Actions action = new Actions(driver);
            action.contextClick(getPasswordField()).sendKeys(Keys.LEFT)
                    .sendKeys(Keys.RIGHT);
        }
        return this;
    }

    @Step
    public ManualRegisterComponent setPasswordField(WebElement passwordField) {
        this.passwordField = passwordField;
        return this;
    }

    @Step
    protected boolean isDisplayedPasswordField() {
        return getPasswordField().isDisplayed();
    }
    @Step
    protected WebElement getShowPasswordButton() {
        this.showPasswordButton = driver
                .findElement(By.xpath(SHOW_PASSWORD_BUTTON_SELECTOR));
        return showPasswordButton;
    }
    @Step
    protected RegisterComponent clickShowPasswordButton() {
        if (isDisplayedShowPasswordButton()) {
            this.getShowPasswordButton().click();
        }
        return this;
    }
    @Step
    public ManualRegisterComponent setShowPasswordButton(WebElement showPasswordButton) {
        this.showPasswordButton = showPasswordButton;
        return this;
    }

    @Step
    protected boolean isDisplayedShowPasswordButton() {
        return getShowPasswordButton().isDisplayed();
    }

    @Step
    protected boolean isDisplayedPasswordValidator() {
        return getPasswordValidator().isDisplayed();
    }

    @Step
    public String getPasswordValidatorText() {
        return getPasswordValidator().getText();
    }

    @Step
    protected WebElement getPasswordValidator() {
        passwordValidator = driver
                .findElement(By.xpath(PASSWORD_VALIDATOR_SELECTOR));
        return passwordValidator;
    }

    @Step
    protected boolean sizePasswordValidator() {
        return driver.findElements(By.cssSelector(PASSWORD_VALIDATOR_SELECTOR))
                .size() != 0;
    }

    @Step
    protected boolean isDisplayedPasswordConfirmValidator() {
        return getPasswordConfirmValidator().isDisplayed();
    }
    @Step
    public String getPasswordConfirmValidatorText() {
        return getPasswordConfirmValidator().getText().trim();
    }
    @Step
    protected WebElement getPasswordConfirmValidator() {
        passwordConfirmValidator = driver.findElement(
                By.xpath(PASSWORD_CONFIRM_VALIDATOR_SELECTOR));
        return passwordConfirmValidator;
    }
    @Step
    protected WebElement getPasswordConfirmField() {

        this.passwordConfirmField = driver
                .findElement(By.cssSelector(PASSWORD_CONFIRM_FIELD_SELECTOR));
        return passwordConfirmField;
    }

    @Step
    protected RegisterComponent inputPasswordConfirm(String passwordConfirm) {
        this.getPasswordConfirmField().sendKeys(passwordConfirm);
        return this;
    }

    @Step
    protected RegisterComponent clearPasswordConfirmField() {
        this.getPasswordConfirmField().clear();
        return this;
    }

    @Step
    protected RegisterComponent clickPasswordConfirmField(WebDriver driver) {
        if (isDisplayedPasswordConfirmField()) {
            this.getPasswordConfirmField().click();
            Actions action = new Actions(driver);
            action.contextClick(getPasswordConfirmField()).sendKeys(Keys.LEFT)
                    .sendKeys(Keys.RIGHT);
        }
        return this;
    }

    @Step
    protected boolean isDisplayedPasswordConfirmField() {
        return getPasswordConfirmField().isDisplayed();
    }

    @Step
    protected WebElement getShowPasswordConfirmButton() {
        this.showPasswordConfirmButton = driver
                .findElement(By.xpath(SHOW_PASSWORD_CONFIRM_BUTTON_SELECTOR));
        return showPasswordConfirmButton;
    }
    @Step
    protected RegisterComponent clickShowPasswordConfirmButton() {
        if (isDisplayedShowPasswordConfirmButton())
            this.getShowPasswordConfirmButton().click();
        return this;
    }
    @Step
    protected boolean isDisplayedShowPasswordConfirmButton() {
        return getShowPasswordConfirmButton().isDisplayed();
    }

    @Step
    protected boolean sizePasswordConfirmValidator() {
        return driver
                .findElements(
                        By.cssSelector(PASSWORD_CONFIRM_VALIDATOR_SELECTOR))
                .size() != 0;
    }
    @Step
    public WebElement getSignUpButton() {

        this.signUpButton = driver
                .findElement(By.cssSelector(SIGNUP_BUTTON_SELECTOR));
        return signUpButton;
    }
    @Step
    protected boolean isDisplayedSignUpButton() {
        return getSignUpButton().isDisplayed();
    }
    @Step
    protected String getSignUpButtonText() {
        return getSignUpButton().getText();
    }
    @Step
    public boolean signUpIsDisabled() {
        return getSignUpButton().getAttribute("disabled") != null;

    }
    @Step
    protected ManualRegisterComponent fillEmailField(String email) {
        if (isDisplayedEmailField()) {
            clickEmailField(driver);
            clearEmailField();
            inputEmailField(email);
        }
        return this;
    }
    @Step
    protected ManualRegisterComponent fillUserNameField(String firstName) {
        if (isDisplayedFirstNameField()) {
            clickFirstName(driver);
            clearFirstName();
            inputUserName(firstName);
        }
        return this;
    }
    @Step
    protected ManualRegisterComponent fillPasswordFieldPassShown(String password) {
        if (isDisplayedPasswordField()) {
            clickPasswordField(driver);
            clearPasswordField();
            inputPassword(password);
            clickShowPasswordButton();
        }
        return this;
    }
    @Step
    public ManualRegisterComponent fillPasswordFieldPassHidden(String password) {
        if (isDisplayedPasswordField()) {
            clickPasswordField(driver);
            clearPasswordField();
            inputPassword(password);
        }
        return this;
    }
    @Step
    protected ManualRegisterComponent fillPasswordConfirmField(String passwordConfirm) {
        if (isDisplayedPasswordConfirmField()) {
            clickPasswordConfirmField(driver);
            clearPasswordConfirmField();
            inputPasswordConfirm(passwordConfirm);
            clickShowPasswordConfirmButton();
        }
        return this;
    }

    @Step
    public ManualRegisterComponent clickSignUpButton() {
        if (isDisplayedSignUpButton()) {
            this.getSignUpButton().click();
        }
        return this;
    }

    @Step
    protected RegisterComponent checkVerIfMailReceived() {
driver.get(new GoogleMailAPI().getconfirmURL(10));
        return this;
    }
    @Step
   private void getConfirmURL(){
       confirmURL = new GoogleMailAPI().getconfirmURL(10);
   }
    @Step
    protected RegisterComponent verifyRegistration() {
        if (confirmURL == null) getConfirmURL();
        Assert.assertNotNull(confirmURL);
        return this;
    }
    @Step
    public void registrationWrongUser(User userData) {
        driver.get(confirmURL);
    }
    @Step
    public void fillFieldsWithoutRegistration(User userData) {
        fillEmailField(userData.getEmail())
                .fillUserNameField(userData.getUserName())
                .fillPasswordFieldPassShown(userData.getPassword())
                .fillPasswordConfirmField(userData.getConfirmPassword());

    }
    @Step
    public void registrationNewUserVerified(User userData) {
        fillEmailField(userData.getEmail())
                .fillUserNameField(userData.getUserName())
                .fillPasswordFieldPassShown(userData.getPassword())
                .fillPasswordConfirmField(userData.getConfirmPassword())
                .clickSignUpButton()
                .verifyRegistration();
    }
    @Step
    public void registrationUser(User userData) {
        fillEmailField(userData.getEmail())
                .fillUserNameField(userData.getUserName())
                .fillPasswordFieldPassShown(userData.getPassword())
                .fillPasswordConfirmField(userData.getConfirmPassword());
        clickSignUpButton();
    }
    @Step
    public void registerUserCheckIfMailReceived(User userData) {
        fillEmailField(userData.getEmail())
                .fillUserNameField(userData.getUserName())
                .fillPasswordFieldPassShown(userData.getPassword())
                .fillPasswordConfirmField(userData.getConfirmPassword())
                .clickSignUpButton()
                .checkVerIfMailReceived();
    }


}
