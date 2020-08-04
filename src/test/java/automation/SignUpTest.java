package automation;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpTest {

    @DataProvider
    public Object[] userWithIncorrectConfirmPassword() {
        return new Object[]{
                UserRepository.getUserWithIncorrectConfirmPassword(),
        };
    }

    @Test(dataProvider = "userWithIncorrectConfirmPassword")
    @Description("This test case verify that sign up submit button is disable and error message is displayed when data is incorrect")
    public void SignUpTest(User userWithIncorrectConfirmPassword) {
        Message message = new Message();
        BaseClass baseClass = new BaseClass();
        SignUpPage signUpPage = new SignUpPage();

        String actualResult = baseClass
                .openHomePage()
                .clickSignUpButton()
                .sighUpWithIncorrectConfirmPassword(userWithIncorrectConfirmPassword)
                .checkSignUpButtonState()
                .getPasswordDoNotMatchMessage();

        baseClass.waitMethod(10);
        baseClass.afterTest();

        Assert.assertFalse(signUpPage.getSignUpButtonState());
        Assert.assertEquals(actualResult, message.passwordsDoNotMatchMessage);

        System.out.println("Button state : " + signUpPage.getSignUpButtonState());
        System.out.println("Actual result : " + actualResult);
        System.out.println("Expected result : " + message.passwordsDoNotMatchMessage);
    }

}
