package de.hochtaunusschule;

import java.util.LinkedList;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author BlueTeaWolf
 */
public class Calculation {

    private static final int[][] NUMBER_ARRAY_CACHE = new int[50][];
    private static final Operator[][] OPERATOR_ARRAY_CACHE = new Operator[50][];

    static {
        for (int i = 0; i < NUMBER_ARRAY_CACHE.length; i++) {
            NUMBER_ARRAY_CACHE[i] = new int[i];
        }
        for (int i = 0; i < OPERATOR_ARRAY_CACHE.length; i++) {
            OPERATOR_ARRAY_CACHE[i] = new Operator[i];
        }
    }
    private static final InvalidDivisionException INVALID_DIVISION_EXCEPTION = new InvalidDivisionException();
    public int[] numbers;
    private Operator[] operators;

    public Calculation(int[] numbers, Operator[] operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    private void removeNumberAt(int index) {
        int length = numbers.length;
        int[] array = NUMBER_ARRAY_CACHE[length - 1];
        System.arraycopy(numbers, 0, array, 0, index);
        if (index < length - 1) {
            System.arraycopy(numbers, index + 1, array, index, length - index - 1);
        }
        numbers = array;
    }

    private void removeOperatorAt(int index) {
        int length = operators.length;
        Operator[] array = OPERATOR_ARRAY_CACHE[length - 1];
        System.arraycopy(operators, 0, array, 0, index);
        if (index < length - 1) {
            System.arraycopy(operators, index + 1, array, index, length - index - 1);
        }
        operators = array;
    }

    public void Division(int[] numbers, int start) {

        if (numbers[start + 1] == 0 || numbers[start] % numbers[start + 1] != 0) {
            throw INVALID_DIVISION_EXCEPTION;
        } else {
            runOperation(Operator.DIVISION, start);
        }
    }

    public int calculator() {
        multiDivision();
        return additionSubtraction();
    }

    private void runOperation(Operator operator, int index) {
        int left = numbers[index];
        int right = numbers[index+1];

        removeNumberAt(index+1);
        numbers[index] = operator.calculate(left, right);
        removeOperatorAt(index);
    }

    private int[] multiDivision() {
        for (int i = 0; i < operators.length; i++) {
            Operator operator = operators[i];
            if (operator == Operator.MULTIPLICATION || operator == Operator.DIVISION) {
                if (operator == Operator.DIVISION) {
                    Division(numbers, i);
                } else {
                    runOperation(operator, i);
                }
                i--;
            }
        }
        return numbers;
    }

    private int additionSubtraction() {
        int result = numbers[0];
        for (int i = 0; i < operators.length; i++) {
            result = operators[i].calculate(result, numbers[i + 1]);
        }
        return result;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public Operator[] getOperators() {
        return operators;
    }

    public void setOperators(Operator[] operators) {
        this.operators = operators;
    }
}
