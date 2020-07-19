package task332;

import java.util.HashMap;
import java.util.Map;

public class DataOperation {

    private final static int START = 0;
    private final static int END = 2147483647;
    private final static String EXCEPTION_MESSAGE = "Number must be > 0 and < 2147483647";

    public Number checkNumber(Number number) throws IllegalArgumentException {
        if (number.getNumber() <= START || number.getNumber() > END) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        } else return number;
    }

    public Map<String, Integer> search(Number number) {
        int n = (int) Math.sqrt(number.getNumber());
        Map<String ,Integer> map = new HashMap<>();
        for (int i = n; i > -1 ; i--) {
            int a = i*i;
            for (int j = i; j > -1 ; j--) {
                int b = j*j;
                for (int k = j; k > -1 ; k--) {
                    int c = k*k;
                    for (int l = k; l > -1 ; l--) {
                        int d = l*l;
                        if (a+b+c+d == number.getNumber()){
                            map.put("a",a);
                            map.put("b",b);
                            map.put("c",c);
                            map.put("d",d);
                        }
                    }
                }
            }
        }
        return map;
    }
}
