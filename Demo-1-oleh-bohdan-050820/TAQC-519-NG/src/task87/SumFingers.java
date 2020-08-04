package task87;

public class SumFingers {

	public int sumNumbers(int n, int m) {
		String strN = Integer.toString(n);
		strN = strN.substring(strN.length() - m, strN.length());
		return calculateSum(strN);
	}

	int calculateSum(String strN) {

		int sum = 0;
		for (int i = 1; i <= strN.length(); i++) {
			sum += Integer.parseInt(strN.substring(i - 1, i));
		}
		return sum;
	}

	public int sumNumbers(TwoNumbers twoNumbers) {
		return sumNumbers(twoNumbers.getN(), twoNumbers.getM());
	}
}
