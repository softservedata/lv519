import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputOutput {

    int intInput() {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while (n <= 0) {
            try {
                System.out.println("please chose integer positive number");
                n = in.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("please chose integer value");
                intInput();
            }
        }
        in.close();
        return n;
    }

    public void printCombinations(List<CombinationsDTO> values) {
        if (values.isEmpty()) {
            System.out.println("No matches");
        } else {
            for (CombinationsDTO value : values) {
                System.out.printf("x = %d\t", value.getX());
                System.out.printf("y = %d\t", value.getY());
                System.out.printf("z = %d\n", value.getZ());
            }
        }
    }
}
