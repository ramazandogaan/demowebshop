import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseDriver;

import java.time.Duration;

public class US_209 extends BaseDriver {
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    String email = "leylamensei@gmail.com";
    String password = "123456";

    @Test
    public void downloadOrderHistory() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement homepageText = driver.findElement(By.cssSelector("div > p:nth-child(1)"));
        String expectedHomeText = "Welcome to the new Tricentis store!";
        Assert.assertEquals("Home page text wrong", expectedHomeText, homepageText.getText());

        WebElement loginBtn = driver.findElement(By.xpath("//div[@class='header-links']/ul/li[2]/a"));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();

        WebElement loginPageText = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        wait.until(ExpectedConditions.visibilityOf(loginPageText));

        WebElement emailInput = driver.findElement(By.id("Email"));
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("Password"));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);

        WebElement loginBtnLogPage = driver.findElement(By.xpath("//div[@class='buttons']/input[@type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtnLogPage));
        loginBtnLogPage.click();

        WebElement loggedInPageText = driver.findElement(By.cssSelector(".topic-html-content-header"));
        wait.until(ExpectedConditions.visibilityOf(loggedInPageText));

        WebElement usernameBtn = driver.findElement(By.cssSelector(".header-links a.account"));
        wait.until(ExpectedConditions.elementToBeClickable(usernameBtn));
        usernameBtn.click();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        String expectedName = "Leyla";
        String actualName = firstName.getAttribute("value");
        Assert.assertEquals("Wrong user Name", expectedName, actualName);

        WebElement lastName = driver.findElement(By.id("LastName"));
        String expectedLastName = "Menşei";
        String actualLastName = lastName.getAttribute("value");
        Assert.assertEquals("Wrong user Last Name", expectedLastName, actualLastName);

        WebElement userEmail = driver.findElement(By.id("Email"));
        String expectedEmail = "leylamensei@gmail.com";
        String actualEmail = userEmail.getAttribute("value");
        Assert.assertEquals("Wrong user Email", expectedEmail, actualEmail);

        WebElement ordersBtn = driver.findElement(By.xpath("//div[@class='listbox']/ul/li[3]/a"));
        wait.until(ExpectedConditions.elementToBeClickable(ordersBtn));
        ordersBtn.click();

        WebElement myAccountText = driver.findElement(By.cssSelector("div h1"));
        wait.until(ExpectedConditions.visibilityOf(myAccountText));

        WebElement ordersList = driver.findElement(By.xpath("//div[@class='order-list']"));
        wait.until(ExpectedConditions.visibilityOf(ordersList));

        WebElement detailsBtn = driver.findElement(By.xpath("//input[@type='button']"));
        wait.until(ExpectedConditions.elementToBeClickable(detailsBtn));
        detailsBtn.click();

        WebElement orderInfoText = driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        wait.until(ExpectedConditions.visibilityOf(orderInfoText));

        WebElement downloadBtn = driver.findElement(By.xpath("//div[@class='page-title']/a[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(downloadBtn));
        downloadBtn.click();

        tearDown();
    }
}
