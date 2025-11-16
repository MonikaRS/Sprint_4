package ru.yandex.scooter.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@SuppressWarnings({"FieldMayBeFinal", "unused"})
public class OrderPage {

    private final WebDriver driver;

    // === ПЕРВАЯ СТРАНИЦА ФОРМЫ ===
    @FindBy(xpath = "//input[@placeholder='* Имя']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@placeholder='* Адрес: куда привезти заказ']")
    private WebElement addressInput;

    @FindBy(xpath = "//input[@placeholder='* Телефон: на него позвонит курьер']")
    private WebElement phoneInput;

    @FindBy(xpath = "//button[text()='Далее']")
    private WebElement nextButton;

    // === ВТОРАЯ СТРАНИЦА ФОРМЫ ===
    @FindBy(xpath = "//input[@placeholder='* Когда привезти самокат']")
    private WebElement dateInput;

    @FindBy(className = "Dropdown-placeholder")
    private WebElement rentalPeriodDropdown;

    @FindBy(xpath = "//div[text()='сутки']")
    private WebElement oneDayOption;

    @FindBy(xpath = "//div[text()='двое суток']")
    private WebElement twoDaysOption;

    @FindBy(id = "black")
    private WebElement blackColorCheckbox;

    @FindBy(id = "grey")
    private WebElement greyColorCheckbox;

    @FindBy(xpath = "//input[@placeholder='Комментарий для курьера']")
    private WebElement commentInput;

    @FindBy(xpath = "//button[text()='Заказать' and @class='Button_Button__ra12g Button_Middle__1CSJM']")
    private WebElement orderButton;

    @FindBy(xpath = "//button[text()='Да']")
    private WebElement confirmButton;

    @FindBy(xpath = "//div[contains(@class, 'OrderModal_Header')]")
    private WebElement successMessage;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Методы для первой страницы
    public void fillFirstPage(String name, String address, String phone) {
        enterName(name);
        enterAddress(address);
        enterPhone(phone);
        clickNextButton();
    }

    public void enterName(String name) {
        nameInput.sendKeys(name);
    }

    public void enterAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void enterPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    // Методы для второй страницы
    public void fillSecondPage(String date, String period, String color, String comment) {
        enterDate(date);
        selectRentalPeriod(period);
        selectColor(color);
        enterComment(comment);
        clickOrderButton();
    }

    public void enterDate(String date) {
        dateInput.sendKeys(date);
    }

    public void selectRentalPeriod(String period) {
        rentalPeriodDropdown.click();
        switch(period) {
            case "сутки":
                oneDayOption.click();
                break;
            case "двое суток":
                twoDaysOption.click();
                break;
        }
    }

    public void selectColor(String color) {
        if ("black".equals(color)) {
            blackColorCheckbox.click();
        } else if ("grey".equals(color)) {
            greyColorCheckbox.click();
        }
    }

    public void enterComment(String comment) {
        commentInput.sendKeys(comment);
    }

    public void clickOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(orderButton));
        orderButton.click();
    }

    public void confirmOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        confirmButton.click();
    }

    public boolean isOrderSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();
    }

    // === НОВЫЕ МЕТОДЫ ДЛЯ ВАЛИДАЦИИ ===
    public boolean isNameFieldError() {
        String className = nameInput.getAttribute("class");
        return className.contains("error") || className.contains("invalid") || className.contains("Input_Invalid");
    }

    public boolean isAddressFieldError() {
        String className = addressInput.getAttribute("class");
        return className.contains("error") || className.contains("invalid") || className.contains("Input_Invalid");
    }

    public boolean isPhoneFieldError() {
        String className = phoneInput.getAttribute("class");
        return className.contains("error") || className.contains("invalid") || className.contains("Input_Invalid");
    }

    public boolean isOnFirstPage() {
        return nameInput.isDisplayed() && addressInput.isDisplayed() && phoneInput.isDisplayed();
    }

    public void clearNameField() {
        nameInput.clear();
    }

    public void clearAddressField() {
        addressInput.clear();
    }

    public void clearPhoneField() {
        phoneInput.clear();
    }

    public void clearAllFields() {
        clearNameField();
        clearAddressField();
        clearPhoneField();
    }
}