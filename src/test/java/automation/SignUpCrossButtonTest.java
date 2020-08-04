package automation;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpCrossButtonTest {

    @Test
    @Description("This test case verify that main page is open after click cross button on sign up page")
    public void SignUpCrossButtonTest() {
        BaseClass baseClass = new BaseClass();
        Message message = new Message();

        String actualResult = baseClass
                .openHomePage()
                .clickSignUpButton()
                .clickCrossButton()
                .getMainPageOpenMessage();
        baseClass.afterTest();

        Assert.assertEquals(actualResult, message.mainPageOpenMessage);

        System.out.println("Actual result : " + actualResult);
        System.out.println("Expected result : " + message.mainPageOpenMessage);
    }

}
