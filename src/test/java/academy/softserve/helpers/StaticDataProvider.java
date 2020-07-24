package academy.softserve.helpers;

import academy.softserve.constantParameters.SingUpFieldsSelectorsValue;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;

import java.util.*;

public class StaticDataProvider {
    private String getRandom() {
        return String.format("%s, %d", "+", (int) (Math.random() * ((Integer.MAX_VALUE - 1) - 10 + 1) + 1)).replaceAll("\\s+", "").replace("-", "").replace(",", "");
    }

    private final String constRandom() {
        String random = String.format("%s, %d", "+", ((int) System.currentTimeMillis() / 100)).replaceAll("\\s+", "").replace("-", "").replace(",", "");
        return random;
    }

    private List<String> setErrDaa(String errors) {
        String[] expectedDataStringArray = errors.trim().replaceAll("\\s+", "").split(",");
        List<String> errData = Arrays.asList(expectedDataStringArray);
        return errData;
    }

    @BeforeGroups(value = {"ErrorPositive"})
    @DataProvider(name = "ErrorsDataProvider")
    public Object[][] testData() {
        return new Object[][]{
                {"asf", "", "", "",
                        setErrDaa("Please check that your e-mail address is indicated correctly," +
                                "User name is required," +
                                "Password is required, Password is required")},
                {"nagrebetski.p" + getRandom() + "@gmail.com", "", "", "",
                        setErrDaa("User name is required," +
                                "Password is required, Password is required")}
        };
    }

    @BeforeGroups(value = {"SingInPositive"})
    @DataProvider(name = "registrationDataProvider")
    public Object[][] singUpTestData() {
        return new Object[][]{
                {"nagrebetski.p" + getRandom() + "@gmail.com", "Pavel", "1234qwerTY-", "1234qwerTY-"},
                {"nagrebetski.p" + getRandom() + "@gmail.com", "PavelNagrebetskyi", "1234qwerTY-", "1234qwerTY-"},
        };
    }

    @BeforeGroups(value = {"SingInNegative"})
    @DataProvider(name = "emailAlreadyExistDataProvider")
    public Object[][] singUpExistingEmailTestData() {

        return new Object[][]{
                {"nagrebetski.p" + constRandom() + "@gmail.com", "Pavel", "1234qwerTY-", "1234qwerTY-"},
                {"nagrebetski.p" + constRandom() + "@gmail.com", "PavelNagrebetskyi", "1234qwerTY-", "1234qwerTY-"}
        };
    }
}
