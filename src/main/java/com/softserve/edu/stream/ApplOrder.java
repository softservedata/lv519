package com.softserve.edu.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class ApplOrder {
    public static void main(String[] args) {
        Stream.of(
                Stream.of(1, 2, 3, 4, 5)
                .sorted(Comparator.reverseOrder())
                .limit(4)
                .reduce(0, (acc, x) -> acc + x),
              0)
            .forEach(System.out::print);
    }
}
