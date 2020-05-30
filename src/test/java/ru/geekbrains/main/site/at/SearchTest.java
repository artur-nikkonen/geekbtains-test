package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Test;
import ru.geekbrains.main.site.at.base.GeekBrainsBaseTest;
import ru.geekbrains.main.site.at.pages.ContentPage;

public class SearchTest extends GeekBrainsBaseTest {

    @Test
    public void searchJavaBlocksTest() {

        driver.get(getUrl("/courses"));

        new ContentPage(driver)
                .closePopup()

                .getHeader()
                .showSearch()
                .inputSearch("java")

                .getHeaderTabs()
                .WaitTabs()
                .checkTab("Профессии", 2)
                .checkTab("Курсы", 16)
                .checkTab("Вебинары", 181, 299)
                .checkTab("Блоги", 301)
                .checkTab("Форумы", 350)
                .checkTab("Тесты", 1)
                .checkTab("Компании", 1);
    }
}
