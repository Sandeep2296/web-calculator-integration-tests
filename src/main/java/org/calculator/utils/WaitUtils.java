package org.calculator.utils;

import org.calculator.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {


    public static WebElement waitForClickability(By locator, long seconds){


        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        if (DriverFactory.getDriver() == null) {
            throw new IllegalStateException("WebDriver instance is not initialized");
        }
        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }




}
