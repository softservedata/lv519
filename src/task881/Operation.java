package task881;

public class Operation {

    private final static char THREE = '3';
    private final static int START = 0;
    private final static int END = 103621;
    private final static String SUCCESS_MESSAGE = "Number include 3";
    private final static String FAIL_MESSAGE = "No 3 in your number";
    private final static String EXCEPTION_MESSAGE = "Number must be > 0 and < 10361";

	public Number checkNumber(Number number) throws IllegalArgumentException {
        if (number.getNumber() <= START || number.getNumber() > END) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return number;
    }

    public int numberSquare(int number) {
        return number * number;
    }

    public int numberSquare(Number number) {
        return numberSquare(number.getNumber());
    }

    public char[] convertNumber(int number) {
        String s = Integer.toString(number);
        return s.toCharArray();
    }

    public int includeThree(char[] chars) {
        int check = 0;
        for (char aChar : chars) {
            if (aChar == THREE) {
                check++;
            }
        }
        return check;
    }

    public String conclusion(int check) {
        if (check > 0) {
            return SUCCESS_MESSAGE;
        } else {
            return FAIL_MESSAGE;
        }
    }

    public String start(Number number) {
        return conclusion(includeThree(convertNumber(numberSquare(checkNumber(number)))));
    }

}