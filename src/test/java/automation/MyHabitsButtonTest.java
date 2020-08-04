package automation;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyHabitsButtonTest {

    @Test
    @Description("This test case verify that sign in page is open after click on 'My Habit' button")
    public void SignInPageTest() {
        BaseClass baseClass = new BaseClass();
        Message message = new Message();

        String actualResult = baseClass
                .openHomePage()
                .clickMyHabitButton()
                .getSignInPageOpenMessage();
        baseClass.afterTest();

        Assert.assertNotEquals(actualResult, message.signUpPageOpenMessage);
    }
}
