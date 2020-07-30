package MailExperements;

import org.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.EmailUtils;
import javax.mail.Message;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailTest {
    private static EmailUtils emailUtils;

    @BeforeClass
    public static void connectToEmail() {
        try {
            emailUtils = new EmailUtils("greencitypavel@gmail.com", "1234qwerTY-", "smtp.gmail.com", EmailUtils.EmailFolder.INBOX);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testTextContained() {
        try{
            Message email = emailUtils.getMessagesBySubject("Verify your email address", false, 5)[0];


            String mailContent = emailUtils.getMessageContent(email).trim().replaceAll("\\s+", "");
            Pattern pattern = Pattern.compile("https://greencity.azurewebsites.net/ownSecurity/verifyEmail\\?token=([-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])");
            final Matcher m = pattern.matcher(mailContent);
            System.out.println("link was found: " + m.find());
            System.out.println("link quantity: " + m.groupCount());
            System.out.println("link: " + m.group(0));
            System.out.println(m.group(0).replace("amp;",""));



            /*System.out.println(mCount);
            System.out.println(matcher);
            System.out.println(matcher2);
*/
            //String link = pattern.matcher(mailContent).group();

            //System.out.println(link);


        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}