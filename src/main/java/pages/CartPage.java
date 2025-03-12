package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

import java.time.Duration;

@Log4j2
public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By CART_LINK = By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a");
    private static final By PRODUCT_LINK = By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]");

    @Step("Открытие страницы ContactPage")
    public CartPage open() {
        driver.get("https://www.demoblaze.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(CART_LINK));
        element.click();
        return this;
    }

    @Step("Проверка наличия товара в корзине")
    public String checkCart() {
        return driver.findElement(PRODUCT_LINK).getText();
    }
}