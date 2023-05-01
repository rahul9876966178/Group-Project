package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    @FindBy(xpath = "//a[contains(text(),'Accessories')]")
            WebElement accessories;
    @FindBy(xpath = "//a[normalize-space()='Men']")
            WebElement Men;

//By accesories=By.xpath("//a[contains(text(),'Accessories')]");

WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    void checkProduct(){
        WebElement accessoriesTab=accessories;
        boolean b_productElement1= accessoriesTab.isDisplayed();

        WebElement mensTab=Men;
        boolean b_productElement2=mensTab.isDisplayed();

        if((b_productElement1)&&(b_productElement2))
        {
            System.out.println("Test cases passed");
            System.out.println("accessoriesTab & menTab are visible");
        }
        else
        {
            System.out.println("test is failed");
        }

    }
}
