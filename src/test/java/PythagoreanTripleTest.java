import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PythagoreanTripleTest {

    @BeforeGroups(value = {"returnValue"})
    @DataProvider(name = "dataProvider")
    public Object[][] testData() {
        return new Object[][]{{15,
                "3, 4, 5, 6, 8, 10, 5, 12, 13, 9, 12, 15"}, {20, "3, 4, 5, 6, 8, 10, 5, 12, 13, 9, 12, 15, 8, 15, 17, 12, 16, 20"}};
    }

    @BeforeGroups(value = "noMatches")
    @DataProvider(name = "NoMatchesDataProvider")
    public Object[][] NoMatchesData() {
        return new Object[][]{{1}, {2}, {3}, {4}};
    }

    @BeforeGroups(value = "negativeTests")
    @DataProvider(name = "NegativeDataProvider")
    public Object[][] NegativeData() {
        return new Object[][]{{-1}, {0}, {Integer.MAX_VALUE + 1}, {Integer.MIN_VALUE}};
    }


    @Test(groups = {"returnValue"}, dataProvider = "dataProvider")
    public void canFindTestV(int entryData, String expResultData) {
        String[] expectedDataStringArray = expResultData.trim().replaceAll("\\s+","").split(",");
        int[] expectedDataArray = new int[expectedDataStringArray.length];
        for (int i = 0; i < expectedDataStringArray.length; i++) {
            try {
                expectedDataArray[i] = Integer.parseInt(expectedDataStringArray[i]);
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(entryData);
        List<PythagoreanTripleDTO> expected = new ArrayList<>();
        for (int i = 0; i < expectedDataArray.length; i += 3) {
            expected.add(new PythagoreanTripleDTO(expectedDataArray[i], expectedDataArray[i + 1], expectedDataArray[i + 2]));
        }
        Assert.assertEquals(expected, actual);
    }

    @Test(groups = {"noMatches"}, dataProvider = "NoMatchesDataProvider")
    public void checkNumOne(int entryData) {
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(entryData);
        List<PythagoreanTripleDTO> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }

    @Test(groups = "negativeTests", dataProvider = "NegativeDataProvider",
            expectedExceptions = IllegalArgumentException.class)
    public void NegativeTest(int entryData) {
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(entryData);
    }
}