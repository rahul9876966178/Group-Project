package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class PriceSorting {
    WebDriver driver;
    public PriceSorting(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#testMenuSelect-shop-men > .menuSelect > span")
    WebElement selectMenu;
    @FindBy(css = ".accordionBox:nth-child(1) .filterHeader")
            WebElement filterHeader;
    @FindBy(css="button[class='sortbyButton'] span")
            WebElement sortBtn;
    @FindBy(linkText = "Price : Low to High")
            WebElement High_to_Low;


    void priceSorting() throws InterruptedException {

        selectMenu.click();
        Thread.sleep(3000);
        filterHeader.click();
        Thread.sleep(2000);
        sortBtn.click();
        High_to_Low.click();
        Thread.sleep(200);
        String currentURL = driver.getCurrentUrl();
        if(Objects.equals(currentURL, "https://www.bewakoof.com/men-clothing?sort=low"))
        {
            System.out.println("Passed.");
        }
        else
        {
            System.out.println("Failed.");
        }
    }
}
