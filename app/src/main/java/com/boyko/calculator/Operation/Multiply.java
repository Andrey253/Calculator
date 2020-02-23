package com.boyko.calculator.Operation;

public class Multiply extends Operation {
    public Multiply(int priority) {
        super(priority);
    }

    @Override
    public Double exec(String s1, String s2) {
        return Double.parseDouble(s1)*Double.parseDouble(s1);
    }

    @Override
    public int getPriority() {
        return super.getPriority();
    }
}
