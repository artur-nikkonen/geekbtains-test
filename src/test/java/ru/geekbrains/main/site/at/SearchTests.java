package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.selectors.Header;

import java.util.List;

public class SearchTests extends GeekBrainsBaseTests {

    @Test
    void searchJavaBlocksTest() {

        driver.get(getUrl("/courses"));
        closePopup();
        searchText("java");
        checkTabs();
    }

    void checkTabs() {
        //ждем загрузку панели
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.search-page-tabs")));

        Assertions.assertTrue(checkTab("professions", "Профессии", 2));
        Assertions.assertTrue(checkTab("courses", "Курсы", 16));
        Assertions.assertTrue(checkTab("webinars", "Вебинары", 181, 299));
        Assertions.assertTrue(checkTab("blogs", "Блоги", 301));
        Assertions.assertTrue(checkTab("forums", "Форумы", 350));
        Assertions.assertTrue(checkTab("tests", "Тесты", 1));
        //Нет в задании. Надо уточнить диапазон
        Assertions.assertTrue(checkTab("companies", "Компании", 1));
    }

    boolean checkTab(String dataTab, String text, int minValue) {
        return checkTab(dataTab, text, minValue, Integer.MAX_VALUE);
    }

    boolean checkTab(String dataTab, String text, int minValue, int maxValue) {
        String xpath = "//ul[@class='search-page-tabs']//a[@data-tab='" + dataTab + "']";
        WebElement tab = driver.findElement(By.xpath(xpath));

        String[] parts = tab.getText().split("・");
        int number = Integer.parseInt(parts[1]);

        boolean textCorrect = parts[0].equals(text);
        boolean numberCorrect = number >= minValue && number <= maxValue;

        return textCorrect && numberCorrect;
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
            //не удалось найти только видимую кнопку так, как хотелось. Такой xpath находит и видимую и скрытую кнопки:
            // //button[not(contains(@style, 'display:none'))]//*[local-name()='svg' and contains(@class,'icon-popup-close-button')]/..
            //Хотя, у второй кнопки явно display:none. Думаю, у xpath проблемы с вычисляемыми стилями. Надо подумать.

            //Ждем пока появятся 2 картинки кнопок закрывания окна
            String closePopupButtonsSvgPath = "button > svg.icon-popup-close-button";

            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(closePopupButtonsSvgPath), 2));

            //находим обе картинки
            List<WebElement> svgs = driver.findElements(By.cssSelector(closePopupButtonsSvgPath));

            //нажимаем на кнопку которую видно (в зависимости от размеров окна)
            for (WebElement s : svgs) {

                WebElement button = s.findElement(By.xpath("./.."));

                if (!button.getCssValue("display").equals("none")) {
                    button.click();
                    return;
                }
            }
        } catch (TimeoutException ex) {
            //значить окно не всплыло. Всё ок.
        }
    }
}
