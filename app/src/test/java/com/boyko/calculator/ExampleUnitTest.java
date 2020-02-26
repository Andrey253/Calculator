package com.boyko.calculator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrec() {

        CrStacks crst = new CrStacks(" (33-30)-6");

System.out.println(" my st " + crst.stackObj);

        Double d = new Calculator(crst.stackObj).getResult();

        Assert.assertEquals(-3, d,0.2);
    }
}