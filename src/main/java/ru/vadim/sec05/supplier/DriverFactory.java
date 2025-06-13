package ru.vadim.sec05.supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Supplier<WebDriver> chromeSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\appol\\Downloads\\chromedriver.exe");
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> fireFoxSupplier = () -> {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\appol\\Downloads\\geckodriver.exe");
        return new FirefoxDriver();
    };

    private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();

    static {
        MAP.put("chrome", chromeSupplier);
        MAP.put("firefox", fireFoxSupplier);
    }

    public static WebDriver getDriver(String browser) {
        return MAP.get(browser).get();
    }
}
