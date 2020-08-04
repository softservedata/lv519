package conf;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StaticDataProvider {

    @BeforeGroups(value = {"returnValue"})
    @DataProvider(name = "dataProvider")
    public Object[][] testData() {
        return new Object[][]{
                {3, true, 1, 1, 1},
                {9, true, 1, 2, 2}};
    }

    @BeforeGroups(value = {"noMatches"})
    @DataProvider(name = "NoMatchesDataProvider")
    public Object[][] NoMatchesData() {
        return new Object[][]{{1, true}, {2, true}};
    }

    @BeforeGroups(value = {"negativeTests"})
    @DataProvider(name = "NegativeDataProvider")
    public Object[][] NegativeData() {
        return new Object[][]{{-1, true}, {-2, true}, {0, true}, {Integer.MAX_VALUE + 1, true}, {Integer.MIN_VALUE, true}};
    }


    @BeforeGroups(value = {"returnMultiValues"})
    @DataProvider(name = "multiDataProvider")
    public Object[][] testMultiData() {
        return new Object[][]{
                {3, false,setData("1,1,1" )},
                {9, false,setData("1,2,2, 2,1,2, 2,2,1" )}
        };
    }

    @BeforeGroups(value = {"noMatches"})
    @DataProvider(name = "invalidMultiDataProvider")
    public Object[][] invalidDataProvider() {
        return new Object[][]{{1, false}, {2, false}};
    }

    private List<Integer> setData(String data) {
        String[] expectedDataStringArray = data.trim().replaceAll("\\s+", "").split(",");
        List<Integer> intExpect = Arrays.asList(expectedDataStringArray)
                .stream()
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
            return intExpect;
    }


    @BeforeGroups(value = {"negativeTests"})
    @DataProvider(name = "NegativeMultiDataProvider")
    public Object[][] NegativeMultiData() {
        return new Object[][]{{-1, false}, {-2, false}, {0, false}, {Integer.MAX_VALUE + 1, false}, {Integer.MIN_VALUE, false}};
    }
}
