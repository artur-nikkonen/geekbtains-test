package ru.geekbrains.main.site.at.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.pages.base.BasePageCreator;

public class LoginPage extends BasePageCreator {

    @FindBy(css = "[data-testid='login-email']")
    private WebElement loginInput;

    @FindBy(css = "[data-testid='login-password']")
    private WebElement passwordInput;

    @FindBy(css = "[data-testid='login-submit']")
    private WebElement loginSubmitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login to site")
    public LoginPage login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginSubmitButton.click();

        return this;
    }
}
