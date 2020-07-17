import java.util.ArrayList;
import java.util.List;


public class CombinationsPicker {
    public List<CombinationsDTO> findCombinations(int n, boolean oneCombination) {
        if (n <= 0) {
            throw new IllegalArgumentException("Please chose natural number");
        }
        return oneOptions(n, oneCombination);
    }

    private List<CombinationsDTO> oneOptions(int n, boolean isOne) {
        boolean isRunning = true;
        List<CombinationsDTO> values = new ArrayList<>();
        int x;
        int y;
        int z;
        for (x = 0; isRunning && (x < n); x++) {
            for (y = 0; isRunning && (y < n); y++) {
                for (z = 0; isRunning && (z < n); z++) {
                    if ((n == (x * x + y * y + z * z)) && (x != 0 && y != 0 && z != 0)) {
                        values.add(new CombinationsDTO(x, y, z));
                        isRunning = !isOne;
                    }
                }
            }
        }
        return values;
    }
}
