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

    

    /*Above is original repository setup, below are my additions. <-------
    */

    //Testing DIV/0
    @Test
    void divZeroTest() {
        double result = calculator.calc (1, "0", '/');
        Assertions.assertEquals(Double.POSITIVE_INFINITY,result);
    }
    //Testing normal division
    @Test
    void divNormTest() {
        Assertions.assertEquals(10, calculator.calc(20, "2", '/'));
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
        //Test default case of calc()
    @Test
        void calcDefaultTest() {
        //Default
        Assertions.assertEquals(5, calculator.calc(-255, "5", '.'));
    }
    //Test x-y  case of calc()
    @Test
        void calcMinusTest() {
        
        Assertions.assertEquals(0, calculator.calc(1.7976931348623157E+308, "1.7976931348623157E+308", '-'));
        }
    //Test x*y of calc()
    @Test
        void calcMultTest() {
        
        Assertions.assertEquals(257, calculator.calc(51.4, "5", '*'));
        }
    //Test x%y of calc()
    @Test
        void calcModTest() {
        
        Assertions.assertEquals(-1, calculator.calc(-256, "5", '%'));
        }

        //Test .pow of calc()
    @Test
        void calcPowTest() {
        // NaN result
        Assertions.assertEquals(Double.NaN, calculator.calc(-2, "0.5", '^'));
        // Expect infinity
        Assertions.assertEquals(Double.POSITIVE_INFINITY, calculator.calc(10, "309", '^'));
        Assertions.assertEquals(Double.NEGATIVE_INFINITY, calculator.calc(-10, "309", '^'));
    }
        //Test for string input
    @Test
        void calcAbcTest() {
            Assertions.assertThrows(NumberFormatException.class, () -> calculator.calc(10, "abc", '+'));
        }
    
    

}

