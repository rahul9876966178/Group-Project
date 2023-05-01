package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PaymentMethodTest {
    WebDriver driver;
    PaymentMethod pay;

    @Test
    void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //noinspection deprecation
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.bewakoof.com/login/");
        driver.manage().window().maximize();

        pay=new PaymentMethod(driver);
        pay.PayItem();
    }
}
