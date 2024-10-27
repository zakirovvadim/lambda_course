package ru.vadim.lambdacourse.sec04.assinment;

public class Calculator {
    public static void main(String[] args) {
        MathOperation addOperation = Integer::sum;
        MathOperation subtractOper = (a, b) -> a - b;
        MathOperation multipleOper = (a, b) -> a * b;
        MathOperation devideOper = (a, b) -> a / b;
        System.out.println(calculate(subtractOper));
    }

    private static int calculate(MathOperation mathOperation) {
        int a = 100;
        int b = 5;
        return mathOperation.operate(a, b);
    }
}
