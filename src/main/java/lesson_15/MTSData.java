package lesson_15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class MTSData {

    private final List<String> ListOfPaymentWindowPlaceHolders = Arrays.asList("Номер карты", "Срок действия", "CVC", "Имя держателя (как на карте)");
    private final String nameOfBlock = "Онлайн пополнение\nбез комиссии";
    private final String connectionSum = "50.00";
    private final String connectionPhoneNumber = "297777777";
    private final List<String> listOfCommunicationServicesPlaceHolders = Arrays.asList("Номер телефона", "Сумма", "E-mail для отправки чека");
    private final List<String> listOfHomeInternetPlaceHolders = Arrays.asList("Номер абонента", "Сумма", "E-mail для отправки чека");
    private final List<String> listOfInstalmentPlaceHolders = Arrays.asList("Номер счета на 44", "Сумма", "E-mail для отправки чека");
    private final List<String> listOfArrearsPlaceHolders = Arrays.asList("Номер счета на 2073", "Сумма", "E-mail для отправки чека");
    private final String aboutServicePageURL = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

    public List<String> getListOfPaymentWindowPlaceHolders() {
        return ListOfPaymentWindowPlaceHolders;
    }

    public String getConnectionPhoneNumber() {
        return connectionPhoneNumber;
    }

    public String getConnectionSum() {
        return connectionSum;
    }

    public String getNameOfBlock() {
        return nameOfBlock;
    }

    public List<String> getListOfCommunicationServicesPlaceHolders() {
        return listOfCommunicationServicesPlaceHolders;
    }

    public List<String> getListOfHomeInternetPlaceHolders() {
        return listOfHomeInternetPlaceHolders;
    }

    public List<String> getListOfInstalmentPlaceHolders() {
        return listOfInstalmentPlaceHolders;
    }

    public List<String> getListOfArrearsPlaceHolders() {
        return listOfArrearsPlaceHolders;
    }

    public String getAboutServicePageURL() {
        return aboutServicePageURL;
    }
}
