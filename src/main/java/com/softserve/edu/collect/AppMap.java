package com.softserve.edu.collect;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class AppMap {
    public static void main(String[] args) {
        Map<Object, String> mapA = new HashMap<>();
        mapA.put("key1", "one");
        mapA.put("key2", "two");
        mapA.put(3, "three");
        mapA.put(null, "null123");
        mapA.put(new Object(), "Object");
        //
//        for (Map.Entry<Object, String> entry : mapA.entrySet()) {
//            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
//        }
        for (Iterator<Entry<Object, String>> i = mapA.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry<Object, String> entry = i.next();
            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
        }
        System.out.println("mapA.get(3) = " + mapA.get(3));
        System.out.println("mapA.get(41) = " + mapA.get(41));
    }
}
