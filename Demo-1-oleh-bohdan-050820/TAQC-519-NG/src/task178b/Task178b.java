/*
 * Task178b
 * 
 * Version 1.4
 * 
 * Date 08/04/2020
 * 
 * SoftServe IT Academy
 * 
 * This application gives quantity of the numbers  
 * of the list which are divided on 3, but not on 5
 */
package task178b;

public class Task178b {
	
	
	public static void main(String[] args) {
		InputOutput io = new InputOutput();
		CalcQuantity cq= new CalcQuantity();
		io.printResult(cq.numberFigures(io.setArray()));
		
	}
}