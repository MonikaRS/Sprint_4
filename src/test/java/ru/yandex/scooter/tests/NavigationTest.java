package ru.yandex.scooter.tests;

import org.junit.Test;
import ru.yandex.scooter.pageobjects.HomePage;

import static org.junit.Assert.assertEquals;

public class NavigationTest extends BaseTest {

    @Test
    public void testScooterLogoNavigation() {
        HomePage homePage = new HomePage(driver);

        // Запоминаем исходный URL
        String originalUrl = homePage.getCurrentUrl();
        System.out.println("Исходный URL: " + originalUrl);

        // Кликаем на логотип Самоката
        homePage.clickScooterLogo();

        // Даем время для навигации
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Прерывание ожидания: " + e.getMessage());
        }

        // Проверяем, что остались на той же странице (главной)
        String newUrl = homePage.getCurrentUrl();
        System.out.println("Новый URL: " + newUrl);

        assertEquals("После клика на логотип Самоката должны остаться на главной странице",
                originalUrl, newUrl);

        System.out.println("✓ Тест навигации по логотипу Самоката пройден!");
    }
}