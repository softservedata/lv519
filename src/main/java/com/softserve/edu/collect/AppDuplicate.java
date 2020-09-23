package com.softserve.edu.collect;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class AppDuplicate {
    public static void main(String[] args) {
        /*-
        Set<String> s = new HashSet<>();
        //Set<String> s = new TreeSet<>();
        //List<String> s = new LinkedList<>();
        for (int i = 0; i < args.length; i++) {
            if (!s.add(args[i])) {
                System.out.println("Duplicate detected: " + args[i]);
            }
        }
        System.out.println("Elements: " + s);
        */
        //
        //Set<Student> s = new HashSet<>();
        LinkedHashSet<Student> s = new LinkedHashSet<>();
        //Set<Student> s = new TreeSet<>();
        //Set<Student> s = new TreeSet<>(new Student.ById());
        //Set<Student> s = new TreeSet<>(new Student.ByNameId());
        //
        //List<Student> lst = Arrays.asList(new Student(123, "Ivan"), new Student(123, "Ivan"));
        //s.addAll(lst);
        //
//        Student st1 = new Student(123, "Ivan");
//        System.out.println("add: " + s.add(st1));
//        System.out.println("add: " + s.add(st1));
        //
        // /*
        boolean b;
        b = s.add(new Student(123, "Ivan"));
        System.out.println("s.add(new Student(123, Ivan)) = " + b);
        b = s.add(new Student(120, "Petro"));
        System.out.println("s.add(new Student(124, Petro)) = " + b);
        b = s.add(new Student(12, "Ivan"));
        System.out.println("s.add(new Student(123, Ivan)) = " + b);
//        b = s.add(null);
//        System.out.println("s.add(null) = " + b);
//        b = s.add(null);
//        System.out.println("s.add(null) = " + b);
        // */
        // s.accessOrder
        System.out.println("Students: " + s);
        for (Student current : s) {
            System.out.println("student: " + current + "  hashCode():" + current.hashCode());
        }
    }
}
