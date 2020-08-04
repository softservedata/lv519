package academy.softserve.helpers;

import academy.softserve.constantParameters.sing.up.Links;
import io.qameta.allure.Step;
import org.testng.Assert;
import utils.EmailUtils;

import javax.mail.Message;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static academy.softserve.constantParameters.sing.up.Links.CONFIRMATION_REGEX_TEMPLATE;
import com.sun.mail.imap.protocol.FLAGS;

public class Mail {

    private static EmailUtils emailUtils;

    public void wait(int secondsDelay) {
        try {
            Thread.sleep((secondsDelay) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Connect to email")
    public static void connectToEmail() {
        try {
            emailUtils = new EmailUtils("greencitypavel@gmail.com", "1234qwerTY-", "smtp.gmail.com", EmailUtils.EmailFolder.INBOX);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("get Messages By Subject")
    public static void clearMail() {
        try {
            Message[] msg = emailUtils.getAllMessages();
            for (Message message :msg) {
                message.setFlag(FLAGS.Flag.DELETED, true);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Step("get Messages By Subject")
    private Message[] getMessagesBySubject(Links text, boolean isUnreadOnly, int maxSearchPool) throws Exception {
        return emailUtils.getMessagesBySubject(text.getValue(), isUnreadOnly, maxSearchPool);
    }

    @Step("get Mail Content")
    private String getMailContent(Message[] emails, int sequenceNumber) throws Exception {
        String MailContent;
        MailContent = emailUtils.getMessageContent(emails[sequenceNumber]).trim().replaceAll("\\s+", "");
        return MailContent;
    }

    @Step("get Link From Text By Regx")
    private String getLinkFromTextByRegx(String mailContent) {
        new ScreenshotCreator().wait(3);
        connectToEmail();
        Pattern pattern = Pattern.compile(CONFIRMATION_REGEX_TEMPLATE.getValue());
        final Matcher m = pattern.matcher(mailContent);
        m.find();
        m.groupCount();
        return m.group(0).replace("amp;", "");
    }

    @Step("get Authorization Link")
    public String getAuthorizationLink(Links text, boolean isUnreadOnly, int maxSearchPool, int mailNumber) {
        int count = 0;
        int maxTries = 10;
        while (true) {
            wait(1);
            try {
                Message[] emails = getMessagesBySubject(text, isUnreadOnly, maxSearchPool);
                String mailContent = getMailContent(emails, mailNumber);
                return getLinkFromTextByRegx(mailContent);
            } catch (Exception e) {
                if (++count == maxTries){
                e.printStackTrace();
                Assert.fail(e.getMessage());
                return null;
                }
            }
        }
    }


}
