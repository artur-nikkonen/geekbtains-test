package ru.geekbrains.main.site.at.selectors;

import org.openqa.selenium.By;

public class Footer {
    public static final String rootXPath = "//footer";
    public static final By root = By.xpath(rootXPath);

    public static final By facebookLink = By.xpath(rootXPath + "//a[@href='//www.facebook.com/geekbrains.ru']");
    public static final By vkLink = By.xpath(rootXPath + "//a[@href='//vk.com/geekbrainsru']");
    public static final By instagramLink = By.xpath(rootXPath + "//a[@href='//www.instagram.com/geekbrains.ru']");
    public static final By youtubeLink = By.xpath(rootXPath + "//a[@href='//youtube.com/user/progliveru']");
    public static final By telegramLink = By.xpath(rootXPath + "//a[@href='//telegram.me/geekbrains_ru']");

    public static final By feedbackLink = By.xpath(rootXPath + "//a[@href='/feedbacks']");
    public static final By helpLink = By.xpath(rootXPath + "//a[@href='https://geekbrains.zendesk.com/hc/ru']");
    public static final By aboutLink = By.xpath(rootXPath + "//a[@href='/company']");
    public static final By licenseLink = By.xpath(rootXPath + "//a[@href='/license.pdf']");
    public static final By careerLink = By.xpath(rootXPath + "//a[@href='/career/682']");
    public static final By forbusinessLink = By.xpath(rootXPath + "//a[@href='https://forbusiness.geekbrains.ru']");

    public static final By copyright = By.xpath(rootXPath + "//*[@class='site-footer__copyright']");
    public static final By phone = By.xpath(rootXPath + "//*[@class='site-footer__phone']");
    public static final By skolkovo = By.xpath(rootXPath + "//a[@class='site-footer__icon-sk']");


}
