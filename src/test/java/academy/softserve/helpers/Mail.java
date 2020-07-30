package academy.softserve.helpers;

import org.testng.Assert;
import utils.EmailUtils;

import javax.mail.Message;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail {


    private static EmailUtils emailUtils;

    public static void connectToEmail() {
        try {
            emailUtils = new EmailUtils("greencitypavel@gmail.com", "1234qwerTY-", "smtp.gmail.com", EmailUtils.EmailFolder.INBOX);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
    public String confirmAuthorizationLink() {
        String link = "";
        //TODO: apply for a loan using criteria that will result in the application being rejected

        try {
            Message[] email = emailUtils.getMessagesBySubject("Verify your email address", true, 20);
            String mailContent = emailUtils.getMessageContent(email[0]).trim().replaceAll("\\s+", "");
            Pattern pattern = Pattern.compile("https://greencity.azurewebsites.net/ownSecurity/verifyEmail\\?token=([-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])");
            final Matcher m = pattern.matcher(mailContent);
            boolean isLinkFended = m.find();
            int linkGroupCount = m.groupCount();
            link = m.group(0).replace("amp;", "");
            return link;
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
            return null;
        }
    }


}
