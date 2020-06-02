package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.main.site.at.base.GeekBrainsBaseTest;
import ru.geekbrains.main.site.at.pages.page_blocks.LeftMenu;

import java.util.stream.Stream;

@Execution(value = ExecutionMode.CONCURRENT)
public class NavigationTest extends GeekBrainsBaseTest {

    public static Stream getTitles() {
        return Stream.of("Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера");
    }

    @BeforeEach
    void setUp() {
        driver.get(getUrl("/career"));
    }

    @ParameterizedTest
    @MethodSource("getTitles")
    public void checkNavButtons(String title) {

        new LeftMenu(driver)
                .checkButtonTitle(title)
                .clickButton(title)

                .getHeader()
                .checkTitle(title)
                .checkMainElementsExist()

                .getFooter()
                .checkMainElementsExist();
    }
}
