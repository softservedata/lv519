package academy.softserve.testsLogic.sing.up;

import academy.softserve.helpers.BaseTest;
import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.widgets.MainPage;
import academy.softserve.widgets.SingUpPage;
import org.testng.annotations.Test;
import static academy.softserve.constantParameters.sing.up.SelectorsValue.*;
import static academy.softserve.constantParameters.BaseLink.BASE_URL;


public class ToLongNameTest extends BaseTest {
    @Test(groups = {"SingUpNameNegative"},dataProvider = "overheadUsernameDataProvider",dataProviderClass = StaticDataProvider.class)
    public void singUp(String mail, String name, String password, String confirmPassword){
        open(BASE_URL.getValue());
        new MainPage(driver)
                .singUp();
        new SingUpPage(driver)
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .checkContentSize(USER_NAME,20)
                .setFor(PASSWORD, password)
                .setFor(PASSWORD_CONFIRM, confirmPassword)
                .confirmSingUp(SING_UP_BUTTON)
                .waitSuccessfulRegistrationMsg();
    }
}
