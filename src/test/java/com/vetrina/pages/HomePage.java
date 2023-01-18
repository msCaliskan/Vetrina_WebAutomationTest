package com.vetrina.pages;

import com.github.javafaker.Faker;
import com.vetrina.utilities.BrowserUtils;
import com.vetrina.utilities.ConfigurationReader;
import com.vetrina.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends BasePage{

    @FindBy(xpath = "//*[text()='Kabul Ediyorum']") public WebElement cookies_Loc;

    @FindBy(css = "#myAccount") public WebElement loginBtn_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#mui-1") public WebElement searchBox_Loc;

    @FindBy(css = "a#socialInstagram") public WebElement instagramButton_Loc;

    @FindBy(css = "a#socialFacebook") public WebElement facebookButton_Loc;

    @FindBy(css = "a#socialTwitter") public WebElement twitterButton_Loc;

    @FindBy(xpath = "//*[@class='MuiBox-root css-j7qwjs']//p") public List<WebElement> footerLinks_Loc;

    @FindBy(xpath = "//*[@class='MuiBox-root css-i3pbo']//h3") public WebElement title_Loc;

    @FindBy(css = "button#submitNewsletterForm") public WebElement newsLetterButton_Loc;

    @FindBy(css = "[name='isConfirmPrivacyPolicy']") public WebElement confirmPrivacyButton_Loc;

    public void gotoHomePage(){
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForClickablility(cookies_Loc,5);
        cookies_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public void clickLoginButton(){
        BrowserUtils.waitForClickablility(loginBtn_Loc,5);
        loginBtn_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public static void checkHomePage(){
        String expectedTitle ="Vetrina";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void searchBox(String string){
        searchBox_Loc.sendKeys(string+ Keys.ENTER);

        BrowserUtils.waitFor(1);
    }

    public void clickInstagramButton(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(instagramButton_Loc);
        BrowserUtils.waitFor(2);
    }

    public void verifyInstagramPage(){
        BrowserUtils.getWindowHandle();
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Vetrina Türkiye (@vetrinaturkiye) • Instagram photos and videos";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void clickFacebookButton(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(facebookButton_Loc);
        BrowserUtils.waitFor(2);
    }
    public void verifyFacebookPage(){
        BrowserUtils.getWindowHandle();
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Vetrina Türkiye | Istanbul | Facebook";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void clickTwitterButton(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(twitterButton_Loc);
        BrowserUtils.waitFor(2);
    }

    public void verifyTwitterPage(){
        BrowserUtils.getWindowHandle();
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Vetrina Turkiye (@VetrinaTurkiye) / Twitter";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void checkPageTitle(String button, String title){
        for (int i = 0; i < footerLinks_Loc.size(); i++) {
            if (footerLinks_Loc.get(i).getText().contains(button)){
                BrowserUtils.clickWithJS(footerLinks_Loc.get(i));
                BrowserUtils.waitForPageToLoad(10);
                BrowserUtils.waitFor(2);
                String actualTitle = title_Loc.getText();
                Assert.assertEquals(title,actualTitle);
                BrowserUtils.waitFor(2);
                break;
            }
        }
    }

    public void clickNewsLetterButton(){
        BrowserUtils.waitForClickablility(newsLetterButton_Loc,10);
        BrowserUtils.clickWithJS(newsLetterButton_Loc);
        BrowserUtils.waitFor(2);
    }

    public void clickConfirmButton(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(confirmPrivacyButton_Loc);
        BrowserUtils.waitFor(2);
    }

    public void sendInvalidEmail(){
        BrowserUtils.waitForClickablility(email_Loc,5);
        email_Loc.sendKeys("abcd");
        BrowserUtils.waitFor(1);
    }

    public void sendValidEmail(){
        BrowserUtils.waitForClickablility(email_Loc,5);
        Faker faker = new Faker();
        email_Loc.sendKeys(faker.internet().emailAddress());
        BrowserUtils.waitFor(1);
    }

}
