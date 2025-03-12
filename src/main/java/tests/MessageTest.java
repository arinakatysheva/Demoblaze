package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import dto.Contact;

import static org.testng.Assert.assertEquals;

@Log4j2
public class MessageTest extends BaseTest {

    Contact contact = new Contact ("arinakatysheva@gmail.com", "ArinaK", "I want to buy");

    /*
        ## Тестирование отправки сообщений ##
        1. Перейти на веб-страницу https://www.demoblaze.com/index.html
        2. Нажать на кнопку "Contact"
        3. Заполнить поля всплывающей формы
           - ввести email: "arinakatysheva@gmail.com"
           - вести имя: "ArinaK"
           - ввести сообщение: "I want to buy"
        4. Нажать на кнопку "Send message"
        5. Проверить видимость сообщения с текстом: "Thanks for the message!!"
     */

    @Test
    public void checkSendMessage() {
        assertEquals(contactPage.open().sendMessage(contact), "Thanks for the message!!");
    }
}