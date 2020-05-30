package ru.geekbrains.main.site.at.pages.base;

import org.openqa.selenium.WebDriver;
import ru.geekbrains.main.site.at.pages.ContentPage;
import ru.geekbrains.main.site.at.pages.CoursesPage;
import ru.geekbrains.main.site.at.pages.LoginPage;
import ru.geekbrains.main.site.at.pages.page_blocks.*;

public class BasePageCreator extends BasePage {

    public BasePageCreator(WebDriver driver) {
        super(driver);
    }

    public HeaderTabs getHeaderTabs() {
        return new HeaderTabs(driver);
    }

    public Footer getFooter() {
        return new Footer(driver);
    }

    public Header getHeader() {
        return new Header(driver);
    }

    public ContentPage getContentPage() {
        return new ContentPage(driver);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public LeftMenu getLeftMenu() {
        return new LeftMenu(driver);
    }

    public CoursesNavLinks getCoursesNavLinks() {
        return new CoursesNavLinks(driver);
    }

    public CoursesFilter getCoursesFilter() {
        return new CoursesFilter(driver);
    }

    public CoursesPage getCoursesPage() {
        return new CoursesPage(driver);
    }
}
