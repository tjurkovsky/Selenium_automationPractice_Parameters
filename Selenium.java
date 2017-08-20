package selenium.multi_data_provider;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;

/**
 * Created by Tomáš on 18.8.2017.
 */
public class Selenium {

    public static WebDriver driver;
    static String driverPathChrome = "D:\\chromedriver_2.exe";
    static String driverPathFirefox = "D:\\geckodriver_2.exe";
    static String driverPathIE = "D:\\IEDriverServer.exe";



    @BeforeClass(alwaysRun = true)
    public static void setUpBrowser() {
        String browser = "Chrome";
        if (browser == "Chrome") {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            System.setProperty("webdriver.chrome.driver", driverPathChrome);
            driver = new ChromeDriver(options);

        } else if (browser == "Firefox"){
            System.setProperty("webdriver.gecko.driver", driverPathFirefox);
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            driver = new FirefoxDriver(capabilities);

        } else {
            System.setProperty("webdriver.ie.driver", driverPathIE);
           driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

}

    @BeforeMethod
    public void webPage() {
        driver.navigate().to("http://automationpractice.com/index.php");
        String strPageTitle = driver.getTitle();
        System.out.println("Website name: "+strPageTitle);
        System.out.println("Driver: "+driver);
        Assert.assertTrue(strPageTitle.equalsIgnoreCase("My store"));
    }

    @Test(dependsOnMethods="webPage")
    @Parameters({"firstNameData"})
    public void automationPractice(String firstNameData) {
        Selenium_SignAndLog registration = new Selenium_SignAndLog(driver);
        registration.clickSignUpButton();
        registration.fillEmail();
        registration.clickCreateButton();
        registration.fillForm(firstNameData);
        registration.checkCreditSlips();
    }
        @Test(description = "test rozdelen na 2 testy kvuli reportu")
         public void test2 () {Selenium_SignAndLog registration2 = new Selenium_SignAndLog(driver);
            registration2.clickHomeButton();
  }
  /*  @AfterClass
    public static void tearDown(){
        if (driver != null)
            System.out.println("Closing browser!");
            driver.quit();
    }*/
}


