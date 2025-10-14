import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseDriver;

import java.time.Duration;

public class US_201 extends BaseDriver {

    String password="123456";
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    @Test
    public void register(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement registerHomepageButton=driver.findElement(By.xpath("//a[text()='Register']"));
        registerHomepageButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[2]/div[1]/label")));

        WebElement maleRadioButton=wait.until(ExpectedConditions.elementToBeClickable(By.id("gender-male")));
        maleRadioButton.click();

        WebElement femaleRadioButton=wait.until(ExpectedConditions.elementToBeClickable(By.id("gender-female")));
        femaleRadioButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[2]/div[2]/label")));
        WebElement firstNameInput=wait.until(ExpectedConditions.elementToBeClickable(By.id("FirstName")));
        firstNameInput.sendKeys("Team");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[3]/label[1]")));
        WebElement lastNameInput=wait.until(ExpectedConditions.elementToBeClickable(By.id("LastName")));
        lastNameInput.sendKeys("Dort");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]/label")));
        WebElement emailInput=wait.until(ExpectedConditions.elementToBeClickable(By.id("Email")));
        emailInput.sendKeys("test"+(int)(Math.random()*1000)+"@test.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/div[2]/div[1]/label")));
        WebElement passwordInput=wait.until(ExpectedConditions.elementToBeClickable(By.id("Password")));
        passwordInput.sendKeys(password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/div[2]/div[2]/label")));
        WebElement confirmPasswordInput=wait.until(ExpectedConditions.elementToBeClickable(By.id("ConfirmPassword")));
        confirmPasswordInput.sendKeys(password);

        WebElement registerButton=wait.until(ExpectedConditions.elementToBeClickable(By.id("register-button")));
        registerButton.click();

        WebElement completedText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div/div[2]/div[1]")));
        Assert.assertTrue(completedText.isDisplayed());

        WebElement continueButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[2]/input")));
        continueButton.click();

        WebElement redirectHomepageText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[1]/h2")));
        Assert.assertTrue("\nWelcome to our store\n is not visible",redirectHomepageText.isDisplayed());

        tearDown();
    }
}
