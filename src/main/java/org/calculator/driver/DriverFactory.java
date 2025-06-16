package org.calculator.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();


    public static void createInstance( String browser){
        if(threadLocalDriver.get() == null){
            WebDriver  driver = switch (browser.toLowerCase()){
                case "chrome" -> new ChromeDriver();
                case "firefox" -> new FirefoxDriver();
                default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
            };
            threadLocalDriver.set(driver);
        }


    }

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }


    public static void quitDriver(){
        if(threadLocalDriver.get()!=null){
            threadLocalDriver.get().quit();
            threadLocalDriver.remove();
        }
    }

}
