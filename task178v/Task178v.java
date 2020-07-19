/*
 * Task178v
 * 
 * Version 1.3
 * 
 * Date 19072020
 * 
 * SoftServe IT Academy
 * 
 * This app gives you quantity of the numbers of the list
 * which are a square of even numbers 
 */
package task178v;
public class Task178v {

	public static void main(String[] args) {
		InputOutput io = new InputOutput();
		CalcQuantity cq = new CalcQuantity();
		io.printResult(cq.numberFigures(io.setArray()));
	}
}
