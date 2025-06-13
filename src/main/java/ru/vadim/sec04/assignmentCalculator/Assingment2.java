package ru.vadim.sec04.assignmentCalculator;

public class Assingment2 {

    public static void main(String[] args) {
        MathOperation add = Integer::sum;
        MathOperation sub = (a, b) -> a - b;
        MathOperation mult = (a, b) -> a * b;
        MathOperation div = (a, b) -> a / b;

        int calculated1 = calculate(2, div, 3);
        int calculated2 = calculate(3, mult, 7);
        int calculated22 = calculate(calculated1, add, calculated2);
        int calculated3 = calculate(calculated22, sub, 2);
        int calculated4 = calculate(calculated3, add, 5);
        System.out.println(calculated4);
    }

    public static int calculate(int a, MathOperation mathOperation, int b) {
        return mathOperation.operate(a, b);
    }

}
