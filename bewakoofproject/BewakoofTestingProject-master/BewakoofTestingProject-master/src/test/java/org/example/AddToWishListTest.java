package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddToWishListTest {
    WebDriver driver;
    AddToWishList addWish;

  @Test
    void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //noinspection deprecation
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.bewakoof.com/login");
        driver.manage().window().maximize();

        addWish=new AddToWishList(driver);
        addWish.addToFavourite();
    }

}