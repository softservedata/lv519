package academy.softserve.testsLogic.sing.up;

import static academy.softserve.constantParameters.BaseLink.BASE_URL;

import academy.softserve.helpers.*;
import academy.softserve.widgets.MainPage;
import org.testng.annotations.Test;
import static academy.softserve.constantParameters.sing.up.Links.MAIL_SUBJECT_NAME;
import static academy.softserve.constantParameters.sing.up.SelectorsValue.*;


public class SmokeTest extends TestRunnner {

    @Test(groups = {"SmokeSingUp"},dataProvider = "registrationDataProvider",dataProviderClass = StaticDataProvider.class)
    public void testSingUp(String mail, String name, String password) {
        open(BASE_URL.getValue());
        new MainPage(driver)
                .singUp()
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .setFor(PASSWORD, password)
                .setFor(PASSWORD_CONFIRM, password)
                .confirmSingUp(SING_UP_BUTTON)
                .waitSuccessfulRegistrationMsg();
                open( new Mail().getAuthorizationLink(MAIL_SUBJECT_NAME,true,20,0));
    }
}
