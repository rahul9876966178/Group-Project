package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;


public class AddNewUser {
    WebDriver driver;
    public AddNewUser(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='fullname']")
    WebElement fullName;

    @FindBy(css = ".countryCode-wrap")
            WebElement countryCode;

    @FindBy(xpath = "//span[normalize-space()='+971']")
            WebElement selectCode;

    @FindBy(xpath = "//input[@class='mobile-field']")
            WebElement AddMobileNumber;

    @FindBy(css = "input[name='email']")
            WebElement AddEmail;

    @FindBy(xpath = "//input[@name='password']")
            WebElement AddPass;

    @FindBy(css = "button[type='submit']")
            WebElement submit;

    public void validate_NewUser() throws InterruptedException {

        ResourceBundle r=ResourceBundle.getBundle("UData");
        String Uname=r.getString("name");
        String id=r.getString("email");
        String mobile=r.getString("ph");
        String Upass=r.getString("passkey");

        fullName.sendKeys(Uname);
        countryCode.click();
        selectCode.click();
        AddMobileNumber.sendKeys(mobile);
        AddEmail.sendKeys(id);
        AddPass.sendKeys(Upass);
        submit.click();

    }

}
