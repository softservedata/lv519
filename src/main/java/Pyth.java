import java.util.ArrayList;
import java.util.List;

public class Pyth {

    public List<PythTrianglDTO> iSNaturalNum(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("Please chose natural number");
        }
        return findPossibleValues(n);

    }

    private List<PythTrianglDTO> findPossibleValues(int n) {
        List<PythTrianglDTO> values = new ArrayList<>();
        int a;
        int b;
        int c;
        for (c = 0; c <= n; c++) {
            for (b = 0; b <= c; b++) {
                for (a = 0; a <= b; a++) {
                    if ((a * a + b * b == c * c) && (a != 0 && b != 0 && c != 0)) {
                        values.add(new PythTrianglDTO(a, b, c));
                    }
                }
            }
        }
        return values;
    }


}
