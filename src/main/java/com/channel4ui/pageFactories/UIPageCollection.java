package com.channel4ui.pageFactories;

import com.channel4ui.pages.CategoriesPage;
import com.channel4ui.pages.HomePage;
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
