package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import io.qameta.allure.Step;
import java.time.Duration;

@Log4j2
public class ProductsPage {
    WebDriver driver;

    public ProductsPage (WebDriver driver) {
        this.driver = driver;
    }

    private static final By PRODUCT_PAGE = By.xpath("//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a");
    private static final By PRODUCT_BUY_BUTTON = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");

    @Step("Открытие страницы ProductsPage")
    public ProductsPage open() {
        driver.get("https://www.demoblaze.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(PRODUCT_PAGE));
        element.click();
        return this;
    }

    @Step("Добавление товара в корзину")
    public String addIntoCart() {
        driver.findElement(PRODUCT_BUY_BUTTON).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}