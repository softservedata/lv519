import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AllOptionsPickerTest {
    @Test
    @Parameters("entryData0")
        public void testValueThree(String entryData0) {
            CombinationsPicker picker = new CombinationsPicker();
        System.out.println(Integer.parseInt(entryData0));
            List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData0), false);

         List<CombinationsDTO> expected = new ArrayList<>();
         expected.add(new CombinationsDTO(1,1,1));
         Assert.assertEquals(expected,actual);
    }
    @Test
    @Parameters("entryData1")
    public void testValueNine(String entryData1) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData1), false);

        List<CombinationsDTO> expected = new ArrayList<>();
        expected.add(new CombinationsDTO(1,2,2));
        expected.add(new CombinationsDTO(2,1,2));
        expected.add(new CombinationsDTO(2,2,1));
        Assert.assertEquals(actual, expected );
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    @Parameters("entryData2")
    public void testValueOne(String entryData2) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData2), false);

        List<CombinationsDTO> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected );
    }
    @Test()
    @Parameters("entryData3")
    public void testValueTwo(String entryData3) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData3), false);

        List<CombinationsDTO> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected );
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    @Parameters("entryData4")
    public void testValueNegtive(String entryData4) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData4), false);

    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    @Parameters("entryData5")
    public void testValueZero(String entryData5) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData5), false);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    @Parameters("entryData6")
    public void testValeUnderMaxInt(String entryData6) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData6), false);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    @Parameters("entryData7")
    public void testValueMin(String entryData7) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.parseInt(entryData7), false);
    }


}