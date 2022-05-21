package de.hochtaunusschule;

import java.util.Random;

/**
 * @author BlueTeaWolf
 */
public class NumberGenerator {
    private static final Random random = new Random();

    private int[] numbers;
    private Operator[] operators;

    public NumberGenerator(int[] numbers, Operator[] operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public NumberGenerator() {

    }

    public NumberGenerator generator(int operations) {
        int counter = 0;
        int[] numbers = new int[operations + 1];
        Operator[] operators = new Operator[operations];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 9)+1;
        }
        for (int i = 0; i < operations; i++) {
            operators[i] = Operator.values()[(int)(Math.random()*4)];
        }
        setNumbers(numbers);
        setOperators(operators);
        return new NumberGenerator(numbers, operators);
    }

    public int[] getNumbers() {
        return numbers;
    }

    public Operator[] getOperators() {
        return operators;
    }

    private void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    private void setOperators(Operator[] operators) {
        this.operators = operators;
    }
}
