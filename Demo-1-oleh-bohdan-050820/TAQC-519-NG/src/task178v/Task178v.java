/*
 * Task178v
 * 
 * Version 1.4
 * 
 * Date 08/04/2020
 * 
 * SoftServe IT Academy
 * 
 * This application gives quantity of the numbers 
 * of the list which are a square of even numbers 
 */
package task178v;
public class Task178v {

	public static void main(String[] args) {
		InputOutput io = new InputOutput();
		CalcQuantity cq = new CalcQuantity();
		io.printResult(cq.numberFigures(io.setArray()));
	}
}
