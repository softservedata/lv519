package academy.softserve.testsLogic;

import academy.softserve.helpers.BaseTest;
import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.widgets.MainPage;
import academy.softserve.widgets.SingUpPage;
import org.testng.annotations.Test;

import static academy.softserve.constantParameters.BaseLink.BASE_URL;
import static academy.softserve.constantParameters.SingUpFieldsSelectorsValue.*;

public class SingUpRedirectTest extends BaseTest {
    @Test(groups = {"redirect"},dataProvider = "SingUpRedirectDataProvider",dataProviderClass = StaticDataProvider.class)
    public void testSingUp(String mail, String name, String password, String confirmPassword, String expectedPath) {
        open(BASE_URL.getValue());
        new MainPage(driver)
                .singUp();
        new SingUpPage(driver)
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .setFor(PASSWORD, password)
                .setFor(PASSWORD_CONFIRM, confirmPassword)
                .confirmSingUp(SING_UP_BUTTON)
                .waitSuccessfulRegistrationMsg()
                .checkPath(expectedPath);
    }
}
