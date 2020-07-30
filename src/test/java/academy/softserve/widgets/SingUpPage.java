package academy.softserve.widgets;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import academy.softserve.constantParameters.SingUpFieldsSelectorsValue;
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

    /**
     * @param label -  String from enum with locators
     * @param value - String value that will be typed
     * @return instance of SingUpPage
     */
    @Step("Set property for mail,user name, password and confirm password ")
    public SingUpPage setFor(SingUpFieldsSelectorsValue label, String value) {
        driver.findElement(name(label.getValue())).sendKeys(value);
        return this;
    }

    /**
     * @param singUpButton - SingUp button that should to be clicked
     * @return void
     */
    @Step("Click confirm password")
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
    @Step("search text on provided element")
    public SingUpPage textSearch(SingUpFieldsSelectorsValue locator, String expectedText) {
        Assert.assertEquals(expectedText, driver.findElement(xpath(locator.getValue())).getText());
        return this;
    }

    /**
     * @return list of errors in format of web elements
     */
    @Step("get all errors from singUp page")
    public List<WebElement> findErrors() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver.findElements(By.className("error-message error-message-show"));
    }

    /**
     * provide information about comparison result
     *
     * @param expectedErrorMsg - message that you expect to receive in string format
     * @return SingUpPage instance
     */
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

    /**
     * @param expectedErrorMsg             - message that you expect to receive in string format
     * @param screenShotSecondsDelayBefore - delay before screen shot
     * @param screenShotSecondsDelayAfter  - delay after screen shot
     * @return SingUpPage instance
     */
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

    /**
     * @param label - element name
     * @param size - expected content size
     * @return SingUp instance
     */
    @Step("check content size in element")
    public SingUpPage checkContentSize(SingUpFieldsSelectorsValue label, int size) {
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
       public SingUpPage buttonIsActive(SingUpFieldsSelectorsValue singUpButton) {
           Assert.assertTrue(driver.findElement(xpath(singUpButton.getValue())).isEnabled());
           return this;
       }
    @Step("Check or button is not active")
    public SingUpPage buttonIsNotActive(SingUpFieldsSelectorsValue singUpButton) {
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
