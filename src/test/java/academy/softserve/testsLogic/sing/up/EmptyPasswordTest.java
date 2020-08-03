package academy.softserve.testsLogic.sing.up;

import academy.softserve.helpers.BaseTest;
import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.widgets.MainPage;
import org.testng.annotations.Test;

import java.util.List;

import static academy.softserve.constantParameters.BaseLink.BASE_URL;
import static academy.softserve.constantParameters.sing.up.SelectorsValue.*;

public class EmptyPasswordTest extends BaseTest {
        @Test(groups = {"SingUPNegative"}, dataProvider = "EmptyPasswordDataProvider",dataProviderClass = StaticDataProvider.class)
        public void testSingUp(String mail, String name, String password, String confirmPassword, List<String> expectedErrorMsg) {
            open(BASE_URL.getValue());
            new MainPage(driver)
                    .singUp()
                    .setFor(EMAIL, mail)
                    .setFor(USER_NAME, name)
                    .setFor(PASSWORD, password)
                    .setFor(PASSWORD_CONFIRM, confirmPassword)
                    .assertErrors(expectedErrorMsg)
                    .buttonIsNotActive(SING_UP_BUTTON);
        }
    }
