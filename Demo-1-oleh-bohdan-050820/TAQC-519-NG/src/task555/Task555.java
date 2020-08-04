/*
 * ApplPascalTreangle_555
 * 
 * Version 1.4
 * 
 * Date 08/04/2020
 * 
 * SoftServe IT Academy
 * 
 * This application build a Pascal Triangle of dimension n. 
 * Every border's finger of the triangle is one.
 * Every finger inside - the sum of the nearest two elements
 * up over the finger
 */
package task555;
public class Task555 {

	public static void main(String[] args) {
		CreateMatrix matrixPascal = new CreateMatrix();
		OneNumber one = OneNumber.read();
		OneNumber.write(matrixPascal.matrix(one));
	}

}