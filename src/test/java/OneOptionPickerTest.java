
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class OneOptionPickerTest {
//  !!! Assert.assertEquals(expected,actual );
@Test
@Parameters({"entryData0","testValueThreeExpX","testValueThreeExpY","testValueThreeExpZ"})
public void testValueThree(String entryData0, String testValueThreeExpX,String testValueThreeExpY,String testValueThreeExpZ) {
    CombinationsPicker picker = new CombinationsPicker();
    System.out.println(Integer.parseInt(entryData0));
    List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData0), true);

    List<CombinationsDTO> expected = new ArrayList<>();
    expected.add(new CombinationsDTO(
            Integer.parseInt(testValueThreeExpX),
            Integer.parseInt(testValueThreeExpY),
            Integer.parseInt(testValueThreeExpZ)));
    Assert.assertEquals(expected,actual);
}
    @Test
    @Parameters( {"entryData1","firstValueNineX","firstValueNineY", "firstValueNineZ"})
    public void testValueNine(String entryData1,String firstValueNineX, String firstValueNineY, String firstValueNineZ) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData1), true);

        List<CombinationsDTO> expected = new ArrayList<>();
        expected.add(new CombinationsDTO(
                Integer.parseInt(firstValueNineX),
                Integer.parseInt(firstValueNineY),
                Integer.parseInt(firstValueNineZ)
        ));
        Assert.assertEquals(actual, expected );
    }


    @Test()
    @Parameters("entryData2")
    public void testValueOne(String entryData2) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData2), true);

        List<CombinationsDTO> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected );
    }
    @Test()
    @Parameters("entryData3")
    public void testValueTwo(String entryData3) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData3), true);

        List<CombinationsDTO> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected );
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    @Parameters("entryData4")
    public void testValueNegtive(String entryData4) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData4), true);

    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    @Parameters("entryData5")
    public void testValueZero(String entryData5) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData5), true);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    @Parameters("entryData6")
    public void testValeUnderMaxInt(String entryData6) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData6), true);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    @Parameters("entryData7")
    public void testValueMin(String entryData7) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData7), true);
    }

}