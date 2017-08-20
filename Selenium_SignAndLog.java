package selenium.multi_data_provider;

import org.junit.Assert;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;

import java.util.Random;

/**
 * Created by Tomáš on 18.8.2017.
 */
public class Selenium_SignAndLog {
    WebDriver driver;
    WebElement element;
    Random rand = new Random();
    int randomNumber = rand.nextInt(999);


    By signUp = By.linkText("Sign in");
    By emailCreate = By.id("email_create");
    By createAnAccount = By.id("SubmitCreate");

    public Selenium_SignAndLog (WebDriver driver){
        this.driver = driver;
    }

    public void clickSignUpButton(){
        driver.findElement(signUp).click();
    }

    public void fillEmail(){
        driver.findElement(emailCreate).sendKeys("vetrelec"+randomNumber+(char)64+"seznam.cz");

    }

    public void clickCreateButton() {
        driver.findElement(createAnAccount).click();
    }



    public void fillForm(String firstNameData) {
        By radioMr = By.id("id_gender1");
        By firstName = By.id("customer_firstname");
        By lastName = By.id("customer_lastname");
        By passwd = By.id("passwd");
        By newsletter = By.name("newsletter");
        By specialOffers = By.id("optin");
        By addressFirstName = By.id("firstname");
        By addressLastName = By.id("lastname");
        By company =  By.id("company");
        By address1 = By.id("address1");
        By address2 = By.id("address2");
        By city =  By.id("city");
        By country = By.id("id_state");
        By postCode = By.id("postcode");
        By mobileNumber = By.id("phone_mobile");
        By alias = By.name("alias");
        By submitButton = By.id("submitAccount");

        driver.findElement(radioMr).click();
        driver.findElement(firstName).sendKeys(firstNameData);
        driver.findElement(lastName).sendKeys("Nowak");
        driver.findElement(passwd).sendKeys("123abc");
        driver.findElement(newsletter).click();
        driver.findElement(specialOffers).click();
        driver.findElement(addressFirstName).sendKeys("Tester");
        driver.findElement(addressLastName).sendKeys("Testerovic");
        driver.findElement(company).sendKeys("microsoft");
        driver.findElement(address1).sendKeys("street123");
        driver.findElement(address2).sendKeys("apartment");
        driver.findElement(city).sendKeys("London");
        Select dropdown = new Select(driver.findElement(country));
        dropdown.selectByIndex(10);
        driver.findElement(postCode).sendKeys("10000");
        driver.findElement(mobileNumber).sendKeys("001692110");
        driver.findElement(alias).click();
        driver.findElement(alias).sendKeys("Address123");
        driver.findElement(submitButton).click();
    }

    public void checkCreditSlips(){
        By creditSlipIcon = By.className("icon-ban-circle");
        By checkText = By.xpath("//*[@id=\"block-history\"]/p");

        driver.findElement(creditSlipIcon).click();
        Assert.assertTrue(driver.getPageSource().contains("You have not received any credit slips."));

    }
    public void clickHomeButton(){
        By homeButton = By.linkText("Home");
        driver.findElement(homeButton).click();
    }
}
