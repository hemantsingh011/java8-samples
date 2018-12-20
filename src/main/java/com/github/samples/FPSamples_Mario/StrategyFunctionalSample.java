package com.github.samples.FPSamples_Mario;

import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface ExtendedBiFunction<T,U,R> extends BiFunction<T, U, R>{

    default Function<T,R> curry1(U u){
        return t -> apply(t, u);
    }
    default Function<U,R> curry2(T t){
        return u -> apply(t, u);
    }

    default<V> ExtendedBiFunction<V, U, R> compose1(Function<? super V, ? extends T> before) {
        return (v, u) -> apply(before.apply(v), u);
    }
    default<V> ExtendedBiFunction<T, V, R> compose2(Function<? super V, ? extends U> before) {
        return (t, v) -> apply(t, before.apply(v));
    }
}

public class StrategyFunctionalSample {
    public static void main(String[] args) {

        BiFunction<Double, Double, Double> function =(conversionRate, value) -> conversionRate * value;

      /* To remove this duplicacy we are using the curry1 methods
      BiFunction<Double, Double, Double> mi2kmConverterBiFunction =(conversionRate, value) -> 1.609 * value;
        BiFunction<Double, Double, Double> ou2gmConverterBiFunction =(conversionRate, value) -> 28.305 * value;*/

        ExtendedBiFunction<Double, Double, Double> extendedBiFunction = (conversionRate, value) -> conversionRate * value;

        Function<Double, Double> mi2kmConverter = extendedBiFunction.curry1(1.609);
        Function<Double, Double> ou2gmConverter = extendedBiFunction.curry1(28.305);

        mi2kmConverter.apply(10.0);
        ou2gmConverter.apply(10.0);


    }
}
