package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import dto.User;

import static org.testng.Assert.assertEquals;

@Log4j2
public class CheckoutTest extends BaseTest {
    User user = new User("arinak", "123456");
    /*
        ## Проверка авторизации и добавления товара в корзину ##
        1. Перейти на веб-страницу https://www.demoblaze.com/index.html
        2. Нажать на кнопку "Log in"
        3. Заполнить поля всплывающей формы
           - ввести имя пользователя: "arinak"
           - ввести пароль: "123456"
        4. Нажать на кнопку "Log in"
        5. Дождаться возвращения на страницу с товарами
        6. Проверить отображение надписи: "Welcome arinak"
        7. Перейти по ссылке на товар "Nexus 6"
        8. Нажать на кнопку "Add to cart"
        9. Проверить видимость сообщения с текстом: "Product added"
        10. Перейти в раздел "Cart"
        11. Проверить наличие добавленного товара в корзине
     */

    @Test
    public void checkSendMessage() {
        assertEquals(loginPage.open().regNewUser(user), "Welcome ArinaK");
        assertEquals(productsPage.open().addIntoCart(), "Product added.");
        assertEquals(cartPage.open().checkCart(), "Nexus 6");
    }
}