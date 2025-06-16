package com.calculator.tests;

import com.calculator.base.TestBase;
import org.calculator.driver.DriverFactory;
import org.calculator.pages.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class MultiplicationTest extends TestBase {
    CalculatorPage calc;

    @BeforeMethod
    public  void init() {
        calc = new CalculatorPage(DriverFactory.getDriver());
        calc.clickClear();
    }


    @Test(description = "Verify non zero multiplication")
    public void testMultiplication(){

        calc.clickByInputValue("10");
        calc.clickMul();
        calc.clickByInputValue("20");

        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "200");
    }

    @Test(description = "Verify one operand as 0")
    public void testZeroResultingMultiplication(){

        calc.clickByInputValue("10");
        calc.clickMul();
        calc.clickByInputValue("0");

        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "0");
    }

    @Test(description = "Verify both operand as 0")
    public void testZeroMultiplication(){

        calc.clickByInputValue("0");
        calc.clickMul();
        calc.clickByInputValue("0");

        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "0");
    }

    @Test(description = "Multiplication of negative numbers")
    public void testMulOfNegativeNumbers(){

        calc.clickSub();
        calc.clickByInputValue("-2");
        calc.clickMul();
        calc.clickSub();
        calc.clickByInputValue("-2");
        calc.clickEquals();
        String result = calc.getResult();
        Assert.assertEquals(result, "4", "Oops! Expected 4 but found : "+result);
    }

    @Test(description = "Multiplication of one operand as negative numbers")
    public void testMultiplyOnOneOperandAsNegativeNumber() throws InterruptedException {

        calc.clickSub();
        calc.clickByInputValue("10");
        Thread.sleep(1000);
        calc.clickMul();
        calc.clickByInputValue("9");

        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "-90");
    }

    @Test(description = "Multiplication of two decimals")
    public void testMultiplyOfTwoDecimals(){
        calc.clickByInputValue("1");
        calc.clickByInputValue(".");
        calc.clickByInputValue("2");

        calc.clickMul();

        calc.clickByInputValue("1");
        calc.clickByInputValue(".");
        calc.clickByInputValue("2");

        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "1.44");
    }

    @Test(description = "Verify chaining of multiplication")
    public void testMultiplyChaining(){

        Random random = new Random();
        int operand = 1;

        for(int i=0; i<5; i++){
            int  randomNumber = random.nextInt(10);
            operand = operand * randomNumber;
            calc.clickByInputValue(String.valueOf(randomNumber));

            if(i<4){
                calc.clickMul();
            }
            else{
                calc.clickEquals();
            }

            String result = calc.getResult();
            Assert.assertEquals(result, String.valueOf(operand), "Incorrect result at step " + (i + 1) + ": Expected " + operand + " but got " + result);
        }
    }
}
