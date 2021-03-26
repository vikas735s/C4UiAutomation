package com.channel4ui.categoriesTest;

import com.channel4ui.BaseTest;
import com.channel4ui.utils.UITestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CategoriesPageTest extends CategoriesBaseTest {


    @Test(description = "Test to verify if 40 slice items are shown when Show more button is clicked for first time")
    public void test_CategoriesPage_SliceCount(){
        driver.get().get(UITestConstants.HOME_PAGE_URL+ CategoryPageTestData.CATEGORIES_Tab_URL);
        getUIPageCollection().getHomePage().clickAcceptPrivacyPopUp();
        int sliceCount = getUIPageCollection().getCategoriesPage().getSliceItemCount();
        Reporter.log("initialCount = " + sliceCount, true);
        getUIPageCollection().getCategoriesPage().clickShowMoreBtn();
        sliceCount = getUIPageCollection().getCategoriesPage().getSliceItemCount();
        Reporter.log("finalCount = " + sliceCount, true);
        Assert.assertTrue(sliceCount== CategoryPageTestData.SLICE_ITEM_COUNT, "40 slice items are not shown when Show more button is clicked for first time");
    }

    @Test(description = "Test to verify if 40 slice items are shown when Show more button is clicked for first time")
    public void test_CategoriesPage_SliceCounts(){
        driver.get().get(UITestConstants.HOME_PAGE_URL);
        getUIPageCollection().getHomePage().clickAcceptPrivacyPopUp();
        getUIPageCollection().getHomePage().reloadPage();
        getUIPageCollection().getHomePage().clickCategoriesTab();
        getUIPageCollection().getCategoriesPage().clickAcceptPrivacyPopUp();
        int sliceCount = getUIPageCollection().getCategoriesPage().getSliceItemCount();
        Reporter.log("initialCount = " + sliceCount, true);
        getUIPageCollection().getCategoriesPage().reloadPage();
        getUIPageCollection().getCategoriesPage().clickShowMoreBtn();

        sliceCount = getUIPageCollection().getCategoriesPage().getSliceItemCount();
        Reporter.log("finalCount = " + sliceCount, true);
        Assert.assertTrue(sliceCount== CategoryPageTestData.SLICE_ITEM_COUNT, "40 slice items are not shown when Show more button is clicked for first time");
    }





}
