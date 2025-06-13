package ru.vadim.sec04.assignmentCalculator;

public class Assingment {

    public static void main(String[] args) {
        MathOperation addOperation = Integer::sum;
        MathOperation subtractOperation = (a, b) -> a - b;
        MathOperation multipyOperation = (a, b) -> a * b;
        MathOperation devideOperation = (a, b) -> a / b;

        int calculated = calculate(subtractOperation);
        System.out.println(calculated);
    }

    public static int calculate(MathOperation mathOperation) {
        int a = 100;
        int b = 5;
        return mathOperation.operate(a, b);
    }

}
