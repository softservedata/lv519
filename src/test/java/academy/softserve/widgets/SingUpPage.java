package academy.softserve.widgets;

import static org.openqa.selenium.By.*;

import academy.softserve.constantParameters.SingUpFieldsSelectorsValue;
import academy.softserve.helpers.ScreenshotCreator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
     * @param singUpButton - click on SingUp button
     * @return void
     */
    public void confirmSingUp(SingUpFieldsSelectorsValue singUpButton) {
        driver.findElement(xpath(singUpButton.getValue())).click();
    }

    /**
     * find element by xpath and assert expected and actual expectedText
     *
     * @param locator -  String from enum with locators {@link SingUpFieldsSelectorsValue}
     * @param expectedText    - expectedText that should be in element
     * @return - instance of SingUpPage
     */
    public SingUpPage textSearch(SingUpFieldsSelectorsValue locator, String expectedText) {
        Assert.assertEquals(expectedText, driver.findElement(xpath(locator.getValue())).getText());
        return this;
    }
    public List<WebElement> findErrors(){
        List<WebElement> errors= driver.findElements(By.className("error-message error-message-show"));
        return errors;
    }

    public SingUpPage assertErrors(List<String> expectedErrorMsg ){

        List<WebElement> errors = findErrors();
            for (WebElement actual: errors){
                for (String expected:expectedErrorMsg){
                    Assert.assertEquals(expected,actual.getText());
                }
            }
        return this;
    }

    public SingUpPage assertErrors(List<String> expectedErrorMsg, int SrnShotWithDelay ){

        List<WebElement> errors = findErrors();
        for (WebElement actual: errors){
            for (String expected:expectedErrorMsg){
                Assert.assertEquals(expected,actual.getText());
            }
        }
        new ScreenshotCreator().screenshot(driver,SrnShotWithDelay);
        return this;
    }
}
