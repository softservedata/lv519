package academy.softserve.testsLogic.sing.up;

import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.helpers.TestRunner;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static academy.softserve.constantParameters.BaseLink.BASE_URL;
import static academy.softserve.constantParameters.sing.up.SelectorsValue.*;

public class RedirectTest extends TestRunner {
    @Test(groups = {"redirect"},dataProvider = "RedirectTestDataProvider",dataProviderClass = StaticDataProvider.class)
    @Description("Making successful registration, waited until successful registration pop-up disappears and compare actual vs expected path")
    public void testSingUp(String mail, String name, String password, String expectedPath) {
        open(BASE_URL.getValue())
                .singUp()
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .setFor(PASSWORD, password)
                .setFor(PASSWORD_CONFIRM, password)
                .confirmSingUp(SING_UP_BUTTON)
                .waitSuccessfulRegistrationMsg()
                .waitSuccessfulRegistrationMsgInvisible()
                .verifyPath(expectedPath);
    }
}