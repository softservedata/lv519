package com.softserve.edu.collect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AppCompare {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("aa");
        list.add("cc");
        list.add("aa");
        list.add("bb");
        list.add("cc");
        //
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "cc");
        map.put(2, "bb");
        map.put(3, "cc");
        //map.put(4, "aa");
        map.put(4, "dd");
        //
        Set<String> set1 = new HashSet<>(list);
        Set<String> set2 = new HashSet<>(map.values());
        System.out.println("set1.size() = " + set1.size());
        System.out.println("set2.size() = " + set2.size());
        System.out.println("set1.equals(set2) = " + set1.equals(set2));
        //
        Set<String> common =new HashSet<>(set1);
        common.retainAll(set2);
        System.out.println("set1 = " + set1);
        System.out.println("set2 = " + set2);
        System.out.println("common = " + common);
    }
}
