package ru.geekbrains.main.site.at.pages.page_blocks;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.geekbrains.main.site.at.pages.base.BaseElementsList;
import ru.geekbrains.main.site.at.pages.base.BasePageCreator;

//сделал не как на уроке для разнообразия. И switch я не люблю)))))

public class LeftMenu extends BasePageCreator {

    private BaseElementsList buttons;

    public LeftMenu(WebDriver driver) {
        super(driver);

        buttons = new BaseElementsList(driver, "nav.gb-left-menu__nav>a[href='%s']");

        buttons.add("Курсы", "/courses");
        buttons.add("Вебинары", "/events");
        buttons.add("Форум", "/topics");
        buttons.add("Блог", "/posts");
        buttons.add("Тесты", "/tests");
        buttons.add("Карьера", "/career");
    }

    @Step("Click button '{name}' ")
    public LeftMenu clickButton(String name) {
        buttons.click(name);
        return this;
    }

    @Step("Check button {buttonName} has title {title} ")
    public LeftMenu checkButtonTitle(String buttonName, String title) {
        buttons.checkTitle(buttonName, title);
        return this;
    }

    public LeftMenu checkButtonTitle(String buttonName) {
        buttons.checkTitle(buttonName);
        return this;
    }
}

