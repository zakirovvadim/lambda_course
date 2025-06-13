package ru.vadim.sec05;

import java.util.function.Supplier;

public class SupplierInterface {
    public static void main(String[] args) {
        Supplier<Double> random = Math::random;
        System.out.println(random.get());
    }
}
