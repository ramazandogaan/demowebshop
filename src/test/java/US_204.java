import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseDriver;

import java.time.Duration;

public class US_204 extends BaseDriver {
    String email = "evrem99evrem@gmail.com";
    String password = "691296.Merve";

    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(6));

    @Test
    public void loginSuccessfully() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginFirst= driver.findElement(By.xpath("//a[@class='ico-login']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginFirst));
        loginFirst.click();

        WebElement verifyLoginPage= driver.findElement(By.xpath("(//div[@class='title'])[5]"));
        wait.until(ExpectedConditions.visibilityOf(verifyLoginPage));
        Assert.assertTrue("Login sayfası açılmadı", verifyLoginPage.isDisplayed());

        WebElement emailInput= driver.findElement(By.id("Email"));
        emailInput.sendKeys(email);

        WebElement passwordInput= driver.findElement(By.id("Password"));
        passwordInput.sendKeys(password);

        WebElement loginBtn= driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();

        WebElement verifyHomePage= driver.findElement(By.xpath("(//a[@class='account'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(verifyHomePage));
        Assert.assertTrue("Home page açılmadı", verifyHomePage.isDisplayed());


    }
}
