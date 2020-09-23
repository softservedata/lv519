package com.softserve.edu.collect;

import java.util.ArrayList;
import java.util.List;

class A {
}

class B extends A {
}

class C extends B {
}

public class AppGen {

    public static <T extends Comparable<T>> T max(T arg1, T arg2) {
        return arg1.compareTo(arg2) > 0 ? arg1 : arg2;
    }
    
    public static <T extends B> void info(T arg1) {
        System.out.println("Class Type = " + arg1.getClass().getName());
    }

//    public static <T super B> void info2(T arg1) { // Error
//        System.out.println("Class Type = " + arg1.getClass().getName());
//    }
    
    public void work(List<? super Exception> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Class, Type = " + list.get(i).getClass().getName());
        }
    }

    public static void main(String[] args) {
        int i1 = 11;
        int i2 = 2;
        System.out.println("max = " + max(i1, i2));
        //
        String s1 = "abc";
        String s2 = "abd";
        System.out.println("max = " + max(s1, s2));
        //
        AppGen app = new AppGen();
        //
        List<? super Exception> list = new ArrayList<>();
        // List<? extends RuntimeException> list = new ArrayList<>();
        list.add(new RuntimeException("1"));
        list.add(new Exception("2"));
        list.add(new ArithmeticException("2"));
        app.work(list);
        //
        //List<? extends B> list2 = new ArrayList<>();
        //list.add(new C());
        //list.add(new Object());
        //list.add(null);
        //
        //info(new A()); Error
        info(new B());
        info(new C());
    }
}
