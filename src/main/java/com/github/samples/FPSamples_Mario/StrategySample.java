package com.github.samples.FPSamples_Mario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Converter {
    double convert(double value);
}
abstract class AbstractConverter implements Converter {
    @Override public double convert(double value) {
        return value*conversionRate();
    }

    protected abstract double conversionRate();
}
class Mi2KConverter extends AbstractConverter {

    @Override protected double conversionRate() {
        return 1.609;
    }
}

class Ou2GrConverter extends AbstractConverter {

    @Override protected double conversionRate() {
        return 28.345;
    }
}
public class StrategySample {

    public static void main(String[] args) {
        List<Double> values = Arrays.asList(10.0, 20.0, 30.0);
        List<Double> convertValues = new StrategySample().convertValues(values, new Mi2KConverter());
        List<Double> convertValues1 = new StrategySample().convertValues(values, new Ou2GrConverter());
    }

    public List<Double> convertValues(List<Double> values, Converter converter) {
        List<Double> convertedValues = new ArrayList<>();
        for (double value: values) {
            convertedValues.add(converter.convert(value));
        }
        return convertedValues;
    }
}
