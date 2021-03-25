package com.channel4.qa.utils;

import java.io.File;
import java.io.IOException;

public class UITestConstants {

    public static final String BROWSER;
    public static final String HOME_PAGE_URL;
    public static final Long IMPLICIT_WAIT;
    public static final Long PAGE_LOAD_TIMEOUT;
    public static final Long EXPLICIT_WAIT;
    public static final String PURCHASE_SUCCESS_MESSAGE = "Thank you for your purchase";
    public static final String TEST_DATA_FILE = "src\\test\\resources\\TestData.xlsx";




    static {
        try {
            PropertyReader.getInstance().loadPropertyFile(new File("src\\resources\\beta.properties"));
        }
        catch (IOException e ){
            e.printStackTrace();
        }
        BROWSER = PropertyReader.getInstance().getPropertyValue("BROWSER");
        HOME_PAGE_URL = PropertyReader.getInstance().getPropertyValue("HOSTNAME");
        IMPLICIT_WAIT = Long.valueOf(PropertyReader.getInstance().getPropertyValue("IMPLICIT_WAIT"));
        PAGE_LOAD_TIMEOUT = Long.valueOf(PropertyReader.getInstance().getPropertyValue("PAGE_LOAD_TIMEOUT"));
        EXPLICIT_WAIT = Long.valueOf(PropertyReader.getInstance().getPropertyValue("EXPLICIT_WAIT"));;
    }
}
