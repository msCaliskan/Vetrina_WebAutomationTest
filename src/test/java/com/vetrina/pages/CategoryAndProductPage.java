package com.vetrina.pages;

import com.vetrina.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CategoryAndProductPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-sm-3 MuiGrid-grid-md-3')]") public List<WebElement> prodList_Loc;

    @FindBy(xpath = "//*[contains(@class,'MuiTypography-root MuiTypography-body2 MuiTypography-alignCenter')]") public List<WebElement> product_Loc;

    @FindBy(xpath = "//button[contains(@class, 'has-stock')]") public List<WebElement> sizeList_Loc;

    @FindBy(xpath = "//button[contains(@aria-label,'add-to-favorites')]") public WebElement hearthBtn_Loc;

    @FindBy(xpath = "//*[@class='MuiTypography-root jss140 MuiTypography-body1']") public List<WebElement> productName_Loc;

    @FindBy(xpath = "(//*[@fill='#2C2B2B'])[10]") public WebElement popUp_Loc;

    @FindBy(xpath = "(//*[@fill='#2C2B2B'])[9]") public WebElement popUpp_Loc;

    @FindBy(xpath = "//*[contains(@class, 'MuiTypography-root MuiTypography-body1 MuiFormControlLabel')]") public List<WebElement> values_Loc;

    @FindBy(xpath = "//*[@name='price']") public WebElement priceHolder_Loc;

    static String productName="";
    public void clickProductRandom(){

        Random rn = new Random();
        int a = rn.nextInt(prodList_Loc.size());

        BrowserUtils.waitFor(1);
        BrowserUtils.hover(prodList_Loc.get(a));
        BrowserUtils.waitFor(1);
        productName = product_Loc.get(a).getText();
        prodList_Loc.get(a).click();
        BrowserUtils.waitFor(1);
    }

    public void selectSize(){

        Random rn = new Random();
        int a = rn.nextInt(sizeList_Loc.size());

        sizeList_Loc.get(a).click();
    }

    public void searchResult(String string){

        List<String> allNames = new ArrayList<>();
        for (WebElement element : prodList_Loc) {
        allNames.add(element.getText());
        }
        for (int i = 0; i < productName_Loc.size(); i++) {
             allNames.get(i).contains(string);
        }
    }
    public void hearthBtn(){
        BrowserUtils.waitForClickablility(hearthBtn_Loc,5);
        hearthBtn_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public void closePopUp(){
        BrowserUtils.waitForClickablility(popUp_Loc,5);
        popUp_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public void closePopUpp(){
        BrowserUtils.waitForClickablility(popUpp_Loc,5);
        popUpp_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public void validPrice(){
        String price = priceHolder_Loc.getAttribute("value");

        int b = Integer.parseInt(price);
        int c= b-5;

        priceHolder_Loc.sendKeys(Keys.CONTROL+"a");
        priceHolder_Loc.sendKeys(Keys.DELETE);
        BrowserUtils.waitFor(1);
        priceHolder_Loc.sendKeys(Integer.toString(c));
        BrowserUtils.waitFor(2);

    }

    public void chooseValue(String value){

        for (int i = 0; i < values_Loc.size(); i++) {
             if (values_Loc.get(i).getText().equals(value)){
                 values_Loc.get(i).click();
                 break;
             }

        }
        BrowserUtils.waitFor(1);
    }
}