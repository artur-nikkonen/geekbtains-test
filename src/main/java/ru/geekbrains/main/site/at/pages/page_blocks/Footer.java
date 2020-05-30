package ru.geekbrains.main.site.at.pages.page_blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.pages.base.BasePageCreator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class Footer extends BasePageCreator {

    @FindBy(xpath = "//footer")
    private WebElement root;

    //-----------------------------------

    @FindBy(xpath = "//footer//a[@href='//www.facebook.com/geekbrains.ru']")
    private WebElement facebookLink;

    @FindBy(xpath = "//footer//a[@href='//vk.com/geekbrainsru']")
    private WebElement vkLink;

    @FindBy(xpath = "//footer//a[@href='//www.instagram.com/geekbrains.ru']")
    private WebElement instagramLink;

    @FindBy(xpath = "//footer//a[@href='//youtube.com/user/progliveru']")
    private WebElement youtubeLink;

    @FindBy(xpath = "//footer//a[@href='//telegram.me/geekbrains_ru']")
    private WebElement telegramLink;

    //-----------------------------------

    @FindBy(xpath = "//footer//a[@href='/feedbacks']")
    private WebElement feedbackLink;

    @FindBy(xpath = "//footer//a[@href='https://geekbrains.zendesk.com/hc/ru']")
    private WebElement helpLink;

    @FindBy(xpath = "//footer//a[@href='/company']")
    private WebElement aboutLink;

    @FindBy(xpath = "//footer//a[@href='/license.pdf']")
    private WebElement licenseLink;
    @FindBy(xpath = "//footer//a[@href='/career/682']")
    private WebElement careerLink;

    @FindBy(xpath = "//footer//a[@href='https://forbusiness.geekbrains.ru']")
    private WebElement forbusinessLink;

    //-----------------------------------

    @FindBy(xpath = "//footer//*[@class='site-footer__copyright']")
    private WebElement copyright;

    @FindBy(xpath = "//footer//*[@class='site-footer__phone']")
    private WebElement phone;

    @FindBy(xpath = "//footer//a[@class='site-footer__icon-sk']")
    private WebElement skolkovo;

    //-----------------------------------

    public Footer(WebDriver driver) {
        super(driver);
    }

    public Footer checkMainElementsExist() {

        //не знаю как красиво проверить сущетвование элемента
        //решил просто взять имена тегов. Если элемента нет, то вылетит ошибка

        assertAll(
                () -> assertDoesNotThrow(() -> facebookLink.getTagName()),
                () -> assertDoesNotThrow(() -> vkLink.getTagName()),
                () -> assertDoesNotThrow(() -> instagramLink.getTagName()),
                () -> assertDoesNotThrow(() -> youtubeLink.getTagName()),
                () -> assertDoesNotThrow(() -> telegramLink.getTagName()),

                () -> assertDoesNotThrow(() -> feedbackLink.getTagName()),
                () -> assertDoesNotThrow(() -> helpLink.getTagName()),
                () -> assertDoesNotThrow(() -> aboutLink.getTagName()),
                () -> assertDoesNotThrow(() -> licenseLink.getTagName()),
                () -> assertDoesNotThrow(() -> careerLink.getTagName()),
                () -> assertDoesNotThrow(() -> forbusinessLink.getTagName()),

                () -> assertDoesNotThrow(() -> copyright.getTagName()),
                () -> assertDoesNotThrow(() -> phone.getTagName()),
                () -> assertDoesNotThrow(() -> skolkovo.getTagName())
        );

        return this;
    }
}
