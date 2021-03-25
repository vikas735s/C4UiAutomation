package com.channel4ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {


    /** header's Locators. */

    private By categoriesTab = By.xpath(".//li[contains(@class,\"nav__list__item nav__list__item--categories\")]");

    /**
     * Instantiates a new base page.
     *
     * @param driver the driver
     */
    public HomePage(ThreadLocal<WebDriver> driver) {
        super(driver);
        //this.driver = driver;
        PageFactory.initElements(driver.get(), this);
    }

    public void clickCategoriesTab(){
        click(categoriesTab, "categoriesTab");
    }


}
