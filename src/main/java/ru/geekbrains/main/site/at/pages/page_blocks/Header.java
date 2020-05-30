package ru.geekbrains.main.site.at.pages.page_blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.pages.base.BasePageCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Header extends BasePageCreator {
    public static final String rootXPath = "//*[@id='top-menu']";

    @FindBy(xpath = rootXPath)
    private WebElement root;

    @FindBy(xpath = "//*[@id='top-menu']//*[@class='gb-header__title']")
    private WebElement title;

    @FindBy(xpath = "//*[@id='top-menu']//*[@class='show-search-form']")
    private WebElement showSearchFormButton;

    @FindBy(xpath = "//*[@id='top-menu']//*[@href='/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='top-menu']//*[@href='/register']")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@id='top-menu']//*[@class='search-panel__search-field']")
    private WebElement searchInput;

    //-----------------------------------

    public Header(WebDriver driver) {
        super(driver);
    }

    public Header checkMainElementsExist() {

        //не знаю как красиво проверить сущетвование элемента
        //решил просто взять имена тегов. Если элемента нет, то вылетит ошибка

        assertAll(
                () -> assertDoesNotThrow(() -> title.getTagName()),
                () -> assertDoesNotThrow(() -> showSearchFormButton.getTagName()),
                () -> assertDoesNotThrow(() -> loginButton.getTagName()),
                () -> assertDoesNotThrow(() -> registerButton.getTagName()),
                () -> assertDoesNotThrow(() -> searchInput.getTagName())
        );

        return this;
    }

    public Header checkTitle(String expected) {
        assertThat(expected, equalToIgnoringCase(title.getText()));
        return this;
    }

    public Header showSearch() {
        showSearchFormButton.click();
        return this;
    }

    public Header inputSearch(String text) {
        searchInput.sendKeys(text);
        return this;
    }
}
