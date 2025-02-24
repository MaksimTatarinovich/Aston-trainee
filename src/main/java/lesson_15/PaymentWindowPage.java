package lesson_15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class PaymentWindowPage {

    private WebDriver driver;

    @FindBy(xpath = "//iframe[@allowpaymentrequest and @class='bepaid-iframe']")
    private WebElement paymentWindow;

    @FindBy(xpath = "//div[@class='card-page__card']//button[@type='submit']")
    private WebElement payButton;

    @FindBy(xpath = "//div[contains(@class, 'pay-description__cost')]//span[1]")
    private WebElement payDescriptionCost;

    @FindBy(xpath = "//div[contains(@class, 'pay-description__text')]//span")
    private WebElement payDescriptionText;

    @FindBy(xpath = "//div[contains(local-name(_ngcontent-c46), '') and contains(@class, 'content-container ng-tns-c46-1')]")
    private WebElement cardNumberField;

    @FindBy(xpath = "//div[contains(local-name(_ngcontent-c46), '') and contains(@class, 'content-container ng-tns-c46-4')]")
    private WebElement validityPeriodField;

    @FindBy(xpath = "//div[contains(local-name(_ngcontent-c46), '') and contains(@class, 'content-container ng-tns-c46-5')]")
    private WebElement cvcField;

    @FindBy(xpath = "//div[contains(local-name(_ngcontent-c46), '') and contains(@class, 'content-container ng-tns-c46-3')]")
    private WebElement holderNameField;

    @FindBy(xpath = "//div[contains(@class, 'cards-brands__container')]//img")
    private List<WebElement> listOfLogos;

    public PaymentWindowPage() {
        driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
    }

    public WebElement getPaymentWindow() {
        return paymentWindow;
    }

    public WebElement getPayButton() {
        return payButton;
    }

    public String getCostOnPayButton() {
        return payButton.getText().replaceAll("[^\\d.]", "");
    }

    public String getPayDescriptionCost() {
        return payDescriptionCost.getText().substring(0, 5);
    }

    public String getPayDescriptionText() {
        return payDescriptionText.getText().substring(payDescriptionText.getText().indexOf("375") + 3);
    }

    public List<String> getListOfEmptyFieldsPlaceHolders() {
        String cardNumberText = cardNumberField.getText();
        String validityPeriodText = validityPeriodField.getText();
        String cvcText = cvcField.getText();
        String holderNameText = holderNameField.getText();
        return Arrays.asList(cardNumberText, validityPeriodText, cvcText, holderNameText);
    }

    public List<WebElement> getListOfLogos() {
        return listOfLogos;
    }
}
