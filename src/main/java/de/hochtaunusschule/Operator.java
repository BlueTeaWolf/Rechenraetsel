package de.hochtaunusschule;

import java.util.function.IntBinaryOperator;

/**
 * @author BlueTeaWolf
 */
public enum Operator {
    ADDITION(Integer::sum),
    SUBTRACTION((v, v1) -> v - v1),
    MULTIPLICATION((v, v1) -> v * v1),
    DIVISION((v, v1) -> v / v1);

    private final IntBinaryOperator operator;

    Operator(IntBinaryOperator operator) {
        this.operator = operator;
    }

    public int calculate(int one, int two) {
        return operator.applyAsInt(one, two);
    }
}
