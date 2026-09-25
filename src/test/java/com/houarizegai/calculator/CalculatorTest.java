package com.houarizegai.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() { // Create object before each test
        calculator = new Calculator();
    }

    

    /*Above is original repository setup, below is my additions. <-------
    * Note on double/string usage:
        Confirmed first number must be a double and the second must be a string by flipping the double and string in the call. 
        IDE Fault resulted, so I will be using a double for the first variable, and a string for the second one.
    */

    //Testing DIV/0
    @Test
    void divZeroTest() {
        double result = calculator.calc (1, "0", '/');
        Assertions.assertEquals(Double.POSITIVE_INFINITY,result);
    }

    //Boundary testing use of Parse.Double
    //Test of specified max
    @Test
    void testParseDoubleMax() {
      
        Assertions.assertEquals(1.7976931348623157E+308, calculator.calc(0, "1.7976931348623157E+308", '+'));
    }
    //Add 1 to max specification should result in no change to expectation
    @Test
        void testParseDoubleMaxPlus1() {
      
        Assertions.assertEquals(1.7976931348623157E+308, calculator.calc(1, "1.7976931348623157E+308", '+'));
    }



}

