import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import utilities.ReusableMethods;

import java.time.Duration;

public class US_206 {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    public void ordering(){


        driver.get("https://demowebshop.tricentis.com/");

        WebElement addtoCart = driver.findElement(By.xpath("(//input[@value='Add to cart'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(addtoCart));
        addtoCart.click();

        driver.get(driver.getCurrentUrl());

        WebElement shoppingCart = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("(//a[@class='ico-cart'])[1]")));
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCart));
        shoppingCart.click();

        WebElement dropdown = driver.findElement(By.id("CountryId"));
        Select select = new Select(dropdown);
        select.selectByIndex(2);

        WebElement zipCode = driver.findElement(By.xpath("//input[@class='zip-input']"));
        wait.until(ExpectedConditions.visibilityOf(zipCode));
        zipCode.sendKeys("00054");

        WebElement checkbox =driver.findElement(By.xpath("//input[@id='termsofservice']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        checkbox.click();

        WebElement checkout = driver.findElement(By.xpath("//button[@type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkout));
        checkout.click();

        WebElement guest = driver.findElement(By.xpath("(//input[@type='button'])[3]"));
        wait.until(ExpectedConditions.elementToBeClickable(guest));
        guest.click();

        WebElement firstname = driver.findElement(By.xpath("(//input[@id='BillingNewAddress_FirstName'])"));
        wait.until(ExpectedConditions.visibilityOf(firstname));
        firstname.sendKeys("Walter");

        WebElement lastname = driver.findElement(By.xpath("(//input[@id='BillingNewAddress_LastName'])"));
        wait.until(ExpectedConditions.visibilityOf(lastname));
        lastname.sendKeys("White");

        WebElement email = driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']"));
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("walterwhite@gmail.com");

        WebElement company = driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']"));
        wait.until(ExpectedConditions.visibilityOf(company));
        company.sendKeys("heisinberg");

        WebElement dropdown1 = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select1 = new Select(dropdown1);
        select1.selectByIndex(2);

        WebElement city = driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
        wait.until(ExpectedConditions.visibilityOf(city));
        city.sendKeys("America");

        WebElement adress1 = driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']"));
        wait.until(ExpectedConditions.visibilityOf(adress1));
        adress1.sendKeys("House");

        WebElement adress2 = driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address2']"));
        wait.until(ExpectedConditions.visibilityOf(adress2));
        adress2.sendKeys("House 2");

        WebElement zipcode2 = driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"));
        wait.until(ExpectedConditions.visibilityOf(zipcode2));
        zipcode2.sendKeys("4729");

        WebElement phonenumber = driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"));
        wait.until(ExpectedConditions.visibilityOf(phonenumber));
        phonenumber.sendKeys("04874791274");

        WebElement faxNumber= driver.findElement(By.xpath("//input[@id='BillingNewAddress_FaxNumber']"));
        wait.until(ExpectedConditions.visibilityOf(faxNumber));
        faxNumber.sendKeys("75827359");

        WebElement btncontinue = driver.findElement(By.xpath("(//input[@title='Continue'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(btncontinue));
        btncontinue.click();

        ReusableMethods.threadWait(10);

        WebElement instorepickup = driver.findElement(By.xpath("//input[@id='ç']"));
        wait.until(ExpectedConditions.elementToBeClickable(instorepickup));
        instorepickup.click();

        WebElement btncontinue2 = driver.findElement(By.xpath("(//input[@title='Continue'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(btncontinue2));
        btncontinue2.click();

        WebElement payment = driver.findElement(By.xpath("(//input[@id='paymentmethod_2'])"));
        wait.until(ExpectedConditions.elementToBeClickable(payment));
        payment.click();

        WebElement btncontinue3 = driver.findElement(By.xpath("(//input[@class='button-1 payment-method-next-step-button'])"));
        wait.until(ExpectedConditions.elementToBeClickable(btncontinue3));
        btncontinue3.click();

        WebElement cardholderName = driver.findElement(By.xpath("(//input[@id='CardholderName'])"));
        wait.until(ExpectedConditions.visibilityOf(cardholderName));
        cardholderName.sendKeys("Walter");

        WebElement cardNumber = driver.findElement(By.xpath("(//input[@id='CardNumber'])"));
        wait.until(ExpectedConditions.visibilityOf(cardNumber));
        cardNumber.sendKeys("4242 4242 4242 4242");

        WebElement dropdown2 = driver.findElement(By.id("ExpireYear"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("2032");






























    }
}
