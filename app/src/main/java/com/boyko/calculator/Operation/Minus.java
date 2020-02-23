package com.boyko.calculator.Operation;

import com.boyko.calculator.Calculator;

public class Minus extends Operation{

    public int priority;

    public Minus(int priority) {
        super(priority);
    }

    @Override
    public Double exec(String s1, String s2) {
        return Double.parseDouble(s1)-Double.parseDouble(s1);
    }
}
