import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseDriver;

import java.time.Duration;

public class US_208 extends BaseDriver {
    String email = "lunar.nova42@outlook.com";
    String password = "12345++aA-s";
    String firstName = "Gurhan";
    String lastName = "Atas";
    String city = "Chicago";
    String address1 = "Michigan Av. S.Wall st. #34";
    String zipCode = "62890";
    String phoneNr = "0555555555";

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    public void shoppingWithoutCouponsAndGiftCards() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement registerBtn = driver.findElement(By.xpath("//a[@class='ico-register']"));
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn));
        registerBtn.click();

        WebElement genderRadioBtn = driver.findElement(By.xpath("//input[@id='gender-male']"));
        wait.until(ExpectedConditions.elementToBeClickable(genderRadioBtn));
        genderRadioBtn.click();

        WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='FirstName']"));
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.sendKeys(firstName);

        WebElement lastNameInput = driver.findElement(By.xpath("//input[@name='LastName']"));
        wait.until(ExpectedConditions.visibilityOf(lastNameInput));
        lastNameInput.sendKeys(lastName);

        WebElement emailInput = driver.findElement(By.xpath("//input[@name='Email']"));
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='Password']"));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordInput));
        confirmPasswordInput.sendKeys(password);

        WebElement RegisterBtn = driver.findElement(By.xpath("//input[@name='register-button']"));
        wait.until(ExpectedConditions.elementToBeClickable(RegisterBtn));
        RegisterBtn.click();

        WebElement registerationCompletedMessage = driver.findElement(By.xpath("//div[@class='result']"));
        Assert.assertTrue(" 'Your registration completed'  message is not visible", registerationCompletedMessage.isDisplayed());

        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        continueBtn.click();

        WebElement computersField = driver.findElement(By.xpath("//ul[@class='top-menu']/li[2]/a"));
        wait.until(ExpectedConditions.elementToBeClickable(computersField));
        computersField.click();
        WebElement notebookField = driver.findElement(By.xpath("(//h2[@class='title']/a)[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(notebookField));
        notebookField.click();

        WebElement addToCartBtn = driver.findElement(By.xpath("//input[@value='Add to cart']"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addToCartBtn.click();

        WebElement shoppingCartField = driver.findElement(By.xpath("(//span[@class='cart-label'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartField));
        shoppingCartField.click();

        WebElement applyCouponBtn = driver.findElement(By.xpath("//input[@value='Apply coupon']"));
        wait.until(ExpectedConditions.elementToBeClickable(applyCouponBtn));
        applyCouponBtn.click();

        WebElement couponMessage = driver.findElement(By.xpath("//div[@class='message']"));
        Assert.assertTrue(" 'The coupon code you entered couldn't be applied to your order' message is not visible", couponMessage.isDisplayed());

        WebElement addGiftCardBtn = driver.findElement(By.xpath("//input[@value='Add gift card']"));
        wait.until(ExpectedConditions.elementToBeClickable(addGiftCardBtn));
        addGiftCardBtn.click();

        WebElement couponMessage2 = driver.findElement(By.xpath("//div[@class='message']"));
        Assert.assertTrue(" 'The coupon code you entered couldn't be applied to your order' message is not visible", couponMessage2.isDisplayed());

        WebElement termsOfServiceCheckBox = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        wait.until(ExpectedConditions.elementToBeClickable(termsOfServiceCheckBox));
        termsOfServiceCheckBox.click();

        WebElement checkoutBtn = driver.findElement(By.xpath("//button[@name='checkout']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        checkoutBtn.click();

        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@name='BillingNewAddress.CountryId']"));
        Select select = new Select(dropdownMenu);
        select.selectByVisibleText("United States");

        WebElement cityInput = driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
        wait.until(ExpectedConditions.visibilityOf(cityInput));
        cityInput.sendKeys(city);

        WebElement address1Input = driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']"));
        address1Input.sendKeys(address1);

        WebElement zipInput = driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"));
        zipInput.sendKeys(zipCode);

        WebElement phoneNrInput = driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"));
        phoneNrInput.sendKeys(phoneNr);
        WebElement continueBtn2 = driver.findElement(By.xpath("(//input[@value='Continue'])[1]"));
        continueBtn2.click();

        WebElement continueBtn3 = driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"));
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn3));
        continueBtn3.click();

        WebElement continueBtn4 = driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']"));
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn4));
        continueBtn4.click();

        WebElement continueBtn5 = driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn5));
        continueBtn5.click();

        WebElement continueBtn6 = driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']"));
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn6));
        continueBtn6.click();
        WebElement confirmBtn = driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"));
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
        confirmBtn.click();

        WebElement continueBtn7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='button']")));
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn7));
        continueBtn7.click();

        WebElement successfulOrder = driver.findElement(By.xpath("//input[@type='button']"));
        Assert.assertTrue("Your order has not been completed", successfulOrder.isDisplayed());

        tearDown();
    }
}