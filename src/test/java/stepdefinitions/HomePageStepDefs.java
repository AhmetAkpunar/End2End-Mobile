package stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Allpages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class HomePageStepDefs {


    Allpages  allpages = new Allpages();
    //AppiumDriver driver = Driver.getAppiumDriver();

    @Given("Alltricks anasayfasina gidin")
    public void alltricks_anasayfasina_gidin() throws InterruptedException {

        Driver.getAppiumDriver().get(ConfigReader.getProperty("Url"));
        allpages.cookies.click();

    }

    @Given("Profil sekmesine gec")
    public void profil_sekmesine_gec() {

        allpages.profil.click();
    }

    @Then("Adresim kismime emaili gir")
    public void adresim_kismime_emaili_gir() {

        allpages.monProfil.click();
        allpages.email.sendKeys("ahmetakpunar");
    }

}
