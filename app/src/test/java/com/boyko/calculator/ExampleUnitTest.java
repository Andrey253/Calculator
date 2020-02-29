package com.boyko.calculator;

import android.app.Application;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import com.boyko.calculator.Operation.Add;
import com.boyko.calculator.Operation.IOperation;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

import static com.boyko.calculator.R.string.dev;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {

        StacksBuilder stackinput = new StacksBuilder(" -((((4-30/15+6/3-1-1+30/15-1*2)-1)*8-4)/4)");

        Double d = new Calculator(stackinput.stackinput).getResult();

        Assert.assertEquals(-1.0, d,0.1);
    }
    @Test
    public void addition_isCorrect2() {

        StacksBuilder stackinput = new StacksBuilder(" 2+3");

        Double d = new Calculator(stackinput.stackinput).getResult();

        Assert.assertEquals(5.0, d,0.1);
    }

    @Test
    public void add() {

        IOperation add = new Add(1);
        Stack<Double> sd = new Stack<>();
        Stack<Character> so = new Stack<>();
        sd.push(1.0);
        sd.push(2.0);
        so.push('+');

        add.exec(sd,sd);

        Assert.assertEquals(3.0, sd.peek(),0.1);
    }
    @Test
    public void buttonIsOperator() {

        InputChar inputChar = new InputChar("5", "/");

        Assert.assertEquals(true, inputChar.last_simbol_is_operator);
    }
    @Test
    public void countBracket() {

        InputChar inputChar = new InputChar("((6-9", ")");

        Assert.assertEquals(1, inputChar.dif_count_bracket);
    }
}