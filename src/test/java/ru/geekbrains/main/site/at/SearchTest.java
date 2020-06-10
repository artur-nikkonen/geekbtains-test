package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import ru.geekbrains.main.site.at.base.GeekBrainsBaseTest;
import ru.geekbrains.main.site.at.pages.ContentPage;

public class SearchTest extends GeekBrainsBaseTest {

    @Step("Open page '/creer'")
    public void openStartPage(){
        driver.get(getUrl("/courses"));
    }
    @Test
    @Step("Test 'Java' blocks")
    public void searchJavaBlocksTest() {

        openStartPage();

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
