package ru.geekbrains.main.site.at.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.pages.base.BasePageCreator;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CoursesPage extends BasePageCreator {

    @FindBy(css = ".gb-course-card")
    private List<WebElement> coursesCards;

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify that '{title}' is displayed")
    public CoursesPage checkCardDisplayed(String title) {

        for (WebElement card : coursesCards) {
            String cardTitle = card.findElement(By.cssSelector(".gb-course-card__title-text")).getText();

            if (cardTitle.equals(title)) {
                assertThat(card.isDisplayed(), is(true));
                return this;
            }
        }

        throw new NotFoundException(String.format("Card not found [%s]", title));
    }

}
