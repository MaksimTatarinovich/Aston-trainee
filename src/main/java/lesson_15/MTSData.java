package lesson_15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class MTSData {

    private final List<String> ListOfPaymentWindowPlaceHolders = Arrays.asList("����� �����", "���� ��������", "CVC", "��� ��������� (��� �� �����)");
    private final String nameOfBlock = "������ ����������\n��� ��������";
    private final String connectionSum = "50.00";
    private final String connectionPhoneNumber = "297777777";
    private final List<String> listOfCommunicationServicesPlaceHolders = Arrays.asList("����� ��������", "�����", "E-mail ��� �������� ����");
    private final List<String> listOfHomeInternetPlaceHolders = Arrays.asList("����� ��������", "�����", "E-mail ��� �������� ����");
    private final List<String> listOfInstalmentPlaceHolders = Arrays.asList("����� ����� �� 44", "�����", "E-mail ��� �������� ����");
    private final List<String> listOfArrearsPlaceHolders = Arrays.asList("����� ����� �� 2073", "�����", "E-mail ��� �������� ����");
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
