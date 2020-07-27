package academy.softserve.widgets;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import academy.softserve.constantParameters.SingUpFieldsSelectorsValue;
import academy.softserve.helpers.ScreenshotCreator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * Registration from main page
 */
public class SingUpPage {
    public SingUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    /**
     * @param label -  String from enum with locators
     * @param value - String value that will be typed
     * @return instance of SingUpPage
     */
    public SingUpPage setFor(SingUpFieldsSelectorsValue label, String value) {
        driver.findElement(name(label.getValue())).sendKeys(value);
        return this;
    }

    /**
     * @param singUpButton - SingUp button that should to be clicked
     * @return void
     */
    public SingUpPage confirmSingUp(SingUpFieldsSelectorsValue singUpButton) {
        driver.findElement(xpath(singUpButton.getValue())).click();
        return this;
    }


    /**
     * find element by xpath and assert expected and actual expectedText
     *
     * @param locator      -  String from enum with locators {@link SingUpFieldsSelectorsValue}
     * @param expectedText - expectedText that should be in element
     * @return - instance of SingUpPage
     */
    public SingUpPage textSearch(SingUpFieldsSelectorsValue locator, String expectedText) {
        Assert.assertEquals(expectedText, driver.findElement(xpath(locator.getValue())).getText());
        return this;
    }

    /**
     * @return list of errors in format of web elements
     */
    public List<WebElement> findErrors() {
        return driver.findElements(By.className("error-message error-message-show"));
    }

    /**
     * provide information about comparison result
     *
     * @param expectedErrorMsg - message that you expect to receive in string format
     * @return SingUpPage instance
     */
    public SingUpPage assertErrors(List<String> expectedErrorMsg) {
        List<WebElement> errors = findErrors();
        for (WebElement actual : errors) {
            for (String expected : expectedErrorMsg) {
                Assert.assertEquals(expected, actual.getText());
            }
        }
        return this;
    }

    /**
     * @param expectedErrorMsg             - message that you expect to receive in string format
     * @param screenShotSecondsDelayBefore - delay before screen shot
     * @param screenShotSecondsDelayAfter  - delay after screen shot
     * @return SingUpPage instance
     */
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

    /**
     * try catch to avoid element is not attached to the page document err
     * check or popup with information about Successful Registration displayed
     */

    /**
     *
     * @param label - element name
     * @param size - expected content size
     * @return SingUp instance
     */
    public SingUpPage checkContentSize(SingUpFieldsSelectorsValue label, int size) {
        Assert.assertFalse(driver.findElement(name(label.getValue())).getText().length() > 0
                && driver.findElement(name(label.getValue())).getText().length() < size + 1);
        return this;
    }

    public SingUpPage checkPath(String expectedPath){
        waitSuccessfulRegistrationMsgInvisible();
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedPath),"expected: " +driver.getCurrentUrl() + "\nactual: " + expectedPath);
        return this;
    }


    public SingUpPage waitSuccessfulRegistrationMsg() {
        try {
            new WebDriverWait(driver, 5).until(visibilityOfElementLocated(By.id("mat-dialog-1")));
            return this;
        } catch (WebDriverException e) {
            new WebDriverWait(driver, 5).until(visibilityOfElementLocated(By.id("mat-dialog-1")));
        }
        return this;
    }
    public SingUpPage waitSuccessfulRegistrationMsgInvisible() {
        try {
            new WebDriverWait(driver, 5).until(invisibilityOfElementLocated(By.id("mat-dialog-1")));
            return this;
        } catch (WebDriverException e) {
            new WebDriverWait(driver, 5).until(invisibilityOfElementLocated(By.id("mat-dialog-1")));
        }
        return this;
    }
       public SingUpPage singUp (){
           driver.findElement(By.className("sign-up-link")).click();
           new WebDriverWait(driver, 10).until(elementToBeClickable(By.className("sign-up-link")));
           return this;
       }
}
