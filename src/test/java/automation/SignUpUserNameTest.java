package automation;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpUserNameTest {

    @DataProvider
    public Object[] userWithoutUserName() {
        return new Object[]{
                UserRepository.getUserWithoutUserName(),
        };
    }

    @Test(dataProvider = "userWithoutUserName")
    @Description("This test case verify that sign up submit button is disable and error message is displayed when data is incorrect")
    public void SignUpUserNameTest(User userWithoutUserName) {
        Message message = new Message();
        BaseClass baseClass = new BaseClass();
        SignUpPage signUpPage = new SignUpPage();

        String actualResult = baseClass
                .openHomePage()
                .clickSignUpButton()
                .signUpWithoutUserName(userWithoutUserName)
                .checkSignUpButtonState()
                .getUserNameRequiredMessage();

        baseClass.waitMethod(10);
        baseClass.afterTest();

        Assert.assertFalse(signUpPage.getSignUpButtonState());
        Assert.assertEquals(actualResult, message.userNameRequiredMessage);

        System.out.println("Button state : " + signUpPage.getSignUpButtonState());
        System.out.println("Actual result : " + actualResult);
        System.out.println("Expected result : " + message.userNameRequiredMessage);
    }

}
