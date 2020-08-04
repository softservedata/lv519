package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//*[@class = 'sign-up-link ng-star-inserted']//span[contains(text(),'Sign up ')]")
    private WebElement signUpButton;

    @FindBy(xpath = "//h1[contains(text(),'A new way to cultivate useful habits')]")
    private WebElement mainPageMessage;

    @FindBy(xpath = "//*[@class = 'navigation-menu-left']//a[contains(text(),'My habits')]")
    private WebElement myHabitsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage clickSignUpButton() {
        this.signUpButton.click();
        return new SignUpPage(driver);
    }

    public SignInPage clickMyHabitButton() {
        this.myHabitsButton.click();
        return new SignInPage(driver);
    }

    public String getMainPageOpenMessage() {
        return this.mainPageMessage.getText();
    }
}
