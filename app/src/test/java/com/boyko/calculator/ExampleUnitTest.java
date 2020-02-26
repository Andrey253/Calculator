package com.boyko.calculator;

import com.boyko.calculator.Operation.Add;
import com.boyko.calculator.Operation.IOperation;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrec() {

        StacksBuilder crst = new StacksBuilder(" -((((3-30/15)/(4-8/4))))");

System.out.println(" my st " + crst.stackObj);

        Double d = new Calculator(crst.stackObj).getResult();

        Assert.assertEquals(-0.5, d,0.1);
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
}