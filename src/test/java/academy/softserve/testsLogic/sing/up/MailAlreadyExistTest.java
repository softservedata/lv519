package academy.softserve.testsLogic.sing.up;

import academy.softserve.helpers.Mail;
import academy.softserve.helpers.ScreenshotCreator;
import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.helpers.TestRunner;
import io.qameta.allure.Description;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.List;

import static academy.softserve.constantParameters.BaseLink.BASE_URL;
import static academy.softserve.constantParameters.sing.up.Links.MAIL_SUBJECT_NAME;
import static academy.softserve.constantParameters.sing.up.SelectorsValue.*;


public class MailAlreadyExistTest extends TestRunner {
    @Test(groups = {"SingUPNegative"}, dataProvider = "emailAlreadyExistDataProvider",dataProviderClass = StaticDataProvider.class)
    @Description("Making successful registration and tried to register again with the same mail")
    public void testSingUp(String mail, String name, String password, List<String> expectedErrorMsg) {
        Mail.connectToEmail();
        Mail.clearMail();
        open(BASE_URL.getValue())
                .singUp()
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .setFor(PASSWORD, password)
                .setFor(PASSWORD_CONFIRM, password)
                .confirmSingUp(SING_UP_BUTTON)
                .waitSuccessfulRegistrationMsg()
                .waitSuccessfulRegistrationMsgInvisible();
        open( new Mail().getAuthorizationLink(MAIL_SUBJECT_NAME,true,20,0))
                .waitTitleLoad("GreenCity")
                .singUp()
                .setFor(EMAIL, mail, Keys.TAB)
                .setFor(name,Keys.TAB)
                .setFor(password,Keys.TAB)
                .setFor(password, Keys.ENTER)
                .assertErrors(1,expectedErrorMsg);
        new ScreenshotCreator().wait(5);
    }
}

