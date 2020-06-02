package ru.geekbrains.main.site.at.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class BaseElementsList {

    WebDriver driver;
    private String cssSelectorTemplate;
    private HashMap<String, String> map;

    public BaseElementsList(WebDriver driver, String cssSelectorTemplate) {
        this.cssSelectorTemplate = cssSelectorTemplate;
        this.driver = driver;

        map = new HashMap<>();
    }

    public void add(String name, String path) {
        map.put(name, getSelector(path));
    }

    private String getSelector(String path) {
        return String.format(cssSelectorTemplate, path);
    }

    public void click(String name) {
        getElementByName(name).click();
    }

    public void checkTitle(String name, String title) {
        assertThat(getElementByName(name).getText(), equalToIgnoringCase(title));
    }

    public void checkTitle(String name) {
        checkTitle(name, name);
    }

    public WebElement getElementByName(String name) {
        return driver.findElement(By.cssSelector(map.get(name)));
    }

    public String getText(String name) {
        return getElementByName(name).getText();
    }
}
