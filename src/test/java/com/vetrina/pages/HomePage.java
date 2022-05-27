package com.vetrina.pages;

import com.vetrina.utilities.BrowserUtils;
import com.vetrina.utilities.ConfigurationReader;
import com.vetrina.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

    @FindBy(xpath = "//*[text()='Kabul Ediyorum']") public WebElement cookies_Loc;

    @FindBy(css = "#myAccount") public WebElement loginBtn_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#password") public WebElement password_Loc;

    @FindBy(css = "#mui-1") public WebElement searchBox_Loc;

    public void gotoHomePage(){
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForClickablility(cookies_Loc,5);
        cookies_Loc.click();
    }

    public void login(){
    String email = ConfigurationReader.get("user_email");
    String password = ConfigurationReader.get("user_password");

    email_Loc.sendKeys(email);
    password_Loc.sendKeys(password);
    }

    public static void checkHomePage(){
        String expectedUrl ="https://www.vetrinaturkiye.com/";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    public void searchBox(String string){
        searchBox_Loc.sendKeys(string+ Keys.ENTER);

        BrowserUtils.waitFor(1);
    }

    public void invalidEmailCheck(){
        email_Loc.sendKeys(ConfigurationReader.get("guest_email"));
        password_Loc.sendKeys(ConfigurationReader.get("user_password"));
    }
    public void invalidPasswordCheck(){
       email_Loc.sendKeys(ConfigurationReader.get("user_email"));
       password_Loc.sendKeys("Inveon34...");
    }

}
