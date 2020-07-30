package academy.softserve.widgets;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage  {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By singUpButton = By.className("sign-up-link");

    /**
     * click sing up button on main page
     * @return
     */

    public MainPage singUp() {
        driver.findElement(singUpButton);
        new WebDriverWait(driver, 10).until(elementToBeClickable(singUpButton));
        driver.findElement(singUpButton).click();
        return this;
    }

    /**
     * click sing up button on main page with Explicit wait
     *
     * @param wait - explicit wait time
     */
    public void singUp(boolean wait) {
        driver.findElement(singUpButton);
        if (wait) {
            new WebDriverWait(driver, 10).until(elementToBeClickable(singUpButton));
        }
        driver.findElement(singUpButton).click();
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