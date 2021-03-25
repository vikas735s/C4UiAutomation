package com.channel4.qa.pageFactories;

import com.channel4.qa.pages.CategoriesPage;
import com.channel4.qa.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class UIPageCollection {



    protected ThreadLocal<WebDriver> driver;

    /**
     * Instantiates a new base page.
     *
     * @param driver the driver
     */
    public UIPageCollection(ThreadLocal<WebDriver> driver) {
        this.driver = driver;
    }

    //Add you pages

    private HomePage homePage;
    private CategoriesPage categoriesPage;

    public HomePage getHomePage() {
        return homePage == null ? homePage = new HomePage(driver) : homePage;
    }

    public CategoriesPage getCategoriesPage(){
        return categoriesPage == null ? categoriesPage = new CategoriesPage(driver): categoriesPage;
    }

}
