package com.channel4.qa.pages;

import com.channel4.qa.utils.UITestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;


public class BasePage {
    private WebDriverWait wait;
    private By acceptPrivacyPopUp = By.xpath(".//div[contains(@class, \"all4-grid all4-popup\")]//button//span[contains(text(), 'Accept & Continue')]");

    /**
     * The driver.
     */
    protected ThreadLocal<WebDriver> driver;


    /**
     * Instantiates a new base page.
     *
     * @param driver the driver
     */
    // Constructor
    public BasePage(ThreadLocal<WebDriver> driver) {
        this.driver = driver;
    }

    /**
     * Click method
     */

    public void click(By locator, String locatorName, long... waitTime) {
        try {
            Reporter.log("Going to Click "+locatorName+" element", true);
            driver.get().findElement(locator).click();
            Reporter.log("Element "+locatorName+" is Clicked", true);
        } catch (Exception e) {
            Reporter.log("Wait for Element "+locatorName+" to Clickable", true);
            try {
                if (waitTime.length == 0) {
                    waitForElementToBeClickable(locator);
                    Reporter.log("Element "+locatorName+" is Clickable", true);
                    driver.get().findElement(locator).click();
                } else {
                    waitForElementToBeClickable(locator, waitTime[0]);
                    Reporter.log("Element "+locatorName+" is Clickable", true);
                    driver.get().findElement(locator).click();
                }
                Reporter.log("Element "+locatorName+"Clicked", true);

            } catch (Exception e1) {
                JavascriptExecutor js = (JavascriptExecutor) driver.get();
                js.executeScript("arguments[0].click();", driver.get().findElement(locator));
                Reporter.log("Element "+locatorName+"Clicked", true);
            }
        }

    }


    /**
     * Wait for element to be clickable
     */
    @Deprecated
    public void waitForElementToBeClickable(By locator, long... timeInSec) {

        if (timeInSec.length == 0) {
            wait = new WebDriverWait(driver.get(), UITestConstants.EXPLICIT_WAIT);
            waitForElementToBeVisible(locator);

        } else {
            wait = new WebDriverWait(driver.get(), timeInSec[0]);
            waitForElementToBeVisible(locator, timeInSec[0]);
        }
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * wait for element to be visible
     */
    @Deprecated
    public void waitForElementToBeVisible(By locator, long... timeInsec) {

        if (timeInsec.length == 0)
            wait = new WebDriverWait(driver.get(), UITestConstants.EXPLICIT_WAIT);
        else
            wait = new WebDriverWait(driver.get(), timeInsec[0]);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * wait for element to be visible
     */
    @Deprecated
    public void waitForElementToBeInVisible(By locator, long... timeInsec) {

        if (timeInsec.length == 0)
            wait = new WebDriverWait(driver.get(), UITestConstants.EXPLICIT_WAIT);
        else
            wait = new WebDriverWait(driver.get(), timeInsec[0]);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Scroll in view
     *
     */
    public void scrollInView(By locator){
        WebElement element = driver.get().findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //js.executeScript("arguments[0].scrollIntoView();", element);

    }

    /**
     * get elements using locator
     */
    public List<WebElement> getElements(By loc){
        return driver.get().findElements(loc);
    }

    public void clickAcceptPrivacyPopUp(){
        try {
            Reporter.log("Going to accept Privacy popup");
            click(acceptPrivacyPopUp, "acceptPrivacyPopUp");
            //waitForElementToBeInVisible(acceptPrivacyPopUp);
        }catch (Exception e){
            e.printStackTrace();
            Reporter.log("Privacy popup did not appear", true);
        }

    }

    public  boolean waitForPageLoad( ) {
        try {
            Boolean result = false;
            JavascriptExecutor js = (JavascriptExecutor) driver.get();
            long endTime = System.currentTimeMillis() + 30000;
            while (System.currentTimeMillis() < endTime) {
                result = (js.executeScript("return document.readyState")).equals("complete");
                if (result == false) {
                    Reporter.log("Page is not loaded completely hence going to wait for more 2 sec", true);
                    Thread.sleep(2000);
                }
            }
            return result;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
