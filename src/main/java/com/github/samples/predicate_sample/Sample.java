package com.github.samples.predicate_sample;

import java.awt.*;
import java.util.function.Predicate;

public class Sample {
    public static void print(int number, Predicate<Integer> predicate, String msg) {
        System.out.println(number + " "+ msg + ":" + predicate.test(number));
    }

    public static void main(String[] args) {
        Predicate<Integer> isEven = e -> e % 2 == 0;
        Predicate<Integer> isGT4 = e -> e >4;

        print(4, isEven, "isEven ?");
        print(5, isEven, "isEven ?");
        print(6, isGT4, "isGT4 ?");
        print(6, isGT4.and(isEven), "isGT4 and is Even ?");
    }
}
