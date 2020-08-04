package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BaseClass {

    @FindBy(xpath = "//*[@name = 'email']")
    private WebElement email;

    @FindBy(xpath = "//*[@name = 'fistName']")
    private WebElement userName;

    @FindBy(xpath = "//*[@name = 'form-control password']")
    private WebElement password;

    @FindBy(xpath = "//*[@name = 'form-control password-confirm']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//div[contains(text(),' Passwords do not match ')]")
    private WebElement passwordDoNotMatchMessage;

    @FindBy(xpath = "//button[contains(text(),' Sign Up ')]")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@alt = 'cross']")
    private WebElement cross;

    @FindBy(xpath = "//*[@class = 'subtitle']")
    private WebElement signUpSubtitle;

    @FindBy(id = "mat-dialog-1")
    private WebElement successfulRegistrationMessage;

    @FindBy(xpath = "//div[contains(text(), 'User name is required')]")
    private WebElement userNameRequiredMessage;

    private boolean signUpButtonState;

    public SignUpPage() {
    }

    public SignUpPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SignUpPage setValueIntoEmail(String email) {
        this.email.click();
        this.email.clear();
        this.email.sendKeys(email);
        return this;
    }

    public SignUpPage setValueIntoUserName(String userName) {
        this.userName.click();
        this.userName.clear();
        this.userName.sendKeys(userName);
        return this;
    }

    public SignUpPage setValueIntoPassword(String password) {
        this.password.click();
        this.password.clear();
        this.password.sendKeys(password);
        return this;
    }

    public SignUpPage setValueIntoConfirmPassword(String confirmPassword) {
        this.confirmPassword.click();
        this.confirmPassword.clear();
        this.confirmPassword.sendKeys(confirmPassword);
        return this;
    }

    public SignUpPage successfulSignUp(User validUser) {
        setValueIntoEmail(validUser.getUserEmail());
        setValueIntoUserName(validUser.getUserName());
        setValueIntoPassword(validUser.getUserPassword());
        setValueIntoConfirmPassword(validUser.getUserConfirmPassword());
        return this;
    }

    public SignUpPage signUpWithoutUserName(User invalidUser) {
        setValueIntoEmail(invalidUser.getUserEmail());
        clickUserNameField();
        setValueIntoPassword(invalidUser.getUserPassword());
        setValueIntoConfirmPassword((invalidUser.getUserConfirmPassword()));
        return this;
    }

    public SignUpPage sighUpWithIncorrectConfirmPassword(User invalidUser) {
        setValueIntoEmail(invalidUser.getUserEmail());
        setValueIntoUserName(invalidUser.getUserName());
        setValueIntoPassword(invalidUser.getUserPassword());
        setValueIntoConfirmPassword((invalidUser.getUserConfirmPassword()));
        return this;
    }

    public SignUpPage checkSignUpButtonState() {
        signUpButtonState = this.signUpButton.isEnabled();
        return this;
    }

    public String getPasswordDoNotMatchMessage() {
        return this.passwordDoNotMatchMessage.getText();
    }

    public String getUserNameRequiredMessage() {
        return this.userNameRequiredMessage.getText();
    }

    public boolean getSignUpButtonState() {
        return signUpButtonState;
    }

    public HomePage clickCrossButton() {
        this.cross.click();
        return new HomePage(driver);
    }

    public SignUpPage clickUserNameField() {
        this.userName.click();
        return this;
    }

}
