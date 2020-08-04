package academy.softserve.testsLogic.sing.up;

import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.helpers.TestRunner;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static academy.softserve.constantParameters.BaseLink.BASE_URL;
import static academy.softserve.constantParameters.sing.up.SelectorsValue.*;


public class ToLongNameTest extends TestRunner {
    @Test(groups = {"SingUpNameNegative"},dataProvider = "overheadUsernameDataProvider",dataProviderClass = StaticDataProvider.class)
    @Description("Trying to send too long name and register")
    public void singUp(String mail, String name, String password){
        open(BASE_URL.getValue())
                .singUp()
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .verifyContentSize(20,USER_NAME)
                .setFor(PASSWORD, password)
                .setFor(PASSWORD_CONFIRM, password)
                .confirmSingUp(SING_UP_BUTTON)
                .waitSuccessfulRegistrationMsg();
    }
}
