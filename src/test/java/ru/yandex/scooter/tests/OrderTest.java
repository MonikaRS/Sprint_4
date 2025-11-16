package ru.yandex.scooter.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.scooter.pageobjects.HomePage;
import ru.yandex.scooter.pageobjects.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;
    private final String buttonType; // "top" или "bottom"

    public OrderTest(String name, String surname, String address, String phone,
                     String date, String period, String color, String comment, String buttonType) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
        this.buttonType = buttonType;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                // Набор 1 - через верхнюю кнопку
                {"Иван", "Иванов", "ул. Пушкина, д. 10", "+79991112233",
                        "25.12.2024", "сутки", "black", "Позвонить за час", "top"},

                // Набор 2 - через нижнюю кнопку
                {"Мария", "Петрова", "пр. Ленина, д. 25", "+79994445566",
                        "26.12.2024", "двое суток", "grey", "Код от домофона 123", "bottom"}
        };
    }

    @Test
    public void testOrderScooterWithDifferentData() {
        HomePage homePage = new HomePage(driver);
        OrderPage orderPage = new OrderPage(driver);

        // Выбор кнопки заказа в зависимости от параметра
        if ("top".equals(buttonType)) {
            homePage.clickOrderButtonTop();
        } else {
            homePage.clickOrderButtonBottom();
        }

        // Заполнение первой страницы формы
        orderPage.fillFirstPage(name + " " + surname, address, phone);

        // Заполнение второй страницы формы
        orderPage.fillSecondPage(date, period, color, comment);

        // Подтверждение заказа
        orderPage.confirmOrder();

        // Проверка успешного создания заказа
        assertTrue("Заказ должен быть успешно создан", orderPage.isOrderSuccess());
    }
}
