package com.boyko.calculator.Operation;

import com.boyko.calculator.Calculator;

public class Add extends Operation{


    public Add(int priority) {
        super(priority);
    }

    @Override
    public Double exec(String s1, String s2) {
        return Double.parseDouble(s1)+Double.parseDouble(s1);
    }
}
