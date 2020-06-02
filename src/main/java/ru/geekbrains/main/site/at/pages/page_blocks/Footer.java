package ru.geekbrains.main.site.at.pages.page_blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.pages.base.BasePageCreator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
        assertAll(
                () -> assertTrue(() -> facebookLink.isDisplayed()),
                () -> assertTrue(() -> vkLink.isDisplayed()),
                () -> assertTrue(() -> instagramLink.isDisplayed()),
                () -> assertTrue(() -> youtubeLink.isDisplayed()),
                () -> assertTrue(() -> telegramLink.isDisplayed()),

                () -> assertTrue(() -> feedbackLink.isDisplayed()),
                () -> assertTrue(() -> helpLink.isDisplayed()),
                () -> assertTrue(() -> aboutLink.isDisplayed()),
                () -> assertTrue(() -> licenseLink.isDisplayed()),
                () -> assertTrue(() -> careerLink.isDisplayed()),
                () -> assertTrue(() -> forbusinessLink.isDisplayed()),

                () -> assertTrue(() -> copyright.isDisplayed()),
                () -> assertTrue(() -> phone.isDisplayed()),
                () -> assertTrue(() -> skolkovo.isDisplayed())
        );

        return this;
    }
}
