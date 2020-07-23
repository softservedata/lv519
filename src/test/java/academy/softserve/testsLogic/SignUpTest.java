package academy.softserve.testsLogic;

import static academy.softserve.constantParameters.BaseLink.BASE_URL;

import academy.softserve.constantParameters.BaseLink;
import academy.softserve.helpers.BaseTest;
import academy.softserve.widgets.MainPage;
import academy.softserve.widgets.SingUpPage;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static academy.softserve.constantParameters.SingUpFieldsSelectorsValue.*;


public class SignUpTest extends BaseTest {


    @Test(groups = {"SingInPositive"})
    public void testSingUp() {
        open(BASE_URL.getValue());
        new MainPage(driver)
                .singUp();
        new SingUpPage(driver)
                .setFor(EMAIL, "nagrebetski.p" + random + "@gmail.com")
                .setFor(USER_NAME, "Pavel")
                .setFor(PASSWORD, "1234qwerTY-")
                .setFor(PASSWORD_CONFIRM, "1234qwerTY-")
                .confirmSingUp(SING_UP_BUTTON);
        new SingUpPage(driver)
                .textSearch(H1, "Hello!")
                .textSearch(H2, "Please enter your details to sign up")
                .textSearch(SPAN, "Do you already have an account? Sign in")
                .textSearch(SING_IN_LINK, "Sign in");
    }
}
