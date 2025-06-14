package ru.vadim.sec05.predicate;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Rules {

    private static Predicate<WebElement> isBlank = (e) -> e.getText().trim().isEmpty(); // указатель на пустую строку
    private static Predicate<WebElement> hasS = (e) -> e.getText().toLowerCase().contains("s"); // и удаляем символ

    public static List<Predicate<WebElement>> get(){
        List<Predicate<WebElement>> r = new ArrayList<Predicate<WebElement>>();
        r.add(isBlank);
        r.add(hasS);
        return r;
    }
}
