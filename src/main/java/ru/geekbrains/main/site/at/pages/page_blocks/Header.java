package ru.geekbrains.main.site.at.pages.page_blocks;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.pages.base.BasePageCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.*;

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

    @Step("Verify that all header elements are displayed")
    public Header checkMainElementsExist() {
        assertAll(
                () -> assertTrue(() -> title.isDisplayed()),
                () -> assertTrue(() -> showSearchFormButton.isDisplayed()),
                () -> assertTrue(() -> loginButton.isDisplayed()),
                () -> assertTrue(() -> registerButton.isDisplayed()),
                () -> assertTrue(() -> !searchInput.isDisplayed()) // по умолчанию не отображается
        );

        return this;
    }

    @Step("Verify that the title is '{expected}'")
    public Header checkTitle(String expected) {
        assertThat(expected, equalToIgnoringCase(title.getText()));
        return this;
    }

    @Step("Click search button to show search input")
    public Header showSearch() {
        showSearchFormButton.click();
        return this;
    }

    @Step("Print '{text}' to search input")
    public Header inputSearch(String text) {
        searchInput.sendKeys(text);
        return this;
    }
}
