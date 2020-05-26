package ru.geekbrains.main.site.at.selectors;

import org.openqa.selenium.By;

public class Header {
    public static final String rootXPath = "//*[@id='top-menu']";
    public static final By root = By.xpath(rootXPath);
    public static final By title = By.xpath(rootXPath + "//*[@class='gb-header__title']");
    public static final By showSearchFormButton = By.xpath(rootXPath + "//*[@class='show-search-form']");
    public static final By loginButton = By.xpath(rootXPath + "//*[@href='/login']");
    public static final By registerButton = By.xpath(rootXPath + "//*[@href='/register']");
    public static final By searchInput = By.xpath(rootXPath + "//*[@class='search-panel__search-field']");
}
