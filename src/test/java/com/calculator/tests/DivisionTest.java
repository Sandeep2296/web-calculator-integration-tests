package com.calculator.tests;

import com.calculator.base.TestBase;
import org.calculator.driver.DriverFactory;
import org.calculator.pages.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class DivisionTest extends TestBase {

    CalculatorPage calc;

    @BeforeMethod
    public  void init() {
        calc = new CalculatorPage(DriverFactory.getDriver());
        calc.clickClear();
    }


    @Test(description = "Verify non zero division")
    public void testDivision(){

        calc.clickByInputValue("20");
        calc.clickDiv();
        calc.clickByInputValue("10");
        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "2");
    }

    @Test(description = "Verify divide by 0")
    public void testDivideByZero(){

        calc.clickByInputValue("10");
        calc.clickDiv();
        calc.clickByInputValue("0");
        calc.clickEquals();


        String result = calc.getResult();
        Assert.assertEquals(result, "Error");
    }

    @Test(description = "Verify both operand as 0")
    public void testDivideByZero_a(){

        calc.clickByInputValue("0");
        calc.clickDiv();
        calc.clickByInputValue("0");
        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "Error");
    }

    //Fails because of application issue
    @Test(description = "Division of negative numbers")
    public void testDivOfNegativeNumbers(){

        calc.clickSub();
        calc.clickByInputValue("2");
        calc.clickDiv();
        calc.clickSub();
        calc.clickByInputValue("2");
        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "1");
    }

    //Fails because of application issue
    @Test(description = "Division of one operand as negative numbers")
    public void testDivOnOneNegativeNumbers(){

        calc.clickByInputValue("2");
        calc.clickDiv();
        calc.clickSub();
        calc.clickByInputValue("2");
        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "-1");
    }

    @Test(description = "Division of two decimals")
    public void testDivisionOfTwoDecimals(){
        calc.clickByInputValue("1");
        calc.clickByInputValue(".");
        calc.clickByInputValue("2");

        calc.clickDiv();

        calc.clickByInputValue("1");
        calc.clickByInputValue(".");
        calc.clickByInputValue("2");

        calc.clickEquals();

        String result = calc.getResult();
        Assert.assertEquals(result, "1");
    }

}
