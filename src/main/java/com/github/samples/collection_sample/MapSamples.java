package com.github.samples.collection_sample;

import java.util.HashMap;
import java.util.Map;

public class MapSamples {
    public static double compute(int number) {
        System.out.println("Called .....");
        return Math.sqrt(number);
    }
    public static double computeAgain(int number, double value) {
        return number*value;
    }

    public static void main(String[] args) {
        Map<Integer, Double> map= new HashMap<>();
      /*  if(!map.containsKey(4)) {
            map.put(4, compute(4));
        }*/

      map.computeIfAbsent(4, MapSamples::compute);
      map.computeIfAbsent(36, MapSamples::compute);
      map.computeIfPresent(4, MapSamples::computeAgain);

      map.forEach((k, v) -> System.out.println("Key "+k+ " Value "+ v));
    }
}
