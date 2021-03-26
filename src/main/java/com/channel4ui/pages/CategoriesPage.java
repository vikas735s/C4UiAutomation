package com.channel4ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage extends BasePage {
    /**
     * Locator of category page
     */

    private By showMoreBtn = By.xpath(".//span[contains(@class,\"primary-button__label\")]");
    private  String slicItemLocUsingName = ".//article[contains(@class,\"all4-slice-item__bottom-part size-compact\")]//h3[contains(text(), '%s')]";


    /**
     * @param driver
     */
    public CategoriesPage(ThreadLocal<WebDriver> driver){
        super(driver);
        PageFactory.initElements(driver.get(), this);
    }

    public void clickShowMoreBtn(){
        //scrollInView(showMoreBtn);
        waitForPageLoad();
        clickByJS(showMoreBtn, "showMoreBtn");
        waitForPageLoad();
    }


    public int getSliceItemCount() {
        waitForPageLoad();
        return getElements(By.xpath(String.format(slicItemLocUsingName, ""))).size();
    }
}
