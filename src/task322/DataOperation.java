package task322;

import java.util.HashMap;
import java.util.Map;

public class DataOperation {

    private Map<String, Integer> map;
    private final static int START = 1;
    private final static int END = 10000;
    private final static String EXCEPTION_MESSAGE = "Incorrect values ";

    public Value checkValue(Value value) throws IllegalArgumentException {
        if (value.getStart() < START || value.getEnd() > END) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        } else if(value.getStart()>value.getEnd()){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return value;
    }

    public Map<String, Integer> search (Value value){

        int max_k = 0;
        int max_number = 1;

        for (int i = value.getStart(); i <= value.getEnd() ; i++) {
            int k=0;
            for (int j = 1; j <= i ; j++) {
                if(i%j==0){
                    k++;
                }
            }
            if(k >= max_k){
                max_k = k;
                max_number = i;
            }
        }

        map = new HashMap<>();
        map.put("Max_number", max_number);
        map.put("Max_k", max_k);

        return map;
    }
}
