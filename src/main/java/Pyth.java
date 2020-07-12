import java.util.ArrayList;
import java.util.List;

public class Pyth {
    private static List<int[]> values = new ArrayList<>();

    public static List<int[]> getValues() {
        return values;
    }

    public void iSNaturalNum(int n) {

        if (n > 0) {
            findPossibleValues(n);
            printValues();
        } else {
            System.out.println("Please chose natural number");
        }

    }

    private void findPossibleValues(int n) {
        int a;
        int b;
        int c;
        for (c = 0; c <= n; c++) {
            for (b = 0; b <= c; b++) {
                for (a = 0; a <= b; a++) {
                    if ((a * a + b * b == c * c) && (a != 0 && b != 0 && c != 0)) {
                        values.add(new int[]{a, b, c});
                    }
                }
            }
        }


    }

    private void printValues() {
        for (int[] value : values) {
            System.out.printf("a = %d \t", value[0]);
            System.out.printf("b = %d \t", value[1]);
            System.out.printf("c = %d \n", value[2]);
        }
        if (values.isEmpty()) System.out.println("No matches");
    }
}
