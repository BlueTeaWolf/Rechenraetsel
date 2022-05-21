package de.hochtaunusschule;

import java.util.HashSet;
import java.util.Set;
/**
 * @author BlueTeaWolf
 */
public class OperatorsTester {
    private static final Operator[] OPERATORS = Operator.values();
    private final int[] numbers;
    private final DuplicateTracker<Operator[]> duplicateTracker = new DuplicateTracker<>();
    private final Operator[] operators;

    public OperatorsTester(int[] numbers) {
        this.numbers = numbers;
        operators = new Operator[numbers.length - 1];
    }

    public void generateOperators(int index) {
        if (index == operators.length) {
            Calculation calculation = new Calculation(numbers, operators);
            try {
                int result = calculation.calculator();
                if (result > 0) {
                    duplicateTracker.track(result, operators.clone());
                }
            } catch (InvalidDivisionException e) {
            }
            return;
        }
        for (Operator operator : OPERATORS) {
            operators[index] = operator;
            generateOperators(index + 1);
        }
    }

    public boolean hasUniqueSolutions() {
        return !duplicateTracker.getResults().isEmpty();
    }

    public DuplicateTracker<Operator[]> getDuplicateTracker() {
        return duplicateTracker;
    }
}
