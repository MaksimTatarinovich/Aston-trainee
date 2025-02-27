package lesson_15_tests;

import lesson_15.AboutServicePage;
import lesson_15.MTSMainPage;
import lesson_15.WebDriverSingleton;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MTSMainPageTest {

    private WebDriver driver;
    private MTSMainPage mtsMainPage;
    private AboutServicePage aboutServicePage;

    @BeforeEach
    public void setUp(){
        driver = WebDriverSingleton.getInstance();
        driver.get("https://www.mts.by/");

        mtsMainPage = new MTSMainPage(driver);
        aboutServicePage = new AboutServicePage(driver);
    }

    @DisplayName("Проверка названия блока")
    @Test
    public void checkNameOfBlock(){
        assertEquals(mtsMainPage.getRefillBlock().getText(), mtsMainPage.getNameOfBlock());
    }

    @DisplayName("Проверка наличия логотипов")
    @Test
    public void checkLogos(){
        for (WebElement logo : mtsMainPage.getLogos()) {
            String src = logo.getDomAttribute("src");
            assertNotNull(src);
        }
    }

    @DisplayName("Проверка работы ссылки <<Подробнее о сервисе>>")
    @Test
    public void checkLinkAboutService(){
        mtsMainPage.clickAboutButton();
        assertEquals(driver.getCurrentUrl(), aboutServicePage.getAboutServicePageURL());
    }

    @DisplayName("Проверка работы кнопки <<Продолжить>>")
    @Test
    public void checkContinueButton(){
        mtsMainPage.enterPhoneNumber("297777777");
        mtsMainPage.enterReplenishmentSum("50");
        mtsMainPage.clickContinueButton();
        assertNotNull(mtsMainPage.getPaymentWindows());
    }

    @AfterEach
    public void tearDown(){
        WebDriverSingleton.closeDriver();
    }
}
