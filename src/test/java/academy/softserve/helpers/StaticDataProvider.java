package academy.softserve.helpers;

import io.qameta.allure.Step;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;

import java.util.*;

/**
 * Class should provide variables for all tests
 */
public class StaticDataProvider {
    /*DATA PROVIDERS*/
    @BeforeGroups(value = {"SmokeSingUp"})
    @DataProvider(name = "registrationDataProvider")
    public Object[][] smokeTestDataProvider() {
        return new Object[][]{
                {"greencitypavel" + getRandom() + "@gmail.com", "Pavel", "1234qwerTY-", "1234qwerTY-",
                        "greencitypavel@gmail.com", "1234qwerTY-", 1, "Verify Email"},
//  {"greencitypavel" + getRandom() + "@gmail.com", "PavelNagrebetskyi", "1234qwerTY-", "1234qwerTY-","greencitypavel@gmail.com","1234qwerTY-",1,"Verify Email"}
        };
    }

    @BeforeGroups(value = {"redirect"})
    @DataProvider(name = "correctSingUp")
    public Object[][] SingUpRedirectDataProvider() {
        return new Object[][]{
                {"greencitypavel" + getRandom() + "@gmail.com", "nagrebetskiPavel1234", "1234qwerTY-", "1234qwerTY-", "https://ita-social-projects.github.io/GreenCityClient/#/profile"},
                {"greencitypavel" + getRandom() + "@gmail.com", "nagrebetskiPavel1234", "1234qwerTY-", "1234qwerTY-", "https://ita-social-projects.github.io/GreenCityClient/#/welcome"}
        };
    }

    @BeforeGroups(value = {"SingUPNegative"})
    @DataProvider(name = "emailAlreadyExistDataProvider")
    public Object[][] singUpMailExistDataProvider() {
        return new Object[][]{
                {"greencitypavel" + getStaticRandom() + "@gmail.com", "Pavel", "1234qwerTY-", "1234qwerTY-",
                        setErrData("The user already exists by this email"),
                        "greencitypavel@gmail.com", "1234qwerTY-", 1, "Verify Email"}
        };
    }

    @BeforeGroups(value = {"SingUPNegative"})
    @DataProvider(name = "EmptyPasswordDataProvider")
    public Object[][] singUpEmptyPasswordDataProvider() {
        return new Object[][]{
                {"greencitypavel" + getStaticRandom() + "@gmail.com", "Pavel", "", "1234qwerTY-",
                        setErrData("Password is required")},
        };
    }

    @BeforeGroups(value = {"SingUpNameNegative"})
    @DataProvider(name = "overheadUsernameDataProvider")
    public Object[][] toLingUserName() {
        return new Object[][]{
                {"greencitypavel" + getRandom() + "@gmail.com", "nagrebetskiPavel1234", "1234qwerTY-", "1234qwerTY-"},
                {"greencitypavel" + getRandom() + "@gmail.com", "nagrebetskiPavel234+123456798", "1234qwerTY-", "1234qwerTY-"}
        };
    }

    @BeforeGroups(value = {"ErrorPositive"})
    @DataProvider(name = "ErrorsDataProvider")
    public Object[][] testData() {
        return new Object[][]{
                {"asf", "", "", "",
                        setErrData("Please check that your e-mail address is indicated correctly," +
                                "User name is required," +
                                "Password is required, Password is required")},
                {"greencitypavel" + getRandom() + "@gmail.com", "", "", "",
                        setErrData("User name is required," +
                                "Password is required, Password is required")}
        };
    }
    /*SETUP*/

    @Step("get random int")
    private String getRandom() {
        return String.format("%s, %d", "+", (int) (Math.random() * ((Integer.MAX_VALUE - 1) - 10 + 1) + 1))
                .replaceAll("\\s+", "")
                .replace("-", "")
                .replace(",", "");
    }

    @Step("get random int, const in test method scope")
    private String getStaticRandom() {
        return String.format("%s, %d", "+", ((int) System.currentTimeMillis() / 100))
                .replaceAll("\\s+", "")
                .replace("-", "")
                .replace(",", "");
    }

    @Step("set expected errors")
    private List<String> setErrData(String errors) {
        String[] expectedDataStringArray = errors.trim().replaceAll("\\s+", "").split(",");
        return Arrays.asList(expectedDataStringArray);
    }
}