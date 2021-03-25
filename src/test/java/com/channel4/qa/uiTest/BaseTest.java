package com.channel4.qa.uiTest;

import com.channel4.qa.pageFactories.UIPageCollection;
import com.channel4.qa.utils.UITestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    protected ThreadLocal<UIPageCollection> uiPageCollectionThreadLocal;

    @BeforeMethod(alwaysRun = true)
    public void initializeAllPages() {
        if (uiPageCollectionThreadLocal == null) {
            uiPageCollectionThreadLocal = new ThreadLocal<UIPageCollection>();
        }
        uiPageCollectionThreadLocal.set(new UIPageCollection(driver));
    }

    /**
     * page collection to get all page of application
     * @return
     */
    protected UIPageCollection getUIPageCollection() {
        return uiPageCollectionThreadLocal.get();
    }

    /**
     * Creates the chrome driver.
     */
    protected void createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(UITestConstants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get().manage().timeouts().pageLoadTimeout(UITestConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

    }

    /**
     * Creates the fireFox
     */
    protected void createFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver.set(new FirefoxDriver());
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(UITestConstants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get().manage().timeouts().pageLoadTimeout(UITestConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    /**
     * Driver setup before every test
     */
    @BeforeMethod(alwaysRun = true)
    public void driversetup() {
        String browser = UITestConstants.BROWSER;
        Reporter.log("Browser for Test  " + browser, true);
        if ("chrome".equals(browser)) {
            createChromeDriver();
            Reporter.log("Browser for Test  " + browser + "Created with success", true);

        } else if ("firefox".equals(browser)) {
            createFireFoxDriver();
            Reporter.log("Browser for Test  " + browser + "Created with success", true);
        } else {
            Reporter.log("browser not found ", true);
        }
    }

    /**
     * closing web driver after every test
     */
    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
       /* try {
            Reporter.log("Closing Browser for Test  ", true);
            driver.get().quit();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
