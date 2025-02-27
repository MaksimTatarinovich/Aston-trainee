package lesson_15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MTSMainPage {

    private WebDriver driver;
    private final String nameOfBlock = "Онлайн пополнение\nбез комиссии";

    @FindBy(xpath = "//div[@class='pay__wrapper']/child::h2")
    private WebElement refillBlock;

    @FindBy(xpath = "//div[@class='pay__partners']//img")
    private List<WebElement> logos;

    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    private WebElement aboutServiceLink;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement replenishmentSumField;

    @FindBy(xpath = "//form[@id='pay-connection']//button[contains(@class, 'button__default') and text()='Продолжить']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@_ngcontent-oym-c43 and (@class='app-wrapper__content')]")
    private WebElement paymentWindows;

    public MTSMainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getRefillBlock(){
        return refillBlock;
    }

    public String getNameOfBlock(){
        return nameOfBlock;
    }

    public List<WebElement> getLogos(){
        return logos;
    }

    public void clickAboutButton(){
        aboutServiceLink.click();
    }

    public void enterPhoneNumber(String phoneNumber){
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void enterReplenishmentSum(String replenishmentSum){
        replenishmentSumField.sendKeys(replenishmentSum);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public WebElement getPaymentWindows(){return paymentWindows;}
}
