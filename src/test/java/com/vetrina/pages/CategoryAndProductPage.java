package com.vetrina.pages;

import com.vetrina.utilities.BrowserUtils;
import com.vetrina.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CategoryAndProductPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-sm-3 MuiGrid-grid-md-3')]") public List<WebElement> prodList_Loc;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButtonBase-root has-stock')]") public List<WebElement> sizeList_Loc;

    @FindBy(xpath = "//button[contains(@aria-label,'add-to-favorites')]") public WebElement hearthBtn_Loc;

    @FindBy(xpath = "//*[@class='MuiTypography-root jss140 MuiTypography-body1']") public List<WebElement> productName_Loc;

    public void clickProductRandom(){

        Random rn = new Random();
        int a = rn.nextInt(prodList_Loc.size())+1;

        String loc = "(//*[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-sm-3 MuiGrid-grid-md-3')])["+a+"]";
        BrowserUtils.waitFor(1);
        WebElement randomProd = Driver.get().findElement(By.xpath(loc));
        BrowserUtils.waitFor(1);
        BrowserUtils.hover(randomProd);
        BrowserUtils.waitFor(1);
        randomProd.click();
        BrowserUtils.waitFor(1);
    }

    public void selectSize(){

        Random rn = new Random();
        int a = rn.nextInt(sizeList_Loc.size())+1;
        String loc = "(//button[contains(@class, 'MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButtonBase-root has-stock')])["+a+"]";

        Driver.get().findElement(By.xpath(loc)).click();
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
        hearthBtn_Loc.click();
        BrowserUtils.waitFor(4);
    }
}