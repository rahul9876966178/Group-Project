package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchFieldTest {
    WebDriver driver;
@Test
    void setup()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();

        driver.get("https://www.bewakoof.com/");
        driver.manage().window().maximize();

        SearchField searchField=new SearchField(driver);
        searchField.checkSearch_product();
    }
}
