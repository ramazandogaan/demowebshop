import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseDriver;

import java.time.Duration;

public class US_203 extends BaseDriver {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

    @Test
    public void logOutSuccessfully() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement logOutBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='ico-logout']")));
        wait.until(ExpectedConditions.visibilityOf(logOutBtn));
        logOutBtn.click();

        WebElement verifyLogOut = driver.findElement(By.xpath("//a[@class='ico-login']"));
        wait.until(ExpectedConditions.visibilityOf(verifyLogOut));
        String actualText = verifyLogOut.getText();
        Assert.assertTrue(actualText.contains("Log in"));

        tearDown();
    }
}
