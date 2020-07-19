
/*
 * Appl_87
 * 
 * Version 1.3
 * 
 * Date 19072020
 * 
 * SoftServe IT Academy
 * 
 * This app gives you a sum of the last m-figures of number n
 */
package task87;
public class Task87 {

	public static void main(String[] args) {
		SumFingers sum = new SumFingers();
		TwoNumbers two = TwoNumbers.read();
		TwoNumbers.write(sum.sumNumbers(two));
	}
}
