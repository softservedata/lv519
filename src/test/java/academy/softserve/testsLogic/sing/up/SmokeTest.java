package academy.softserve.testsLogic.sing.up;

import academy.softserve.helpers.Mail;
import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.helpers.TestRunner;
import academy.softserve.widgets.MainPageUsage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static academy.softserve.constantParameters.BaseLink.BASE_URL;
import static academy.softserve.constantParameters.sing.up.Links.MAIL_SUBJECT_NAME;
import static academy.softserve.constantParameters.sing.up.SelectorsValue.*;


public class SmokeTest extends TestRunner {
    @Test(groups = {"SmokeSingUp"},dataProvider = "SmokeDataProvider",dataProviderClass = StaticDataProvider.class)
    @Description("Verifying that registration works in general")
    public void testSingUp(String mail, String name, String password) {
        Mail.connectToEmail();
        Mail.clearMail();
        open(BASE_URL.getValue());
        new MainPageUsage(driver)
                .singUp()
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .setFor(PASSWORD, password)
                .setFor(PASSWORD_CONFIRM, password)
                .confirmSingUp(SING_UP_BUTTON)
                .waitSuccessfulRegistrationMsg();
                open( new Mail().getAuthorizationLink(MAIL_SUBJECT_NAME,true,20,0))
                .waitTitleLoad("GreenCity");
    }
}
