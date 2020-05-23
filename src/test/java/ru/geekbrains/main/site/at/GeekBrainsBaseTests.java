package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GeekBrainsBaseTests {

    protected static final String BASE_URL = "https://geekbrains.ru";
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeAll
    static void PrepareDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, 60);
    }

    @AfterAll
    static void CloseDriver() {
        driver.quit();
    }


    public String getUrl(String path) {

        if (path.charAt(0) != '/') {
            return BASE_URL + "/" + path;
        } else {
            return BASE_URL + path;
        }
    }

    protected WebElement getFirstElementBy(By by) {

        List<WebElement> elements = driver.findElements(by);

        if (elements.isEmpty()) {
            return null;
        } else {
            return elements.get(0);
        }
    }
}