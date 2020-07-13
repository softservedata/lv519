import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AllOptionsPickerTest {

    @Test
    public void testValueThree() {
         CombinationsPicker picker = new CombinationsPicker();
         List<CombinationsDTO> actual = picker.findCombinations(3,false);
         List<CombinationsDTO> expected = new ArrayList<>();
         expected.add(new CombinationsDTO(1,1,1));
         Assert.assertEquals(expected,actual);
    }
    @Test
    public void testValueNine() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(9,false);
        List<CombinationsDTO> expected = new ArrayList<>();
        expected.add(new CombinationsDTO(1,2,2));
        expected.add(new CombinationsDTO(2,1,2));
        expected.add(new CombinationsDTO(2,2,1));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testNoMatchesValueOne() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(1,false);
        List<CombinationsDTO> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testNoMatchesValueTwo() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(2,false);
        List<CombinationsDTO> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueNegative() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(-1,false);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testValueZero() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(0,false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOverMaxValue() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.MAX_VALUE+1,false);
    }
    @Test(expected = IllegalArgumentException.class)
    public void tesIntegerMin() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.MIN_VALUE,false);
    }


}