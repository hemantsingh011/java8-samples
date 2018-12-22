package com.github.samples.enum_samples;

import java.util.List;
import java.util.function.DoubleBinaryOperator;

enum Operation {

    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    DIVIDE("/", (x, y) -> x / y),
    MULTIPLY("*", (x, y) -> x * y);

    private final String symbol;
    private final DoubleBinaryOperator operator;

    Operation(String symbol, DoubleBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public double apply(double x, double y) {
        return operator.applyAsDouble(x, y);
    }

}

enum Operation_WithoutLambda {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    },
    MULTIPLY("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    };

    Operation_WithoutLambda(String symbol) {

    }

    public abstract double apply(double x, double y);
}

class Main {
    public static void main(String[] args) {
        System.out.println(Operation.PLUS.apply(1, 3));
        System.out.println(Operation_WithoutLambda.PLUS.apply(1, 3));
    }
}