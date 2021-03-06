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
        scrollInView(showMoreBtn);
        clickByJS(showMoreBtn, "showMoreBtn");
        waitForPageLoad();
        /*try {
            scrollInView(showMoreBtn);
            clickByJS(showMoreBtn, "showMoreBtn");
            waitForPageLoad();
        }catch (Exception e){
            e.printStackTrace();
            reloadPage();
                try {
                    scrollInView(showMoreBtn);
                    clickByJS(showMoreBtn, "showMoreBtn");
                    waitForPageLoad();
                }catch (Exception f){
                    f.printStackTrace();
                }

        }
*/
    }


    public int getSliceItemCount() {
        waitForPageLoad();
        return getElements(By.xpath(String.format(slicItemLocUsingName, ""))).size();
    }
}
