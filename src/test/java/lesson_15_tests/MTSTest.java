package lesson_15_tests;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import lesson_15.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MTSTest {

    private WebDriver driver;
    private MTSMainPage mtsMainPage;
    private PaymentWindowPage paymentWindowPage;
    private MTSData mtsData;

    @BeforeEach
    public void setUp() {
        driver = WebDriverSingleton.getInstance();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
        try {
            driver.get("https://www.mts.by/");
        } catch (TimeoutException e) {
            System.out.println("Страница не загрузилась в течение 5 минут.");
        }

        mtsMainPage = new MTSMainPage();
        paymentWindowPage = new PaymentWindowPage();
        mtsData = new MTSData();
    }

    @DisplayName("Проверка названия блока")
    @Description("Этот тест проверяет название блока")
    @Owner("Maksim Tatarinovich")
    @Link(name = "github", url = "https://github.com/MaksimTatarinovich")
    @Test
    public void checkNameOfBlock() {
        assertEquals(mtsMainPage.getRefillBlock().getText(), mtsData.getNameOfBlock());
    }

    @DisplayName("Проверка наличия логотипов")
    @Test
    public void checkLogosOnMainPage() {
        for (WebElement logo : mtsMainPage.getLogos()) {
            assertNotNull(logo.getDomAttribute("src"));
        }
    }

    @DisplayName("Проверка работы ссылки <<Подробнее о сервисе>>")
    @Description("Этот тест проверяет работоспособность ссылки <<Подробнее о сервисе>>")
    @Owner("Maksim Tatarinovich")
    @Link(name = "github", url = "https://github.com/MaksimTatarinovich")
    @Test
    public void checkLinkAboutService() {
        mtsMainPage.clickAboutButton();
        assertEquals(driver.getCurrentUrl(), mtsData.getAboutServicePageURL());
    }

    @DisplayName("Проверка работы кнопки <<Продолжить>>")
    @Test
    public void checkContinueButton() {
        mtsMainPage.loginCommunicationServices();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(paymentWindowPage.getPaymentWindow()));
        assertNotNull(paymentWindowPage.getPaymentWindow());
    }

    @DisplayName("Проверка плейсхолдеров в Услуги связи")
    @Test
    public void checkCommunicationServicesPlaceHolders() {
        mtsMainPage.clickToDropDownList();
        mtsMainPage.chooseCommunicationServicesInDropDownList();
        assertEquals(mtsMainPage.getInfoAboutCommunicationServices(), mtsData.getListOfCommunicationServicesPlaceHolders());
    }

    @DisplayName("Проверка плейсхолдеров в Домашний интернет")
    @Test
    public void checkHomeInternetPlaceHolders() {
        mtsMainPage.clickToDropDownList();
        mtsMainPage.chooseHomeInternetDropDownList();
        assertEquals(mtsMainPage.getInfoAboutHomeInternet(), mtsData.getListOfHomeInternetPlaceHolders());
    }

    @DisplayName("Проверка плейсхолдеров в Рассрочка")
    @Test
    public void checkInstalmentPlaceHolders() {
        mtsMainPage.clickToDropDownList();
        mtsMainPage.chooseInstalmentDropDownList();
        assertEquals(mtsMainPage.getInfoAboutInstalment(), mtsData.getListOfInstalmentPlaceHolders());
    }

    @DisplayName("Проверка плейсхолдеров в Задолженность")
    @Test
    public void checkArrearsPlaceHolders() {
        mtsMainPage.clickToDropDownList();
        mtsMainPage.chooseArrearsDropDownList();
        assertEquals(mtsMainPage.getInfoAboutArrears(), mtsData.getListOfArrearsPlaceHolders());
    }

    @DisplayName("Проверка отображения суммы пополнения")
    @Test
    public void checkReplenishmentSumDisplay() {
        mtsMainPage.loginCommunicationServices();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(paymentWindowPage.getPaymentWindow()));
        driver.switchTo().frame(paymentWindowPage.getPaymentWindow());
        wait.until(ExpectedConditions.visibilityOf(paymentWindowPage.getPayButton()));
        assertAll(
                () -> assertEquals(paymentWindowPage.getCostOnPayButton(), mtsData.getConnectionSum(), "Должны быть равны"),
                () -> assertEquals(paymentWindowPage.getPayDescriptionCost(), mtsData.getConnectionSum(), "Должны быть равны")
        );
    }

    @DisplayName("Проверка отображения номера телефона")
    @Test
    public void checkReplenishmentPhoneDisplay() {
        mtsMainPage.loginCommunicationServices();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(paymentWindowPage.getPaymentWindow()));
        driver.switchTo().frame(paymentWindowPage.getPaymentWindow());
        wait.until(ExpectedConditions.visibilityOf(paymentWindowPage.getPayButton()));
        assertEquals(paymentWindowPage.getPayDescriptionText(), mtsData.getConnectionPhoneNumber());
    }

    @DisplayName("Проверка плейсхолдеров пустых полей в окне пополнения")
    @Test
    public void checkTextInEmptyCardFields() {
        mtsMainPage.loginCommunicationServices();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        wait.until(ExpectedConditions.visibilityOf(paymentWindowPage.getPaymentWindow()));
        driver.switchTo().frame(paymentWindowPage.getPaymentWindow());
        wait.until(ExpectedConditions.visibilityOf(paymentWindowPage.getPayButton()));
        assertEquals(mtsData.getListOfPaymentWindowPlaceHolders(), paymentWindowPage.getListOfEmptyFieldsPlaceHolders());
    }

    @DisplayName("Проверка наличия логотипов платежных систем")
    @Test
    public void checkLogosOnPaymentWindow() {
        mtsMainPage.loginCommunicationServices();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(paymentWindowPage.getPaymentWindow()));
        driver.switchTo().frame(paymentWindowPage.getPaymentWindow());
        wait.until(ExpectedConditions.visibilityOf(paymentWindowPage.getPayButton()));
        for (WebElement logo : paymentWindowPage.getListOfLogos()) {
            assertNotNull(logo.getDomAttribute("src"));
        }
    }

    @AfterEach
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}
