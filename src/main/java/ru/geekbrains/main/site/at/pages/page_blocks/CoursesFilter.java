package ru.geekbrains.main.site.at.pages.page_blocks;

import org.openqa.selenium.WebDriver;
import ru.geekbrains.main.site.at.pages.base.BaseElementsList;
import ru.geekbrains.main.site.at.pages.base.BasePageCreator;

public class CoursesFilter extends BasePageCreator {

    private BaseElementsList inputs;

    public CoursesFilter(WebDriver driver) {
        super(driver);

        inputs = new BaseElementsList(driver, "input[value='%s']");

        inputs.add("Бесплатные", "free");
        inputs.add("Для начинающих", "beginner");
        inputs.add("Веб-разработка", "web");
        inputs.add("Разработка программ", "soft");
        inputs.add("Веб-дизайн", "design");
        inputs.add("Мобильная разработка", "mob");
        inputs.add("Разработка игр", "game");
        inputs.add("Информационная безопасность", "ib");
        inputs.add("Data Science", "data_science");
        inputs.add("Тестирование", "tester");
        inputs.add("Интернет маркетинг", "smm");
        inputs.add("Системное администрирование", "admin");
        inputs.add("GeekClub", "geekclub");
        inputs.add("Киберспорт", "esport");
    }

    public CoursesFilter clickInput(String name) {
        inputs.click(name);
        return this;
    }
}
