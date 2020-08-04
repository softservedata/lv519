import conf.StaticDataProvider;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MultiOptionsPickerTest {
    @Test(groups = {"returnMultiValues"}, dataProvider = "multiDataProvider",dataProviderClass = StaticDataProvider.class)
    public void FindMultiDataTest(int entryData, boolean OneCombination, List<Integer> setData) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData, OneCombination);
        List<CombinationsDTO> expected = new ArrayList<>();
        for (int i = 0; i < setData.size(); i += 3) {
            expected.add(new CombinationsDTO(setData.get(i), setData.get(i+1), setData.get(i+2)));
        }
        Assert.assertEquals(expected, actual);
    }

    @Test(groups = "noMatches", dataProvider = "invalidMultiDataProvider",dataProviderClass = StaticDataProvider.class)
    public void NoMatchesTest(int entryData, boolean OneCombination) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData, OneCombination);
        List<CombinationsDTO> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }

    @Test(groups = "negativeTests", dataProvider = "NegativeMultiDataProvider",dataProviderClass = StaticDataProvider.class,
            expectedExceptions = IllegalArgumentException.class)
    @Parameters({"entryData4", "OneCombination"})
    public void testValueNegtive(int entryData, boolean oneCombination) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData, oneCombination);
    }

}
