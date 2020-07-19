package task332;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Number {

    private int number;
    private final static String HELLO_MESSAGE = "Enter the number : ";
    private final static String EXCEPTION_MESSAGE = "Incorrect input, please try again";

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static Number read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(HELLO_MESSAGE);
        int number;
        boolean b = true;

        while (b) {
            try {
                number = scanner.nextInt();
                b = false;
                return new Number(number);
            } catch (InputMismatchException exception) {
                System.out.println(EXCEPTION_MESSAGE);
                scanner.nextLine();
            }
        }
        scanner.close();
        return null;
    }

    public static void print (Map<String,Integer> map){
        for (int i = 0; i < 1 ; i++) {
            System.out.println(map.values());
        }
    }
}