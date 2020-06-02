package ru.geekbrains.main.site.at.pages.page_blocks;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.pages.base.BasePageCreator;

public class CoursesNavLinks extends BasePageCreator {

    @FindBy(css = "ul.nav-tabs>li>[id=\"prof-link\"]")
    private WebElement professionsLink;

    @FindBy(css = "ul.nav-tabs>li>[id=\"free-link\"]")
    private WebElement freeIntensivesLink;

    @FindBy(css = "ul.nav-tabs>li>[id=\"cour-link\"]")
    private WebElement coursesLink;


    public CoursesNavLinks(WebDriver driver) {
        super(driver);
    }

    public CoursesNavLinks clickLink(String name) {

        switch (name) {
            case "Профессии": {
                professionsLink.click();
                break;
            }
            case "Бесплатные интенсивы": {
                freeIntensivesLink.click();
                break;
            }
            case "Курсы": {
                coursesLink.click();
                break;
            }
            default: {
                throw new NotFoundException(String.format("Link not found [%s]", name));
            }
        }

        return this;
    }
}
