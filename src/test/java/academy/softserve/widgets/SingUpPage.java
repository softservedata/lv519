package academy.softserve.widgets;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import academy.softserve.constantParameters.SingUpFieldsSelectorsValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingUpPage {
    public SingUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By field;
    private WebDriver driver;

    public SingUpPage setFor(SingUpFieldsSelectorsValue label, String value) {
        field = By.name(label.getValue());
        driver.findElement(field).sendKeys(value);
        new WebDriverWait(driver, 10).until(textToBePresentInElementValue(field, value));
        return this;
    }

    public SingUpPage confirmSingUp() {
        driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
        new WebDriverWait(driver, 10).until(elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"))));
        return this;
    }


}
