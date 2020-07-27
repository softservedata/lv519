package academy.softserve.helpers.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Gmail {
    private WebDriver driver;

    public Gmail(WebDriver driver) {
        this.driver = driver;
    }

    public Gmail openG() {
        driver.get("https://accounts.google.com/ServiceLogin?");
        return this;
    }


    public Gmail login() {
        driver.findElement(By.id("Email")).sendKeys("greencitypavel@gmail.com",Keys.ENTER);
        // driver.findElement(By.id("next")).click();
        driver.findElement(By.id("Passwd")).sendKeys("1234qwerTY-",Keys.ENTER);
        //driver.findElement(By.id("signIn")).click();
        return this;
    }

/*
    public Gmail gmailInbox() {
        driver.findElement(By.xpath("//*[@title='Google apps']")).click();
        driver.findElement(By.id("gb23")).click();
        return this;
    }
*/

    // now talking un-read email form inbox into a list
    private List<WebElement> unreadEmails = driver.findElements(By.xpath("//*[@class='zF']"));

    // Mailer name for which i want to check do i have an email in my inbox
    String MyMailer = "mailgreencity1";

    public void logic() {
        for (int i = 0; i < unreadEmails.size(); i++) {
            if (unreadEmails.get(i).isDisplayed() == true) {
                // now verify if you have got mail form a specific mailer (Note Un-read mails)
                // for read mails xpath loactor will change but logic will remain same
                if (unreadEmails.get(i).getText().equals(MyMailer)) {
                    System.out.println("Yes we have got mail form " + MyMailer);
                    // also you can perform more actions here
                    // like if you want to open email form the mailer
                    break;
                } else {
                    System.out.println("No mail form " + MyMailer);
                }
            }
        }
    }
}
