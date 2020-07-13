import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.List;

public class PythagoreanTripleTest {
    @Rule
    public TestRule timeout = new Timeout(100);


    @Test
    public void checkNaturalNum() {
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(15);
        List<PythagoreanTripleDTO> expected = new ArrayList<>();
        expected.add(new PythagoreanTripleDTO(3, 4, 5));
        expected.add(new PythagoreanTripleDTO(6, 8, 10));
        expected.add(new PythagoreanTripleDTO(5, 12, 13));
        expected.add(new PythagoreanTripleDTO(9, 12, 15));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkNumFive() {
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(5);
        List<PythagoreanTripleDTO> expected = new ArrayList<>();
        expected.add(new PythagoreanTripleDTO(3, 4, 5));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkNumOne() {
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(1);
        List<PythagoreanTripleDTO> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void checkNumTwo() {
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(1);
        List<PythagoreanTripleDTO> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void checkNumThree() {
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(1);
        List<PythagoreanTripleDTO> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }
//to do add 2 and 3
    @Test
    public void checkNumFour() {
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(4);
        List<PythagoreanTripleDTO> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }



    @Test(expected = IllegalArgumentException.class)
    public void checkNegativeNum() {
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkZeroNum() {
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMaxNum() {
        PythagoreanTriple calc = new PythagoreanTriple();
        List<PythagoreanTripleDTO> actual = calc.findAllOptions(Integer.MAX_VALUE+1);
    }
/*-
    @Test()
    public void iSNaturalNumNegative() {
        String consoleOutput =null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(200);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);
            Pyth calc = new Pyth();
            in.printValues(calc.iSNaturalNum(-15));
            capture.flush();
            consoleOutput = outputStream.toString();
            System.setOut(originalOut);
        }catch (Exception e){
            e.printStackTrace();
        }
        String expected = "Please chose natural number";
        assertEquals(expected.trim(),consoleOutput.trim());
    }
    */
}