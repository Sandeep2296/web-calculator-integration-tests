package com.calculator.tests;

import com.calculator.base.TestBase;
import org.calculator.driver.DriverFactory;
import org.calculator.pages.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AdditionTest extends TestBase {
    CalculatorPage calc;

    @BeforeMethod
    public  void init() {
        calc = new CalculatorPage(DriverFactory.getDriver());
        calc.clickClear();
    }


    @Test(description = "Verify non zero addition")
    public void testAddition() throws InterruptedException {

        calc.clickByInputValue("10");
        calc.clickAdd();
        calc.clickByInputValue("20");
        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "30");
    }

    @Test(description = "Verify one operand as 0")
    public void testAdditionWithZeros(){

        calc.clickByInputValue("1");
        calc.clickAdd();
        calc.clickByInputValue("0");
        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "1");
    }

    @Test(description = "Verify both operand as 0")
    public void testZeroAddition(){

        calc.clickByInputValue("0");
        calc.clickAdd();
        calc.clickByInputValue("0");
        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "0");
    }

    @Test(description = "Sum of negative numbers")
    public void testSumOfNegativeNumbers(){

        calc.clickSub();
        calc.clickByInputValue("2");
        calc.clickAdd();
        calc.clickSub();
        calc.clickByInputValue("2");
        calc.clickEquals();


        String result = calc.getResult();
        Assert.assertEquals(result, "-4");
    }

    @Test(description = "Sum of two decimals")
    public void testSumOfTwoDecimals(){

        calc.clickByInputValue("1");
        calc.clickByInputValue(".");
        calc.clickByInputValue("2");

        calc.clickAdd();

        calc.clickByInputValue("1");
        calc.clickByInputValue(".");
        calc.clickByInputValue("2");

        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "2.4");
    }

    @Test(description = "Verify chaining of sum")
    public void testAdditionChaining(){

        Random random = new Random();
        int operand = 0;

        for(int i=0; i<5; i++){
            int  randomNumber = random.nextInt(10);
            operand = operand + randomNumber;
            calc.clickByInputValue(String.valueOf(randomNumber));

            if(i<4){
                calc.clickAdd();
            }
            else{
                calc.clickEquals();
            }

            String result = calc.getResult();
            Assert.assertEquals(result, String.valueOf(operand), "Incorrect result at step " + (i + 1) + ": Expected " + operand + " but got " + result);
        }
    }

}
