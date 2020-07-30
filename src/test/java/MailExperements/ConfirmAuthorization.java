package MailExperements;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.EmailUtils;

import javax.mail.Message;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfirmAuthorization {

    private static EmailUtils emailUtils;





    public void testTextContained() {
        try {
            emailUtils = new EmailUtils("greencitypavel@gmail.com", "1234qwerTY-", "smtp.gmail.com", EmailUtils.EmailFolder.INBOX);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        try{
            Message email = emailUtils.getMessagesBySubject("Verify your email address", false, 5)[0];


            String mailContent = emailUtils.getMessageContent(email).trim().replaceAll("\\s+", "");
            Pattern pattern = Pattern.compile("https://greencity.azurewebsites.net/ownSecurity/verifyEmail\\?token=([-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])");
            final Matcher m = pattern.matcher(mailContent);
            System.out.println("link was found: " + m.find());
            System.out.println("link quantity: " + m.groupCount());
            System.out.println("link: " + m.group(0));
            System.out.println(m.group(0).replace("amp;",""));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}
