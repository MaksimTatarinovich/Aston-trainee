package lesson_15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class MTSMainPage {

    private WebDriver driver;
    private MTSData mtsData;

    @FindBy(xpath = "//div[@class='pay__wrapper']/child::h2")
    private WebElement refillBlock;

    @FindBy(xpath = "//div[@class='pay__partners']//img")
    private List<WebElement> logos;

    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    private WebElement aboutServiceLink;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement connectionPhoneField;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement connectionSumField;

    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement connectionEmailField;

    @FindBy(xpath = "//input[@id='internet-phone']")
    private WebElement internetPhoneField;

    @FindBy(xpath = "//input[@id='internet-sum']")
    private WebElement internetSumField;

    @FindBy(xpath = "//input[@id='internet-email']")
    private WebElement internetEmailField;

    @FindBy(xpath = "//input[@id='score-instalment']")
    private WebElement instalmentScoreField;

    @FindBy(xpath = "//input[@id='instalment-sum']")
    private WebElement instalmentSumField;

    @FindBy(xpath = "//input[@id='instalment-email']")
    private WebElement instalmentEmailField;

    @FindBy(xpath = "//input[@id='score-arrears']")
    private WebElement arrearsScoreField;

    @FindBy(xpath = "//input[@id='arrears-sum']")
    private WebElement arrearsSumField;

    @FindBy(xpath = "//input[@id='arrears-email']")
    private WebElement arrearsEmailField;

    @FindBy(xpath = "//form[@id='pay-connection']//button[contains(@class, 'button__default') and text()='Продолжить']")
    private WebElement continueButton;

    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement dropDownListInRefillBlock;

    @FindBy(xpath = "//div[@class='pay__form']//p[text()='Услуги связи']")
    private WebElement communicationServices;

    @FindBy(xpath = "//div[@class='pay__form']//p[text()='Домашний интернет']")
    private WebElement homeInternet;

    @FindBy(xpath = "//div[@class='pay__form']//p[text()='Рассрочка']")
    private WebElement instalment;

    @FindBy(xpath = "//div[@class='pay__form']//p[text()='Задолженность']")
    private WebElement arrears;

    public MTSMainPage() {
        driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
        mtsData = new MTSData();
    }

    public WebElement getRefillBlock() {
        return refillBlock;
    }


    public List<WebElement> getLogos() {
        return logos;
    }

    public void clickAboutButton() {
        aboutServiceLink.click();
    }

    public void enterConnectionPhoneNumber() {
        connectionPhoneField.sendKeys(mtsData.getConnectionPhoneNumber());
    }

    public void enterConnectionSum() {
        connectionSumField.sendKeys(mtsData.getConnectionSum());
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void loginCommunicationServices() {
        enterConnectionPhoneNumber();
        enterConnectionSum();
        clickContinueButton();
    }

    public void clickToDropDownList() {
        dropDownListInRefillBlock.click();
    }

    public void chooseCommunicationServicesInDropDownList() {
        communicationServices.click();
    }

    public void chooseHomeInternetDropDownList() {
        homeInternet.click();
    }

    public void chooseInstalmentDropDownList() {
        instalment.click();
    }

    public void chooseArrearsDropDownList() {
        arrears.click();
    }

    public List<String> getInfoAboutCommunicationServices() {
        String phonePlaceHolder = connectionPhoneField.getDomAttribute("placeholder");
        String sumPlaceHolder = connectionSumField.getDomAttribute("placeholder");
        String emailPlaceHolder = connectionEmailField.getDomAttribute("placeholder");
        return Arrays.asList(phonePlaceHolder, sumPlaceHolder, emailPlaceHolder);
    }

    public List<String> getInfoAboutHomeInternet() {
        String phonePlaceHolder = internetPhoneField.getDomAttribute("placeholder");
        String sumPlaceHolder = internetSumField.getDomAttribute("placeholder");
        String emailPlaceHolder = internetEmailField.getDomAttribute("placeholder");
        return Arrays.asList(phonePlaceHolder, sumPlaceHolder, emailPlaceHolder);
    }

    public List<String> getInfoAboutInstalment() {
        String scorePlaceHolder = instalmentScoreField.getDomAttribute("placeholder");
        String sumPlaceHolder = instalmentSumField.getDomAttribute("placeholder");
        String emailPlaceHolder = instalmentEmailField.getDomAttribute("placeholder");
        return Arrays.asList(scorePlaceHolder, sumPlaceHolder, emailPlaceHolder);
    }

    public List<String> getInfoAboutArrears() {
        String scorePlaceHolder = arrearsScoreField.getDomAttribute("placeholder");
        String sumPlaceHolder = arrearsSumField.getDomAttribute("placeholder");
        String emailPlaceHolder = arrearsEmailField.getDomAttribute("placeholder");
        return Arrays.asList(scorePlaceHolder, sumPlaceHolder, emailPlaceHolder);
    }
}
