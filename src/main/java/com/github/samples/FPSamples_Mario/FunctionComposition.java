package com.github.samples.FPSamples_Mario;

import java.util.function.Function;

public class FunctionComposition {
    public static void main(String[] args) {
        ExtendedBiFunction<Double, Double, Double> biFunction = (value1, value2) -> value1*value2;

        Function<Double, Double> calBlock1 = n -> n-32;

        ExtendedBiFunction<Double, Double, Double> biFunction1 = biFunction.compose1(calBlock1);

        Function<Double, Double> f2cConverter = biFunction1.curry1(5.0 / 9);

        f2cConverter.apply(20.0);

    }
}
