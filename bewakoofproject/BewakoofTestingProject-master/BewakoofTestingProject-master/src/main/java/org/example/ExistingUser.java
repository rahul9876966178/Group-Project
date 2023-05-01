package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ResourceBundle;

public class ExistingUser {
    WebDriver driver;
    public ExistingUser(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@id='email_input']")
            WebElement email;
    @FindBy(xpath = "//input[@id='mob_password']")
            WebElement passWrd;
    @FindBy(css = "#mob_login_password_submit")
            WebElement submit;

    @FindBy(tagName = "body")
            WebElement body;

    @FindBy(xpath ="//i[@class='icon_user']" )
            WebElement Icon_Account;

    @FindBy(id ="web_menu_myaccount")
            WebElement Show_Account;

   // By email =By.xpath("//input[@id='email_input']");
   // By passWrd=By.xpath("//input[@id='mob_password']");

   // By submit=By.cssSelector("#mob_login_password_submit");

   // By body=By.tagName("body");

    //By Icon_Account=By.xpath("//i[@class='icon_user']");

    //By Show_Account=By.id("web_menu_myaccount");


    void valid_details() throws InterruptedException
    {
        Actions action=new Actions(driver);
       driver.get("https://www.bewakoof.com/login/");
        driver.findElement(By.cssSelector("#web_email_login")).click();

       ResourceBundle userDetail=ResourceBundle.getBundle("Confidential");
        String id=userDetail.getString("email");
        String p_id= userDetail.getString("password");
        (email).sendKeys(id);
        (passWrd).sendKeys(p_id);
        WebElement element = (submit);
        action.doubleClick(element).perform();

        WebElement element2 = (body);
        Actions builder = new Actions(driver);
        builder.moveToElement(element2, 0, 0).perform();

        Thread.sleep(3000);
        WebElement icon=(Icon_Account);
        action.doubleClick(icon).perform();

        (Show_Account).click();


        String CurrentUrl=driver.getCurrentUrl();
        String ExpectedUrl="https://www.bewakoof.com/myaccount";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(CurrentUrl, ExpectedUrl);
//        System.out.println("login Successful");
    }
}
