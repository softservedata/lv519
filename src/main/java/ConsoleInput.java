import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput {
    int intInput() {
        Scanner in = new Scanner(System.in);
        int n = 0;
        try {
            n = in.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("please chose integer value");
            intInput();
        }
        in.close();
        return n;
    }
}
