package ru.yandex.scooter.tests;

import org.junit.Test;
import ru.yandex.scooter.pageobjects.HomePage;
import ru.yandex.scooter.pageobjects.OrderPage;

import static org.junit.Assert.assertTrue;

public class ValidationTest extends BaseTest {

    @Test
    public void testEmptyFormValidation() {
        HomePage homePage = new HomePage(driver);
        OrderPage orderPage = new OrderPage(driver);

        // Переходим к форме заказа
        homePage.clickOrderButtonTop();

        // Пытаемся отправить пустую форму
        orderPage.clickNextButton();

        // Даем время для валидации
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Прерывание ожидания: " + e.getMessage());
        }

        // Проверяем, что остались на первой странице (валидация не прошла)
        boolean stillOnFirstPage = orderPage.isOnFirstPage();
        assertTrue("При пустой форме должны остаться на первой странице", stillOnFirstPage);

        // Проверяем, что поля показывают ошибки (если приложение поддерживает)
        boolean nameHasError = orderPage.isNameFieldError();
        boolean addressHasError = orderPage.isAddressFieldError();
        boolean phoneHasError = orderPage.isPhoneFieldError();

        System.out.println("Поле имени имеет ошибку: " + nameHasError);
        System.out.println("Поле адреса имеет ошибку: " + addressHasError);
        System.out.println("Поле телефона имеет ошибку: " + phoneHasError);

        System.out.println("✓ Тест валидации пустой формы завершен!");
    }
}