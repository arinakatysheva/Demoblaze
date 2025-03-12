package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dto.Contact;
import org.openqa.selenium.Alert;
import io.qameta.allure.Step;
import java.time.Duration;

@Log4j2
public class ContactPage {
    WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By CONTACT_US = By.xpath("/html/body/nav/div[1]/ul/li[2]/a");
    private static final By CONTACT_EMAIL = By.id("recipient-email");
    private static final By CONTACT_NAME = By.id("recipient-name");
    private static final By MESSAGE_TEXT = By.id("message-text");
    private static final By MESSAGE_BUTTON = By.xpath("//button[text()='Send message']");

    @Step("Открытие страницы ContactPage")
    public ContactPage open() {
        driver.get("https://www.demoblaze.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(CONTACT_US));
        element.click();
        return this;
    }

    @Step("Отправка сообщения")
    public String sendMessage(Contact contact) {
        driver.findElement(CONTACT_EMAIL).sendKeys(contact.getEmail());
        driver.findElement(CONTACT_NAME).sendKeys(contact.getUsername());
        driver.findElement(MESSAGE_TEXT).sendKeys(contact.getMessage());
        driver.findElement(MESSAGE_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}