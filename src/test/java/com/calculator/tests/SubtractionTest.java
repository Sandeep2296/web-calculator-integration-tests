package com.calculator.tests;

import com.calculator.base.TestBase;
import org.calculator.driver.DriverFactory;
import org.calculator.pages.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class SubtractionTest extends TestBase {

    CalculatorPage calc;

    @BeforeMethod
    public  void init() {
        calc = new CalculatorPage(DriverFactory.getDriver());
        calc.clickClear();
    }

    @Test(description = "Verify subtraction resulting with negative")
    public void testSubtractionResultingNegative(){
        calc.clickByInputValue("10");
        calc.clickSub();
        calc.clickByInputValue("20");
        calc.clickEquals();
        String result = calc.getResult();
        Assert.assertEquals(result, "-10");
    }

    @Test(description = "Verify subtraction resulting with positive")
    public void testSubtractionResultingPositive(){
        calc.clickByInputValue("20");
        calc.clickSub();
        calc.clickByInputValue("20");
        calc.clickEquals();
        String result = calc.getResult();
        Assert.assertEquals(result, "0");
    }

    @Test(description = "Verify subtraction resulting in zero")
    public void testSubtractionResultingInZero(){
        calc.clickByInputValue("10");
        calc.clickSub();
        calc.clickByInputValue("10");
        calc.clickEquals();
        String result = calc.getResult();
        Assert.assertEquals(result, "0");
    }

    @Test(description = "Verify both operand as 0")
    public void testZeroSubtraction(){
        calc.clickByInputValue("0");
        calc.clickSub();
        calc.clickByInputValue("0");
        calc.clickEquals();
        String result = calc.getResult();
        Assert.assertEquals(result, "0");
    }

    @Test(description = "Sub on negative numbers")
    public void testSubtractOnNegativeNumbers(){
        calc.clickSub();
        calc.clickByInputValue("2");
        calc.clickSub();
        calc.clickByInputValue("2");
        calc.clickEquals();
        String result = calc.getResult();
        Assert.assertEquals(result, "-4");
    }

    @Test(description = "Sub of two decimals")
    public void testSubOfTwoDecimals(){
        calc.clickByInputValue("1");
        calc.clickByInputValue(".");
        calc.clickByInputValue("3");

        calc.clickSub();

        calc.clickByInputValue("1");
        calc.clickByInputValue(".");
        calc.clickByInputValue("0");

        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "0.3");
    }

    @Test(description = "Verify chaining of subtraction")
    public void testSubtractionChaining(){

        Random random = new Random();
        int operand = random.nextInt(10);
        calc.clickByInputValue(String.valueOf(operand));

        for(int i=0; i<5; i++){
            calc.clickSub();
            int  randomNumber = random.nextInt(10);
            calc.clickByInputValue(String.valueOf(randomNumber));
            operand = operand - randomNumber;

            if(i==3){
                calc.clickEquals();
                String result = calc.getResult();
                Assert.assertEquals(result, String.valueOf(operand),
                        "Incorrect result at step " + (i + 1) + ": Expected " + operand + " but got " + result);
            }
        }
    }

}
