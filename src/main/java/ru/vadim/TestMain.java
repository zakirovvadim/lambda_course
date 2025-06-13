package ru.vadim;

import ru.vadim.lambda.GreetingService;

import java.util.Locale;

public class TestMain {
    public static void main(String[] args) {
        convertToUppercase("vadim");
        convertToUppercase("nastya");
        convertToUppercase("daria");
    }

    private static void convertToUppercase(String s) {
        String returningString = s.toUpperCase();
        System.out.println(returningString);
    }

    private static void convertToLowercase(String s) {
        String returningString = s.toLowerCase();
        System.out.println(returningString);
    }


    private static void test(GreetingService g, String s) {
        String returningstring = g.greet(s);
        System.out.println(returningstring);
    }
}
