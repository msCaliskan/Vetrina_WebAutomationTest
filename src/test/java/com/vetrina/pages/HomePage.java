package com.vetrina.pages;

import com.vetrina.utilities.BrowserUtils;
import com.vetrina.utilities.ConfigurationReader;
import com.vetrina.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

    @FindBy(xpath = "(//*[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium')])[2]") public WebElement close_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#password") public WebElement password_Loc;

    @FindBy(css = "#mui-1") public WebElement searchBox_Loc;


    public void gotoHomePage(){
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(2);

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        WebElement accept = (WebElement) jse.executeScript("return document.querySelector('#usercentrics-root').shadowRoot.querySelector('#focus-lock-id > div.sc-furwcr.kbclTA > div > div.sc-ikJyIC.jegfVy > div > div > div.sc-dlVxhl.bEDIID > div > button:nth-child(5)')");

       BrowserUtils.clickWithJS(accept);
       BrowserUtils.waitFor(1);
       close_Loc.click();

    }

    public void login(){
    String email = ConfigurationReader.get("user_email");
    String password = ConfigurationReader.get("user_password");

    email_Loc.sendKeys(email);
    BrowserUtils.waitFor(1);
    password_Loc.sendKeys(password);
    }

    public static void checkHomePage(){
        String expectedUrl ="https://www.gerryweber.com.tr/";
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
