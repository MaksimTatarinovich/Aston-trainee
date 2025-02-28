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
            System.out.println("�������� �� ����������� � ������� 5 �����.");
        }

        mtsMainPage = new MTSMainPage();
        paymentWindowPage = new PaymentWindowPage();
        mtsData = new MTSData();
    }

    @DisplayName("�������� �������� �����")
    @Description("���� ���� ��������� �������� �����")
    @Owner("Maksim Tatarinovich")
    @Link(name = "github", url = "https://github.com/MaksimTatarinovich")
    @Test
    public void checkNameOfBlock() {
        assertEquals(mtsMainPage.getRefillBlock().getText(), mtsData.getNameOfBlock());
    }

    @DisplayName("�������� ������� ���������")
    @Test
    public void checkLogosOnMainPage() {
        for (WebElement logo : mtsMainPage.getLogos()) {
            assertNotNull(logo.getDomAttribute("src"));
        }
    }

    @DisplayName("�������� ������ ������ <<��������� � �������>>")
    @Description("���� ���� ��������� ����������������� ������ <<��������� � �������>>")
    @Owner("Maksim Tatarinovich")
    @Link(name = "github", url = "https://github.com/MaksimTatarinovich")
    @Test
    public void checkLinkAboutService() {
        mtsMainPage.clickAboutButton();
        assertEquals(driver.getCurrentUrl(), mtsData.getAboutServicePageURL());
    }

    @DisplayName("�������� ������ ������ <<����������>>")
    @Test
    public void checkContinueButton() {
        mtsMainPage.loginCommunicationServices();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(paymentWindowPage.getPaymentWindow()));
        assertNotNull(paymentWindowPage.getPaymentWindow());
    }

    @DisplayName("�������� ������������� � ������ �����")
    @Test
    public void checkCommunicationServicesPlaceHolders() {
        mtsMainPage.clickToDropDownList();
        mtsMainPage.chooseCommunicationServicesInDropDownList();
        assertEquals(mtsMainPage.getInfoAboutCommunicationServices(), mtsData.getListOfCommunicationServicesPlaceHolders());
    }

    @DisplayName("�������� ������������� � �������� ��������")
    @Test
    public void checkHomeInternetPlaceHolders() {
        mtsMainPage.clickToDropDownList();
        mtsMainPage.chooseHomeInternetDropDownList();
        assertEquals(mtsMainPage.getInfoAboutHomeInternet(), mtsData.getListOfHomeInternetPlaceHolders());
    }

    @DisplayName("�������� ������������� � ���������")
    @Test
    public void checkInstalmentPlaceHolders() {
        mtsMainPage.clickToDropDownList();
        mtsMainPage.chooseInstalmentDropDownList();
        assertEquals(mtsMainPage.getInfoAboutInstalment(), mtsData.getListOfInstalmentPlaceHolders());
    }

    @DisplayName("�������� ������������� � �������������")
    @Test
    public void checkArrearsPlaceHolders() {
        mtsMainPage.clickToDropDownList();
        mtsMainPage.chooseArrearsDropDownList();
        assertEquals(mtsMainPage.getInfoAboutArrears(), mtsData.getListOfArrearsPlaceHolders());
    }

    @DisplayName("�������� ����������� ����� ����������")
    @Test
    public void checkReplenishmentSumDisplay() {
        mtsMainPage.loginCommunicationServices();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(paymentWindowPage.getPaymentWindow()));
        driver.switchTo().frame(paymentWindowPage.getPaymentWindow());
        wait.until(ExpectedConditions.visibilityOf(paymentWindowPage.getPayButton()));
        assertAll(
                () -> assertEquals(paymentWindowPage.getCostOnPayButton(), mtsData.getConnectionSum(), "������ ���� �����"),
                () -> assertEquals(paymentWindowPage.getPayDescriptionCost(), mtsData.getConnectionSum(), "������ ���� �����")
        );
    }

    @DisplayName("�������� ����������� ������ ��������")
    @Test
    public void checkReplenishmentPhoneDisplay() {
        mtsMainPage.loginCommunicationServices();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(paymentWindowPage.getPaymentWindow()));
        driver.switchTo().frame(paymentWindowPage.getPaymentWindow());
        wait.until(ExpectedConditions.visibilityOf(paymentWindowPage.getPayButton()));
        assertEquals(paymentWindowPage.getPayDescriptionText(), mtsData.getConnectionPhoneNumber());
    }

    @DisplayName("�������� ������������� ������ ����� � ���� ����������")
    @Test
    public void checkTextInEmptyCardFields() {
        mtsMainPage.loginCommunicationServices();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        wait.until(ExpectedConditions.visibilityOf(paymentWindowPage.getPaymentWindow()));
        driver.switchTo().frame(paymentWindowPage.getPaymentWindow());
        wait.until(ExpectedConditions.visibilityOf(paymentWindowPage.getPayButton()));
        assertEquals(mtsData.getListOfPaymentWindowPlaceHolders(), paymentWindowPage.getListOfEmptyFieldsPlaceHolders());
    }

    @DisplayName("�������� ������� ��������� ��������� ������")
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
