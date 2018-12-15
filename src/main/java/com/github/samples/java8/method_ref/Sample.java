package com.github.samples.java8.method_ref;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Sample extends ParentSample{

    public static void main(String[] args) {
        Arrays.asList(1, 2, 3)
                .stream()
                .filter(Sample::greaterThanFive) // Static method reference
                .forEach(System.out::println);
    }

    public void sortNumbers() {
        Arrays.asList(1, 2, 3)
                .stream()
                .filter(this::greaterZero) // Instance method reference
                .filter(super::greaterZero) // Super method reference
                .forEach(System.out::println);
    }

    Supplier<Map> mapSupplier = HashMap::new; // Constructor method reference

    Supplier<Map<String, Integer>> genericMapSupplier = HashMap<String, Integer>::new; // Generic Type constructor



   private static boolean greaterThanFive(int number) {
        return number > 5;
   }

    public boolean greaterZero (int n) {
        return n>0;
    }

}

class ParentSample  {
    public boolean greaterZero (int n) {
        return n>=0;
    }
}
