import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AllOptionsPickerTest {
/*        <parameter name =  "entryData1" value="*9"/>
        <parameter name =  "entryData2" value="1"/>
        <parameter name =  "entryData3" value="2"/>
        <parameter name =  "entryData4" value="-1"/>
        <parameter name =  "entryData5" value="0"/>*/
    @Test
    @Parameters("entryData1")
        public void testValueThree(int entryData1) {
            CombinationsPicker picker = new CombinationsPicker();
            List<CombinationsDTO> actual = picker.findCombinations(entryData1, false);

         List<CombinationsDTO> expected = new ArrayList<>();
         expected.add(new CombinationsDTO(1,1,1));
         Assert.assertEquals(expected,actual);
    }
    @Test
    @Parameters("entryData2")
    public void testValueThree(int entryData2) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData2, false);

        List<CombinationsDTO> expected = new ArrayList<>();
        expected.add(new CombinationsDTO(1,2,2));
        expected.add(new CombinationsDTO(2,1,2));
        expected.add(new CombinationsDTO(2,2,1));
        Assert.assertEquals(actual, expected );
    }


    @Test
    @Parameters("entryData2")
    public void testValueThree(int entryData2) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData2, false);

        List<CombinationsDTO> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected );
    }
    @Test
    @Parameters("entryData3")
    public void testValueThree(int entryData3) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData3, false);

        List<CombinationsDTO> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected );
    }


    @Test
    @Parameters("entryData4")
    public void testValueThree(int entryData4) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData4, false);

    }
    @Test
    @Parameters("entryData5")
    public void testValueThree(int entryData5) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData5, false);
    }

    @Test
    @Parameters("entryData6")
    public void testValueThree(int entryData6) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData6, false);
    }
    @Test
    @Parameters("entryData7")
    public void testValueThree(int entryData7) {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(entryData7, false);
    }


}