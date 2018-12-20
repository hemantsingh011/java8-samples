package com.github.samples.FPSamples_Mario;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class SalaryRules {
    private SalaryRules() {}

    public static double allowance(double d) {
        return d * 1.2;
    }

    public static double bonus(double d) {
        return d * 1.1;
    }

    public static double tax(double d) {
        return d * 0.1;
    }

    public static double surcharge(double d) {
        return d * 0.1;
    }
}

public class FunctionalSalaryCalculator {
    private final List<Function<Double, Double>> fs = new ArrayList<>();

    public FunctionalSalaryCalculator with(Function<Double, Double> func) {
        fs.add(func);
        return this;
    }

    public double calculate(double basic) {
        return fs.stream()
                .reduce(Function.identity(), Function::andThen)
                .apply(basic);

    }
}

class SampleMain {
    public static void main(String[] args) {
        new FunctionalSalaryCalculator()
                .with(SalaryRules::allowance)
                .with(SalaryRules::tax)
                .with(t -> t * 1.5)
                .calculate(1000.0);
    }
}
