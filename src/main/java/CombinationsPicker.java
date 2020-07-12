import java.util.ArrayList;
import java.util.List;


public class CombinationsPicker {
    private static List<int[]> values = new ArrayList<>();

    public static List<int[]> getValues() {
        return values;
    }

    public void iSNaturalNum(int n) {

        if (n > 0) {
            findPossibleValues(n);
        } else {
            System.out.println("Please chose natural number");
        }

    }

    private void findPossibleValues(int n) {
        int x;
        int y;
        int z;
        for (x = 0; x < n; x++) {
            for (y = 0; y < n; y++) {
                for (z = 0; z < n; z++) {
                    if ((n == (x * x + y * y + z * z)) && (x != 0 && y != 0 && z != 0)) {
                        values.add(new int[]{x, y, z});
                    }
                }
            }
        }


    }

    public void displayOptions(boolean option){
        if (option){
            printValue();
        } else {
            printValues();
        }

    }
    private void printValue() {
            System.out.printf("x = %d \t", values.get(0)[0]);
            System.out.printf("y = %d \t", values.get(0)[1]);
            System.out.printf("z = %d \n", values.get(0)[2]);

    }
    private void printValues() {
        for (int[] value : values) {
            System.out.printf("x = %d \t", value[0]);
            System.out.printf("y = %d \t", value[1]);
            System.out.printf("z = %d \n", value[2]);
        }
        if (values.isEmpty()) System.out.println("No matches");
    }
}
