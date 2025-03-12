package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dto.User;
import io.qameta.allure.Step;
import java.time.Duration;

@Log4j2
public class LoginPage {
    WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    private static final By LOGIN_PAGE = By.xpath("//*[@id=\"login2\"]");
    private static final By LOGIN_USERNAME = By.xpath("//*[@id=\"loginusername\"]");
    private static final By LOGIN_PASSWORD = By.xpath("//*[@id=\"loginpassword\"]");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    private static final By WELCOME_TEXT = By.xpath("//*[@id=\"nameofuser\"]");

    @Step("Открытие страницы LoginPage")
    public LoginPage open() {
        driver.get("https://www.demoblaze.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(LOGIN_PAGE));
        element.click();
        return this;
    }

    @Step("Авторизация в личном кабинете")
    public String regNewUser(User user) {
        driver.findElement(LOGIN_USERNAME).sendKeys(user.getUsername());
        driver.findElement(LOGIN_PASSWORD).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON ).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement newElement = wait.until(ExpectedConditions.visibilityOfElementLocated(WELCOME_TEXT));
        return newElement.getText();
    }
}