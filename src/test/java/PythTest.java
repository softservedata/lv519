import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PythTest {

    @Test
    public void checkNaturalNum() {
        Pyth calc = new Pyth();
        List<PythTrianglDTO> actual = calc.iSNaturalNum(15);
        List<PythTrianglDTO> expected = new ArrayList<>();
        expected.add(new PythTrianglDTO(3, 4, 5));
        expected.add(new PythTrianglDTO(6, 8, 10));
        expected.add(new PythTrianglDTO(5, 12, 13));
        expected.add(new PythTrianglDTO(9, 12, 15));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkNumFive() {
        Pyth calc = new Pyth();
        List<PythTrianglDTO> actual = calc.iSNaturalNum(5);
        List<PythTrianglDTO> expected = new ArrayList<>();
        expected.add(new PythTrianglDTO(3, 4, 5));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkNumOne() {
        Pyth calc = new Pyth();
        List<PythTrianglDTO> actual = calc.iSNaturalNum(1);
        List<PythTrianglDTO> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }
//to do add 2 and 3
    @Test
    public void checkNumFour() {
        Pyth calc = new Pyth();
        List<PythTrianglDTO> actual = calc.iSNaturalNum(4);
        List<PythTrianglDTO> expected = new ArrayList<>();
        Assert.assertEquals(expected, actual);
    }



    @Test(expected = IllegalArgumentException.class)
    public void checkNegativeNum() {
        Pyth calc = new Pyth();
        List<PythTrianglDTO> actual = calc.iSNaturalNum(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkZeroNum() {
        Pyth calc = new Pyth();
        List<PythTrianglDTO> actual = calc.iSNaturalNum(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMaxNum() {
        Pyth calc = new Pyth();
        List<PythTrianglDTO> actual = calc.iSNaturalNum(Integer.MAX_VALUE+1);
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

    @Test()
    public void iSNaturalNumZero() {
        String consoleOutput =null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(200);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);
            Pyth calc = new Pyth();
            calc.iSNaturalNum(0);
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