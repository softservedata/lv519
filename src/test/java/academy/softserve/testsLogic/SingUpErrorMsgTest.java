package academy.softserve.testsLogic;

import academy.softserve.constantParameters.SingUpFieldsSelectorsValue;
import academy.softserve.helpers.BaseTest;
import academy.softserve.helpers.ScreenshotCreator;
import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.widgets.MainPage;
import academy.softserve.widgets.SingUpPage;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

import static academy.softserve.constantParameters.BaseLink.BASE_URL;
import static academy.softserve.constantParameters.SingUpFieldsSelectorsValue.*;


public class SingUpErrorMsgTest extends BaseTest {
    @Test(groups = {"ErrorPositive"}, dataProvider = "ErrorsDataProvider",dataProviderClass = StaticDataProvider.class)
    public void testErrorMsg(String mail, String name, String password, String confirmPassword, List<String> expectedErrMassage) {
        open(BASE_URL.getValue());
        new MainPage(driver)
                .singUp();
        new SingUpPage(driver)
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .setFor(PASSWORD, password)
                .setFor(PASSWORD_CONFIRM, confirmPassword)
                .assertErrors(expectedErrMassage);
        new ScreenshotCreator().wait(10);
    }
}
