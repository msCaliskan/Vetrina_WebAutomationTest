package com.vetrina.pages;

import com.vetrina.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceSubscriptionPage extends BasePage{

    @FindBy(xpath = "//*[@class='MuiBox-root css-1bs036l']") public WebElement urun_Loc;

    @FindBy(xpath = "//*[text()='Listeden Çıkar']") public WebElement removeBtn_Loc;

    public void removeProduct(){
        BrowserUtils.hover(urun_Loc);
        BrowserUtils.waitFor(2);
        removeBtn_Loc.click();
        BrowserUtils.waitFor(1);
    }
}
