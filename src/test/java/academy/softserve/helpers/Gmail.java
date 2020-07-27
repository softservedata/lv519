package academy.softserve.helpers;

import academy.softserve.widgets.SingUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Get mail and click on some link
 */
public class Gmail {
    private WebDriver driver;
    List<WebElement> targetMails = new ArrayList<>();

    public Gmail(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * open registration page
     */
    private void openG() {
        driver.get("https://accounts.google.com/ServiceLogin");
    }

    /**
     * @param username gmail username
     * @param password gmail password
     * @return Gmail instance
     */
    private Gmail login(String username, String password) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(username, Keys.ENTER);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password, Keys.ENTER);
        new ScreenshotCreator().wait(5);
        driver.navigate().to("https://mail.google.com/");
        return this;
    }

    /**
     * used to avoid element is not attached to the page document
     * @return list of web elements
     */
    private List<WebElement> getListOfMails() {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver.findElements(By.xpath("//*[@class='zF']"));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            driver.navigate().refresh();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver.findElements(By.xpath("//*[@class='zF']"));
        }
    }

    /**
     * find list of mails
     * @param mailFrom - name of email sender in string format
     */
    private void mailFilter(String mailFrom) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> unreadEmail = getListOfMails();
        for (WebElement mail : unreadEmail) {
            if (mail.isDisplayed()) {
                // now verify if you have got mail form a specific mailer (Note Un-read mails)
                // for read mails xpath loactor will change but logic will remain same
                if (mail.getText().equals(mailFrom)) {
                    targetMails.add(mail);
                    // also you can perform more actions here
                    // like if you want to open email form the mailer
                } else {
                    System.out.println("No mail form " + mailFrom);
                }
            }
        }
        System.out.println("Yes we have  " + targetMails.size() + " mail form " + mailFrom);
    }

    /**
     * open mail form list @see mailFilter
     * @param index -
     * @return
     */
    private Gmail openMail(int index) {
        targetMails.get(index).click();
        return this;
    }

    /**
     * open link from email
     * @param linkText - text in link
     */
    private void openLink(String linkText) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText(linkText)).click();
    }

    /**
     * combination of all methods above to open link using one method
     * @param username  - email username
     * @param password  - email password
     * @param mailFrom  - who send mail
     * @param mailIndex - index what mail should be opened starts form 1
     * @param linkText  - text in link
     * @return
     */
    public SingUpPage openLinkFromEmail(String username, String password, String mailFrom, int mailIndex, String linkText) {
        openG();
        login(username, password);
        mailFilter(mailFrom);
        openMail(mailIndex - 1);
        openLink(linkText);
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
