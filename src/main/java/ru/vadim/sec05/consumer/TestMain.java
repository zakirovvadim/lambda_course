package ru.vadim.sec05.consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/*
Принимает один аргумент (тип T), не возвращает результат (void).
Используется, когда нужно выполнить действие с объектом, но не возвращать значение.
 */
public class TestMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("vadim");
        list.add("darya");

        // можно настроить интерфейсы на разную логику
        Consumer<String> dbConsumer = (s) -> {
            System.out.println("I am writing into DB :: " + s);
        };

        Consumer<String> loggingConsumer = (s) -> {
            System.out.println("I am writing into log file :: " + s);
        };

        Consumer<String> dbLogConsumer = dbConsumer.andThen(loggingConsumer);
        // и с легкостью переключать нужный интерфейс и денйствие
        list.forEach(dbLogConsumer);


        /*
        Вместо использования множественных if-else для выбора поведения, можно:
        Создать Map, где:
        Ключ — строка (например, название действия: "db", "log").
        Значение — Consumer<T> (поведение, которое нужно выполнить).
        Динамически выбирать нужный Consumer из Map на основе внешних параметров (например, системных свойств или аргументов командной строки).
         */
        Map<String, Consumer<String>> map = Map.of("db", dbConsumer, "log", loggingConsumer, "dbLog", dbLogConsumer);
        // берем какой нибудь проперти
//        list.forEach(map.get(System.getProperty("consumer-type")));

        System.out.println("--------------------------------------");

        BiConsumer<String, Integer> biConsumer = (s1, s2) -> {
            System.out.println("I am writing into DB :: " + s1);
            System.out.println("I am writing into logFile :: " + s2);
        };

        biConsumer.accept("vadim", 10);
    }

}
