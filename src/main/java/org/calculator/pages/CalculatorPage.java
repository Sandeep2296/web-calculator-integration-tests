package org.calculator.pages;

import org.calculator.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {
    private WebDriver driver;

    public CalculatorPage(){
    }

    public CalculatorPage(WebDriver driver){
        this.driver = driver;
    }

    private final By display = By.id("display");
    private final By operatorDivide = By.id("divide");
    private final By operatorMul = By.id("multiply");
    private final By operatorAdd = By.id("add");
    private final By operatorSub = By.id("subtract");

    public WebElement getInputByValue(String value){
        return WaitUtils.waitForClickability(By.xpath("//input[@value='"+value+"']"), 2);
    }

    public void clickByInputValue(String value) {
        int inputLength = value.length();
        if(value.length()>1){
            for(int i =0; i<inputLength;i++){
                getInputByValue(String.valueOf(value.charAt(i))).click();
            }
        }
        else{
            getInputByValue(value).click();
        }
    }

    public String getResult(){
        return driver.findElement(display).getText().trim();
    }

    private void clickOperator(By operator){
        WaitUtils.waitForClickability(operator, 2).click();
    }

    public void clickAdd(){
        clickOperator(operatorAdd);
    }

    public void clickSub(){
        clickOperator(operatorSub);
    }

    public void clickMul(){
        clickOperator(operatorMul);
    }

    public void clickDiv(){
        clickOperator(operatorDivide);
    }

    public void clickEquals(){
        clickByInputValue("=");
    }

    public void clickClear(){
        clickByInputValue("C");
    }

}
