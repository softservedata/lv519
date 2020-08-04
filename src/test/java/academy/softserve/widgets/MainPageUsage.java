package academy.softserve.widgets;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import verifications.CommunalVerifications;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MainPageUsage implements CommunalVerifications {
    private WebDriver driver;

    public MainPageUsage(WebDriver driver) {
        this.driver = driver;
    }

    private By singUpButton = By.className("sign-up-link");
    @Step("click Sing Up")
    public SingUpPageUsage singUp() {
        driver.findElement(singUpButton);
        new WebDriverWait(driver, 10).until(elementToBeClickable(singUpButton));
        driver.findElement(singUpButton).click();
        return new SingUpPageUsage(driver);
    }

    @Step("click Sing Up")
    public SingUpPageUsage singUp(boolean wait) {
        driver.findElement(singUpButton);
        if (wait) {
            new WebDriverWait(driver, 10).until(elementToBeClickable(singUpButton));
        }
        driver.findElement(singUpButton).click();
        return new SingUpPageUsage(driver);
    }
    @Step("switch to new tab")
    public SingUpPageUsage switchToNewTab (){
        String originalWindow = driver.getWindowHandle();
        new WebDriverWait(driver, 10).until(numberOfWindowsToBe(2));
        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        new WebDriverWait(driver, 10).until(titleIs("GreenCity"));
        return new SingUpPageUsage(driver);
    }

    @Step("wait for page load")
    public MainPageUsage waitTitleLoad(String title) {
        new WebDriverWait(driver, 10).until(titleIs(title));
        return this;
    }
}