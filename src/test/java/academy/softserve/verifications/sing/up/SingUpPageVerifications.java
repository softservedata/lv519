package academy.softserve.verifications.sing.up;

import academy.softserve.constantParameters.sing.up.SelectorsValue;
import academy.softserve.helpers.ScreenshotCreator;
import academy.softserve.widgets.SingUpPageUsage;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.List;

import static academy.softserve.helpers.TestRunner.driver;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

//  !!! Assert.assertEquals(expected,actual );
public interface SingUpPageVerifications {
    @Step("verification that button is active")
    default SingUpPageUsage buttonIsActive(SelectorsValue singUpButton) {
        Assert.assertTrue(driver.findElement(xpath(singUpButton.getValue())).isEnabled());
        return new SingUpPageUsage(driver);
    }

    @Step("verification that button is not active")
    default SingUpPageUsage buttonIsNotActive(SelectorsValue singUpButton) {
        Assert.assertFalse(driver.findElement(xpath(singUpButton.getValue())).isEnabled());
        return new SingUpPageUsage(driver);
    }

    @Step
    List<String> findErrors();

    @Step("compare expected vs actual errors text")
    default SingUpPageUsage assertErrors(int expectedQuantity,List<String> expectedErrorMsg) {
        List<String> actualErrors = findErrors();
        Assert.assertEquals( actualErrors,expectedErrorMsg);
        assertErrorsQuantity(expectedQuantity,actualErrors);
        return new SingUpPageUsage(driver);
    }

    @Step("compare expected vs actual errors quantity")
    default SingUpPageUsage assertErrorsQuantity(int expectedQuantity, List<String> actualErrors) {
        Assert.assertEquals(actualErrors.size(), expectedQuantity);
        return new SingUpPageUsage(driver);
    }

    @Step("compare expected and actual errors quantity + screen shot ")
    default SingUpPageUsage assertErrors(List<String> expectedErrorMsg, int DelayBefore, int DelayAfter, int expectedQuantity) {
        List<String> actualErrors = findErrors();
        Assert.assertEquals(actualErrors, expectedErrorMsg);
        assertErrorsQuantity(expectedQuantity, actualErrors);
        new ScreenshotCreator().screenshot(driver, DelayBefore, DelayAfter);
        return new SingUpPageUsage(driver);
    }

    @Step
    String findText(SelectorsValue locator);

    @Step("search text on provided element")
    default SingUpPageUsage AssertElementText(String expectedText, SelectorsValue locator) {
        verifyContentSize(expectedText.length(), locator);
        Assert.assertEquals(findText(locator),expectedText);
        return new SingUpPageUsage(driver);
    }

    @Step("verification of content size in element")
    default SingUpPageUsage verifyContentSize(int expectedSize, SelectorsValue label) {
        Assert.assertFalse(driver.findElement(name(label.getValue())).getText().length() > 0
                && driver.findElement(name(label.getValue())).getText().length() < expectedSize + 1);
        return new SingUpPageUsage(driver);
    }

    SingUpPageUsage waitSuccessfulRegistrationMsgInvisible();

    @Step("compare expected and actual path")
    default SingUpPageUsage verifyPath(String expectedPath) {
        waitSuccessfulRegistrationMsgInvisible();
        Assert.assertEquals(driver.getCurrentUrl(),expectedPath);
        return new SingUpPageUsage(driver);
    }


}
