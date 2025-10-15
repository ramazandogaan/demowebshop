import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseDriver;

import java.time.Duration;

public class US_207 extends BaseDriver {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    String email = "ayse-oz@example.com";
    String password = "123456a1";

    @Test
    public void surveyResponse() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginBtn = driver.findElement(By.xpath("//a[@class='ico-login']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();

        WebElement emailInput = driver.findElement(By.id("Email"));
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("Password"));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);

        WebElement loginInput = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginInput));
        loginInput.click();

        WebElement communityPollText = driver.findElement(By.xpath("//div[@class='block block-poll']/div/strong"));

        String expected = "COMMUNITY POLL";
        String actual = communityPollText.getText();

        Assert.assertEquals("Sayfaya ulaşılamadı", expected, actual);

        WebElement radioBtn = driver.findElement(By.xpath("(//ul[@class='poll-options']/li/input)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(radioBtn));
        radioBtn.click();

        WebElement voteBtn = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(voteBtn));
        voteBtn.click();

        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(),'Excellent')]")));
        System.out.println(result);

        String expectedText = "Excellent";
        String actualText = result.getText();
        System.out.println(actualText);

        Assert.assertTrue(actualText.contains(expectedText));

        tearDown();
    }
}
