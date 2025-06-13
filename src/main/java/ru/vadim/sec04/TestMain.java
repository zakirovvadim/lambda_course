package ru.vadim.sec04;

import ru.vadim.sec04.lambda.GreetingService;
/*
### Конспект: Высокоуровневые функции (Higher-Order Functions)

#### **Основная идея**
Высокоуровневая функция (Higher-Order Function, HOF) — это функция, которая:
1. **Принимает другую функцию как аргумент** или
2. **Возвращает функцию как результат**.

Это противоположно традиционному подходу, где функция содержит фиксированное поведение, а данные передаются в неё.

---

#### **Традиционный подход**
1. **Функция с фиксированным поведением**
   - Пример: метод `convertToUpperCase`, который всегда преобразует строку в верхний регистр.
   - Код:
     ```java
     String convertToUpperCase(String data) {
         return data.toUpperCase();
     }
     ```
   - Использование:
     ```java
     String result = convertToUpperCase("Vinoth"); // "VINOTH"
     ```

2. **Проблема**
   - Для каждого нового поведения (например, `toLowerCase`, `length`) нужно создавать отдельную функцию.
   - Это приводит к дублированию кода.

---

#### **Функциональный подход (HOF)**
1. **Функция принимает поведение как аргумент**
   - Пример: метод `test`, который принимает строку **и функцию** для её обработки.
   - Код (псевдокод для иллюстрации):
     ```java
     void test(String data, Function<String, String> behavior) {
         String result = behavior.apply(data);
         System.out.println(result);
     }
     ```
   - Использование:
     ```java
     test("Udemy", str -> str.toUpperCase()); // "UDEMY"
     test("Udemy", str -> str.toLowerCase()); // "udemy"
     test("Udemy", str -> String.valueOf(str.length())); // "5"
     ```

2. **Преимущества**
   - Одна функция (`test`) может выполнять **разные операции** в зависимости от переданного поведения.
   - Не нужно создавать множество методов под каждую задачу.

---

#### **Ключевое отличие**
| Традиционный подход               | Функциональный подход (HOF)         |
|-----------------------------------|-------------------------------------|
| Функция **содержит поведение**, данные передаются в неё. | Функция **получает данные**, поведение передаётся как аргумент. |
| `convertToUpperCase(data)`        | `test(data, toUpperCaseBehavior)`   |

---

#### **Важные моменты**
- **HOF — это стиль программирования**, требующий переосмысления подхода.
- Поначалу может быть непривычно, но с практикой становится понятнее.
- Примеры языков с поддержкой HOF: Java (с лямбдами), Kotlin, JavaScript, Python.

---

#### **Итог**
Высокоуровневая функция даёт гибкость:
- Вы **передаёте поведение** (например, "преобразуй в верхний регистр"), а функция применяет его к данным.
- Это уменьшает дублирование кода и делает его более модульным.

 */

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
