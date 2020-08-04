import conf.StaticDataProvider;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;

public class OptionsPickerTest {
    //  !!! Assert.assertEquals(expected,actual );


    @Test(groups = {"returnValue"}, dataProvider = "dataProvider",dataProviderClass = StaticDataProvider.class)
    public void canFindTest(int entryData, boolean OneCombination, int x, int y, int z) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData, OneCombination);
        List<CombinationsDTO> expected = new ArrayList<>();
        expected.add(new CombinationsDTO(x, y, z));
        Assert.assertEquals(expected, actual);
    }

    @Test(groups = "noMatches", dataProvider = "NoMatchesDataProvider",dataProviderClass = StaticDataProvider.class)
    public void NoMatchesTest(int entryData, boolean OneCombination) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData, OneCombination);
        List<CombinationsDTO> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }

    @Test(groups = "negativeTests", dataProvider = "NegativeDataProvider",dataProviderClass = StaticDataProvider.class,
            expectedExceptions = IllegalArgumentException.class)
    @Parameters({"entryData4", "OneCombination"})
    public void testValueNegtive(int entryData, boolean oneCombination) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData, oneCombination);
    }
}