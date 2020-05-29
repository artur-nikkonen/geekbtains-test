package ru.geekbrains.main.site.at;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.geekbrains.main.site.at.selectors.Footer;
import ru.geekbrains.main.site.at.selectors.Header;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NavigationTests extends GeekBrainsBaseTests {

    public static Stream<Arguments> getPathsAndTitles() {
        return Stream.of(
                Arguments.of("/courses", "Курсы"),
                Arguments.of("/events", "Вебинары"),
                Arguments.of("/topics", "Форум"),
                Arguments.of("/posts", "Блог"),
                Arguments.of("/tests", "Тесты"),
                Arguments.of("/career", "Карьера")
        );
    }

    //Переделал тест, чтобы он был похож на тот, который задан в презентации к 3 уроку
    @ParameterizedTest
    @MethodSource("getPathsAndTitles")
    public void checkAllButtons(String path, String title) {

        //Переходим на начальную страницу
        driver.get(getUrl("/career"));

        //Проверяем кнопку и нажади на нее
        checkButtonAndClick(path, title);

        //Проверяем загруженную страницу
        checkTitle(title);
        checkHeader();
        checkFooter();
    }

    private void checkButtonAndClick(String path, String title) {
        String buttonSelector = "a.gb-left-menu__nav-item[href='" + path + "']";
        WebElement button = driver.findElement(By.cssSelector(buttonSelector));

        assertThat(button.getText(), equalToIgnoringCase(title));

        button.click();
    }

    private void checkTitle(String title) {
        String text = driver.findElement(By.xpath("//header//h2")).getText();
        assertThat(title, equalTo(text));
    }

    void checkHeader() {
        //проверяем только наличие элементов
        assertThat(getFirstElementBy(Header.root), notNullValue());
        assertThat(getFirstElementBy(Header.title), notNullValue());
        assertThat(getFirstElementBy(Header.searchInput), notNullValue());
        assertThat(getFirstElementBy(Header.showSearchFormButton), notNullValue());
        assertThat(getFirstElementBy(Header.loginButton), notNullValue());
        assertThat(getFirstElementBy(Header.registerButton), notNullValue());
    }

    void checkFooter() {
        //проверяем только наличие элементов
        assertThat(getFirstElementBy(Footer.root), notNullValue());

        assertThat(getFirstElementBy(Footer.facebookLink), notNullValue());
        assertThat(getFirstElementBy(Footer.vkLink), notNullValue());
        assertThat(getFirstElementBy(Footer.instagramLink), notNullValue());
        assertThat(getFirstElementBy(Footer.youtubeLink), notNullValue());
        assertThat(getFirstElementBy(Footer.telegramLink), notNullValue());

        assertThat(getFirstElementBy(Footer.feedbackLink), notNullValue());
        assertThat(getFirstElementBy(Footer.helpLink), notNullValue());
        assertThat(getFirstElementBy(Footer.aboutLink), notNullValue());
        assertThat(getFirstElementBy(Footer.licenseLink), notNullValue());
        assertThat(getFirstElementBy(Footer.careerLink), notNullValue());
        assertThat(getFirstElementBy(Footer.forbusinessLink), notNullValue());

        assertThat(getFirstElementBy(Footer.copyright), notNullValue());
        assertThat(getFirstElementBy(Footer.phone), notNullValue());
        assertThat(getFirstElementBy(Footer.copyright), notNullValue());
    }
}
