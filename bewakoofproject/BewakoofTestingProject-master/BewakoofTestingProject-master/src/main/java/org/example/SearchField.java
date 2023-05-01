package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SearchField {
    WebDriver driver;
    @FindBy(xpath = "//input[@placeholder='Search by product, category or collection']")
    WebElement searchField;


    public SearchField(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    void checkSearch_product() {
        //noinspection deprecation
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        searchField.sendKeys("shirts");
        searchField.sendKeys(Keys.ENTER);

        System.out.println("Searched Item Successfully");
    }
}
