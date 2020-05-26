package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.geekbrains.main.site.at.selectors.Footer;
import ru.geekbrains.main.site.at.selectors.Header;

public class HeaderAndFooterTests extends GeekBrainsBaseTests {

    @Test
    void coursesTest() {
        runMainChecks("/courses");
    }

    @Test
    void eventsTest() {
        runMainChecks("/events");
    }

    @Test
    void topicsTest() {
        runMainChecks("/topics");
    }

    @Test
    void postsTest() {
        runMainChecks("/posts");
    }

    @Test
    void educationTest() {
        runMainChecks("/education");
    }

    @Test
    void testsTest() {
        runMainChecks("/tests");
    }

    @Test
    void careerTest() {
        runMainChecks("/career");
    }

    void runMainChecks(String path) {
        driver.get(getUrl(path));

        checkHeader();
        checkFooter();
    }

    void checkHeader() {
        //проверяем только наличие элементов
        Assertions.assertNotNull(getFirstElementBy(Header.root));
        Assertions.assertNotNull(getFirstElementBy(Header.title));
        Assertions.assertNotNull(getFirstElementBy(Header.searchInput));
        Assertions.assertNotNull(getFirstElementBy(Header.showSearchFormButton));
        Assertions.assertNotNull(getFirstElementBy(Header.loginButton));
        Assertions.assertNotNull(getFirstElementBy(Header.registerButton));
    }

    void checkFooter() {
        //проверяем только наличие элементов
        Assertions.assertNotNull(getFirstElementBy(Footer.root));

        Assertions.assertNotNull(getFirstElementBy(Footer.facebookLink));
        Assertions.assertNotNull(getFirstElementBy(Footer.vkLink));
        Assertions.assertNotNull(getFirstElementBy(Footer.instagramLink));
        Assertions.assertNotNull(getFirstElementBy(Footer.youtubeLink));
        Assertions.assertNotNull(getFirstElementBy(Footer.telegramLink));

        Assertions.assertNotNull(getFirstElementBy(Footer.feedbackLink));
        Assertions.assertNotNull(getFirstElementBy(Footer.helpLink));
        Assertions.assertNotNull(getFirstElementBy(Footer.aboutLink));
        Assertions.assertNotNull(getFirstElementBy(Footer.licenseLink));
        Assertions.assertNotNull(getFirstElementBy(Footer.careerLink));
        Assertions.assertNotNull(getFirstElementBy(Footer.forbusinessLink));

        Assertions.assertNotNull(getFirstElementBy(Footer.copyright));
        Assertions.assertNotNull(getFirstElementBy(Footer.phone));
        Assertions.assertNotNull(getFirstElementBy(Footer.copyright));
    }
}
