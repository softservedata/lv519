import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PythagoreanTripleTest {
    @BeforeGroups(value = {"returnValue"})
    @DataProvider(name = "dataProvider")
    public Object[][] testData() {
        return new Object[][]{{15, 3, 4, 5, 6, 8, 10, 5, 12, 13, 9, 12, 15}};
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
    @Parameters({"entryData", "a", "b", "c"})
    public void canFindTest(int entryData, int a0, int b0, int c0,int a1, int b1, int c1,int a2, int b2, int c2,int a3, int b3, int c3) {
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(entryData);
        List<PythagoreanTripleDTO> expected = new ArrayList<>();
        expected.add(new PythagoreanTripleDTO(a0, b0, c0));
        expected.add(new PythagoreanTripleDTO(a1, b1, c1));
        expected.add(new PythagoreanTripleDTO(a2, b2, c2));
        expected.add(new PythagoreanTripleDTO(a3, b3, c3));
        Assert.assertEquals(expected, actual);
    }

    @Test(groups = {"noMatches"}, dataProvider = "NoMatchesDataProvider")
    @Parameters({"entryData"})
    public void checkNumOne(int entryData) {
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(entryData);
        List<PythagoreanTripleDTO> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }

    @Test(groups = "negativeTests", dataProvider = "NegativeDataProvider",
            expectedExceptions = IllegalArgumentException.class)
    @Parameters({"entryData"})
    public void NegativeTest(int entryData) {
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(entryData);
    }
}