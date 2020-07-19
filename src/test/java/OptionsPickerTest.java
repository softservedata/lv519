import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;

public class OptionsPickerTest {
    //  !!! Assert.assertEquals(expected,actual );
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

    @Test(groups = {"returnValue"}, dataProvider = "dataProvider")
    public void canFindTest(int entryData, boolean OneCombination, int x, int y, int z) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData, OneCombination);
        List<CombinationsDTO> expected = new ArrayList<>();
        expected.add(new CombinationsDTO(x, y, z));
        Assert.assertEquals(expected, actual);
    }

    @Test(groups = "noMatches", dataProvider = "NoMatchesDataProvider")
    public void NoMatchesTest(int entryData, boolean OneCombination) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData, OneCombination);
        List<CombinationsDTO> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }

    @Test(groups = "negativeTests", dataProvider = "NegativeDataProvider",
            expectedExceptions = IllegalArgumentException.class)
    @Parameters({"entryData4", "OneCombination"})
    public void testValueNegtive(int entryData, boolean oneCombination) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData, oneCombination);
    }
}