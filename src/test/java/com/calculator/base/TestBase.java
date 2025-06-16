package com.calculator.base;

import org.calculator.driver.DriverFactory;
import org.calculator.utils.EnvManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;


public class TestBase {

    @BeforeClass()
    public void suiteSetup(){
        String browser = System.getProperty("browser", "chrome");
        DriverFactory.createInstance(browser);
        WebDriver driver = DriverFactory.getDriver();
        driver.get(EnvManager.get("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }


    @AfterClass()
    public void suiteTeardown(){
        DriverFactory.getDriver().quit();
    }

}
