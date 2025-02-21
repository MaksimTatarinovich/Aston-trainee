package lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {

    private static WebDriver instance = null;

    private WebDriverSingleton(){};

    public static WebDriver getInstance() {
        if (instance == null) {
            WebDriverManager.chromedriver().setup();
            instance = new ChromeDriver();
        }
        return instance;
    }

    public static void closeDriver() {
        if (instance != null) {
            instance.quit();
            instance = null;
        }
    }
}
