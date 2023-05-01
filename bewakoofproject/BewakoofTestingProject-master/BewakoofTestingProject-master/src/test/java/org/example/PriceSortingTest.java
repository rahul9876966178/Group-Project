package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.annotations.Test;

public class PriceSortingTest {
    WebDriver driver;
    PriceSorting priceSorting;

    @Test
    void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.bewakoof.com/");
        driver.manage().window().maximize();

        priceSorting=new PriceSorting(driver);
        priceSorting.priceSorting();
    }
}
