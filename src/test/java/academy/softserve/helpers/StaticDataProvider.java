package academy.softserve.helpers;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class StaticDataProvider {
    public static List<String> errData;

    static {
        errData = new ArrayList<>();
        errData.add("Please check that your e-mail address is indicated correctly");
        errData.add("User name is required");
        errData.add("Password is required");
        errData.add("Password is required");
    }
    @BeforeGroups(value = {"ErrorPositive"})
    @DataProvider(name = "ErrorsDataProvider")
    public Object[][] testData() {
        return new Object[][]{
                {errData}};
    }
}
