package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ResourceBundle;

public class AddToWishList {

    WebDriver driver;
    public AddToWishList(WebDriver driver) {
    this.driver=driver;
        PageFactory.initElements(driver,this);
}

    @FindBy(css = "#web_email_login")
            WebElement emailLog;

    @FindBy(xpath = "//input[@id='email_input']")
    WebElement email;

    @FindBy(xpath = "//input[@id='mob_password']")
    WebElement passKey;

    @FindBy(css = "#mob_login_password_submit")
            WebElement submit;

    @FindBy(xpath ="//input[@placeholder='Search by product, category or collection']" )
            WebElement searchField;

    @FindBy(xpath = "//*[@id=\"testProductcard_2\"]/a/div")
            WebElement shirtSelect;

    @FindBy(xpath = "//span[normalize-space()='WISHLIST']")
    WebElement clkWish;

    @FindBy(xpath = "//i[@class='icon_user']")
            WebElement iconAccount;

    @FindBy(id = "web_menu_mywishlist")
            WebElement wishList;


    void addToFavourite()throws InterruptedException{

        ResourceBundle r=ResourceBundle.getBundle("Confidential");
        String id=r.getString("email");
        String pass=r.getString("password");

        emailLog.click();

        Thread.sleep(3000);
        email.sendKeys(id);

        Thread.sleep(2000);
        passKey.sendKeys(pass);
        WebElement element =submit;
        Actions action=new Actions(driver);
        action.doubleClick(element).perform();

        Thread.sleep(2000);
        searchField.sendKeys("shirt");
        searchField.sendKeys(Keys.ENTER);

        Thread.sleep(3000);
        WebElement selectShirt=shirtSelect;
        selectShirt.click();

        Thread.sleep(3000);
        clkWish.click();

        Thread.sleep(3000);
        WebElement icon=iconAccount;
        action.doubleClick(icon).perform();

        Thread.sleep(3000);
        wishList.click();


        String CurrentUrl=driver.getCurrentUrl();
        String ExpectedUrl="https://www.bewakoof.com/wishlist";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(CurrentUrl, ExpectedUrl);
        System.out.println("Item added in wishlist.");
    }
}
