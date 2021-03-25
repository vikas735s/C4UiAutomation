package com.channel4.qa.uiTest;

import com.channel4.qa.utils.UITestConstants;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CategoriesPageTest extends BaseTest{

    @Test
    public void test_CategoriesPage_SliceCount(){
        driver.get().get(UITestConstants.HOME_PAGE_URL);
        getUIPageCollection().getHomePage().clickCategoriesTab();
        getUIPageCollection().getCategoriesPage().clickAcceptPrivacyPopUp();
        int sliceCount = getUIPageCollection().getCategoriesPage().getSliceItemCount();
        getUIPageCollection().getCategoriesPage().clickShowMoreBtn();
        sliceCount = getUIPageCollection().getCategoriesPage().getSliceItemCount();
         Reporter.log("Count = " + sliceCount, true);


    }
}
