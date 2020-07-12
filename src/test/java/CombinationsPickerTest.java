import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CombinationsPickerTest {

    @Test
    public void iSNaturalNum() {
        CombinationsPicker testPicker = new CombinationsPicker();
        testPicker.iSNaturalNum(9);
        int[][] expected = new int[][]
                {
                        {1, 2, 2},
                        {2, 1, 2},
                        {2, 2, 1}
                };

        int[][] actual = new int[][]
                {
                        testPicker.getValues().get(0),
                        testPicker.getValues().get(1),
                        testPicker.getValues().get(2)
                };
        Assert.assertArrayEquals(expected,actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void iSNaturalNumMegative () {
        CombinationsPicker testPicker = new CombinationsPicker();
        testPicker.iSNaturalNum(-9);
        int[][] expected = new int[][]
                {
                        {1, 2, 2},
                        {2, 1, 2},
                        {2, 2, 1}
                };

        int[][] actual = new int[][]
                {
                        testPicker.getValues().get(0),
                        testPicker.getValues().get(1),
                        testPicker.getValues().get(2)
                };
        Assert.assertArrayEquals(expected,actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void iSNaturalNumMegativeZero () {
        CombinationsPicker testPicker = new CombinationsPicker();
        testPicker.iSNaturalNum(-0);
        int[][] expected = new int[][]
                {
                        {1, 2, 2},
                        {2, 1, 2},
                        {2, 2, 1}
                };

        int[][] actual = new int[][]
                {
                        testPicker.getValues().get(0),
                        testPicker.getValues().get(1),
                        testPicker.getValues().get(2)
                };
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void displayOptions() {
        String consoleOutput =null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(200);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);

            CombinationsPicker testPicker = new CombinationsPicker();
            testPicker.iSNaturalNum(9);
            testPicker.displayOptions(true);

            capture.flush();
            consoleOutput = outputStream.toString();
            System.setOut(originalOut);
        }catch (Exception e){
            e.printStackTrace();
        }
        String expResult = "x = 1 \ty = 2 \tz = 2";
        assertEquals(expResult.trim(),consoleOutput.trim());
    }

    @Test
    public void displayOptionsFalse() {
        String consoleOutput =null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(200);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);

            CombinationsPicker testPicker = new CombinationsPicker();
            testPicker.iSNaturalNum(9);
            testPicker.displayOptions(false);

            capture.flush();
            consoleOutput = outputStream.toString();
            System.setOut(originalOut);
        }catch (Exception e){
            e.printStackTrace();
        }
        String expResults = "x = 1 \ty = 2 \tz = 2 \n" +
                "x = 2 \ty = 1 \tz = 2 \n" +
                "x = 2 \ty = 2 \tz = 1 ";
        assertEquals(expResults.trim().toLowerCase(),consoleOutput.trim().toLowerCase());
    }
}