package com.channel4ui.categoriesTest;

import com.channel4ui.BaseTest;
import com.channel4ui.utils.UITestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CategoriesPageTest extends CategoriesBaseTest {

    @Test(description = "Test to verify if 40 slice items are shown when Show more button is clicked for first time")
    public void test_CategoriesPage_SliceCount(){
        driver.get().get(UITestConstants.HOME_PAGE_URL);
        getUIPageCollection().getHomePage().clickCategoriesTab();
        getUIPageCollection().getCategoriesPage().clickAcceptPrivacyPopUp();
        //int sliceCount = getUIPageCollection().getCategoriesPage().getSliceItemCount();
        getUIPageCollection().getCategoriesPage().clickShowMoreBtn();
        //Reporter.log("Count = " + sliceCount, true);
        //Assert.assertTrue(getUIPageCollection().getCategoriesPage().getSliceItemCount() == CategoryPageTestData.SLICE_ITEM_COUNT, "40 slice items are not shown when Show more button is clicked for first time");
    }

    @Test(enabled =  false)
    public void test_CategoriesPage_SliceCount_2(){
        driver.get().get(UITestConstants.HOME_PAGE_URL);
        getUIPageCollection().getHomePage().clickCategoriesTab();
        getUIPageCollection().getCategoriesPage().clickAcceptPrivacyPopUp();
        int sliceCount = getUIPageCollection().getCategoriesPage().getSliceItemCount();
        getUIPageCollection().getCategoriesPage().clickShowMoreBtn();
        sliceCount = getUIPageCollection().getCategoriesPage().getSliceItemCount();
        Reporter.log("Count = " + sliceCount, true);
    }

    @Test(enabled =  false)
    public void test_CategoriesPage_SliceCount_3(){
        driver.get().get(UITestConstants.HOME_PAGE_URL);
        getUIPageCollection().getHomePage().clickCategoriesTab();
        getUIPageCollection().getCategoriesPage().clickAcceptPrivacyPopUp();
        int sliceCount = getUIPageCollection().getCategoriesPage().getSliceItemCount();
        getUIPageCollection().getCategoriesPage().clickShowMoreBtn();
        sliceCount = getUIPageCollection().getCategoriesPage().getSliceItemCount();
        Reporter.log("Count = " + sliceCount, true);
    }
}
