package academy.softserve.testsLogic;

import academy.softserve.helpers.BaseTest;
import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.widgets.MainPage;
import academy.softserve.widgets.SingUpPage;
import org.testng.annotations.Test;

import java.util.List;

import static academy.softserve.constantParameters.BaseLink.BASE_URL;
import static academy.softserve.constantParameters.SingUpFieldsSelectorsValue.*;
import static academy.softserve.constantParameters.SingUpFieldsSelectorsValue.PASSWORD_CONFIRM;

public class SingUpErrorMsgTest extends BaseTest {
    @Test(groups = {"ErrorPositive"}, dataProvider = "ErrorsDataProvider",dataProviderClass = StaticDataProvider.class)
    public void testErrorMsg(List<String> expectedErrMassage) {
        open(BASE_URL.getValue());
        new MainPage(driver)
                .singUp();
        new SingUpPage(driver)
                .setFor(EMAIL, "asf")
                .setFor(USER_NAME, "")
                .setFor(PASSWORD, "")
                .setFor(PASSWORD_CONFIRM, "")
                .assertErrors(expectedErrMassage);
    }
}
