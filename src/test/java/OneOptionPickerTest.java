
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class OneOptionPickerTest {
//  !!! Assert.assertEquals(actual, expected );
    @Test
    public void testValueThree() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(3,true);
        List<CombinationsDTO> expected = new ArrayList<>();
        expected.add(new CombinationsDTO(1,1,1));
        Assert.assertEquals(actual, expected );
    }

    @Test
    public void testValueNine() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(9,true);
        List<CombinationsDTO> expected = new ArrayList<>();
        expected.add(new CombinationsDTO(1,2,2));
        Assert.assertEquals(actual, expected );
    }

    @Test
    public void testNoMatchesValueOne() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(1,true);
        List<CombinationsDTO> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected );
    }

    @Test
    public void testNoMatchesValuTwo() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(2,true);
        List<CombinationsDTO> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testValueNegative() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(-1,true);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testValueZero() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(0,true);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testOverMaxValue() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.MAX_VALUE+1,true);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void tesIntegerMin() {
        CombinationsPicker picker = new CombinationsPicker();
        List<CombinationsDTO> actual = picker.findCombinations(Integer.MIN_VALUE,true);
    }

}