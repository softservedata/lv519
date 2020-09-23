package com.softserve.edu.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppIter {
    public static void main(String[] args) {
        //
        List<String> list = new ArrayList<>();
        list.add("First element");
        list.add("Second element");
        list.add(0, "One more first element");
        list.add("Second element");
        //
        System.out.println("\tOrigin list");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("element[" + i + "] = " + list.get(i));
        }
        //
        /*
        String element2 = list.get(1);
        System.out.println("element[1] = " + element2);
        for (String current : list) {
            System.out.println(current);
        }
        //
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String current = iterator.next();
            System.out.println(current);
        }
        */
        /*-
        // Invalid Approach
        System.out.println("\tDelete Element contains 'Second'");
        //int n = list.size();
        for (int i = 0; i < list.size(); i++) {
        //for (int i = 0; i < n; i++) {
            System.out.println("Element: " + list.get(i));
            if (list.get(i).contains("Second")) {
                list.remove(i); // Architecture Error
                //i--; // Architecture Error
            }
        }
        //
        // Invalid Approach
        System.out.println("\nDeleting ...");
        for (String current : list) {
            System.out.println(current);
            if (current.contains("Second")) {
                list.remove(current); // Architecture Error
            }
        }
        */
        //
        System.out.println("\nDeleting ...");
        Iterator<String> iterat = list.iterator();
        while(iterat.hasNext()) {
            String current = iterat.next();
            System.out.println("Elem: " + current);
            if (current.contains("Second")) {
                iterat.remove();
            }
        }
        //
        System.out.println("\tUpdated list");
        for (String current : list) {
            System.out.println(current);
        }
        //
    }
}
