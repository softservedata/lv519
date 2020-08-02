package academy.softserve.widgets;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import academy.softserve.constantParameters.sing.up.SelectorsValue;
import academy.softserve.helpers.ScreenshotCreator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Registration from main page
 */
public class SingUpPage  {
    public SingUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    @Step("Set property for mail,user name, password and confirm password ")
    public SingUpPage setFor(SelectorsValue label, String value) {
        driver.findElement(name(label.getValue())).sendKeys(value);
        return this;
    }

    @Step("Click confirm password")
    public SingUpPage confirmSingUp(SelectorsValue singUpButton) {
        driver.findElement(xpath(singUpButton.getValue())).click();
        return this;
    }

    @Step("search text on provided element")
    public SingUpPage textSearch(SelectorsValue locator, String expectedText) {
        Assert.assertEquals(expectedText, driver.findElement(xpath(locator.getValue())).getText());
        return this;
    }

    @Step("get all errors from singUp page")
    public List<WebElement> findErrors() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver.findElements(By.className("error-message error-message-show"));
    }

    @Step("assert expected and actual errors")
    public SingUpPage assertErrors(List<String> expectedErrorMsg) {
        List<WebElement> errors = findErrors();
        for (WebElement actual : errors) {
            for (String expected : expectedErrorMsg) {
                Assert.assertEquals(expected, actual.getText());
            }
        }
        return this;
    }

    @Step("assert expected and actual errors plus screen shot ")
    public SingUpPage assertErrors(List<String> expectedErrorMsg, int screenShotSecondsDelayBefore, int screenShotSecondsDelayAfter) {
        List<WebElement> errors = findErrors();
        for (WebElement actual : errors) {
            for (String expected : expectedErrorMsg) {
                Assert.assertEquals(expected, actual.getText());
            }
        }
        new ScreenshotCreator().screenshot(driver, screenShotSecondsDelayBefore, screenShotSecondsDelayAfter);
        return this;
    }

    @Step("check content size in element")
    public SingUpPage checkContentSize(SelectorsValue label, int size) {
        Assert.assertFalse(driver.findElement(name(label.getValue())).getText().length() > 0
                && driver.findElement(name(label.getValue())).getText().length() < size + 1);
        return this;
    }
    @Step("assert expected and actual path")
    public SingUpPage checkPath(String expectedPath){
        waitSuccessfulRegistrationMsgInvisible();
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedPath),"actual: " +driver.getCurrentUrl() + "\n" +"expected: " + expectedPath);
        return this;
    }

    @Step("check that SuccessfulRegistrationMsg exist")
    public SingUpPage waitSuccessfulRegistrationMsg() {

        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement SuccessfulRegistrationPopUp = driver.findElement(By.id("mat-dialog-1"));
            return this;
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            new WebDriverWait(driver, 5).until(visibilityOfElementLocated(By.id("mat-dialog-1")));
            return this;
        }

    }
    @Step("check that SuccessfulRegistrationMsg disappear")
    public SingUpPage waitSuccessfulRegistrationMsgInvisible() {
        try {
            new WebDriverWait(driver, 5).until(invisibilityOfElementLocated(By.id("mat-dialog-1")));
            return this;
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            new WebDriverWait(driver, 5).until(invisibilityOfElementLocated(By.id("mat-dialog-1")));
        }
        return this;
    }
    @Step("Check or button is active")
       public SingUpPage buttonIsActive(SelectorsValue singUpButton) {
           Assert.assertTrue(driver.findElement(xpath(singUpButton.getValue())).isEnabled());
           return this;
       }
    @Step("Check or button is not active")
    public SingUpPage buttonIsNotActive(SelectorsValue singUpButton) {
        Assert.assertFalse(driver.findElement(xpath(singUpButton.getValue())).isEnabled());
        return this;
    }

    public SingUpPage switchToNewTab (){

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
        return new SingUpPage(driver);
    }


}
