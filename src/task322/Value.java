package task322;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Value {

    private int start;
    private int end;
    private final static String START_MESSAGE = "Enter start : ";
    private final static String END_MESSAGE = "Enter end : ";
    private final static String EXCEPTION_MESSAGE = "Incorrect input, please try again";
    private final static String MAX_NUMBER = "Number : ";
    private final static String DIVIDER_COUNT = "Dividers : ";

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Value(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static Value read(){

        Scanner scanner = new Scanner(System.in);
        int start;
        int end;
        boolean b = true;

        while (b) {
            try {
                System.out.println(START_MESSAGE);
                start = scanner.nextInt();
                System.out.println(END_MESSAGE);
                end = scanner.nextInt();
                b = false;
                return new Value(start,end);
            } catch (InputMismatchException exception) {
                System.out.println(EXCEPTION_MESSAGE);
                scanner.nextLine();
            }
        }
        scanner.close();
        return null;
    }


    public static void print(Map<String, Integer> map){
        System.out.println(MAX_NUMBER+map.get("Max_number"));
        System.out.println(DIVIDER_COUNT+map.get("Max_k"));
    }
}
