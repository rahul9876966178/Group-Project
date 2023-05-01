package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExistingUserTest {
    WebDriver driver;

    @Test
    //@Parameters({"browser","url"})
    void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.bewakoof.com/login/email");
        driver.manage().window().maximize();

        ExistingUser existingUser=new ExistingUser(driver);
        existingUser.valid_details();
    }
}
