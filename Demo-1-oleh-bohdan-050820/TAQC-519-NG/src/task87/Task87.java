
/*
 * Appl_87
 * 
 * Version 1.4
 * 
 * Date 08/04/2020
 * 
 * SoftServe IT Academy
 * 
 * Input - two natural numbers - n,m.
 * This application gives a sum of the last m-figures of number n
 */
package task87;
public class Task87 {

	public static void main(String[] args) {
		SumFingers sumFingers = new SumFingers();
		TwoNumbers two = TwoNumbers.read();
		TwoNumbers.write(sumFingers.sumNumbers(two));
	}
}
