package academy.softserve.widgets;

import academy.softserve.constantParameters.sing.up.SelectorsValue;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import verifications.CommunalVerifications;
import verifications.sing.up.SingUpPageVerifications;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Registration from main page
 */
public class SingUpPageUsage implements SingUpPageVerifications, CommunalVerifications {
    public SingUpPageUsage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    @Step("Set property for mail,user name, password and confirm password ")
    public SingUpPageUsage setFor(SelectorsValue label, String value) {
        driver.findElement(name(label.getValue())).sendKeys(value);
        return this;
    }

    @Step("Set property for mail,user name, password and confirm password + Enter")
    public SingUpPageUsage setFor(SelectorsValue label, String value, Keys keys) {
        driver.findElement(name(label.getValue())).sendKeys(value, keys);
        return this;
    }
    public SingUpPageUsage setFor( String value, Keys keys) {
        driver.switchTo().activeElement().sendKeys(value, keys);
        return this;
    }
    @Step("Click confirm password")
    public SingUpPageUsage confirmSingUp(SelectorsValue singUpButton) {
        driver.findElement(xpath(singUpButton.getValue())).click();
        return this;
    }

    public String findText(SelectorsValue locator){
        return driver.findElement(xpath(locator.getValue())).getText();
    }

    @Step("get all errors from singUp page")
    public List<String> findErrors() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> elements = driver.findElements(className("error-message-show"));
        return elements.stream()
                .map(webElement->(webElement.getText().trim().replaceAll("\\s+", ""))).collect(Collectors.toList());
    }

    @Step("verification that successful registration message displayed")
    public SingUpPageUsage waitSuccessfulRegistrationMsg() {
        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement SuccessfulRegistrationPopUp = driver.findElement(By.id("mat-dialog-1"));
            return this;
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            new WebDriverWait(driver, 5).until(visibilityOfElementLocated(By.id("mat-dialog-1")));
            return this;
        }
    }

    @Step("verification that successful registration message disappear")
    public SingUpPageUsage waitSuccessfulRegistrationMsgInvisible() {
        try {
            new WebDriverWait(driver, 5).until(invisibilityOfElementLocated(By.id("mat-dialog-1")));
            return this;
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            new WebDriverWait(driver, 5).until(invisibilityOfElementLocated(By.id("mat-dialog-1")));
        }
        return this;
    }

    @Step("switch to new tab")
    public SingUpPageUsage switchToNewTab(String title) {
        String originalWindow = driver.getWindowHandle();
        new WebDriverWait(driver, 10).until(numberOfWindowsToBe(2));
        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        waitTitleLoad(title);
        return this;
    }

    @Step("wait for page load")
    public SingUpPageUsage waitTitleLoad(String title) {
        new WebDriverWait(driver, 10).until(titleIs(title));
        return this;
    }
}
