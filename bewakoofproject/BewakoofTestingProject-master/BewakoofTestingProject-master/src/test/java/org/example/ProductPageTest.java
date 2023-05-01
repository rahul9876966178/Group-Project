package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ProductPageTest {
    WebDriver driver;

    @Test
    void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.bewakoof.com/");
        driver.manage().window().maximize();

        ProductPage productPage=new ProductPage(driver);
        productPage.checkProduct();
    }


}
