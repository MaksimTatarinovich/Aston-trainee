package lesson_15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AboutServicePage {

    private WebDriver driver;
    private final String aboutServicePageURL = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

    public AboutServicePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAboutServicePageURL(){
        return aboutServicePageURL;
    }
}
