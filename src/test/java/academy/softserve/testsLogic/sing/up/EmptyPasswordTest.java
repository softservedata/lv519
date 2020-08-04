package academy.softserve.testsLogic.sing.up;


import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.helpers.TestRunner;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.List;

import static academy.softserve.constantParameters.BaseLink.BASE_URL;
import static academy.softserve.constantParameters.sing.up.SelectorsValue.*;

public class EmptyPasswordTest extends TestRunner {
    @Test(groups = {"SingUPNegative"}, dataProvider = "EmptyPasswordDataProvider", dataProviderClass = StaticDataProvider.class)
    @Description("Sending empty string in the password field")
    public void testSingUp(String mail, String name, String password, String confirmPassword, List<String> expectedErrorMsg) {
        open(BASE_URL.getValue())
                .singUp()
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .setFor(PASSWORD, password)
                .setFor(PASSWORD_CONFIRM, confirmPassword)
                .assertErrors(2, expectedErrorMsg)
                .buttonIsNotActive(SING_UP_BUTTON);
    }

    @Test(groups = {"SingUPNegative"}, dataProvider = "EmptyPasswordDataProviderWithoutFocus", dataProviderClass = StaticDataProvider.class)
    @Description("Didn't touch password field at all")
    public void testSingUpWithoutFocusOnPassword(String mail, String name, String password, List<String> expectedErrorMsg) {
        open(BASE_URL.getValue())
                .singUp()
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .setFor(PASSWORD_CONFIRM, password)
                .assertErrors(2, expectedErrorMsg)
                .buttonIsNotActive(SING_UP_BUTTON);
    }
}
