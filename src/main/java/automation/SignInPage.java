package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BaseClass {

    @FindBy(xpath = "//button[contains(text(),' Sign in ')]")
    private WebElement signInButton;

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getSignInPageOpenMessage() {
        return this.signInButton.getText();
    }
}
