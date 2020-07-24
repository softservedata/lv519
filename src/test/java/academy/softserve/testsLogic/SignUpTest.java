package academy.softserve.testsLogic;

import static academy.softserve.constantParameters.BaseLink.BASE_URL;

import academy.softserve.helpers.BaseTest;
import academy.softserve.helpers.ScreenshotCreator;
import academy.softserve.helpers.StaticDataProvider;
import academy.softserve.widgets.MainPage;
import academy.softserve.widgets.SingUpPage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static academy.softserve.constantParameters.SingUpFieldsSelectorsValue.*;


public class SignUpTest extends BaseTest {

    @Test(groups = {"SingInPositive"},dataProvider = "registrationDataProvider",dataProviderClass = StaticDataProvider.class)
    public void testSingUp(String mail, String name, String password, String confirmPassword) {
        open(BASE_URL.getValue());
        new MainPage(driver)
                .singUp();
        new SingUpPage(driver)
                .setFor(EMAIL, mail)
                .setFor(USER_NAME, name)
                .setFor(PASSWORD, password)
                .setFor(PASSWORD_CONFIRM, confirmPassword)
                .confirmSingUp(SING_UP_BUTTON);
        new SingUpPage(driver)
                .textSearch(H1, "Hello!")
                .textSearch(H2, "Please enter your details to sign up")
                .textSearch(SPAN, "Do you already have an account? Sign in")
                .textSearch(SING_IN_LINK, "Sign in");
        new ScreenshotCreator().wait(10);
    }
}
