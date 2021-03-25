package com.channel4.qa.uiTest;

import com.channel4.qa.utils.UITestConstants;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test
    public void test_HomeScreen_SliceCount(){
        driver.get().get(UITestConstants.HOME_PAGE_URL);
        getUIPageCollection().getHomePage().clickCategoriesTab();
    }
}
