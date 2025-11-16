package ru.yandex.scooter.tests;

import org.junit.Test;
import ru.yandex.scooter.pageobjects.HomePage;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class FaqTest extends BaseTest {

    @Test
    public void testAllFaqQuestions() {
        HomePage homePage = new HomePage(driver);

        for (int i = 0; i < 8; i++) {
            homePage.clickQuestion(i);
            assertTrue("Ответ на вопрос " + (i + 1) + " должен отображаться после клика",
                    homePage.isAnswerDisplayed(i));

            String answerText = homePage.getAnswerText(i);
            assertFalse("Ответ на вопрос " + (i + 1) + " должен быть пустым",
                    answerText.isEmpty());
        }
    }

    @Test
    public void testFaqToggleFunctionality() {
        HomePage homePage = new HomePage(driver);

        assertFalse("Ответ на вопрос 1 должен быть скрыт по умолчанию",
                homePage.isAnswerDisplayed(0));

        homePage.clickQuestion(0);
        assertTrue("Ответ на вопрос 1 должен отображаться после первого клика",
                homePage.isAnswerDisplayed(0));

        homePage.clickQuestion(0);
        assertFalse("Ответ на вопрос 1 должен скрыться после второго клика",
                homePage.isAnswerDisplayed(0));
    }
}