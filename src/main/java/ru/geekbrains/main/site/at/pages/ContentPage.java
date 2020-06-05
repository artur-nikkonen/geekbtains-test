package ru.geekbrains.main.site.at.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.pages.base.BasePageCreator;
import ru.geekbrains.main.site.at.pages.page_blocks.LeftMenu;

import java.util.List;

public class ContentPage extends BasePageCreator {

    public ContentPage(WebDriver driver) {
        super(driver);
    }

    public LeftMenu getLeftMenu() {
        return new LeftMenu(driver);
    }

    public ContentPage checkTitle(String expected) {
        getHeader().checkTitle(expected);
        return this;
    }

    @Step("Close popup window")
    public ContentPage closePopup() {
        try {
            //Ждем пока появятся 2 картинки кнопок закрывания окна
            String closePopupButtonsSvgPath = "button > svg.icon-popup-close-button";

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(closePopupButtonsSvgPath), 2));

            //находим обе картинки
            List<WebElement> allSvg = driver.findElements(By.cssSelector(closePopupButtonsSvgPath));

            //нажимаем на кнопку которую видно (в зависимости от размеров окна)
            for (WebElement s : allSvg) {

                WebElement button = s.findElement(By.xpath("./.."));

                if (button.isDisplayed()) {
                    button.click();
                    break;
                }
            }
        } catch (TimeoutException ex) {
            //значить окно не всплыло. Всё ок.
        }

        return this;
    }
}
