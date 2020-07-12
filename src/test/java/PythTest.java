import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PythTest {

    @Test
    public void iSNaturalNum() {
        Pyth calc = new Pyth();
        calc.iSNaturalNum(15);
        int[][] expected = new int[][]
                {
                        {3, 4, 5},
                        {6, 8, 10},
                        {5, 12, 13},
                        {9, 12, 15}
                };

        int[][] actual = new int[][]
                {
                        calc.getValues().get(0),
                        calc.getValues().get(1),
                        calc.getValues().get(2),
                        calc.getValues().get(3)
                };
        Assert.assertArrayEquals(expected,actual);
    }

    @Test()
    public void iSNaturalNumNegative() {
        String consoleOutput =null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(200);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);
            Pyth calc = new Pyth();
            calc.iSNaturalNum(-15);
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
}