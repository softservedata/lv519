package academy.softserve.helpers.gmail;

import javafx.scene.image.Image;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.mail.Message;

public class GmailPage {
    private static EmailUtils emailUtils;
    private WebDriver driver;

    public GmailPage(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeClass
    public void connectToEmail() {
        driver.get("https://mail.google.com");
        try {
            emailUtils = new EmailUtils("greencitypavel@gmail.com", "1234qwerTY-", "smtp.gmail.com", EmailUtils.EmailFolder.INBOX);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testVerificationCode() {
        try {
            //TODO: Execute actions to send verification code to email

            String verificationCode = emailUtils.getAuthorizationCode();

            //TODO: Enter verification code on screen and submit

            //TODO: add assertions

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testLink(String subject, String linkText) {
        connectToEmail();
        //TODO: apply for a loan using criteria that will result in the application being rejected

        try{
            Message email = emailUtils.getMessagesBySubject(subject, true, 5)[0];
            String link = emailUtils.getUrlsFromMessage(email, subject).get(0);

            driver.get(link);

            //TODO: continue testing
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}
