package com.softserve.edu.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface Base {
    default int two() { return 1; }
    //int two();
}

@FunctionalInterface
interface My extends Base {
    int one();
    //int two();
    //boolean equals(Object obj);
}

public class ApplSort {
    public static void main(String[] args) {
        /*-
        int[] x = new int[10];
        Random rand = new Random();
        for (int i = 0; i < x.length; i++) {
            x[i] = rand.nextInt(10);
        }
        System.out.println("Original Array:\n" + Arrays.toString(x)
            .replace("[", "").replace("]", ""));
        Arrays.sort(x);
        System.out.println("Sorted Array: ");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + "  ");
        }
        //
        //
        List<String> lstStr = new ArrayList<>();
        lstStr.add("222");
        lstStr.add("1");
        lstStr.add("1111");
        lstStr.add("10");
        System.out.println("Original: lstStr = " + lstStr);
        lstStr.add(2,"3333");
        System.out.println("add 3333: lstStr = " + lstStr);
        Collections.sort(lstStr);
        System.out.println("Sorted: lstStr = " + lstStr);
        //
        //
        Student[] x = {new Student(143, "Stepan"), new Student(234, "Petro"), new Student(123, "Ivan")};
        System.out.println("Original Array:\n" + Arrays.toString(x));
        Arrays.sort(x);
        System.out.println("Sorted Array:\n" + Arrays.toString(x));
        */
        //
        List<Student> lstStr = new ArrayList<>();
        lstStr.add(new Student(143, "Stepan"));
        lstStr.add(new Student(234, "Petro"));
        lstStr.add(new Student(233, "Petro"));
        lstStr.add(new Student(235, "Petro"));
        lstStr.add(new Student(567, "Ira"));
        lstStr.add(new Student(123, "Ivan"));
        System.out.println("Original: lstStr = " + lstStr);
        // System.out.println("hashCode(0) = " + lstStr.get(0).hashCode());
        //
        // Collections.sort(lstStr);
        // Collections.sort(lstStr, new Student.ByName());
        // Collections.sort(lstStr, new Student.ById());
        // Collections.sort(lstStr, new Student.ByNameId());
        // Collections.sort(lstStr, (s1, s2) -> -s1.getName().compareTo(s2.getName()));
        Comparator<Student> comp = (s1, s2) -> - s1.getId() + s2.getId();
        Collections.sort(lstStr, comp);
        System.out.println("Sorted: lstStr = " + lstStr);
    }
}
