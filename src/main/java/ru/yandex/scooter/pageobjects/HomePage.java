package ru.yandex.scooter.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings({"FieldMayBeFinal", "unused"})
public class HomePage {

    private final WebDriver driver;

    // Кнопка "Заказать" вверху страницы
    @FindBy(xpath = "(//button[text()='Заказать'])[1]")
    private WebElement orderButtonTop;

    // Кнопка "Заказать" внизу страницы
    @FindBy(xpath = "(//button[text()='Заказать'])[2]")
    private WebElement orderButtonBottom;

    // Логотип Самоката
    @FindBy(className = "Header_LogoScooter__3lsAR")
    private WebElement scooterLogo;

    // Логотип Яндекса
    @FindBy(className = "Header_LogoYandex__3TSOI")
    private WebElement yandexLogo;

    // === ВСЕ 8 ВОПРОСОВ FAQ ===
    @FindBy(id = "accordion__heading-0")
    private WebElement question0;

    @FindBy(id = "accordion__panel-0")
    private WebElement answer0;

    @FindBy(id = "accordion__heading-1")
    private WebElement question1;

    @FindBy(id = "accordion__panel-1")
    private WebElement answer1;

    @FindBy(id = "accordion__heading-2")
    private WebElement question2;

    @FindBy(id = "accordion__panel-2")
    private WebElement answer2;

    @FindBy(id = "accordion__heading-3")
    private WebElement question3;

    @FindBy(id = "accordion__panel-3")
    private WebElement answer3;

    @FindBy(id = "accordion__heading-4")
    private WebElement question4;

    @FindBy(id = "accordion__panel-4")
    private WebElement answer4;

    @FindBy(id = "accordion__heading-5")
    private WebElement question5;

    @FindBy(id = "accordion__panel-5")
    private WebElement answer5;

    @FindBy(id = "accordion__heading-6")
    private WebElement question6;

    @FindBy(id = "accordion__panel-6")
    private WebElement answer6;

    @FindBy(id = "accordion__heading-7")
    private WebElement question7;

    @FindBy(id = "accordion__panel-7")
    private WebElement answer7;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Методы для кнопок заказа
    public void clickOrderButtonTop() {
        orderButtonTop.click();
    }

    public void clickOrderButtonBottom() {
        orderButtonBottom.click();
    }

    // === МЕТОДЫ ДЛЯ FAQ ===
    public void clickQuestion(int questionNumber) {
        switch(questionNumber) {
            case 0: question0.click(); break;
            case 1: question1.click(); break;
            case 2: question2.click(); break;
            case 3: question3.click(); break;
            case 4: question4.click(); break;
            case 5: question5.click(); break;
            case 6: question6.click(); break;
            case 7: question7.click(); break;
            default: throw new IllegalArgumentException("Неверный номер вопроса: " + questionNumber);
        }
    }

    public boolean isAnswerDisplayed(int questionNumber) {
        switch(questionNumber) {
            case 0: return answer0.isDisplayed();
            case 1: return answer1.isDisplayed();
            case 2: return answer2.isDisplayed();
            case 3: return answer3.isDisplayed();
            case 4: return answer4.isDisplayed();
            case 5: return answer5.isDisplayed();
            case 6: return answer6.isDisplayed();
            case 7: return answer7.isDisplayed();
            default: throw new IllegalArgumentException("Неверный номер вопроса: " + questionNumber);
        }
    }

    public String getAnswerText(int questionNumber) {
        switch(questionNumber) {
            case 0: return answer0.getText();
            case 1: return answer1.getText();
            case 2: return answer2.getText();
            case 3: return answer3.getText();
            case 4: return answer4.getText();
            case 5: return answer5.getText();
            case 6: return answer6.getText();
            case 7: return answer7.getText();
            default: throw new IllegalArgumentException("Неверный номер вопроса: " + questionNumber);
        }
    }


    public void clickScooterLogo() {
        scooterLogo.click();
    }

    public void clickYandexLogo() {
        yandexLogo.click();
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}