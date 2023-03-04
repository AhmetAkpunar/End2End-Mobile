package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.time.Duration;

public class Allpages {

    public Allpages(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(15)),this);
    }

    @FindBy(xpath = "//button[@id='didomi-notice-agree-button']")
    public WebElement cookies;
    @FindBy(xpath = "//a[@class='alltricks-Header-userTrigger']")
    public WebElement profil;
    @FindBy (xpath = "(//li[@class='first'])[1]")
    public WebElement monProfil;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

}
