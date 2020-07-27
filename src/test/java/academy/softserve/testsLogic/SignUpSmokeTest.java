package academy.softserve.testsLogic;

import static academy.softserve.constantParameters.BaseLink.BASE_URL;

import academy.softserve.helpers.BaseTest;
import academy.softserve.helpers.Gmail;
import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.widgets.MainPage;
import academy.softserve.widgets.SingUpPage;
import org.testng.annotations.Test;

import static academy.softserve.constantParameters.SingUpFieldsSelectorsValue.*;


public class SignUpSmokeTest extends BaseTest {

    @Test(groups = {"SmokeSingUp"},dataProvider = "smokeTestDataProvider",dataProviderClass = StaticDataProvider.class)
    public void testSingUp(String mail, String name, String password, String confirmPassword, String mailName, String mailPassword,int maiIndx, String linkText) {
        open(BASE_URL.getValue());
        new MainPage(driver)
                .singUp();
        new SingUpPage(driver)
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .setFor(PASSWORD, password)
                .setFor(PASSWORD_CONFIRM, confirmPassword)
                .confirmSingUp(SING_UP_BUTTON)
                .waitSuccessfulRegistrationMsg();
        new Gmail(driver)
                .openLinkFromEmail(mailName,mailPassword,"mailgreencity1",maiIndx,linkText);
        //openLinkFromEmail(String username, String password, String mailFrom, int mailIndex, String linkText)
    }
}
