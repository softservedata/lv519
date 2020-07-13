import java.util.ArrayList;
import java.util.List;


public class CombinationsPicker {

    public List<CombinationsDTO> findCombinations(int n, boolean oneCombination) {
        if (n <= 0) {
            throw new IllegalArgumentException("Please chose natural number");
        }
        if(oneCombination) {
            return oneOption(n);}
        else {
            return allOptions(n);}
    }

    private List<CombinationsDTO> allOptions(int n) {
        List<CombinationsDTO> values = new ArrayList<>();
        int x;
        int y;
        int z;
        for (x = 0; x < n; x++) {
            for (y = 0; y < n; y++) {
                for (z = 0; z < n; z++) {
                    if ((n == (x * x + y * y + z * z)) && (x != 0 && y != 0 && z != 0)) {
                        values.add(new CombinationsDTO(x, y, z));
                    }
                }
            }
        }
        return values;
    }

    private List<CombinationsDTO> oneOption(int n) {
        List<CombinationsDTO> values = new ArrayList<>();
        int x;
        int y;
        int z;
        label:
        for (x = 0; x < n; x++) {
            for (y = 0; y < n; y++) {
                for (z = 0; z < n; z++) {
                    if ((n == (x * x + y * y + z * z)) && (x != 0 && y != 0 && z != 0)) {
                        values.add(new CombinationsDTO(x, y, z));
                        break label;
                    }
                }
            }
        }
        return values;
    }
}
