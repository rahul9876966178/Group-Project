package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class AddNewUserTest{

    WebDriver driver;
    AddNewUser newUser;

    @Test
    void setup() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //noinspection deprecation
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.bewakoof.com/signup");
        driver.manage().window().maximize();
        newUser=new AddNewUser(driver);

        newUser.validate_NewUser();
    }
}
