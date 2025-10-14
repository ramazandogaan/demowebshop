import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseDriver;

import java.time.Duration;

public class US_205 extends BaseDriver {

    String validEmail = "evrem99evrem@gmail.com";
    String validPassword = "691296.Merve";
    String invalidEmail = "evrem99@gmai.com";
    String invalidPassword = "691296";

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

    @Test
    public void negativeLogin() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginFirst = driver.findElement(By.xpath("//a[@class='ico-login']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginFirst));
        loginFirst.click();

        WebElement verifyLoginPage = driver.findElement(By.xpath("(//div[@class='title'])[5]"));
        wait.until(ExpectedConditions.visibilityOf(verifyLoginPage));
        Assert.assertTrue("Login sayfası açılmadı", verifyLoginPage.isDisplayed());

        WebElement loginBtn = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();

        WebElement loginBtn1 = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn1));
        loginBtn1.click();

        WebElement failedLogin = driver.findElement(By.xpath("//div[@class='message-error']/div/span"));
        String actualText = failedLogin.getText();
        Assert.assertTrue(actualText.contains("Login was unsuccessful"));
    }

    @Test
    public void negativeLogin2() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginFirst = driver.findElement(By.xpath("//a[@class='ico-login']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginFirst));
        loginFirst.click();

        WebElement verifyLoginPage = driver.findElement(By.xpath("(//div[@class='title'])[5]"));
        wait.until(ExpectedConditions.visibilityOf(verifyLoginPage));
        Assert.assertTrue("Login sayfası açılmadı", verifyLoginPage.isDisplayed());

        WebElement emailInput = driver.findElement(By.id("Email"));
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(validEmail);

        WebElement loginBtn2 = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn2));
        loginBtn2.click();

        WebElement failedLogin2 = driver.findElement(By.xpath("//div[@class='message-error']/div/span"));
        String actualText2 = failedLogin2.getText();
        Assert.assertTrue(actualText2.contains("Login was unsuccessful"));
    }

    @Test
    public void negativeLogin3() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginFirst = driver.findElement(By.xpath("//a[@class='ico-login']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginFirst));
        loginFirst.click();

        WebElement verifyLoginPage = driver.findElement(By.xpath("(//div[@class='title'])[5]"));
        wait.until(ExpectedConditions.visibilityOf(verifyLoginPage));
        Assert.assertTrue("Login sayfası açılmadı", verifyLoginPage.isDisplayed());

        WebElement passwordInput = driver.findElement(By.id("Password"));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(validPassword);

        WebElement loginBtn3 = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn3));
        loginBtn3.click();

        WebElement failedLogin3 = driver.findElement(By.xpath("//div[@class='message-error']/div/span"));
        String actualText3 = failedLogin3.getText();
        Assert.assertTrue(actualText3.contains("Login was unsuccessful"));
    }

    @Test
    public void negativeLogin4() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement loginFirst = driver.findElement(By.xpath("//a[@class='ico-login']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginFirst));
        loginFirst.click();

        WebElement verifyLoginPage = driver.findElement(By.xpath("(//div[@class='title'])[5]"));
        wait.until(ExpectedConditions.visibilityOf(verifyLoginPage));
        Assert.assertTrue("Login sayfası açılmadı", verifyLoginPage.isDisplayed());

        WebElement wrongEmail = driver.findElement(By.xpath("//input[@class='email']"));
        wait.until(ExpectedConditions.visibilityOf(wrongEmail));
        wrongEmail.sendKeys(invalidEmail);

        WebElement wrongPassword = driver.findElement(By.id("Password"));
        wrongPassword.sendKeys(invalidPassword);

        WebElement loginBtn4 = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn4));
        loginBtn4.click();

        WebElement failedLogin4 = driver.findElement(By.xpath("//div[@class='message-error']/div/span"));
        String actualText4 = failedLogin4.getText();
        Assert.assertTrue(actualText4.contains("Login was unsuccessful"));

        tearDown();
    }
}
