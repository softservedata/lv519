package task882;

public class Operation {

    private final static int START = 0;
    private final static int END = 2147483647;
    private final static String EXCEPTION_MESSAGE = "Number must be > 0 and < 2147483647";

    public Number checkNumber(Number number) throws IllegalArgumentException {
        if (number.getNumber() <= START || number.getNumber() > END) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        } 
        return number;
    }

    public int inverse(Number number) {
        int result = 0;
        int value = number.getNumber();
        while (value > 0) {
            result = result * 10 + value % 10;
            value /= 10;
        }
        return result;
    }

    public int result(Number number){
        return inverse(checkNumber(number));
    }
}
