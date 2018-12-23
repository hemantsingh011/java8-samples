package com.github.samples.FPSamples_Mario;

import java.util.function.Function;

public class ImmutableFunctionalSalaryCalculator {

    private final Function<Double, Double> calc;

    public ImmutableFunctionalSalaryCalculator() {
        this(Function.identity());
    }
    private ImmutableFunctionalSalaryCalculator(Function<Double, Double> calc){
        this.calc = calc;
    }

    public  ImmutableFunctionalSalaryCalculator with(Function<Double, Double> f){
        return new ImmutableFunctionalSalaryCalculator(calc.andThen(f));
    }

    public double calculate(double basic) {
       return calc.apply(basic);
    }
}
