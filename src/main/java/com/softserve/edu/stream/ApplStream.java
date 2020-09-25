package com.softserve.edu.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class ApplStream {
    public static void main(String[] args) {
//      String[] arr = new String[] {"abc", "", "bc", "abcd", "", "jkl"};
//      List<String> strings = Arrays.asList(arr);
        List<String> strings = Arrays.asList("abc", "", "bc", "abcd", "1", "jkl", "abcd", "ad*");
        //strings.add(1, "_ _ _ _"); // Exception
        //strings.set(1, "_ _ _ _");
        //
        System.out.println("Origin: " + strings);
        /*-
        List<String> filtered = strings.stream()
            .filter(string -> !string.isEmpty())
            .filter(string -> string.length() > 2)
            .collect(Collectors.toList());
        //System.out.println("Updated: " + filtered);
        filtered.forEach(s->System.out.print(s + " "));
        */
        // /*-
        Stream<String> st = strings.stream()
                .filter(string -> !string.isEmpty());
        //
        //st = st.peek(System.out::println);
        st = st.peek(s->System.out.print(s + "...  "));
        System.out.println("----------------");
        st = st.distinct()
                //.peek(x->System.out.println("+++" + x))
                //.sorted((p1, p2) -> -p1.length() + p2.length());
//                .sorted(Comparator
//                        .<String, String>comparing(Function.identity(), (p1, p2) -> -p1.length() + p2.length())
//                        .thenComparing((p1, p2) -> -p1.compareTo(p2)));
                .sorted(Comparator
                        .<String, String>comparing(Function.identity(), (p1, p2) -> p1.length() - p2.length())
                        .thenComparing((p1, p2) -> p1.compareTo(p2)));
        //st = st.peek(x->System.out.println("+"));
        strings.set(1, "_ _ _ _ _");
        st.forEach(System.out::println);
        // st.forEach(System.out::println); // stream has already been operated upon or closed
        // */
    }
}
