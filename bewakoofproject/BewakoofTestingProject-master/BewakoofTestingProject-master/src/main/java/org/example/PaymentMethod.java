package org.example;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class PaymentMethod {
    WebDriver driver;
    public PaymentMethod(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#web_email_login")
            WebElement Continue_Email;

    @FindBy(xpath = "//input[@id='email_input']")
            WebElement email_id;

    @FindBy(xpath = "//input[@id='mob_password']")
            WebElement passKey;

    @FindBy(css = "#mob_login_password_submit")
            WebElement submit;
    @FindBy(xpath = "//input[@placeholder='Search by product, category or collection']")
            WebElement search_field;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]/div[3]/a[1]/div[1]/div[1]/div[1]/img[1]")
            WebElement selectItem;
    @FindBy(xpath = "//div[@id='testSizes_L']")
            WebElement selectSize;
    @FindBy(xpath = "//span[normalize-space()='ADD TO BAG']")
            WebElement BtnAddToCart;
    @FindBy(xpath = "//span[normalize-space()='GO TO BAG']")
            WebElement BtnGoToBag;
    @FindBy(xpath = "//button[@id='os_payNow_btn']")
            WebElement PayBtn;
    @FindBy(xpath = "//span[normalize-space()='Cash On Delivery']")
            WebElement WithCash;
    @FindBy(css = "button[type='button']")
            WebElement ClickPay;



    void PayItem() throws InterruptedException {

        Continue_Email.click();

        ResourceBundle r = ResourceBundle.getBundle("Confidential");
        String id = r.getString("email");
        String pass = r.getString("password");

        email_id.sendKeys(id);
        passKey.sendKeys(pass);
        WebElement element =submit;
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();

        Thread.sleep(3000);
        WebElement selectShirt =  search_field;
        selectShirt.sendKeys("shirts");
        selectShirt.sendKeys(Keys.ENTER);

        Thread.sleep(3000);
        WebElement shirt = selectItem;
        shirt.click();

        Thread.sleep(3000);
        selectSize.click();

        Thread.sleep(3000);
        BtnAddToCart.click();

        Thread.sleep(4000);
        BtnGoToBag.click();

        Thread.sleep(3000);
        PayBtn.click();

        Thread.sleep(3000);
        WithCash.click();

        Thread.sleep(2000);
        WebElement pay = ClickPay;
        pay.click();


        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.bewakoof.com/ordersuccess?detail=eyJvcmRlcl9pZCI6NDQyNDQ4NDgsImNhc2hiYWNrIjowfQ==";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(currentUrl, expectedUrl);
        System.out.println("Order Placed Successfully.");
    }
}
