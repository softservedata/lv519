package academy.softserve.testsLogic.sing.up;

import academy.softserve.helpers.TestRunnner;
import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.helpers.TestRunnner;
import academy.softserve.widgets.MainPage;
import org.testng.annotations.Test;
import static academy.softserve.constantParameters.sing.up.SelectorsValue.*;
import static academy.softserve.constantParameters.BaseLink.BASE_URL;

public class RedirectTest extends TestRunnner {
    @Test(groups = {"redirect"},dataProvider = "correctSingUp",dataProviderClass = StaticDataProvider.class)
    public void testSingUp(String mail, String name, String password, String expectedPath) {
        open(BASE_URL.getValue());
        new MainPage(driver)
                .singUp()
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .setFor(PASSWORD, password)
                .setFor(PASSWORD_CONFIRM, password)
                .confirmSingUp(SING_UP_BUTTON)
                .waitSuccessfulRegistrationMsg()
                .checkPath(expectedPath);
    }
}