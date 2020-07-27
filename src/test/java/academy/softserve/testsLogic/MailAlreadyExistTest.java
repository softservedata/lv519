package academy.softserve.testsLogic;

import academy.softserve.helpers.BaseTest;
import academy.softserve.helpers.Gmail;
import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.widgets.MainPage;
import academy.softserve.widgets.SingUpPage;
import org.testng.annotations.Test;
import java.util.List;

import static academy.softserve.constantParameters.BaseLink.BASE_URL;
import static academy.softserve.constantParameters.SingUpFieldsSelectorsValue.*;


public class MailAlreadyExistTest extends BaseTest {
    @Test(groups = {"SingUPNegative"}, dataProvider = "emailAlreadyExistDataProvider",dataProviderClass = StaticDataProvider.class)
    public void testSingUp(String mail, String name, String password, String confirmPassword,
                           List<String> expectedErrorMsg, String mailName, String mailPassword,int maiIndx, String linkText) {
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
                .openLinkFromEmail(mailName,mailPassword,"mailgreencity1",maiIndx,linkText)
                .singUp()
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .setFor(PASSWORD, password)
                .setFor(PASSWORD_CONFIRM, confirmPassword)
                .confirmSingUp(SING_UP_BUTTON)
                .assertErrors(expectedErrorMsg);
    }
    }

