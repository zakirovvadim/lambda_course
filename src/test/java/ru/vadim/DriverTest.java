package ru.vadim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import ru.vadim.sec05.predicate.Rules;
import ru.vadim.sec05.supplier.DriverFactory;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DriverTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void googleTest() {
        this.driver.get("https://www.google.com/");
        List<WebElement> elements = this.driver.findElements(By.tagName("a"));
        //  .forEach(e -> System.out.println(e.getText()));
        Predicate<WebElement> isBlank = (e) -> e.getText().trim().isEmpty(); // указатель на пустую строку
        Predicate<WebElement> hasS = (e) -> e.getText().toLowerCase().contains("s"); // и удаляем символ

        System.out.println("Before :: " + elements.size());

//        elements.removeIf(isBlank.or(hasS));
        Rules.get().forEach(elements::removeIf); // если много интерфейсов можно поместить их в кеоллекцию

        System.out.println("After :: " + elements.size());
        elements.forEach(e -> System.out.println(e.getText()));
    }

    @AfterTest
    public void getDriver() {
        this.driver.quit();
    }
}
