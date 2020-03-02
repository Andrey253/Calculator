package com.boyko.calculator;

import com.boyko.calculator.Operation.Calc.Add;
import com.boyko.calculator.Operation.IOperation;

import org.junit.Assert;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.Stack;

public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {

        StacksBuilder stackinput = new StacksBuilder(" (5-2*(3/((4-30/15+6/3-1-1+30/15-1*2)-1)*8-4)/4)");

        Double d = new Calculator(stackinput.stackinput).getResult();

        Assert.assertEquals(-5.0, d,0.1);
    }    @Test
    public void infinity() {

        InputChar inputChar = new InputChar("Infinity", "0");

        Assert.assertEquals("00", inputChar.getInputString());
    }

    @Test
    public void nullException() {

        String s = String.format("%.12f", 19999999999.5656);
            while (s.charAt(s.length()-1) == '0') s = s.substring(0,s.length()-1);
            if (s.charAt(s.length()-1) == ',') s = s.substring(0,s.length()-1);

        Assert.assertEquals("19999999999,5656",s );
    }
    @Test
    public void addition_isCorrect2() {

        StacksBuilder stackinput = new StacksBuilder(" (2+3)*(2+2)");

        Double d = new Calculator(stackinput.stackinput).getResult();

        Assert.assertEquals(20.0, d,0.1);
    }

    @Test
    public void add() {

        IOperation add = new Add(1);
        Stack<Double> sd = new Stack<>();
        Stack<Character> so = new Stack<>();
        sd.push(1.0);
        sd.push(2.0);
        so.push('+');

        add.exec(sd);

        Assert.assertEquals(3.0, sd.peek(),0.1);
    }
    @Test
    public void buttonIsOperator() {

        InputChar inputChar = new InputChar("5", "/");

        Assert.assertEquals(true, inputChar.isLastCharOperator());
    }
    @Test
    public void countBracket() {

        InputChar inputChar = new InputChar("(((6-9", ")");

        Assert.assertEquals(2, inputChar.getDif_count_bracket());
    }
    @Test
    public void stringToStack() {

        StacksBuilder stackinput = new StacksBuilder(" 0");

        Double d = new Calculator(stackinput.stackinput).getResult();

        Assert.assertEquals(0.0, d,0.1);
    }
}