package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.selectors.Header;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchTests extends GeekBrainsBaseTests {

    @Test
    public void searchJavaBlocksTest() {

        driver.get(getUrl("/courses"));
        closePopup();
        searchText("java");
        checkTabs();
    }

    void checkTabs() {
        //ждем загрузку панели
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.search-page-tabs")));

        checkTab("professions", "Профессии", 2);
        checkTab("courses", "Курсы", 16);
        checkTab("webinars", "Вебинары", 181, 299);
        checkTab("blogs", "Блоги", 301);
        checkTab("forums", "Форумы", 350);
        checkTab("tests", "Тесты", 1);
        checkTab("companies", "Компании", 1); //Нет в задании. Надо уточнить диапазон
    }

    void checkTab(String dataTab, String text, int minValue) {
        checkTab(dataTab, text, minValue, Integer.MAX_VALUE);
    }

    void checkTab(String dataTab, String text, int minValue, int maxValue) {
        String xpath = "//ul[@class='search-page-tabs']//a[@data-tab='" + dataTab + "']";
        WebElement tab = driver.findElement(By.xpath(xpath));

        String[] parts = tab.getText().split("・");
        int number = Integer.parseInt(parts[1]);
        String name = parts[0];

        assertThat(name, equalTo(text));
        assertThat(number, allOf(
                greaterThanOrEqualTo(minValue),
                lessThanOrEqualTo(maxValue)
        ));
    }

    void searchText(String text) {
        //открываем окно для поиска
        WebElement searchButton = driver.findElement(Header.showSearchFormButton);
        searchButton.click();

        //пишем в окно поиска текст
        WebElement searchInput = driver.findElement(Header.searchInput);
        searchInput.sendKeys(text);
    }

    void closePopup() {
        try {
            //Ждем пока появятся 2 картинки кнопок закрывания окна
            String closePopupButtonsSvgPath = "button > svg.icon-popup-close-button";

            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(closePopupButtonsSvgPath), 2));

            //находим обе картинки
            List<WebElement> svgs = driver.findElements(By.cssSelector(closePopupButtonsSvgPath));

            //нажимаем на кнопку которую видно (в зависимости от размеров окна)
            for (WebElement s : svgs) {

                WebElement button = s.findElement(By.xpath("./.."));

                if (button.isDisplayed()) {
                    button.click();
                    return;
                }
            }
        } catch (TimeoutException ex) {
            //значить окно не всплыло. Всё ок.
        }
    }
}
