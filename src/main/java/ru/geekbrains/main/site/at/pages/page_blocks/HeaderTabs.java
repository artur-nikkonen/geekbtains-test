package ru.geekbrains.main.site.at.pages.page_blocks;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.pages.base.BaseElementsList;
import ru.geekbrains.main.site.at.pages.base.BasePageCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HeaderTabs extends BasePageCreator {

    BaseElementsList tabs;

    public HeaderTabs(WebDriver driver) {
        super(driver);

        tabs = new BaseElementsList(driver, "ul.search-page-tabs > li > a[data-tab='%s']");

        tabs.add("Профессии", "professions");
        tabs.add("Курсы", "courses");
        tabs.add("Вебинары", "webinars");
        tabs.add("Блоги", "blogs");
        tabs.add("Форумы", "forums");
        tabs.add("Тесты", "tests");
        tabs.add("Компании", "companies");
    }

    @Step("Wait while tabs loaded")
    public HeaderTabs WaitTabs() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.search-page-tabs")));
        return this;
    }

    public HeaderTabs checkTab(String name, int minValue) {
        return checkTab(name, minValue, Integer.MAX_VALUE);
    }

    @Step("Verify that tab '{name}' has number >={minValue} and <={maxValue}")
    public HeaderTabs checkTab(String name, int minValue, int maxValue) {

        String text = tabs.getText(name);

        String[] parts = text.split("・");
        int number = Integer.parseInt(parts[1]);
        String tabTitle = parts[0];

        assertThat(tabTitle, equalTo(name));
        assertThat(number, allOf(
                greaterThanOrEqualTo(minValue),
                lessThanOrEqualTo(maxValue)
        ));

        return this;
    }
}
