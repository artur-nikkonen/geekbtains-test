package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.main.site.at.base.GeekBrainsBaseTest;
import ru.geekbrains.main.site.at.pages.LoginPage;

public class LoginTest extends GeekBrainsBaseTest {

    @BeforeEach
    @Step("Open page '/login'")
    void setUp() {
        driver.get(getUrl("/login"));
    }

    @Test
    public void checkLogin() {
        new LoginPage(driver)
                .login("hao17583@bcaoo.com", "hao17583")
                .getHeader()
                .checkTitle("Главная");
    }

    @Test
    public void checkCoursesAfterLogin() {
        new LoginPage(driver)
                .login("hao17583@bcaoo.com", "hao17583")

                .getLeftMenu()
                .clickButton("Курсы")

                .getCoursesNavLinks()
                .clickLink("Курсы")


                .getCoursesFilter()
                //.clickInput("Бесплатные") //курсы больше не бесплатные)))
                .clickInput("Тестирование")

                .getCoursesPage()
                .checkCardDisplayed("Тестирование ПО. Уровень 1")
                .checkCardDisplayed("Тестирование ПО. Уровень 2");
    }
}
