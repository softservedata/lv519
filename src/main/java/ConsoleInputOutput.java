import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputOutput {
    int intInput() {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while (n<=0){
        try {
            System.out.println("a*a + b*b = c*c a <= b <= c <= n, please enter n to find all a,b,c");
            n = in.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("please chose integer value");
            intInput();
        }}
        in.close();
        return n;
    }

    public void printValues(List<PythagoreanTripleDTO> values) {
        if (values.isEmpty()) {
            System.out.println("No matches");
        } else {
            for (PythagoreanTripleDTO value : values) {
                System.out.printf("a = %d \t", value.getA());
                System.out.printf("b = %d \t", value.getB());
                System.out.printf("c = %d \n", value.getC());
            }
        }
    }

}
