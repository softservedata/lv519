package com.softserve.edu;

import com.softserve.training.Maximum;

/**
 * <b>Short <font color="red">one line</font> description.</b>                           (1)
 * <p>
 * Longer description. If there were any, it would be    (2)
 * here.
 * <p>
 * And even more explanations to follow in consecutive
 * paragraphs separated by HTML paragraph breaks.
 *
 * @param  variable Description text text text.          (3)
 * @return Description text text text.
 */
public class Example {//extends Maximum {
	private int i = 11;
	private String s = "abc";

	public static void main(String[] args) {
		Example ex = new Example();
		System.out.println("My first program");
		System.out.println("i = " + ex.i);
		//
		Example ex2 = new Example();
		ex2.i = 12;
		System.out.println("ex2.i = " + ex2.i);
		Class<?> cls = Example.class;
		//
		for (int i = 0; i < args.length; i++) {
			System.out.println("Arg " + i + " is " + args[i]);
		}
		Maximum m = new Maximum();
		System.out.println("m.j = " + m.getJ());
		//System.out.println("m.j = " + m.j);
		// System.out.println("m.j = " + ex2.j);
		Maximum.main(new String[] {"1", "2"});
	}
}
